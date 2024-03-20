package ru.epetrashko.itischucknorris.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @author e.petrashko
 */
@MapKey
annotation class ViewModelKey(val viewModelClass: KClass<out ViewModel>)
