package com.example.vindecoder

import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(val apiService: VehicleAPI){
    suspend fun getVinDetails(vin: String):Response<VinResponse> {
        return apiService.getVinDetails(vin)
    }
}