package com.borissoto.thefeedexplorer.presentation.doctor.detail

import com.borissoto.thefeedexplorer.domain.model.Doctor

data class DoctorDetailState (
    val isLoading: Boolean = false,
    val doctor: Doctor? = null,
    val error: String = ""
)