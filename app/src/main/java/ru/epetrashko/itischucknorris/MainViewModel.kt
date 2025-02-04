package ru.epetrashko.itischucknorris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.epetrashko.itischucknorris.repository.JokeRepository

/**
 * @author e.petrashko
 */
class MainViewModel(
    private val jokeRepository: JokeRepository = JokeRepository()
) : ViewModel() {

    private val _jokes = MutableLiveData("Чего ждем?")
    val jokes: LiveData<String> = _jokes


    fun generateJoke() {
        viewModelScope.launch {
            runCatching {
                jokeRepository.generateJoke()
            }.fold(
                onSuccess = _jokes::setValue,
                onFailure = {
                    // Show the error / display the toast
                }
            )
        }
    }
}