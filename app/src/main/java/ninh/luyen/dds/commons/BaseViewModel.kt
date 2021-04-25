package ninh.luyen.dds.commons

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

/**
 * Created by luyen_ninh on 3/29/21.
 */
abstract class BaseViewModel : ViewModel() {
    private lateinit var job: Job
    protected lateinit var uiScope: CoroutineScope
    protected lateinit var ioContext: CoroutineContext
//    val showLoading = SingleLiveEvent<Boolean>()
//    val showError = SingleLiveEvent<String>()

    fun init() {
        onCreate()
    }

    protected open fun onCreate() {
        job = Job()
        uiScope = CoroutineScope(Dispatchers.Main + job)
        ioContext = Dispatchers.IO + job
    }

    fun onDestroy() {
        uiScope.cancel()
        ioContext.cancel()
    }
}