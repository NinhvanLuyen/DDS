package ninh.luyen.dds.datas.repositories.weathers

import ninh.luyen.dds.datas.repositories.ErrorType

/**
 * Created by luyen_ninh on 4/25/21.
 */
sealed class GetWeathersFails : ErrorType.FeatureFailure() {
    object LocalEmpty : GetWeathersFails()
    class UndefineError(val message: String? = "") : GetWeathersFails()
    object NotFound : GetWeathersFails()
}