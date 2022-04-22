package com.azalazar.metaweathercore

import com.azalazar.metaweathercore.entities.WeatherLocation
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class WeatherApi {

    private val httpClient = httpClient() {
        install(ContentNegotiation) {
            json(Json { isLenient = true; ignoreUnknownKeys = true })
        }
    }

    @Throws(Throwable::class)
    suspend fun locationSearch(query: String): List<WeatherLocation> {
        return httpClient.get("$baseUrl/search/?query=${query}").body()
    }

    companion object {
        private const val baseUrl = "https://www.metaweather.com/api/location"
    }
}