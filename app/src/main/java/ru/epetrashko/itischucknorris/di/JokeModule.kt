package ru.epetrashko.itischucknorris.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.epetrashko.itischucknorris.MainViewModel
import ru.epetrashko.itischucknorris.service.JokeService

/**
 * @author e.petrashko
 */
@Module
interface JokeModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun mainViewModel(viewModel: MainViewModel): ViewModel

    companion object {

        @Provides
        fun provideGsonConverterFactory(): GsonConverterFactory {
            return GsonConverterFactory.create()
        }

        @Provides
        fun provideRetrofit(gson: GsonConverterFactory): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/jokes/")
                .addConverterFactory(gson)
                .build()
        }

        @Provides
        fun provideJokeService(retrofit: Retrofit): JokeService {
            return retrofit.create(JokeService::class.java)
        }
    }
}
