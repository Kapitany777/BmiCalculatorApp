package eu.braincluster.bmicalculatorapp

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import eu.braincluster.bmicalculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    private var weight = 80
    private var height = 176
    private var age = 25

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.getRoot());

        // Height
        binding.textViewHeight.text = "${height.toString()} cm"

        binding.sliderHeight.value = height.toFloat()

        binding.sliderHeight.addOnChangeListener { slider, value, fromUser ->
            binding.textViewHeight.text = "${value.toInt().toString()} cm"
        }

        // Weight
        binding.textViewWeight.text = weight.toString()

        binding.buttonWeightDec.setOnClickListener {
            if (weight > 1)
            {
                weight--
                binding.textViewWeight.text = weight.toString()
            }
        }

        binding.buttonWeightInc.setOnClickListener {
            if (weight < 200)
            {
                weight++
                binding.textViewWeight.text = weight.toString()
            }
        }

        // Age
        binding.textViewAge.text = age.toString()

        binding.buttonAgeDec.setOnClickListener {
            if (age > 1)
            {
                age--
                binding.textViewAge.text = age.toString()
            }
        }

        binding.buttonAgeInc.setOnClickListener {
            if (age < 150)
            {
                age++
                binding.textViewAge.text = age.toString()
            }
        }

        // Calculate
        binding.buttonCalculate.setOnClickListener {
            height = binding.sliderHeight.value.toInt()

            val person = Person(weight, height)
            binding.textViewResult.text = String.format("The BMI index is: %.3f", person.getBmiIndex())
        }
    }
}