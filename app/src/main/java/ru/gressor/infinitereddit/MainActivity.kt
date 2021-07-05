package ru.gressor.infinitereddit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.gressor.infinitereddit.databinding.ActivityMainBinding
import ru.gressor.infinitereddit.ui.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.fragmentContainer.id, MainFragment())
                .commit()
        }
    }
}