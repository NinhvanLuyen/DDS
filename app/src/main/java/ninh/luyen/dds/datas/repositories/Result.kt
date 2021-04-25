package ninh.luyen.dds.datas.repositories

/**
 * Created by luyen_ninh on 3/22/21.
 */
sealed class Result<out S, out E> {
    class Success<out S>(val data: S) : Result<S, Nothing>()
    class Error<out E>(val error: E) : Result<Nothing, E>()

    val isSuccess: Boolean
        get() = this is Success<S>
    val isError: Boolean
        get() = this is Error<E>

    fun <S> success(data: S) = Success(data)
    fun <E> error(error: E) = Error(error)

}

