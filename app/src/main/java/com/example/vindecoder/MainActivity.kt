package com.example.vindecoder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vindecoder.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.submitBtn.setOnClickListener {
            val vin = binding.vinEditText.text.toString()
            viewModel.getVinDetails(vin)

        }
          getApiData()


    }
    private fun getApiData(){
        viewModel.vinDetails.observe(this) { vinResponse ->
            val vinDetails=vinResponse.Results.get(0)
            binding.vinDetailsTextView.text=  "VIN: ${vinDetails.VIN}\n" +
                    "Vehicle Type: ${vinDetails.VehicleType}\n" +
                    "Plant City: ${vinDetails.PlantCity}\n" +
                    "Plant Company Name: ${vinDetails.PlantCompanyName}\n" +
                    "Plant Country: ${vinDetails.PlantCountry}\n" +
                    "Plant State: ${vinDetails.PlantState}\n" +
                    "Make: ${vinDetails.Make}\n"
            Log.d("ranu",binding.vinDetailsTextView.text.toString())
        }
    }
}