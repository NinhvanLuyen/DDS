package ninh.luyen.dds.datas.repositories.weathers

import ninh.luyen.dds.commons.utils.handleError
import ninh.luyen.dds.datas.Constances
import ninh.luyen.dds.datas.cache.CacheSharedPreferences
import ninh.luyen.dds.datas.remotes.NetworkHandler
import ninh.luyen.dds.datas.remotes.api.WeatherService
import ninh.luyen.dds.datas.remotes.responses.SearchCacheModel
import ninh.luyen.dds.datas.remotes.responses.SearchResponseModel
import ninh.luyen.dds.datas.repositories.ErrorType
import ninh.luyen.dds.datas.repositories.Result
import ninh.luyen.dds.datas.world.Door

/**
 * Created by luyen_ninh on 3/22/21.
 */
class WeatherRepositoryImp(
    private val newsService: WeatherService,
    private val cacheLocal: CacheSharedPreferences,
    private val networkHandler: NetworkHandler
) : WeatherRepository {

    override suspend fun searchWeather(cityName: String): Result<SearchResponseModel, ErrorType> {
        if (!networkHandler.isNetworkAvailable())
            return Result.Error(ErrorType.NetworkConnection)

        return try {
            val query = HashMap<String, String>()
            query["q"] = cityName
            query["cnt"] = "7"
            query["appid"] = Door.keyMainDoor
            query["units"] = "metric"
            val lastResult = cacheLocal.getCacheSearchResult()
            if (lastResult != null
                && lastResult.isSameQuery(
                    currentQuery = cityName,
                    debounceTime = Constances.DEBOUNCE_TIME_FETCH_API
                )
            ) {
                if (lastResult.searchResponseModel == null)
                    Result.Error(GetWeathersFails.NotFound)
                else

                    Result.Success(lastResult.searchResponseModel)
            } else {
                newsService.searchAsync(query).await().let {
                    cacheLocal.saveSearchResult(
                        SearchCacheModel(
                            query = cityName,
                            timeRequest = System.currentTimeMillis(),
                            searchResponseModel = it
                        )
                    )
                    Result.Success(it)
                }
            }
        } catch (e: Exception) {
            val error = e.handleError()
            val lastResult = cacheLocal.getCacheSearchResult()
            if (lastResult?.isSameQuery(
                    currentQuery = cityName,
                    debounceTime = Constances.DEBOUNCE_TIME_FETCH_API
                ) == false
            ) {
                cacheLocal.saveSearchResult(
                    SearchCacheModel(
                        query = cityName,
                        timeRequest = System.currentTimeMillis(),
                        searchResponseModel = null
                    )
                )
            }
            return error
        }


    }

    override suspend fun getWeatherInCache(): Result<SearchCacheModel, ErrorType> {
        val responseLocal = cacheLocal.getCacheSearchResult()
            ?: return Result.Error(GetWeathersFails.LocalEmpty)
        if (responseLocal.searchResponseModel == null)
            return Result.Error(GetWeathersFails.LocalEmpty)


        return Result.Success(responseLocal)
    }

}