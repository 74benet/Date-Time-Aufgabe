package com.example.date_time_aufgabe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.date_time_aufgabe.ui.theme.DateTimeAufgabeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateTimeAufgabeTheme {
                StartApp().runApp()

            }
        }
    }
}