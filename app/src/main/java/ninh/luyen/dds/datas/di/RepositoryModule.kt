package ninh.luyen.dds.datas.di

import ninh.luyen.dds.datas.repositories.weathers.WeatherRepository
import ninh.luyen.dds.datas.repositories.weathers.WeatherRepositoryImp
import org.koin.dsl.module

/**
 * Created by luyen_ninh on 3/22/21.
 */
var repositoryModule = module {
    factory<WeatherRepository> {
        WeatherRepositoryImp(
            newsService = get(),
            cacheLocal = get(),
            networkHandler = get()
        )
    }
}