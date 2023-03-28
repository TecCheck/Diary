package io.github.teccheck.diary

import android.app.Application

class DiaryApp : Application() {

    private lateinit var diaryStorage: DiaryStorage

    override fun onCreate() {
        super.onCreate()
        diaryStorage = DiaryStorage(this)
    }

    fun getDiaryStorage(): DiaryStorage {
        return diaryStorage
    }
}
