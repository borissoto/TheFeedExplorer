package com.borissoto.thefeedexplorer.presentation.doctor.list

import com.borissoto.thefeedexplorer.domain.model.Doctor

data class DoctorListState(
    val isLoading: Boolean = false,
    val doctors: List<Doctor> = emptyList(),
    val error: String = ""
)
