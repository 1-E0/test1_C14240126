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

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_CATEGORY = "extra_category"
        const val EXTRA_SUBTITLE = "extra_subtitle"
        const val EXTRA_DATE = "extra_date"
        const val EXTRA_TIME = "extra_time"
        const val EXTRA_LOCATION = "extra_location"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detailMain)) { v, insets ->
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

        val title = intent.getStringExtra(EXTRA_TITLE) ?: "Seminar Teknologi 2026"
        val category = intent.getStringExtra(EXTRA_CATEGORY) ?: "SEMINAR"
        val subtitle = intent.getStringExtra(EXTRA_SUBTITLE) ?: "\"Membangun Aplikasi Android Modern\""
        val date = intent.getStringExtra(EXTRA_DATE) ?: "20 Oktober 2026"
        val time = intent.getStringExtra(EXTRA_TIME) ?: "09.00 - 12.00 WIB"
        val location = intent.getStringExtra(EXTRA_LOCATION) ?: "Auditorium Kampus XYZ"
        val desc = intent.getStringExtra(EXTRA_DESC) ?: "Seminar Teknologi 2026"
        val imageRes = intent.getIntExtra(EXTRA_IMAGE, R.drawable.seminar)
        val phone = intent.getStringExtra(EXTRA_PHONE) ?: "081234567890"

        _tvDetailTitle.text = title
        _tvDetailCategory.text = category
        _tvDetailSubtitle.text = subtitle
        _tvDetailDate.text = date
        _tvDetailTime.text = time
        _tvDetailLocation.text = location
        _tvDetailDescription.text = desc
        _ivDetailImage.setImageResource(imageRes)
        _tvSpeakerName.text = "Dr. Monica Santoso"
        _tvSpeakerRole.text = "Mobile Developer & Tech Educator"

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