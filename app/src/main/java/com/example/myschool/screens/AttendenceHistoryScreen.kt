package com.example.myschool.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.random.Random

data class Student(
    val name: String,
    val attendance: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceHistoryScreen(navController: NavController) {

    // 1st Year Students
    val firstYearStudents = listOf(
        Student("Aniket Raut", "${Random.nextInt(70, 100)}%"),
        Student("Om Solanke", "${Random.nextInt(70, 100)}%"),
        Student("Devraj Kadam", "${Random.nextInt(70, 100)}%"),
        Student("Atharva Nikam", "${Random.nextInt(70, 100)}%"),
        Student("Onkar Wayse", "${Random.nextInt(70, 100)}%"),
        Student("Om Gaikwad", "${Random.nextInt(70, 100)}%"),
        Student("Yash Patil", "${Random.nextInt(70, 100)}%"),
        Student("Yashraj Waghmare", "${Random.nextInt(70, 100)}%"),
        Student("Sumit Pawar", "${Random.nextInt(70, 100)}%"),
        Student("Rutik Gaikwad", "${Random.nextInt(70, 100)}%"),
        Student("Ajay Chavan", "${Random.nextInt(70, 100)}%")
    )

    // 2nd Year Students
    val secondYearStudents = listOf(
        Student("Swapnil Pawar", "${Random.nextInt(70, 100)}%"),
        Student("Sayali Pawar", "${Random.nextInt(70, 100)}%"),
        Student("Rutuja Nikam", "${Random.nextInt(70, 100)}%"),
        Student("Pratiksha Pawar", "${Random.nextInt(70, 100)}%"),
        Student("Snehal Pawar", "${Random.nextInt(70, 100)}%"),
        Student("Shraddha Gaikwad", "${Random.nextInt(70, 100)}%"),
        Student("Anuja Gaikwad", "${Random.nextInt(70, 100)}%"),
        Student("Payal Pawar", "${Random.nextInt(70, 100)}%"),
        Student("Aarti Nikam", "${Random.nextInt(70, 100)}%"),
        Student("Pooja Pawar", "${Random.nextInt(70, 100)}%"),
        Student("Tejal Chavan", "${Random.nextInt(70, 100)}%")
    )

    var selectedYear by remember { mutableStateOf("1st Year") }
    val yearOptions = listOf("1st Year", "2nd Year")

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        // Dropdown for year selection
        var expanded by remember { mutableStateOf(false) }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                readOnly = true,
                value = selectedYear,
                onValueChange = {},
                label = { Text("Select Year") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                yearOptions.forEach { year ->
                    DropdownMenuItem(
                        text = { Text(year) },
                        onClick = {
                            selectedYear = year
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        val studentsToShow = if (selectedYear == "1st Year") firstYearStudents else secondYearStudents

        LazyColumn {
            items(studentsToShow) { student ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Name: ${student.name}", style = MaterialTheme.typography.titleMedium)
                        Text("Attendance: ${student.attendance}")
                    }
                }
            }
        }
    }
}
