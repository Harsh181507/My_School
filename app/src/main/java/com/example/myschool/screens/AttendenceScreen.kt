package com.example.myschool.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

data class AttendanceStudent(
    val name: String,
    var isPresent: MutableState<Boolean?> = mutableStateOf(null) // Live-updating observable
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(navController: NavController) {
    val firstYearStudents = remember {
        mutableStateListOf(
            AttendanceStudent("Aniket Raut"),
            AttendanceStudent("Om Solanke"),
            AttendanceStudent("Devraj Kadam"),
            AttendanceStudent("Atharva Nikam"),
            AttendanceStudent("Onkar Wayse"),
            AttendanceStudent("Om Gaikwad"),
            AttendanceStudent("Yash Patil"),
            AttendanceStudent("Yashraj Waghmare"),
            AttendanceStudent("Sumit Pawar"),
            AttendanceStudent("Rutik Gaikwad"),
            AttendanceStudent("Ajay Chavan")
        )
    }

    val secondYearStudents = remember {
        mutableStateListOf(
            AttendanceStudent("Swapnil Pawar"),
            AttendanceStudent("Sayali Pawar"),
            AttendanceStudent("Rutuja Nikam"),
            AttendanceStudent("Pratiksha Pawar"),
            AttendanceStudent("Snehal Pawar"),
            AttendanceStudent("Shraddha Gaikwad"),
            AttendanceStudent("Anuja Gaikwad"),
            AttendanceStudent("Payal Pawar"),
            AttendanceStudent("Aarti Nikam"),
            AttendanceStudent("Pooja Pawar"),
            AttendanceStudent("Tejal Chavan")
        )
    }

    var selectedYear by remember { mutableStateOf("1st Year") }
    val yearOptions = listOf("1st Year", "2nd Year")

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val students = if (selectedYear == "1st Year") firstYearStudents else secondYearStudents

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            var expanded by remember { mutableStateOf(false) }

            // Year Dropdown
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

            // Student List with RadioButtons
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(students) { student ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text(student.name, style = MaterialTheme.typography.titleMedium)

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = student.isPresent.value == true,
                                    onClick = { student.isPresent.value = true }
                                )
                                Text("Present")
                            }

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = student.isPresent.value == false,
                                    onClick = { student.isPresent.value = false }
                                )
                                Text("Absent")
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Save Button
            Button(
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Attendance saved successfully!")
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Save Attendance")
            }
        }
    }
}
