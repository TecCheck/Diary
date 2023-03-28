package io.github.teccheck.diary

import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.appbar.MaterialToolbar

class DiaryViewActivity : DiaryBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_view)

        val filename = intent.getStringExtra(EXTRA_FILENAME)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        val textView = findViewById<AppCompatTextView>(R.id.text_view)

        toolbar.setNavigationOnClickListener { finish() }

        filename?.let {
            toolbar.title = DiaryUtils.getLocalizedDateString(it)
            textView.text = diaryStorage.readDiaryEntry(it)
        }
    }

    companion object {
        const val EXTRA_FILENAME = "filename"
    }
}