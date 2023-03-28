package io.github.teccheck.diary

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val version = findViewById<TextView>(R.id.text_version)
        version.text = BuildConfig.VERSION_NAME

        val sourceCodeLayout = findViewById<View>(R.id.layout_source_code)
        sourceCodeLayout.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.source_code_url)))
            startActivity(intent)
        }
    }
}