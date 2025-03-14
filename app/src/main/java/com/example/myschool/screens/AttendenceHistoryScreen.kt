package com.example.myschool.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceHistoryScreen(navController: NavController) {
    val students = listOf(
        "John Doe", "Emma Watson", "Liam Brown", "Sophia Lee", "Oliver Smith",
        "Ava Martinez", "Noah Johnson", "Isabella Garcia", "Mason Wilson", "Mia Anderson",
        "James Thompson", "Charlotte White", "Benjamin Harris", "Amelia Martin", "Elijah Clark",
        "Lucas Walker", "Harper Young", "Ethan Hall", "Scarlett Allen", "Alexander King",
        "Grace Scott", "Daniel Adams", "Chloe Nelson", "Henry Carter", "Lily Baker",
        "Samuel Wright", "Emily Green", "Jack Lewis", "Aria Hill", "Michael Evans"
    )

    val attendanceMap = remember {
        students.associateWith { Random.nextInt(50, 100) } // Random attendance percentage (50% - 100%)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Attendance History") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)) {
            LazyColumn {
                items(attendanceMap.toList()) { (student, attendance) ->
                    Card(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Row(modifier = Modifier.padding(16.dp)) {
                            Text(text = student, modifier = Modifier.weight(1f))
                            Text(text = "$attendance%", color = MaterialTheme.colorScheme.primary)
                        }
                    }
                }
            }
        }
    }
}
