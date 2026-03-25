package com.borissoto.thefeedexplorer.domain.repository

import com.borissoto.thefeedexplorer.data.remote.dto.DoctorDto

interface DoctorRepository {

    suspend fun getDoctors(): List<DoctorDto>

    suspend fun getDoctorById(id: String): DoctorDto?
}