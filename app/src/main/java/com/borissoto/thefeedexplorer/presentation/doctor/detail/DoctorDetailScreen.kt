package com.borissoto.thefeedexplorer.presentation.doctor.detail

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DoctorDetailScreen(
    viewModel: DoctorDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Log.d("MyComposable", "Doctor Details: " + state.doctor)
        state.doctor?.let { doctor ->
            Column {
                Text(text = "Name: ${doctor.first_name}")
                Text(text = "Last Name: ${doctor.last_name}")
                Text(text = "Speciality: ${doctor.specialty}")
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("Error loading doctor")
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .testTag("loading")
            )
        }
    }

}