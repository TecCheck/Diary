package io.github.teccheck.diary

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen
import com.google.android.material.appbar.MaterialToolbar

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.settings, SettingsFragment())
                .commit()
        }

        findViewById<MaterialToolbar>(R.id.toolbar).setNavigationOnClickListener { finish() }
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)

            val import = findPreference<PreferenceScreen>(KEY_IMPORT)
            val export = findPreference<PreferenceScreen>(KEY_EXPORT)

            import?.setOnPreferenceClickListener {
                Toast.makeText(context, R.string.not_yet_implemented, Toast.LENGTH_SHORT).show()
                true
            }

            export?.setOnPreferenceClickListener {
                Toast.makeText(context, R.string.not_yet_implemented, Toast.LENGTH_SHORT).show()
                true
            }
        }
    }

    companion object {
        private const val KEY_IMPORT = "import_diary"
        private const val KEY_EXPORT = "export_diary"
    }
}