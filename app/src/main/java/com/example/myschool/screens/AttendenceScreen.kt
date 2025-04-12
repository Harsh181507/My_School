package com.example.schoolapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class AttendanceStudent(
    val name: String,
    val enrollmentNumber: String,
    val presentPercentage: Float // between 0f and 100f
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(navController: NavController) {

    // 1st Year
    val firstYearAttendance = listOf(
        AttendanceStudent("Aniket Raut", "224101", 90f),
        AttendanceStudent("Om Solanke", "224102", 88f),
        AttendanceStudent("Devraj Kadam", "224103", 95f),
        AttendanceStudent("Atharva Nikam", "224104", 75f),
        AttendanceStudent("Onkar Wayse", "224105", 85f),
        AttendanceStudent("Om Gaikwad", "224106", 80f),
        AttendanceStudent("Yash Patil", "224107", 92f),
        AttendanceStudent("Yashraj Waghmare", "224108", 87f),
        AttendanceStudent("Sumit Pawar", "224109", 93f),
        AttendanceStudent("Rutik Gaikwad", "224110", 89f),
        AttendanceStudent("Ajay Chavan", "224111", 91f)
    )

    // 2nd Year
    val secondYearAttendance = listOf(
        AttendanceStudent("Swapnil Pawar", "224112", 86f),
        AttendanceStudent("Sayali Pawar", "224113", 84f),
        AttendanceStudent("Rutuja Nikam", "224114", 90f),
        AttendanceStudent("Pratiksha Pawar", "224115", 78f),
        AttendanceStudent("Snehal Pawar", "224116", 82f),
        AttendanceStudent("Shraddha Gaikwad", "224117", 85f),
        AttendanceStudent("Anuja Gaikwad", "224118", 88f),
        AttendanceStudent("Payal Pawar", "224119", 89f),
        AttendanceStudent("Aarti Nikam", "224120", 80f),
        AttendanceStudent("Pooja Pawar", "224121", 91f),
        AttendanceStudent("Tejal Chavan", "224122", 79f)
    )

    var selectedYear by remember { mutableStateOf("1st Year") }
    val yearOptions = listOf("1st Year", "2nd Year")

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

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

        val studentsToShow = if (selectedYear == "1st Year") firstYearAttendance else secondYearAttendance

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
                        Text("Enrollment No: ${student.enrollmentNumber}")
                        Text("Attendance: ${student.presentPercentage}%", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
