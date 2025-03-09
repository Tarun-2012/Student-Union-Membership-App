package var8.tehlyani991673965.com

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SummaryPage(navController: NavHostController, viewModel: MainViewModel) {
    var showDialog by rememberSaveable { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = { navController.popBackStack("home_page", inclusive = false) }) {
                    Text("EXIT")
                }
            },
            title = { Text("Meeting Summary for ${viewModel.userName}") },
            text = {
                Column {
                    Text("Attendance: ${viewModel.attendance}")
                    Text("Your ID: ${viewModel.studentID}")
                    Text("Union Member: ${viewModel.unionMember}")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SummaryPagePreview() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = viewModel()
    SummaryPage(navController, viewModel)
}

