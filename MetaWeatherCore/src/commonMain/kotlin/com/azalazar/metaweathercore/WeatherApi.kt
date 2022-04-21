package com.azalazar.metaweathercore

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.collections.get

class WeatherApi {
    private val client = HttpClient()
    suspend fun locationSearch(): String {
        val response = client.get("$baseUrl/search/?query=buenos")
        return response.bodyAsText()
    }
    companion object {
        private const val baseUrl = "https://www.metaweather.com/api/location"
    }
}