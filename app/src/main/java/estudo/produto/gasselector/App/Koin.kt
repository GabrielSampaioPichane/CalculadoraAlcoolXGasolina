package estudo.produto.gasselector.App

import estudo.produto.gasselector.ViewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel {
        MainViewModel()
    }
}