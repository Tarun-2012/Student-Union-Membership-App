package var8.tehlyani991673965.com

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MeetingConfirmationPage(navController: NavHostController, viewModel: MainViewModel) {
    var attendance by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Hello, ${viewModel.userName}!", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Please, Confirm your meeting attendance:")

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            RadioButton(selected = attendance == "Yes", onClick = { attendance = "Yes" })
            Text(text = "Yes")
        }
        Row {
            RadioButton(selected = attendance == "Maybe", onClick = { attendance = "Maybe" })
            Text(text = "Maybe")
        }
        Row {
            RadioButton(selected = attendance == "No", onClick = { attendance = "No" })
            Text(text = "No")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.setAttendance(attendance)
            navController.navigate("union_status")
        }) {
            Text("NEXT")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeetingConfirmationPagePreview() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = viewModel()
    MeetingConfirmationPage(navController, viewModel)
}

