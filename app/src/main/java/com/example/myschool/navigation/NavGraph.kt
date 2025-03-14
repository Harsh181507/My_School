package com.example.myschool.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myschool.screens.*
import com.example.myschool.screens.AttendanceScreen
import com.example.myschool.screens.TimetableScreen


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("add_student") { AddStudentScreen(navController) }
        composable("student_list") { StudentListScreen(navController) }
        composable("attendance") { AttendanceScreen(navController) }
        composable("attendance_history") { AttendanceHistoryScreen(navController) }
        composable("timetable") { TimetableScreen(navController) }
        composable("announcements") { AnnouncementsScreen(navController) }
        composable("profile") { ProfileScreen(navController) }
    }
}


