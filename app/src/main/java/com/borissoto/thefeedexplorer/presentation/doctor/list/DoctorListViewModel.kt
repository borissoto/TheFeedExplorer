package com.borissoto.thefeedexplorer.presentation.doctor.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borissoto.thefeedexplorer.common.Resource
import com.borissoto.thefeedexplorer.domain.use_case.get_doctors.GetDoctorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DoctorListViewModel @Inject constructor(
    private val getDoctorsUseCase: GetDoctorsUseCase
): ViewModel(){

    private val _state = mutableStateOf(DoctorListState())
    val state: State<DoctorListState> = _state

    init {
        getDoctors()
    }

    private fun getDoctors() {
        getDoctorsUseCase().onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = DoctorListState(doctors = it.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = DoctorListState(error = it.message ?: "Unexpected Error")
                }
                is Resource.Loading -> {
                    _state.value = DoctorListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}