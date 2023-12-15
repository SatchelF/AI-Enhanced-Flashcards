package com.example.cs3200firebasestarter.ui.repositories

import retrofit2.Call
import com.example.cs3200firebasestarter.ui.models.GptRequest
import com.example.cs3200firebasestarter.ui.models.GptResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

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





