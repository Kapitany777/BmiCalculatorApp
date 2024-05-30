package eu.braincluster.bmicalculatorapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.braincluster.bmicalculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    private var weight = 80.0
    private var height = 176.0

    private fun getBmiResult(): String
    {
        var result: String

        if (height > 0.0)
        {
            val heightMeter = height / 100.0
            val bmiIndex = weight / (heightMeter * heightMeter)
            result = String.format("The BMI index is: %.3f", bmiIndex)
        }
        else
        {
            result = "Cannot calculate the index!"
        }

        return result
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.getRoot());

        binding.textViewHeight.text = "${binding.sliderHeight.value.toInt().toString()} cm"

        binding.sliderHeight.addOnChangeListener { slider, value, fromUser ->
            binding.textViewHeight.text = "${value.toInt().toString()} cm"
        }

        binding.buttonCalculate.setOnClickListener {
            binding.textViewResult.text = getBmiResult()
        }
    }
}