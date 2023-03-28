package io.github.teccheck.diary

import android.content.Context
import android.util.Log
import java.io.File
import java.util.*

class DiaryStorage(context: Context) {

    private val folder = getDiaryFolder(context)

    private var currentDiaryEntry = ""

    init {
        folder.mkdirs()
        val file = getCurrentDiaryFile()
        if (file.exists())
            currentDiaryEntry = file.readText()
    }

    fun getDiaryEntryNames(): Array<String>? {
        return folder.list()
    }

    fun readDiaryEntry(filename: String): String {
        return File(folder, filename).readText()
    }

    fun getCurrentDiaryText(): String {
        return currentDiaryEntry
    }

    fun setCurrentDiaryText(text: String) {
        currentDiaryEntry = text
    }

    fun writeCurrentDiary() {
        Log.d(TAG, "write")
        val file = getCurrentDiaryFile()
        if (!file.exists())
            file.createNewFile()

        file.writeText(currentDiaryEntry)
    }

    private fun getCurrentDiaryFile(): File {
        val format = DiaryUtils.getDateFormat()
        val date = Date(System.currentTimeMillis())
        val filename = String.format(DIARY_FILE_NAME_FORMAT, format.format(date))
        return File(folder, filename)
    }

    private fun getDiaryFolder(context: Context): File {
        return File(context.filesDir, DIARY_SUBFOLDER)
    }

    companion object {
        private const val TAG = "DiaryStorage"
        private const val DIARY_SUBFOLDER = "diary"
        const val DIARY_FILE_NAME_FORMAT = "%s.txt"
    }
}