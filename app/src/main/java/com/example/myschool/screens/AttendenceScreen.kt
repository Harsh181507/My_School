package com.example.myschool.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(navController: NavController) {
    val students = listOf(
        "John Doe", "Emma Watson", "Liam Brown", "Sophia Lee", "Oliver Smith",
        "Ava Martinez", "Noah Johnson", "Isabella Garcia", "Mason Wilson", "Mia Anderson",
        "James Thompson", "Charlotte White", "Benjamin Harris", "Amelia Martin", "Elijah Clark",
        "Lucas Walker", "Harper Young", "Ethan Hall", "Scarlett Allen", "Alexander King"
    )

    val attendanceStatus = remember { mutableStateMapOf<String, String>() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Attendance") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            Button(
                onClick = { println("Attendance saved: $attendanceStatus") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Save")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(text = "Mark Attendance", style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(16.dp))
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(students) { student ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = student, modifier = Modifier.weight(1f))
                        Row {
                            listOf("Present", "Absent").forEach { status ->
                                RadioButton(
                                    selected = attendanceStatus[student] == status,
                                    onClick = { attendanceStatus[student] = status }
                                )
                                Text(text = status)
                            }
                        }
                    }
                }
            }
        }
    }
}
