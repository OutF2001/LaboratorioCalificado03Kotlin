package com.valdeos.flavio.laboratoriocalificado03
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("list/teacher-b")
    fun getTeachers(): Call<TeacherResponse>
}

data class TeacherResponse(val teachers: List<Teacher>)
