package com.example.vindecoder


data class VinResponse(
    val Count: Int,
    val Message: String,
    val Results: List<Result>,
    val SearchCriteria: String
)