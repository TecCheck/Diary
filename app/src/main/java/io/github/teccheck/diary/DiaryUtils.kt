package io.github.teccheck.diary

import android.util.Log
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

object DiaryUtils {
    private const val TAG = "DiaryUtils"
    private const val DATE_FORMAT = "yyyy-MM-dd"

    fun getDateFormat(): DateFormat {
        return SimpleDateFormat(DATE_FORMAT)
    }

    fun getLocalizedDateString(filename: String): String {
        val split = filename.split(".")
        Log.d(TAG, split.toString())
        if (split.isEmpty())
            return filename

        val parseDateFormat = getDateFormat()
        parseDateFormat.isLenient = false
        val localDateFormat = DateFormat.getDateInstance()

        try {
            val date = parseDateFormat.parse(split.first()) ?: return filename
            Log.d(TAG, date.toString())
            return localDateFormat.format(date)
        } catch (e: ParseException) {
            Log.e(TAG, e.message, e)
            return filename
        }
    }
}