package ru.epetrashko.itischucknorris.repository

import ru.epetrashko.itischucknorris.service.JokeService
import ru.epetrashko.itischucknorris.service.JokeServiceProvider

/**
 * @author e.petrashko
 */
class JokeRepository(
    private val service: JokeService = JokeServiceProvider.createService()
) {

    suspend fun generateJoke(): String {
        return service.generateRandomJoke().value
    }
}
