package com.borissoto.thefeedexplorer.data.repository

import com.borissoto.thefeedexplorer.data.remote.DoctorApi
import com.borissoto.thefeedexplorer.data.remote.dto.DoctorDto
import com.borissoto.thefeedexplorer.domain.repository.DoctorRepository
import javax.inject.Inject

class DoctorRepositoryImpl @Inject constructor(
    private val api: DoctorApi
) : DoctorRepository {

    override suspend fun getDoctors(): List<DoctorDto> {
        return api.getDoctors()
    }
}
