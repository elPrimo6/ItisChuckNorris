package ru.epetrashko.itischucknorris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.epetrashko.itischucknorris.databinding.ActivityMainBinding

/**
 * @author e.petrashko
 */
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private val viewBinding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

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