package com.borissoto.thefeedexplorer.presentation.doctor.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.borissoto.thefeedexplorer.domain.model.Doctor

@Composable
fun DoctorListItem(
    doctor: Doctor,
    onItemClick: (Doctor) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), // Adds a shadow effect
        shape = MaterialTheme.shapes.medium // Rounded corners
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(doctor) }
                .padding(2.dp),

            ) {

//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(doctor.image)
//                    .crossfade(true)
//                    .build(),
//                contentDescription = doctor.name,
//                modifier = Modifier
//                    .size(100.dp)
//                    .padding(end = 16.dp),
//                contentScale = ContentScale.Crop
//            )
            Text(
                text = doctor.first_name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = doctor.last_name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f)
            )
        }

    }
}