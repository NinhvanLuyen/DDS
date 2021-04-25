package ninh.luyen.dds.datas.repositories.weathers

import android.util.Log
import com.google.gson.Gson
import ninh.luyen.dds.commons.utils.TAG
import ninh.luyen.dds.commons.utils.handleError
import ninh.luyen.dds.datas.cache.CacheSharedPreferences
import ninh.luyen.dds.datas.remotes.NetworkHandler
import ninh.luyen.dds.datas.remotes.api.WeatherService
import ninh.luyen.dds.datas.remotes.responses.SearchCacheModel
import ninh.luyen.dds.datas.remotes.responses.SearchResponseModel
import ninh.luyen.dds.datas.repositories.ErrorType
import ninh.luyen.dds.datas.repositories.Result

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
            query["appid"] = "60c6fbeb4b93ac653c492ba806fc346d"
            query["units"] = "metric"

            newsService.searchAsync(query).await().let {
                cacheLocal.saveSearchResult(SearchCacheModel(cityName,it))
                Result.Success(it)
            }

        } catch (e: Exception) {
            return e.handleError()
        }


    }

    override suspend fun getWeatherInCache(): Result<SearchCacheModel, ErrorType> {
        val responseLocal = cacheLocal.getCacheSearchResult()
        return if (responseLocal == null)
            Result.Error(GetWeathersFails.LocalEmpty)
        else
            Result.Success(responseLocal)
    }

}