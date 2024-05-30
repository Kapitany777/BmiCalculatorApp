package eu.braincluster.bmicalculatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.braincluster.bmicalculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.getRoot());

        binding.textViewHeight.text = "${binding.sliderHeight.value.toInt().toString()} cm"

        binding.sliderHeight.addOnChangeListener { slider, value, fromUser ->
            binding.textViewHeight.text = "${value.toInt().toString()} cm"
        }
    }
}