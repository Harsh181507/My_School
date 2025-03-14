package com.example.myschool.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceHistoryScreen(navController: NavController) {
    val students = listOf(
        "MOMIN AZIZA GAFFAR", "KHANDARE NAMRTA BALAJI", "SHENDRE GAURI CHAGAN", "DESHMUKHE RUTUJA ARVIND",
        "GAIKWAD ANUJA TUKARAM", "KSHIRSAGAR ANUSHKA PRASHANT", "HONRAO ARNAV SACHIN", "WAGHMARE GAYATRI HARI",
        "DHAVAN AGRAJA SHIVSHANKAR", "KANGUDE NIKITA NANDKUMAR", "KAWADE KALYANI KAPIL", "CHAVARE PRATHMESH GANESH",
        "WANI GAYATRI MARUTI", "PATANGE SAHIL SADANAND", "TAMBARE BHAKTI SANTOSH", "DAMTE BIBIAMINA JAFAR",
        "MUSALE SWARALI RAJKUMAR", "GHEMAD SHRUSHTI SUDAM", "WAGHOLIKAR SARTHAK SANJAY", "SAMBALE ASMITA SANJAY",
        "GULAME VAISHNAVI VINOD", "KARALE ISHWARI ASHOK", "KALE DEEPANKAR SACHIN", "GAIKWAD MEGHANA AMOL",
        "PATHAN SANIYA KHAJUDDIN", "VIBHUTE PRATIKSHA RAMESHWAR", "DHARURKAR TRUPTI JIVAN", "DHAS PRANAV BALAJI",
        "DHAS VAISHNAVI VILAS", "DHAS ONKAR HANUMANT", "KULKARNI VIRAJ VILAS", "SHINDE RAJ SHASHIKANT",
        "BHASAKARE HARSHAD SANTOSH", "DEVANPALLI MEGHA RATNAKAR", "VIBHUTE ONKAR ARUN", "KHURANGALE VRUSHALI LAXMAN",
        "CHANDANE SANKET SUNIL", "JADHAV TANUJA RAHUL", "BASATE PRATIKSHA TUKARAM", "TAMBE SAMADHAN SHRIRAM",
        "LAWAND VAISHNAVI DNYANESHWAR", "HANNURE AYESHA MOHAMMAD SHAFI", "SHELAR SUJAL GURUDATTA",
        "DHAME SAMADHAN MAHADEV", "KHARAT KAPIL SHRIDHAR", "RUSHIKESH SANTOSH MASKE", "BARAVKAR VIKRANT VIJAYKUMAR",
        "KIRATKARVE AARTI VISHNU", "KUMBHAR DNYANESHWAR LAXMAN"
    )

    val attendanceMap = remember {
        students.associateWith { Random.nextInt(0, 100) } // Random attendance percentage (50% - 100%)
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            LazyColumn {
                items(attendanceMap.toList()) { (student, attendance) ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Row(modifier = Modifier.padding(16.dp)) {
                            Text(text = student, modifier = Modifier.weight(1f))
                            Text(
                                text = "$attendance%",
                                color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}
