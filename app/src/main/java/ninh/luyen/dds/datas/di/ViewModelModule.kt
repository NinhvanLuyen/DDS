package ninh.luyen.dds.datas.di

import ninh.luyen.dds.ui.homes.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by luyen_ninh on 3/21/21.
 */
val viewModelModule = module {

    viewModel { HomeViewModel(feedRepository = get()) }
}