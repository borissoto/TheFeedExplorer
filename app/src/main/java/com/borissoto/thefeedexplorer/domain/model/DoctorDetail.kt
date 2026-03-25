package com.borissoto.thefeedexplorer.domain.model

import com.borissoto.thefeedexplorer.data.remote.dto.Location

data class DoctorDetail(
    val first_name: String,
    val last_name: String,
    val location: Location,
    val accepting_new_patients: Boolean,
    val npi: String,
    val specialty: String,
    val suffix: String
)
