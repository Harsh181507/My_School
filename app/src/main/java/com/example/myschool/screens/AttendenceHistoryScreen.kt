package com.example.myschool.screens

import android.graphics.Color
import android.widget.LinearLayout
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlin.random.Random

data class Student(
    val name: String,
    val attendance: Map<String, Int> // month to attendance percent
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceHistoryScreen(navController: NavController) {
    val months = listOf(
        "January", "February", "March", "April",
        "May", "June", "July", "August", "September",
        "October", "November", "December"
    )
    val yearOptions = listOf("1st Year", "2nd Year", "3rd Year")

    var selectedYear by remember { mutableStateOf("1st Year") }
    var selectedMonth by remember { mutableStateOf("January") }

    // Generates attendance for all months, with April and May set to 0
    fun generateAttendance(): Map<String, Int> {
        return months.associateWith { month ->
            if (month == "April" || month == "May" || month == "June" || month == "July" || month == "August" || month == "September" || month == "October" || month == "November" || month == "December") 0 else Random.nextInt(
                70,
                100
            )
        }
    }

    // 1st Year Students
    val firstYearStudents = remember {
        listOf(
            "Aniket Raut",
            "Om Solanke",
            "Devraj Kadam",
            "Atharva Nikam",
            "Onkar Wayse",
            "Om Gaikwad",
            "Yash Patil",
            "Yashraj Waghmare",
            "Sumit Pawar",
            "Rutik Gaikwad",
            "Ajay Chavan",
            "SONAWANE ARTI DEEPAK",
            "SUDAKE TEJASHRI MAHADEV",
            "SUTAR SONALI BHAUSAHEB",
            "THONGE YASHRAJ YUVRAJ",
            "WAGHMARE OMKAR VISHWANATH",
            "WAGHMARE YASH NANDKUMAR",
            "WARE GAYATRI VASUDEV",
            "WAYKULE SHUBHAM BAPUSAHEB",
            "SHINDE SHRUTI KANTILAL",
            "PATIL RENUKA PRASHANT",
            "SITAPE AKSHRA BALU",
            "MAHADIK AMARJIT SOPANKAKA"

        ).map { Student(it, generateAttendance()) }
    }

    // 2nd Year Students
    val secondYearStudents = remember {
        listOf(
            "Swapnil Pawar",
            "Sayali Pawar",
            "Rutuja Nikam",
            "Pratiksha Pawar",
            "Snehal Pawar",
            "Shraddha Gaikwad",
            "Anuja Gaikwad",
            "NARSUDE PRANJALI SUHAS",
            "NETKE ARPITA ANANT",
            "PAWAR SARANG SURAJ",
            "PAWAR YASH PANDURANG",
            "PUJARI VAIDAVI MUKIND",
            "SALUNKE SACHIN NITIN",
            "SARAF PRACHI SANTOSH",
            "SATPUTE TANVI ISHWAR",
            "SHIDE VAISHNAVI SANTOSH",
            "SHINDE SHRIRAM DATTATRAYA",
            "SHINDE SIDDHI SUHAS",
            "SHINDE SOHAM PANDURANG",
            "SHINDE TEJASWINI SATISH",
            "Payal Pawar",
            "Aarti Nikam",
            "Pooja Pawar",
            "Tejal Chavan"
        ).map { Student(it, generateAttendance()) }
    }
    val thirdYearStudents = remember {
        listOf(
            "AGARKAR ATHARV VINAYAK",
            "ANKUSHARAO JAY SURAJ",
            "AWAD GAYATRI KHANDERAO",
            "BAGWAN SHAHIDRAZA SHAFIK",
            "BAKSHI PRIYANKA JAYSING",
            "BHOSALE YASH HARISHCHANDRA",
            "BOBE TUSHAR SOMNATH",
            "CHAUTMAHAL SAMIKSHA AVINASH",
            "CHAVAN ONKAR SAMADHAN",
            "CHAVAN PRUTHVIRAJ ANANT",
            "CHAVAN RUSHIKESH SANTOSH",
            "DAKHANI S DANISH S AHEMAD",
            "DEVANPALLI NIKHIL RATNAKAR",
            "DHARURKAR SWARUP AJAY",
            "DHARURKAR VAISHNAVI GANESH",
            "DHOLE PRACHI RAMESH",
            "DOKE ROHAN KRUSHNA",
            "DOMBE PRATIKSHA MANOJ",
            "FATALE RUPESH SANTOSH",
            "FUGE TRUPTI SAUDAGAR",
            "GADHAVE GANESH MAHADEV",
            "GAIKWAD POURNIMA SACHIN",
            "GARDADE ARATI MAHENDRA",
            "GAWARE SUCHITA DNYANESHWAR",
            "GHOLAP NAGESH JIVAN",
            "GHOLAP VAISHNAVI GANESH",
            "GUNJAL SANIKA BAPU",
            "JAGADALE PRASHANT UMESH",
            "JAGADALE SUSHANT UMESH",
            "KAMBLE ANKITA SANTOSH",
            "KANDE PRAJWAL POPAT",
            "KARALE SHANTANU NAVNATH",
            "KHATKE SOHAM SHAHAJI",
            "KURUND RUTUJA SHAHAJI",
            "MAINDARKAR CHAITANYA DHANANJAY",
            "MANGIRE SHAMBHAVI CHANDAN",
            "MANJARE SAKSHI VASANT",
            "MAHADIK AMARJIT SOPANKAKA"

        ).map { Student(it, generateAttendance()) }
    }

    val studentsToShow = if (selectedYear == "1st Year") firstYearStudents else secondYearStudents
    val attendanceForGraph = studentsToShow.mapIndexed { index, student ->
        BarEntry(index.toFloat(), student.attendance[selectedMonth]?.toFloat() ?: 0f)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Dropdown for Year
        DropdownSelector(
            label = "Select Year",
            options = yearOptions,
            selectedOption = selectedYear,
            onOptionSelected = { selectedYear = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Dropdown for Month
        DropdownSelector(
            label = "Select Month",
            options = months,
            selectedOption = selectedMonth,
            onOptionSelected = { selectedMonth = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Attendance Graph", style = MaterialTheme.typography.titleMedium)

        AndroidView(
            factory = { context ->
                BarChart(context).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        600
                    )
                    description = Description().apply { text = "Attendance (%)" }
                    axisRight.isEnabled = false
                    setFitBars(true)
                }
            },
            update = { chart ->
                val dataSet = BarDataSet(attendanceForGraph, "Attendance").apply {
                    color = Color.BLUE
                    valueTextColor = Color.BLACK
                    valueTextSize = 12f
                }
                chart.data = BarData(dataSet)
                chart.invalidate()
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn {
            items(studentsToShow) { student ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Name: ${student.name}", style = MaterialTheme.typography.titleMedium)
                        Text("Attendance in $selectedMonth: ${student.attendance[selectedMonth]}%")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownSelector(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            readOnly = true,
            value = selectedOption,
            onValueChange = {},
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
