package ru.epetrashko.itischucknorris.repository

import ru.epetrashko.itischucknorris.service.JokeService
import javax.inject.Inject

/**
 * @author e.petrashko
 */
class JokeRepository @Inject constructor(private val service: JokeService) {

    suspend fun generateJoke(): String {
        return service.generateRandomJoke().value
    }
}
