package com.example.vindecoder

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel() {

    private val _vinDetails = MutableLiveData<VinResponse>()
    val vinDetails: LiveData<VinResponse> = _vinDetails

    fun getVinDetails(vin: String) {
        viewModelScope.launch {
            val response =repository.getVinDetails(vin)
            if (response.isSuccessful) {
                _vinDetails.value = response.body()

            } else {
                Log.e("VinDetailsViewModel", "Error: ${response.code()}")
            }
        }

    }
}