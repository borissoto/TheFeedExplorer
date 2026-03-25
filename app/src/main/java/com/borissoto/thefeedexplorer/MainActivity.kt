package com.borissoto.thefeedexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.borissoto.thefeedexplorer.presentation.Screens
import com.borissoto.thefeedexplorer.presentation.doctor.list.DoctorListScreen
import com.borissoto.thefeedexplorer.presentation.doctor.detail.DoctorDetailScreen
import com.borissoto.thefeedexplorer.ui.theme.TheFeedExplorerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheFeedExplorerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.DoctorListScreen.route
                    ) {
                        composable(
                            route = Screens.DoctorListScreen.route
                        ) {
                            DoctorListScreen(navController)
                        }
                        composable(
                            route = Screens.DoctorDetailScreen.route + "/{doctorId}",
                            arguments = listOf(
                                navArgument("doctorId") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            DoctorDetailScreen()
                        }
                    }
                }

            }
        }
    }
}
