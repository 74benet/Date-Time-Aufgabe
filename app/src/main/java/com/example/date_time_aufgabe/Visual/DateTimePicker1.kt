package com.example.date_time_aufgabe.Visual

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.date_time_aufgabe.Model.DateTime
import com.example.date_time_aufgabe.Model.getDate1
import com.example.date_time_aufgabe.Model.getSeconds2
import com.example.date_time_aufgabe.Model.getTime1

@Composable
fun DateTimePicker1() {
    val context = LocalContext.current

    var selectedDateText by remember { mutableStateOf("") }
    var selectedTimeText by remember { mutableStateOf("") }
    var showTimePicker by remember { mutableStateOf(false) }
    var showSecondPicker = remember { mutableStateOf(false) }
    var number by remember { mutableStateOf(0)}
    var isNumberSelected by remember { mutableStateOf(false)}


    val datePicker = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            selectedDateText = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"

            getDate1(selectedYear,selectedMonth,selectedDayOfMonth)

            showTimePicker = true

        }, DateTime().year, DateTime().month, DateTime().dayOfMonth
    )

    val timePicker = TimePickerDialog(
        context,
        { _, selectedHour: Int, selectedMinute: Int ->
            selectedTimeText = "$selectedHour:$selectedMinute"

            getTime1(selectedHour,selectedMinute)

            showTimePicker = false

            showSecondPicker.value = true

        }, DateTime().hour, DateTime().minute, false
    )

    NumberPickerDialog(showSecondPicker) { selectedNumber ->
        number = selectedNumber
        isNumberSelected = true
        getSeconds2(number)
    }


    Button(
        onClick = {
            datePicker.show()
        },
        modifier = Modifier
            .shadow(6.dp, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4F4397)
        )
    ) {
        Text(text = "Wähle Datum und Uhrzeit")
    }

    Text(text = "Ausgewähltes Datum: $selectedDateText")
    Text(text = "Ausgewählte Uhrzeit: ${selectedTimeText}${
        if(isNumberSelected){
            ":${number}"
        }
        else{
            ""
        }
    }")

    if (showTimePicker) {
        timePicker.show()
    }
}
