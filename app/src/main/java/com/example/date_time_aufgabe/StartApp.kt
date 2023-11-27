package com.example.date_time_aufgabe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.date_time_aufgabe.Model.CalculateButton
import com.example.date_time_aufgabe.Visual.DateTimePicker1
import com.example.date_time_aufgabe.Visual.DateTimePicker2

class StartApp(){

    @Composable
    fun runApp(){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DateTimePicker1()
            Spacer(modifier = Modifier.height(16.dp))
            Divider()
            Spacer(modifier = Modifier.height(16.dp))
            DateTimePicker2()

            Spacer(modifier = Modifier.height(50.dp))
            CalculateButton()
        }


    }

}