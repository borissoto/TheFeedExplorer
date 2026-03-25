package com.borissoto.thefeedexplorer.data.remote

import com.borissoto.thefeedexplorer.data.remote.dto.DoctorDto
import retrofit2.http.GET

interface DoctorApi {

    @GET("v1/5bb09ab0-8d6d-4d85-8284-b6a467299353")
    suspend fun getDoctors(): List<DoctorDto>
}