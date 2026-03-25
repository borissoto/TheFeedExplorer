package com.borissoto.thefeedexplorer.data.remote.dto

import com.borissoto.thefeedexplorer.domain.model.Doctor

data class DoctorDTO(
    val accepting_new_patients: Boolean,
    val first_name: String,
    val id: Int,
    val last_name: String,
    val location: Location,
    val npi: String,
    val salary_range: String,
    val specialty: String,
    val suffix: String
)

fun DoctorDTO.toDoctor(): Doctor {
    return Doctor(
        first_name = first_name,
        last_name = last_name,
        specialty = specialty,
    )
}