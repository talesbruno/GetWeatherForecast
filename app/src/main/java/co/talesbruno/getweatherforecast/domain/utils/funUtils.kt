package co.talesbruno.getweatherforecast.domain.utils

import co.talesbruno.getweatherforecast.R
import java.text.DecimalFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.TextStyle
import java.util.*

fun convertUnixToDate(unixTimestamp: Long): String {
    val localDate =
        Instant.ofEpochSecond(unixTimestamp).atZone(ZoneId.systemDefault()).toLocalDate()
    return localDate.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("pt", "BR"))
}

fun formatNumber(number: Double): String {
    val decimalFormat = DecimalFormat("#")
    return decimalFormat.format(number)
}

fun convertIcon(icon: String): Int {
    return when (icon) {
        "01d" -> {
            R.drawable.ativo18
        }
        "02d" -> {
            R.drawable.ativo17
        }
        "03d" -> {
            R.drawable.ativo14
        }
        "04d" -> {
            R.drawable.ativo14
        }
        "09d" -> {
            R.drawable.ativo10
        }
        "10d" -> {
            R.drawable.ativo16
        }
        "11d" -> {
            R.drawable.ativo11
        }
        "13d" -> {
            R.drawable.ativo9
        }
        "50d" -> {
            R.drawable.ativo5
        }
        "01n" -> {
            R.drawable.ativo4
        }
        "02n" -> {
            R.drawable.ativo15
        }
        "03n" -> {
            R.drawable.ativo14
        }
        "09n" -> {
            R.drawable.ativo10
        }
        "10n" -> {
            R.drawable.ativo13
        }
        "11n" -> {
            R.drawable.ativo11
        }
        "13n" -> {
            R.drawable.ativo9
        }
        else -> {
            R.drawable.ativo5
        }
    }
}