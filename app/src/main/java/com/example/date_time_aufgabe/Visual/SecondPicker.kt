package com.example.date_time_aufgabe.Visual

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberPickerDialog(
    showDialog: MutableState<Boolean>,
    onNumberSelected: (Int) -> Unit
) {
    if (showDialog.value) {
        var text by remember { mutableStateOf("") }

        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text("Sekunden") },
            text = {
                TextField(
                    value = text,
                    onValueChange = { newText ->
                        text = newText.filter { it.isDigit() }
                    },
                    label = { Text("Zahl von 0-60") }

                )
            },
            confirmButton = {
                Button(onClick = {
                    text.toIntOrNull()?.let { number ->
                        if (number in 0..60) {
                            onNumberSelected(number)
                            showDialog.value = false
                        }
                    }
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog.value = false }) {
                    Text("Abbrechen")
                }
            }
        )
    }
}
