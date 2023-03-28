package io.github.teccheck.diary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import com.google.android.material.appbar.MaterialToolbar

class DiaryActivity : DiaryBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_diary_list -> {
                    startActivity(Intent(this, DiaryListActivity::class.java))
                    true
                }
                else -> false
            }
        }

        val textInput: AppCompatEditText = findViewById(R.id.text_input)
        textInput.setText(diaryStorage.getCurrentDiaryText())
        textInput.doOnTextChanged { text, _, _, _ -> diaryStorage.setCurrentDiaryText(text.toString()) }
    }

    override fun onPause() {
        diaryStorage.writeCurrentDiary()
        super.onPause()
    }
}