package ninh.luyen.dds.datas.repositories

sealed class ErrorType {
    object NetworkConnection : ErrorType()
    object ServerError : ErrorType()
    abstract class FeatureFailure : ErrorType()
}