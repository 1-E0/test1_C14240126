package test1.c14240126.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_event)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detailEventMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _btnBack = findViewById<ImageView>(R.id.btnBack)
        val _btnShare = findViewById<ImageView>(R.id.btnShare)
        val _ivDetailImage = findViewById<ImageView>(R.id.ivDetailImage)
        val _tvDetailCategory = findViewById<TextView>(R.id.tvDetailCategory)
        val _tvDetailTitle = findViewById<TextView>(R.id.tvDetailTitle)
        val _tvDetailSubtitle = findViewById<TextView>(R.id.tvDetailSubtitle)
        val _tvDetailDate = findViewById<TextView>(R.id.tvDetailDate)
        val _tvDetailTime = findViewById<TextView>(R.id.tvDetailTime)
        val _tvDetailLocation = findViewById<TextView>(R.id.tvDetailLocation)
        val _tvDetailDescription = findViewById<TextView>(R.id.tvDetailDescription)
        val _ivSpeaker = findViewById<ImageView>(R.id.ivSpeaker)
        val _tvSpeakerName = findViewById<TextView>(R.id.tvSpeakerName)
        val _tvSpeakerRole = findViewById<TextView>(R.id.tvSpeakerRole)
        val _btnAddToCalendar = findViewById<LinearLayout>(R.id.btnAddToCalendar)
        val _btnCallPanitia = findViewById<LinearLayout>(R.id.btnCallPanitia)

        val title = "Campus Fair 2026"
        val location = "Lapangan Kampus XYZ"
        val phone = "081234567892"

        _btnBack.setOnClickListener {
            finish()
        }

        _btnAddToCalendar.setOnClickListener {
            val calIntent = Intent(Intent.ACTION_INSERT).apply {
                data = CalendarContract.Events.CONTENT_URI
                putExtra(CalendarContract.Events.TITLE, title)
                putExtra(CalendarContract.Events.DESCRIPTION, "[Jadwal - C14240126] . $title")
                putExtra(CalendarContract.Events.EVENT_LOCATION, location)
            }
            startActivity(calIntent)
        }

        _btnCallPanitia.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phone")
            }
            startActivity(dialIntent)
        }
    }
}
