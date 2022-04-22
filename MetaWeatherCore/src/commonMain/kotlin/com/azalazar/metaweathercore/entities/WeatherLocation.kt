package com.azalazar.metaweathercore.entities

import kotlinx.serialization.Serializable

@Serializable
data class WeatherLocation(
    val woeid: Int,
    val title: String,
    val location_type: String,
    val latt_long: String
    )