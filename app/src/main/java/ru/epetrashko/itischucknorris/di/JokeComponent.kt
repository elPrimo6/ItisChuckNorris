package ru.epetrashko.itischucknorris.di

import dagger.Component
import ru.epetrashko.itischucknorris.MainActivity

/**
 * @author e.petrashko
 */
@Component(modules = [JokeModule::class])
abstract class JokeComponent {

    abstract fun inject(activity: MainActivity)
}
