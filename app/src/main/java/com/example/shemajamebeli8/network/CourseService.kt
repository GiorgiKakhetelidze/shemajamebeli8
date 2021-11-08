package com.example.shemajamebeli8.network

import com.example.shemajamebeli8.model.Courses
import retrofit2.Response
import retrofit2.http.GET

interface CourseService {

    @GET("4167a598-b68c-420f-b6e1-fef68b89a10d")
    suspend fun getCourses() : Response<Courses>

}