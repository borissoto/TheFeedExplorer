import com.borissoto.thefeedexplorer.data.remote.dto.DoctorDto
import com.borissoto.thefeedexplorer.domain.model.Doctor

data class DoctorDetailDto(
    val accepting_new_patients: Boolean,
    val first_name: String,
    val id: Int,
    val last_name: String,

    val npi: String,
    val salary_range: String,
    val specialty: String,
    val suffix: String
)

