package com.borissoto.thefeedexplorer.domain.repository

import com.borissoto.thefeedexplorer.data.remote.dto.DoctorDTO

interface DoctorRepository {

    suspend fun getDoctors(): List<DoctorDTO>
}