package com.example.date_time_aufgabe.Model

import java.util.Calendar

class DateTime() {
    val calendar = Calendar.getInstance()

    var year = calendar[Calendar.YEAR]
    var month = calendar[Calendar.MONTH]
    var dayOfMonth = calendar[Calendar.DAY_OF_MONTH]

    var hour = calendar[Calendar.HOUR_OF_DAY]
    var minute = calendar[Calendar.MINUTE]

    var second = calendar[Calendar.SECOND]

}