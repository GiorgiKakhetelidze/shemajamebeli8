package com.example.shemajamebeli8.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewCourse(
    @Json(name = "duration")
    val duration: String?,
    @Json(name = "icon_type")
    val iconType: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "main_color")
    val mainColor: String?,
    @Json(name = "question")
    val question: String?,
    @Json(name = "title")
    val title: String?
)