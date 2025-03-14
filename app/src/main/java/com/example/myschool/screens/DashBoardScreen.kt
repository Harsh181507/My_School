package com.example.myschool.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DashboardButton("Add Student", onClick = { navController.navigate("add_student") })
            DashboardButton("Student List", onClick = { navController.navigate("student_list") })
            DashboardButton("Mark Attendance", onClick = { navController.navigate("attendance") })
            DashboardButton("Attendance History", onClick = { navController.navigate("attendance_history") })
            DashboardButton("Timetable", onClick = { navController.navigate("timetable") })
            DashboardButton("Announcements", onClick = { navController.navigate("announcements") })
            DashboardButton("Profile", onClick = { navController.navigate("profile") })
        }
    }
}

@Composable
fun DashboardButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = text)
    }
}
