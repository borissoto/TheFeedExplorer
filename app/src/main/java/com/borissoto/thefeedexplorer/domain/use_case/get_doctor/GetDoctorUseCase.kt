package com.borissoto.thefeedexplorer.domain.use_case.get_doctor

import coil.network.HttpException
import com.borissoto.thefeedexplorer.common.Resource
import com.borissoto.thefeedexplorer.data.remote.dto.toDoctor
import com.borissoto.thefeedexplorer.domain.model.Doctor
import com.borissoto.thefeedexplorer.domain.repository.DoctorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetDoctorUseCase @Inject constructor(
    private val repository: DoctorRepository

){
    operator fun invoke(doctorId: String): Flow<Resource<Doctor>> = flow {
        try {
            emit(Resource.Loading<Doctor>())
            val doctor = repository.getDoctorById(doctorId)
            if (doctor != null) {
                emit(Resource.Success(doctor.toDoctor()))
            } else {
                emit(Resource.Error("No Doctor found!"))
            }
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}