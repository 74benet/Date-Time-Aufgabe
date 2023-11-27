package com.example.date_time_aufgabe.Model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


val dt = DateTime()
val dt2 = DateTime()
fun getDate1(year: Int, month: Int, day: Int){
    dt.year = year
    dt.month = month
    dt.dayOfMonth = day
}

fun getTime1(hour: Int, minute: Int){
    dt.hour = hour
    dt.minute = minute
}

fun getDate2(year: Int, month: Int, day: Int){
    dt2.year = year
    dt2.month = month
    dt2.dayOfMonth = day
}

fun getTime2(hour: Int, minute: Int){
    dt2.hour = hour
    dt2.minute = minute
}

fun getSeconds1(seconds: Int){
    dt.second = seconds
}
fun getSeconds2(seconds: Int){
    dt.second = seconds
}

var hourResult = 0
var minuteResult = 0
var yearResult = 0
var monthResult = 0
var dayResult = 0
var secondResult = 0
fun Calculate(){

    //hour
    if(dt.hour > dt2.hour){
         hourResult = dt.hour - dt2.hour
    }else {
        hourResult = dt2.hour - dt.hour
    }

    //minute
    if(dt.minute > dt2.minute){
        minuteResult = dt.minute - dt2.minute
    }else {
        minuteResult = dt2.minute - dt.minute
    }

    //second
    if(dt.second > dt2.second){
        secondResult = dt.second - dt2.second
    }else {
        secondResult = dt2.second - dt.second
    }

    //year
    if(dt.year > dt2.year){
        yearResult = dt.year - dt2.year
    }else {
        yearResult = dt2.year - dt.year
    }

    //month
    if(dt.month > dt2.month){
        monthResult = dt.month - dt2.month
    }else {
        monthResult = dt2.month - dt.month
    }

    //day
    if(dt.dayOfMonth > dt2.dayOfMonth){
        dayResult = dt.dayOfMonth - dt2.dayOfMonth
    }else {
        dayResult = dt2.dayOfMonth - dt.dayOfMonth
    }



}

@Composable
fun CalculateButton(){
    var text by remember { mutableStateOf("") }

        Button(
        onClick = {
            Calculate()
            text = "${yearResult}y, ${monthResult}m, ${dayResult}d und ${hourResult}h:${minuteResult}min:${secondResult}s"


        },
        modifier = Modifier
            .shadow(6.dp, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4F4397)
        )
    ) {
        Text(text = "Berechnen")
    }
    Text(text = "Zeit Unterschied: $text")
}