package var8.tehlyani991673965.com

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainViewModel : ViewModel() {
    // User details
    private var _userName by mutableStateOf("")
    val userName: String get() = _userName

    private var _studentID by mutableStateOf("")
    val studentID: String get() = _studentID

    private var _attendance by mutableStateOf("")
    val attendance: String get() = _attendance

    private var _unionMember by mutableStateOf("")
    val unionMember: String get() = _unionMember

    fun setUserName(name: String) { _userName = name }
    fun setStudentID(id: String) { _studentID = id }
    fun setAttendance(choice: String) { _attendance = choice }
    fun setUnionMember(status: String) { _unionMember = status }
}
