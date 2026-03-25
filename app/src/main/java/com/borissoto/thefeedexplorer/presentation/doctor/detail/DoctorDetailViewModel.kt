package com.borissoto.thefeedexplorer.presentation.doctor.detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borissoto.thefeedexplorer.common.Constants
import com.borissoto.thefeedexplorer.common.Resource
import com.borissoto.thefeedexplorer.domain.use_case.get_doctor.GetDoctorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DoctorDetailViewModel @Inject constructor(
    private val getDoctorUseCase: GetDoctorUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(DoctorDetailState())
    val state: State<DoctorDetailState> = _state

    init {
        savedStateHandle.get<Int>("doctorId")?.let { doctorId ->
            getDoctor(doctorId.toString())
        }
    }

    private fun getDoctor(doctorId: String) {
        getDoctorUseCase(doctorId).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = DoctorDetailState(doctor = result.data)
                    Log.d("doctorId viewmodel", "${result.data}")
                }
                is Resource.Error -> {
                    _state.value = DoctorDetailState(error = result.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    _state.value = DoctorDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}