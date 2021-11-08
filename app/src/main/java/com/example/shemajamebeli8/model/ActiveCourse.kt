package com.example.shemajamebeli8.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ActiveCourse(
    @Json(name = "background_color_present")
    val backgroundColorPresent: String?,
    @Json(name = "booking_time")
    val bookingTime: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "main_color")
    val mainColor: String?,
    @Json(name = "play_button_color_present")
    val playButtonColorPresent: String?,
    @Json(name = "progress")
    val progress: String?,
    @Json(name = "title")
    val title: String?
)