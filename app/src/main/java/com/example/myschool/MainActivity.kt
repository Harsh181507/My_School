package com.example.myschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myschool.navigation.AppNavGraph
import com.example.myschool.ui.theme.MySchoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySchoolTheme {
                AppNavGraph()
            }
        }
    }
}
