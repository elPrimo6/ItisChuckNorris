package ru.epetrashko.itischucknorris.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author e.petrashko
 */
object JokeServiceProvider {

    fun createService(): JokeService =
        Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokeService::class.java)
}
