##The Feed Explorer 

The Feed Explorer is a modern Android application built to display a list of doctors and their specific details, consuming data from a REST API. The app is built with Jetpack Compose and follows Clean Architecture principles.


##Architectural Choices

The project is organized into three main layers, following the Clean Architecture and MVVM (Model-View-ViewModel) patterns:
1.Presentation Layer: Uses Jetpack Compose for a fully reactive UI. ViewModels handle the UI state using Compose State and communicate with the domain layer via Use Cases.
2.Domain Layer: The core of the application logic. It contains pure Kotlin Models, Repository Interfaces, and Use Cases (e.g., GetDoctorsUseCase, GetDoctorUseCase). This layer is independent of any Android frameworks.
3.Data Layer: Responsible for data retrieval. It implements the Repository interfaces, handles network logic via Retrofit, and manages the conversion (mapping) of DTOs (Data Transfer Objects) to Domain Models.

##Third-Party Libraries
Dagger-Hilt | Dependency Injection | Reduces boilerplate code, manages ViewModel lifecycles, and makes the code highly testable.  
Retrofit / OkHttp | Networking | The industry standard for type-safe REST API consumption and robust HTTP management

##Time Spent on Project
Initial Setup & Clean Architecture Skeleton: ~1 hours.
Data Layer & Domain Logic (Retrofit/Repos/UseCases): ~1.5 hours.
UI Development (Compose & Theme): ~1.5 hours.
Navigation & DI Debugging (Hilt/Kapt/KSP Migration): ~30 min.
Total Estimated Time: 4.30 hours.
