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
        Student("Ajay Chavan", "224111", "9876543210", "9123456780", "ajay.chavan@school.com", "2005-01-01", "76", "80", "78", "82", "85", "87"),
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
        Student("Tejal Chavan", "224122", "9876543210", "9123456780", "tejal.chavan@school.com", "2005-01-01", "70", "74", "72", "77", "80", "82"),
        Student("Pratiksha Pawar", "224115", "9876543210", "9123456780", "pratiksha.pawar@school.com", "2005-01-01", "69", "73", "71", "76", "79", "81"),
        Student("Snehal Pawar", "224116", "9876543210", "9123456780", "snehal.pawar@school.com", "2005-01-01", "77", "81", "79", "84", "86", "88"),
        Student("Shraddha Gaikwad", "224117", "9876543210", "9123456780", "shraddha.gaikwad@school.com", "2005-01-01", "73", "77", "75", "80", "84", "86"),
        Student("Anuja Gaikwad", "224118", "9876543210", "9123456780", "anuja.gaikwad@school.com", "2005-01-01", "81", "85", "83", "88", "90", "92"),
        Student("Payal Pawar", "224119", "9876543210", "9123456780", "payal.pawar@school.com", "2005-01-01", "78", "82", "80", "85", "87", "89"),
    )
    //3rd Year Students
    val ThirdYearStudents = listOf(
        Student("MOMIN AZIZA GAFFAR", "2116110053", "8378923694", "9145509062", "azizamomin68@gmail.com", "27-03-2006", "80.43", "66.88", "85.41", "87.11", "NA", "68.4"),
        Student("KHANDARE NAMRTA BALAJI", "2215850082", "8999189793", "8975239725", "namrtakhandare97@gmail.com", "14-06-2006", "88.13", "76", "80.47", "83.44", "NA", "93.6"),
        Student("SHENDRE GAURI CHAGAN", "2215850083", "9518923968", "9322059289", "gaurishendre64@gmail.com", "21-10-2006", "76.29", "76", "79.53", "84.56", "NA", "73.2"),
        Student("DESHMUKHE RUTUJA ARVIND", "2215850084", "8805933983", "9370395702", "deshmukherutujao6@gmail.com", "06-05-2006", "78.86", "81.13", "86.59", "89.11", "NA", "86"),
        Student("GAIKWAD ANUJA TUKARAM", "2215850085", "7498487108", "8080866330", "gaikwadanuja327@gmail.com", "23-08-2006", "88.86", "88", "89.28", "90.11", "NA", "93"),
        Student("KSHIRSAGAR ANUSHKA PRASHANT", "2215850087", "7498670235", "9763256453", "kshirsagaranushka696@gmail.com", "24-04-2005", "78", "70", "77.4", "81.11", "NA", "84"),
        Student("HONRAO ARNAV SACHIN", "2215850088", "9822704206", "9822704206", "anitahonrao745@gmail.com", "30-05-2006", "70.43", "62.5", "64.24", "67.67", "NA", "82.4"),
        Student("WAGHMARE GAYATRI HARI", "2215850089", "9529897075", "9529897075", "gayatriwaghmare2006@gmail.com", "07-02-2006", "82.14", "79", "82", "83.56", "NA", "89.8"),
        Student("DHAVAN AGRAJA SHIVSHANKAR", "2215850090", "7499998107", "7499998107", "agrajadhavan23@gmail.com", "23-02-2006", "76.8", "73", "70", "76.8", "NA", "62"),
        Student("KANGUDE NIKITA NANDKUMAR", "2215850091", "9699152044", "9922764745", "nikitakangude12@gmail.com", "30-03-2006", "87.14", "83.5", "92.71", "91.44", "NA", "94.4"),
        Student("KAWADE KALYANI KAPIL", "2215850092", "9699747770", "9890993636", "kkawade871@gmail.com", "13-04-2006", "80.7", "72", "72.6", "72.8", "NA", "90.4"),
        Student("CHAVARE PRATHMESH GANESH", "2215850094", "9579993866", "9421873358", "chavareprathmesh753@gmail.com", "11-10-2006", "72", "60.25", "66.12", "562", "NA", "74.8"), // Note: SEM-IV marks looks unusual
        Student("WANI GAYATRI MARUTI", "2215850096", "7620056225", "8380917462", "gayatrimwani@gmail.com", "07-01-2006", "79", "72", "76.12", "75.89", "NA", "94.8"),
        Student("PATANGE SAHIL SADANAND", "2215850097", "7218109209", "8975306365", "sahilpatange8@gmail.com", "10-01-2006", "71.43", "61.38", "66.98", "68", "NA", "67.6"),
        Student("TAMBARE BHAKTI SANTOSH", "2215850100", "8767494344", "9011969566", "bhaktitambare@gmail.com", "24-03-2006", "75", "71.6", "78", "80", "NA", "80"),
        Student("DAMTE BIBIAMINA JAFAR", "2215850101", "9359883151", "9359883151", "aliyadamte17@gmail.com", "17-09-2006", "83.14", "75", "71.53", "75.22", "NA", "88.4"),
        Student("MUSALE SWARALI RAJKUMAR", "2215850102", "9356092793", "9764753741", "swarali0019@gmail.com", "19-07-2005", "73.43", "64.38", "73.06", "74.33", "NA", "70.4"),
        Student("GHEMAD SHRUSHTI SUDAM", "2215850103", "9699860330", "7620609803", "ghemadshrushti24062006@gmail.com", "24-06-2006", "71.71", "68.25", "72.35", "75", "NA", "83"),
        Student("WAGHOLIKAR SARTHAK SANJAY", "2215850109", "8668541122", "8788162252", "sarthakwagholikar2005@gmail.com", "21-12-2005", "581", "623", "637", "719", "NA", "511"), // Note: Marks look unusual
        Student("SAMBALE ASMITA SANJAY", "2215850110", "70205 12103", "9834826485", "Asmitasambale@gmail.com@gmail.com", "05-01-2006", "70", "60.75", "62.59", "A.T.K.T", "NA", "79.6") // Note: SEM-IV marks and email
    )

    var selectedYear by remember { mutableStateOf("1st Year") }
    val yearOptions = listOf("1st Year", "2nd Year","3rd Year")

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

        val studentsToShow = if (selectedYear == "1st Year") {
            firstYearStudents
        } else if (selectedYear == "2nd Year") {
            secondYearStudents
        } else {
            ThirdYearStudents
        }

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
