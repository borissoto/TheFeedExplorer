package com.borissoto.thefeedexplorer.presentation

sealed class Screens(val route: String){
    object DoctorListScreen: Screens("doctor_list_screen")
    object DoctorDetailScreen: Screens("doctor_detail_screen")
}