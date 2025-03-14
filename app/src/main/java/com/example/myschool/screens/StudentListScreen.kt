package com.example.myschool.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentListScreen(navController: NavController) {
    val names = listOf(
        "MOMIN AZIZA GAFFAR",
        "KHANDARE NAMRTA BALAJI",
        "SHENDRE GAURI CHAGAN",
        "DESHMUKHE RUTUJA ARVIND",
        "GAIKWAD ANUJA TUKARAM",
        "KSHIRSAGAR ANUSHKA PRASHANT",
        "HONRAO ARNAV SACHIN",
        "WAGHMARE GAYATRI HARI",
        "DHAVAN AGRAJA SHIVSHANKAR",
        "KANGUDE NIKITA NANDKUMAR",
        "KAWADE KALYANI KAPIL",
        "CHAVARE PRATHMESH GANESH",
        "WANI GAYATRI MARUTI",
        "PATANGE SAHIL SADANAND",
        "TAMBARE BHAKTI SANTOSH",
        "DAMTE BIBIAMINA JAFAR",
        "MUSALE SWARALI RAJKUMAR",
        "GHEMAD SHRUSHTI SUDAM",
        "WAGHOLIKAR SARTHAK SANJAY",
        "SAMBALE ASMITA SANJAY",
        "GULAME VAISHNAVI VINOD",
        "KARALE ISHWARI ASHOK",
        "KALE DEEPANKAR SACHIN",
        "GAIKWAD MEGHANA AMOL",
        "PATHAN SANIYA KHAJUDDIN",
        "VIBHUTE PRATIKSHA RAMESHWAR",
        "DHARURKAR TRUPTI JIVAN",
        "DHAS PRANAV BALAJI",
        "DHAS VAISHNAVI VILAS",
        "DHAS ONKAR HANUMANT",
        "KULKARNI VIRAJ VILAS",
        "SHINDE RAJ SHASHIKANT",
        "BHASAKARE HARSHAD SANTOSH",
        "DEVANPALLI MEGHA RATNAKAR",
        "VIBHUTE ONKAR ARUN",
        "KHURANGALE VRUSHALI LAXMAN",
        "CHANDANE SANKET SUNIL",
        "JADHAV TANUJA RAHUL",
        "BASATE PRATIKSHA TUKARAM",
        "TAMBE SAMADHAN SHRIRAM",
        "LAWAND VAISHNAVI DNYANESHWAR",
        "HANNURE AYESHA MOHAMMAD SHAFI",
        "SHELAR SUJAL GURUDATTA",
        "DHAME SAMADHAN MAHADEV",
        "KHARAT KAPIL SHRIDHAR",
        "RUSHIKESH SANTOSH MASKE",
        "BARAVKAR VIKRANT VIJAYKUMAR",
        "KIRATKARVE AARTI VISHNU",
        "KUMBHAR DNYANESHWAR LAXMAN"

    )

    val enrollmentNumbers = listOf(
        "2116110053",
        "2215850082",
        "2215850083",
        "2215850084",
        "2215850085",
        "2215850087",
        "2215850088",
        "2215850089",
        "2215850090",
        "2215850091",
        "2215850092",
        "2215850094",
        "2215850096",
        "2215850097",
        "2215850100",
        "2215850101",
        "2215850102",
        "2215850103",
        "2215850109",
        "2215850110",
        "2215850111",
        "2215850112",
        "2215850117",
        "2215850118",
        "2215850121",
        "2215850123",
        "2215850124",
        "2215850127",
        "2215850128",
        "2215850135",
        "2215850136",
        "2215850139",
        "2215850140",
        "2215850142",
        "2215850144",
        "23213220172",
        "23213220173",
        "23213220175",
        "23213220178",
        "23213220179",
        "23213220181",
        "2215850086",
        "2215850122",
        "2215850131",
        "2215850132",
        "2215850137",
        "2215850141",
        "23213220174",
        "23213220177"

    )

    val studentMobileNumbers = listOf(
        "8378923694",
        "8999189793",
        "9518923968",
        // ... rest of student numbers
        "8830612611"
    )

    val parentMobileNumbers = listOf(
        "9145509062",
        "8975239725",
        "9322059289",
        // ... rest of parent numbers
        "9921538381"
    )

    val emails = listOf(
        "azizamomin68@gmail.com",
        "namrtakhandare97@gmail.com",
        "gaurishendre64@gmail.com",
        "deshmukherutujao6@gmail.com",
        "gaikwadanuja327@gmail.com",
        "kshirsagaranushka696@gmail.com",
        "anitahonrao745@gmail.com",
        "gayatriwaghmare2006@gmail.com",
        "agrajadhavan23@gmail.com",
        "nikitakangude12@gmail.com",
        "kkawade871@gmail.com",
        "chavareprathmesh753@gmail.com",
        "gayatrimwani@gmail.com",
        "sahilpatange8@gmail.com",
        "bhaktitambare@gmail.com",
        "aliyadamte17@gmail.com",
        "swarali0019@gmail.com",
        "sarthakwagholikar2005@gmail.com",
        "Asmitasambale@gmail.com@gmail.com",
        "vaishnavigulame06@gmail.com",
        "ishwarikarale47@gmail.com",
        "deepkale43@gmail.com",
        "meghnagaikwad2006@gmail.com",
        "saniyakpathanofficial@gmail.com",
        "rameshwarvibhute97@gmail.com",
        "truptidharurkar10d@gmail.com",
        "dhaspranav22@gmail.com",
        "dhasvaishu@gmail.com",
        "onkardhas10102006@gmail.com",
        "virajkulkarni498@gmail.com",
        "rajshindepatil97@gmail.com",
        "harshadbhasakare@gmail.com",
        "devanpallimegha@gmail.com",
        "vibhuteonkar588@gmail.com",
        "vrushalikhurangale@gmail.com",
        "sanketchandane094@gmail.com",
        "tanujadhav246@gmail.com",
        "basatepratiksha516@gmail.com",
        "samadhantambe005@gmail.com",
        "Vaishulawand0777@Gmail.com",
        "ayeshahannure2006@gmail.com",
        "kharatkapil144@gmail.com",
        "rushikeshmaske164@gmail.com",
        "aartikiratkarve8@gmail.com",
        "dnyaneshwarkumbhar2021@gmail.com"

    )

    val dobs = listOf(
        "27-03-2006",
        "14-06-2006",
        "21-10-2006",
        "06-05-2006",
        "23-08-2006",
        "24-04-2005",
        "30-05-2006",
        "07-02-2006",
        "23-02-2006",
        "30-03-2006",
        "13-04-2006",
        "11-10-2006",
        "07-01-2006",
        "10-01-2006",
        "24-03-2006",
        "17-09-2006",
        "19-07-2005",
        "24-06-2006",
        "21-12-2005",
        "05-01-2006",
        "20-09-2006",
        "27-01-2006",
        "14-09-2005",
        "30-08-2006",
        "17-10-2005",
        "11-05-2006",
        "25-04-2007",
        "22-02-2007",
        "11-12-2006",
        "10-10-2006",
        "07-12-2005",
        "14-11-2005",
        "01-09-2006",
        "23-08-2006",
        "08-10-2005",
        "08-02-2005",
        "30-11-2003",
        "12-02-2005",
        "08-05-2004",
        "05-07-2005",
        "02-11-2005",
        "11-04-2006",
        "21-07-2006",
        "01-06-2004",
        "07-12-2004",
        "04-11-2003"

    )

    val sem1Marks = listOf(
        "80.43",
        "88.13",
        "76.29",
        "78.86",
        "88.86",
        "78",
        "70.43",
        "82.14",
        "76.8",
        "87.14",
        "80.7",
        "72",
        "79",
        "71.43",
        "75",
        "83.14",
        "73.43",
        "71.71",
        "581",
        "70",
        "81",
        "80",
        "77.14",
        "71.14",
        "68.7",
        "84",
        "71.86",
        "83.86",
        "83.86",
        "71.29",
        "75",
        "78.2",
        "79",
        "565",
        "68",
        "DSY",
        "DSY",
        "DSY",
        "DSY",
        "DSY",
        "DSY",
        "71",
        "60",
        "60",
        "DSY",
        "DSY"

    )

    val sem2Marks = listOf(
        "66.88",
        "76",
        "76",
        "81.13",
        "88",
        "70",
        "62.5",
        "79",
        "73",
        "83.5",
        "72",
        "60.25",
        "72",
        "61.38",
        "71.6",
        "75",
        "64.38",
        "68.25",
        "623",
        "60.75",
        "76.63",
        "75",
        "62",
        "63.75",
        "70",
        "73",
        "63.5",
        "80.88",
        "75.5",
        "64.38",
        "68",
        "72",
        "78",
        "617",
        "68",
        "DSY",
        "DSY",
        "DSY",
        "DSY",
        "DSY",
        "DSY",
        "60",
        "65",
        "60",
        "DSY",
        "DSY"

    )

    val sem3Marks = listOf(
        "85.41",
        "80.47",
        "79.53",
        "86.59",
        "89.28",
        "77.4",
        "64.24",
        "82",
        "70",
        "92.71",
        "72.6",
        "66.12",
        "76.12",
        "66.98",
        "78",
        "71.53",
        "73.06",
        "72.35",
        "637",
        "62.59",
        "84.71",
        "79",
        "64.71",
        "73.33",
        "69.85",
        "76",
        "69.77",
        "78.94",
        "77.06",
        "66.59",
        "72",
        "80",
        "75",
        "629",
        "67.53",
        "67.77",
        "482",
        "713",
        "73.53",
        "60",
        "64.82",
        "67",
        "5 back",
        "2 back",
        "64",
        "382"

    )

    val sem4Marks = listOf(
        "87.11",
        "83.44",
        "84.56",
        "89.11",
        "90.11",
        "81.11",
        "67.67",
        "83.56",
        "76.8",
        "91.44",
        "72.8",
        "562",
        "75.89",
        "68",
        "80",
        "75.22",
        "74.33",
        "75",
        "719",
        "A.T.K.T",
        "85.67",
        "77",
        "61.44",
        "76.33",
        "73",
        "74",
        "75.89",
        "81.33",
        "81",
        "67.89",
        "75",
        "79.89",
        "77",
        "728",
        "67",
        "64",
        "59.22",
        "759",
        "73.33",
        "_",
        "64",
        "74",
        "5 back",
        "5 back",
        "-",
        "0.6578"

    )

    val hscMarks = listOf(
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "80",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "NA",
        "48.67",
        "75.5",
        "403",
        "79.67",
        "72.3",
        "54.67",
        "",
        "",
        "",
        "",
        "73",
        "351",
        "",
        ""

    )

    val sscMarks = listOf(
        "68.4",
        "93.6",
        "73.2",
        "86",
        "93",
        "84",
        "82.4",
        "89.8",
        "62",
        "94.4",
        "90.4",
        "74.8",
        "94.8",
        "67.6",
        "80",
        "88.4",
        "70.4",
        "83",
        "511",
        "79.6",
        "82",
        "88",
        "89.4",
        "82.8",
        "79.5",
        "89.6",
        "78.2",
        "84.8",
        "89.4",
        "82.2",
        "77.4",
        "78.2",
        "86",
        "433",
        "814",
        "84.2",
        "79.4",
        "93.8",
        "87.6",
        "85.6",
        "80.6",
        "85",
        "65.6",
        "71.6",
        "82",
        "403"

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            LazyColumn {
                itemsIndexed(names) { index, name ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Name: $name", style = MaterialTheme.typography.titleMedium)
                            Text("Enrollment No: ${enrollmentNumbers.getOrNull(index) ?: "NA"}")
                            Text("Student Mobile: ${studentMobileNumbers.getOrNull(index) ?: "NA"}")
                            Text("Parent Mobile: ${parentMobileNumbers.getOrNull(index) ?: "NA"}")
                            Text("Email: ${emails.getOrNull(index) ?: "NA"}")
                            Text("Date of Birth: ${dobs.getOrNull(index) ?: "NA"}")
                            Text("SEM-I Marks: ${sem1Marks.getOrNull(index) ?: "NA"}")
                            Text("SEM-II Marks: ${sem2Marks.getOrNull(index) ?: "NA"}")
                            Text("SEM-III Marks: ${sem3Marks.getOrNull(index) ?: "NA"}")
                            Text("SEM-IV Marks: ${sem4Marks.getOrNull(index) ?: "NA"}")
                            Text("HSC Marks: ${hscMarks.getOrNull(index) ?: "NA"}")
                            Text("SSC Marks: ${sscMarks.getOrNull(index) ?: "NA"}")
                        }
                    }
                }
            }
        }
    }
}
