package com.borissoto.thefeedexplorer.domain.use_case.get_doctors

import coil.network.HttpException
import com.borissoto.thefeedexplorer.common.Resource
import com.borissoto.thefeedexplorer.domain.model.Doctor
import com.borissoto.thefeedexplorer.domain.repository.DoctorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetDoctorsUseCase @Inject constructor(
    private val repository: DoctorRepository

){
    operator fun invoke(): Flow<Resource<List<Doctor>>> = flow {
        try {
            emit(Resource.Loading())
            val doctors = repository.getDoctors()
            emit(Resource.Success(doctors))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}