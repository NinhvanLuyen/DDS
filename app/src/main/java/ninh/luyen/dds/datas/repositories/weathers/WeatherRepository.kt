package ninh.luyen.dds.datas.repositories.weathers

import ninh.luyen.dds.datas.remotes.responses.SearchCacheModel
import ninh.luyen.dds.datas.remotes.responses.SearchResponseModel
import ninh.luyen.dds.datas.repositories.ErrorType
import ninh.luyen.dds.datas.repositories.Result

/**
 * Created by luyen_ninh on 3/22/21.
 */
interface WeatherRepository {
    suspend fun searchWeather(cityName: String): Result<SearchResponseModel, ErrorType>
    suspend fun getWeatherInCache(): Result<SearchCacheModel, ErrorType>
}