package ninh.luyen.dds

import android.app.Application
import ninh.luyen.dds.datas.di.appModule
import ninh.luyen.dds.datas.di.repositoryModule
import ninh.luyen.dds.datas.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by luyen_ninh on 3/29/21.
 */
class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NewsApplication)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }
    }
}