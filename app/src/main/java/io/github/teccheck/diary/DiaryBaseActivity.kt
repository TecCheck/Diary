package io.github.teccheck.diary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class DiaryBaseActivity : AppCompatActivity() {
    protected lateinit var diaryStorage: DiaryStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
        diaryStorage = (application as DiaryApp).getDiaryStorage()
    }
}