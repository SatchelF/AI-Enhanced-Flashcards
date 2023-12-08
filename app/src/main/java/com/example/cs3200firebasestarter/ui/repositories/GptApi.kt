package com.example.cs3200firebasestarter.ui.repositories

import retrofit2.Call
import com.example.cs3200firebasestarter.ui.models.GptRequest
import com.example.cs3200firebasestarter.ui.models.GptResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface GptApi {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer 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"
    )
    @POST("/v1/completions")
    fun getCompletion(
        @Body requestBody: GptRequest
    ): Call<GptResponse>
}





