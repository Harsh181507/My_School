package com.example.myschool.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimetableScreen(navController: NavController) {
    val timetable = mapOf(
        "Monday" to listOf(
            "09:00-10:00 → DCS [PVD]",
            "10:00-11:00 → CEL [  ]",
            "11:00-12:00 → MAA [PRV]",
            "12:00-12:45 → LUNCH BREAK",
            "12:45-02:45 → S1- BPE [KBJ], S2- MAA [PRV], S3- DCS [PVD]",
            "03:00-05:00 → S1- MEE [PSM], S2- CEL [  ], S3- MEE [PRV]"
        ),
        "Tuesday" to listOf(
            "09:00-10:00 → GFM",
            "10:00-11:00 → EES [RRM]",
            "11:00-12:00 → BPE [KBJ]",
            "12:00-12:45 → LUNCH BREAK",
            "12:45-02:45 → MAA [PRV], DCS [PVD]",
            "03:00-05:00 → S1- MAA [PRV], S2- BPE [KBJ], S3- CEL [  ]"
        ),
        "Wednesday" to listOf(
            "10:00-12:00 → S1- DCS [PVD], S2- MEE [PRV], S3- BPE [KBJ]",
            "12:00-12:45 → LUNCH BREAK",
            "12:45-02:45 → S1- MEE [PSM], S2- DCS [PVD], S3- MAA [PRV]",
            "03:00-04:00 → DCS [PVD]",
            "04:00-05:00 → EES [RRM]"
        ),
        "Thursday" to listOf(
            "10:00-12:00 → S1- DCS [PVD], S2- CEL [  ], S3- MEE [PRV]",
            "12:00-12:45 → LUNCH BREAK",
            "12:45-02:45 → S1- CEL [  ], S2- MEE [PSM], S3- MAA [PRV]",
            "03:00-04:00 → CEL [  ]",
            "04:00-05:00 → BPE [KBJ]"
        ),
        "Friday" to listOf(
            "10:00-12:00 → S1- CEL [  ], S2- MAA [PRV], S3- DCS [PVD]",
            "12:00-12:45 → LUNCH BREAK",
            "12:45-02:45 → S1- MAA [PRV], S2- DCS [PVD], S3- CEL [  ]",
            "03:00-04:00 → DVS [PVD]",
            "04:00-05:00 → BPE [KBJ]"
        ),
        "Saturday" to listOf(
            "10:00-11:00 → MAA [PRV]",
            "11:00-12:00 → CEL [  ]",
            "12:45-01:45 → BPE [KBJ]",
            "01:45-02:45 → MAA [PRV]",
            "03:00-04:00 → CEL [  ]",
            "04:00-05:00 → BPE [KBJ]"
        )
    )

    val daysOfWeek = timetable.keys.toList()
    var selectedDay by remember { mutableStateOf(daysOfWeek.first()) }
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Class Timetable") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Day selection dropdown
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = selectedDay,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Select Day") },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    daysOfWeek.forEach { day ->
                        DropdownMenuItem(
                            text = { Text(day) },
                            onClick = {
                                selectedDay = day
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Display selected day's routine
            timetable[selectedDay]?.let { sessions ->
                LazyColumn {
                    items(sessions) { session ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp),
                            colors = CardDefaults.cardColors()
                        ) {
                            Text(
                                text = session,
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                            )
                        }
                    }
                }
            }
        }
    }
}
