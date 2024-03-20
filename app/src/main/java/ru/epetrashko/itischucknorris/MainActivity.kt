package ru.epetrashko.itischucknorris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.epetrashko.itischucknorris.databinding.ActivityMainBinding
import ru.epetrashko.itischucknorris.di.DaggerJokeComponent
import ru.epetrashko.itischucknorris.di.ViewModelFactory
import javax.inject.Inject

/**
 * @author e.petrashko
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private val viewBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        DaggerJokeComponent.create().inject(this)
        viewBinding.button.setOnClickListener {
            viewModel.generateJoke()
        }
        observeChanges()
    }

    private fun observeChanges() {
        viewModel.jokes.observe(this) {
            viewBinding.textView.text = it
        }
    }
}
