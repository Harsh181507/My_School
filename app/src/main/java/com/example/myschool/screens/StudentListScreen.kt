package com.example.myschool.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Student(
    val name: String,
    val age: String,
    val studentClass: String,
    val phoneNumber: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(navController: NavController) {
    val students = listOf(
        Student("John Doe", "16", "10th", "9876543210"),
        Student("Emma Watson", "15", "9th", "9876543222"),
        Student("Liam Brown", "17", "11th", "9876543233"),
        Student("Sophia Lee", "16", "10th", "9876543244"),
        Student("Oliver Smith", "15", "9th", "9876543255"),
        Student("Ava Martinez", "16", "10th", "9876543266"),
        Student("Noah Johnson", "17", "11th", "9876543277"),
        Student("Isabella Garcia", "15", "9th", "9876543288"),
        Student("Mason Wilson", "16", "10th", "9876543299"),
        Student("Mia Anderson", "17", "11th", "9876543300"),
        Student("James Thompson", "15", "9th", "9876543311"),
        Student("Charlotte White", "16", "10th", "9876543322"),
        Student("Benjamin Harris", "17", "11th", "9876543333"),
        Student("Amelia Martin", "15", "9th", "9876543344"),
        Student("Elijah Clark", "16", "10th", "9876543355")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Student List") },
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
                items(students) { student ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable { /* Do nothing for now */ },
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "Name: ${student.name}", style = MaterialTheme.typography.bodyLarge)
                            Text(text = "Class: ${student.studentClass}", style = MaterialTheme.typography.bodyMedium)
                            Text(text = "Phone: ${student.phoneNumber}", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}