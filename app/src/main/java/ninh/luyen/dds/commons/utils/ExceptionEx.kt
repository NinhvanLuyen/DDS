package ninh.luyen.dds.commons.utils

import ninh.luyen.dds.datas.remotes.responses.HttpErrorCode
import ninh.luyen.dds.datas.repositories.ErrorType
import ninh.luyen.dds.datas.repositories.Result
import ninh.luyen.dds.datas.repositories.weathers.GetWeathersFails
import retrofit2.HttpException

/**
 * Created by luyen_ninh on 4/25/21.
 */
fun Exception.handleError(): Result.Error<ErrorType> {
    this.printStackTrace()
    return if (this is HttpException) {
        when (this.code()) {
            HttpErrorCode.NOT_FOUND -> {
                Result.Error(GetWeathersFails.NotFound)
            }
            else -> {
                Result.Error(ErrorType.ServerError)
            }
        }
    } else {
        Result.Error(GetWeathersFails.UndefineError(this.message))
    }

}