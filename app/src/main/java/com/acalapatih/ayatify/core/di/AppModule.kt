package com.acalapatih.ayatify.core.di

import com.acalapatih.ayatify.core.data.repositoryImpl.bacaquran.BacaAyatRepositoryImpl
import com.acalapatih.ayatify.core.data.repositoryImpl.bacaquran.BacaJuzRepositoryImpl
import com.acalapatih.ayatify.core.data.repositoryImpl.bacaquran.ListSuratRepositoryImpl
import com.acalapatih.ayatify.core.data.repositoryImpl.bacaquran.BacaSuratRepositoryImpl
import com.acalapatih.ayatify.core.data.repositoryImpl.hafalanquran.*
import com.acalapatih.ayatify.core.data.source.remote.RemoteDataSource
import com.acalapatih.ayatify.core.data.source.remote.network.QuranApiService
import com.acalapatih.ayatify.core.domain.interactor.bacaquran.BacaAyatInteractor
import com.acalapatih.ayatify.core.domain.interactor.bacaquran.BacaJuzInteractor
import com.acalapatih.ayatify.core.domain.interactor.bacaquran.ListSuratInteractor
import com.acalapatih.ayatify.core.domain.interactor.bacaquran.BacaSuratInteractor
import com.acalapatih.ayatify.core.domain.interactor.hafalanquran.*
import com.acalapatih.ayatify.core.domain.repository.bacaquran.BacaAyatRepository
import com.acalapatih.ayatify.core.domain.repository.bacaquran.BacaJuzRepository
import com.acalapatih.ayatify.core.domain.repository.bacaquran.ListSuratRepository
import com.acalapatih.ayatify.core.domain.repository.bacaquran.BacaSuratRepository
import com.acalapatih.ayatify.core.domain.repository.hafalanquran.*
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaAyatUsecase
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaJuzUsecase
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaQuranUsecase
import com.acalapatih.ayatify.core.domain.usecase.bacaquran.BacaSuratUsecase
import com.acalapatih.ayatify.core.domain.usecase.hafalanquran.*
import com.acalapatih.ayatify.ui.bacaquran.viewmodel.BacaJuzViewModel
import com.acalapatih.ayatify.ui.bacaquran.viewmodel.ListJuzViewModel
import com.acalapatih.ayatify.ui.bacaquran.viewmodel.ListSuratViewModel
import com.acalapatih.ayatify.ui.bacaquran.viewmodel.BacaSuratViewModel
import com.acalapatih.ayatify.ui.bookmark.viewmodel.BookmarkViewModel
import com.acalapatih.ayatify.ui.hafalanquran.viewmodel.HafalanAyatViewModel
import com.acalapatih.ayatify.ui.hafalanquran.viewmodel.HafalanQuranViewModel
import com.acalapatih.ayatify.ui.hafalanquran.viewmodel.HafalanSuratViewModel
import com.acalapatih.ayatify.ui.home.viewmodel.HomeViewModel
import com.acalapatih.ayatify.utils.Const
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { Retrofit.Builder()
        .baseUrl(Const.QURAN_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
    single { get<Retrofit>().create(QuranApiService::class.java) }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single<ListSuratRepository> { ListSuratRepositoryImpl(get()) }
    single<BacaSuratRepository> { BacaSuratRepositoryImpl(get()) }
    single<BacaJuzRepository> { BacaJuzRepositoryImpl(get()) }
    single<BacaAyatRepository> { BacaAyatRepositoryImpl(get()) }
    single<HafalanQuranRepository> { HafalanQuranRepositoryImpl(get()) }
    single<HafalanSuratRepository> { HafalanSuratRepositoryImpl(get()) }
    single<HafalanAyatRepository> { HafalanAyatRepositoryImpl(get()) }
}

val useCaseModule = module {
    factory<BacaQuranUsecase> { ListSuratInteractor(get()) }
    factory<BacaSuratUsecase> { BacaSuratInteractor(get()) }
    factory<BacaJuzUsecase> { BacaJuzInteractor(get()) }
    factory<BacaAyatUsecase> { BacaAyatInteractor(get()) }
    factory<HafalanQuranUsecase> { HafalanQuranInteractor(get()) }
    factory<HafalanSuratUseCase> { HafalanSuratInteractor(get()) }
    single<HafalanAyatUsecase> { HafalanAyatInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ListSuratViewModel(get()) }
    viewModel { ListJuzViewModel(get()) }
    viewModel { BacaSuratViewModel(get(), get(), get()) }
    viewModel { BacaJuzViewModel(get(), get(), get()) }
    viewModel { HafalanQuranViewModel(get(), get()) }
    viewModel { HafalanSuratViewModel(get(), get()) }
    viewModel { HafalanAyatViewModel(get(), get()) }
    viewModel { BookmarkViewModel(get()) }
}