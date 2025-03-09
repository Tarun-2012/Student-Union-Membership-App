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
fun UnionStatusPage(navController: NavHostController, viewModel: MainViewModel) {
    var studentID by rememberSaveable { mutableStateOf("") }
    var isUnionMember by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Text(text = "Hello, ${viewModel.userName}!", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Enter your ID:", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = studentID,
            onValueChange = { studentID = it },
            label = { Text("ID") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Union Member?")
            Switch(
                checked = isUnionMember,
                onCheckedChange = { isUnionMember = it }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.setStudentID(studentID)
            viewModel.setUnionMember(if (isUnionMember) "Y" else "N")
            navController.navigate("summary_page")
        }) {
            Text("NEXT")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnionStatusPagePreview() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = viewModel()
    UnionStatusPage(navController, viewModel)
}
