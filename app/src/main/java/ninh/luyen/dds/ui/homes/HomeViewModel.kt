package ninh.luyen.dds.ui.homes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ninh.luyen.dds.R
import ninh.luyen.dds.commons.BaseViewModel
import ninh.luyen.dds.datas.remotes.responses.SearchResponseModel
import ninh.luyen.dds.datas.repositories.ErrorType
import ninh.luyen.dds.datas.repositories.Result
import ninh.luyen.dds.datas.repositories.weathers.GetWeathersFails
import ninh.luyen.dds.datas.repositories.weathers.WeatherRepository

/**
 * Created by luyen_ninh on 3/21/21.
 */
class HomeViewModel(private val feedRepository: WeatherRepository) : BaseViewModel() {


    private val newsData = MutableLiveData<SearchResponseModel>()
    val news: LiveData<SearchResponseModel>
        get() = newsData

    private val queryEmitter = MutableLiveData<String>()
    val query:LiveData<String>
        get() = queryEmitter

    private val loadingEmitter = MutableLiveData<Boolean>()
    val loading:LiveData<Boolean>
        get() = loadingEmitter


    private val errorMessage = MutableLiveData<Int>()
    val error: LiveData<Int>
        get() = errorMessage

    fun search(query: String) {
        loadingEmitter.value = true
        uiScope.launch {
            val result =
                withContext(ioContext) {
                    feedRepository.searchWeather(query)
                }
            when (result) {
                is Result.Success -> {
                    newsData.value = result.data
                }
                is Result.Error -> {
                    when (result.error) {

                        is ErrorType.NetworkConnection -> {
                            errorMessage.value = R.string.network_error
                        }
                        is ErrorType.ServerError -> {
                            errorMessage.value = R.string.server_error
                        }
                        is GetWeathersFails.NotFound -> {
                            errorMessage.value = R.string.not_found
                        }
                        else -> errorMessage.value = R.string.undifine_error
                    }


                }
            }
        }
    }

    fun getCache() {
        uiScope.launch {
            val result =
                withContext(ioContext) {
                    feedRepository.getWeatherInCache()
                }
            when (result) {
                is Result.Success -> {
                    newsData.value = result.data.searchResponseModel
                    queryEmitter.value = result.data.query
                }
                is Result.Error -> {
                    when (result.error) {
                        is GetWeathersFails.LocalEmpty -> {
                            //Nothing to show
                        }
                        else -> {

                        }
                    }

                }
            }
        }

    }

}