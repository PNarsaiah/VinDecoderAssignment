package com.example.vindecoder

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface VehicleAPI {
    @GET("DecodeVinValues/{vin}?format=json")
    suspend fun getVinDetails(@Path("vin") vin: String): Response<VinResponse>
}
