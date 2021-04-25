package ninh.luyen.dds.datas.remotes.api

import kotlinx.coroutines.Deferred
import ninh.luyen.dds.datas.remotes.responses.SearchResponseModel
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by luyen_ninh on 3/21/21.
 */
interface WeatherService{
    @GET("forecast/daily")
    fun searchAsync(@QueryMap queryMap: HashMap<String,String> ):Deferred<SearchResponseModel>
}