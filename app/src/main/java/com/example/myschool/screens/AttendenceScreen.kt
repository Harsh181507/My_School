package com.example.myschool.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(navController: NavController) {
    val students = listOf(
        "MOMIN AZIZA GAFFAR" to "2116110053",
        "KHANDARE NAMRTA BALAJI" to "2215850082",
        "SHENDRE GAURI CHAGAN" to "2215850083",
        "DESHMUKHE RUTUJA ARVIND" to "2215850084",
        "GAIKWAD ANUJA TUKARAM" to "2215850085",
        "KSHIRSAGAR ANUSHKA PRASHANT" to "2215850087",
        "HONRAO ARNAV SACHIN" to "2215850088",
        "WAGHMARE GAYATRI HARI" to "2215850089",
        "DHAVAN AGRAJA SHIVSHANKAR" to "2215850090",
        "KANGUDE NIKITA NANDKUMAR" to "2215850091",
        "KAWADE KALYANI KAPIL" to "2215850092",
        "CHAVARE PRATHMESH GANESH" to "2215850094",
        "WANI GAYATRI MARUTI" to "2215850096",
        "PATANGE SAHIL SADANAND" to "2215850097",
        "TAMBARE BHAKTI SANTOSH" to "2215850100",
        "DAMTE BIBIAMINA JAFAR" to "2215850101",
        "MUSALE SWARALI RAJKUMAR" to "2215850102",
        "GHEMAD SHRUSHTI SUDAM" to "2215850103",
        "WAGHOLIKAR SARTHAK SANJAY" to "2215850109",
        "SAMBALE ASMITA SANJAY" to "2215850110",
        "GULAME VAISHNAVI VINOD" to "2215850111",
        "KARALE ISHWARI ASHOK" to "2215850112",
        "KALE DEEPANKAR SACHIN" to "2215850117",
        "GAIKWAD MEGHANA AMOL" to "2215850118",
        "PATHAN SANIYA KHAJUDDIN" to "2215850121",
        "VIBHUTE PRATIKSHA RAMESHWAR" to "2215850123",
        "DHARURKAR TRUPTI JIVAN" to "2215850124",
        "DHAS PRANAV BALAJI" to "2215850127",
        "DHAS VAISHNAVI VILAS" to "2215850128",
        "DHAS ONKAR HANUMANT" to "2215850135",
        "KULKARNI VIRAJ VILAS" to "2215850136",
        "SHINDE RAJ SHASHIKANT" to "2215850139",
        "BHASAKARE HARSHAD SANTOSH" to "2215850140",
        "DEVANPALLI MEGHA RATNAKAR" to "2215850142",
        "VIBHUTE ONKAR ARUN" to "2215850144",
        "KHURANGALE VRUSHALI LAXMAN" to "23213220172",
        "CHANDANE SANKET SUNIL" to "23213220173",
        "JADHAV TANUJA RAHUL" to "23213220175",
        "BASATE PRATIKSHA TUKARAM" to "23213220178",
        "TAMBE SAMADHAN SHRIRAM" to "23213220179",
        "LAWAND VAISHNAVI DNYANESHWAR" to "23213220181",
        "HANNURE AYESHA MOHAMMAD SHAFI" to "2215850086",
        "SHELAR SUJAL GURUDATTA" to "2215850122",
        "DHAME SAMADHAN MAHADEV" to "2215850131",
        "KHARAT KAPIL SHRIDHAR" to "2215850132",
        "RUSHIKESH SANTOSH MASKE" to "2215850137",
        "BARAVKAR VIKRANT VIJAYKUMAR" to "2215850141",
        "KIRATKARVE AARTI VISHNU" to "23213220174",
        "KUMBHAR DNYANESHWAR LAXMAN" to "23213220177"
    )

    val attendanceStatus = remember { mutableStateMapOf<String, String>() }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

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
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Attendance has been saved.")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Save")
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Text(
                text = "Mark Attendance",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(students) { (student, rollNo) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp, horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = student, fontWeight = FontWeight.Bold)
                            Text(
                                text = "Roll No: $rollNo",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
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
