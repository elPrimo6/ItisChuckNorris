package ru.epetrashko.itischucknorris.service

import retrofit2.http.GET
import ru.epetrashko.itischucknorris.response.JokeResponse


/**
 * @author e.petrashko
 */
interface JokeService {

    @GET("random")
    suspend fun generateRandomJoke(): JokeResponse
}
