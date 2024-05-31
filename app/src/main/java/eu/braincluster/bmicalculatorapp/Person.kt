package eu.braincluster.bmicalculatorapp

class Person(val weight: Int, val height: Int)
{
    fun getBmiIndex(): Double
    {
        val heightMeter = height / 100.0
        val bmiIndex = weight / (heightMeter * heightMeter)

        return bmiIndex
    }
}