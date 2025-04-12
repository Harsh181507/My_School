package com.example.schoolapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Student(
    val name: String,
    val enrollmentNumber: String,
    val mobileNumber: String,
    val parentMobileNumber: String,
    val email: String,
    val dob: String,
    val sem1Marks: String,
    val sem2Marks: String,
    val sem3Marks: String,
    val sem4Marks: String,
    val hscMarks: String,
    val sscMarks: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(navController: NavController) {

    // 1st Year Students
    val firstYearStudents = listOf(
        Student("Aniket Raut", "224101", "9876543210", "9123456780", "aniket.raut@school.com", "2005-01-01", "80", "85", "82", "88", "90", "92"),
        Student("Om Solanke", "224102", "9876543210", "9123456780", "om.solanke@school.com", "2005-01-01", "75", "80", "78", "85", "88", "90"),
        Student("Devraj Kadam", "224103", "9876543210", "9123456780", "devraj.kadam@school.com", "2005-01-01", "82", "86", "80", "87", "89", "91"),
        Student("Atharva Nikam", "224104", "9876543210", "9123456780", "atharva.nikam@school.com", "2005-01-01", "70", "75", "74", "78", "82", "85"),
        Student("Onkar Wayse", "224105", "9876543210", "9123456780", "onkar.wayse@school.com", "2005-01-01", "88", "84", "86", "90", "92", "93"),
        Student("Om Gaikwad", "224106", "9876543210", "9123456780", "om.gaikwad@school.com", "2005-01-01", "68", "72", "70", "75", "80", "82"),
        Student("Yash Patil", "224107", "9876543210", "9123456780", "yash.patil@school.com", "2005-01-01", "79", "83", "81", "85", "87", "88"),
        Student("Yashraj Waghmare", "224108", "9876543210", "9123456780", "yashraj.waghmare@school.com", "2005-01-01", "74", "78", "77", "80", "83", "85"),
        Student("Sumit Pawar", "224109", "9876543210", "9123456780", "sumit.pawar@school.com", "2005-01-01", "85", "89", "87", "90", "92", "94"),
        Student("Rutik Gaikwad", "224110", "9876543210", "9123456780", "rutik.gaikwad@school.com", "2005-01-01", "71", "75", "73", "78", "81", "84"),
        Student("Ajay Chavan", "224111", "9876543210", "9123456780", "ajay.chavan@school.com", "2005-01-01", "76", "80", "78", "82", "85", "87")
    )

    // 2nd Year Students
    val secondYearStudents = listOf(
        Student("Swapnil Pawar", "224112", "9876543210", "9123456780", "swapnil.pawar@school.com", "2005-01-01", "83", "87", "85", "89", "91", "93"),
        Student("Sayali Pawar", "224113", "9876543210", "9123456780", "sayali.pawar@school.com", "2005-01-01", "72", "76", "74", "79", "83", "85"),
        Student("Rutuja Nikam", "224114", "9876543210", "9123456780", "rutuja.nikam@school.com", "2005-01-01", "80", "84", "82", "86", "89", "91"),
        Student("Pratiksha Pawar", "224115", "9876543210", "9123456780", "pratiksha.pawar@school.com", "2005-01-01", "69", "73", "71", "76", "79", "81"),
        Student("Snehal Pawar", "224116", "9876543210", "9123456780", "snehal.pawar@school.com", "2005-01-01", "77", "81", "79", "84", "86", "88"),
        Student("Shraddha Gaikwad", "224117", "9876543210", "9123456780", "shraddha.gaikwad@school.com", "2005-01-01", "73", "77", "75", "80", "84", "86"),
        Student("Anuja Gaikwad", "224118", "9876543210", "9123456780", "anuja.gaikwad@school.com", "2005-01-01", "81", "85", "83", "88", "90", "92"),
        Student("Payal Pawar", "224119", "9876543210", "9123456780", "payal.pawar@school.com", "2005-01-01", "78", "82", "80", "85", "87", "89"),
        Student("Aarti Nikam", "224120", "9876543210", "9123456780", "aarti.nikam@school.com", "2005-01-01", "74", "78", "76", "81", "83", "85"),
        Student("Pooja Pawar", "224121", "9876543210", "9123456780", "pooja.pawar@school.com", "2005-01-01", "86", "90", "88", "92", "94", "96"),
        Student("Tejal Chavan", "224122", "9876543210", "9123456780", "tejal.chavan@school.com", "2005-01-01", "70", "74", "72", "77", "80", "82")
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
                        Text("Enrollment No: ${student.enrollmentNumber}")
                        Text("Mobile: ${student.mobileNumber}")
                        Text("Parent Mobile: ${student.parentMobileNumber}")
                        Text("Email: ${student.email}")
                        Text("DOB: ${student.dob}")
                        Text("SEM-I: ${student.sem1Marks}")
                        Text("SEM-II: ${student.sem2Marks}")
                        Text("SEM-III: ${student.sem3Marks}")
                        Text("SEM-IV: ${student.sem4Marks}")
                        Text("HSC: ${student.hscMarks}")
                        Text("SSC: ${student.sscMarks}")
                    }
                }
            }
        }
    }
}
