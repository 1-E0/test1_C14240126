package test1.c14240126.app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _cardSeminar = findViewById<LinearLayout>(R.id.cardSeminar)
        val _cardWorkshop = findViewById<LinearLayout>(R.id.cardWorkshop)
        val _cardEvent = findViewById<LinearLayout>(R.id.cardEvent)
        val _btnAbout = findViewById<LinearLayout>(R.id.btnAbout)

        _cardSeminar.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_TITLE, "Seminar Teknologi 2026")
                putExtra(DetailActivity.EXTRA_CATEGORY, "SEMINAR")
                putExtra(DetailActivity.EXTRA_SUBTITLE, "\"Membangun Aplikasi Android Modern\"")
                putExtra(DetailActivity.EXTRA_DATE, "20 Oktober 2026")
                putExtra(DetailActivity.EXTRA_TIME, "09.00 - 12.00 WIB")
                putExtra(DetailActivity.EXTRA_LOCATION, "Auditorium Kampus XYZ")
                putExtra(DetailActivity.EXTRA_DESC, "Seminar Teknologi 2026")
                putExtra(DetailActivity.EXTRA_IMAGE, R.drawable.seminar)
                putExtra(DetailActivity.EXTRA_PHONE, "081234567890")
            }
            startActivity(intent)
        }

        _cardWorkshop.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_TITLE, "Workshop UI/UX Design")
                putExtra(DetailActivity.EXTRA_CATEGORY, "WORKSHOP")
                putExtra(DetailActivity.EXTRA_SUBTITLE, "\"Dari Ide Menjadi Desain yang Menarik\"")
                putExtra(DetailActivity.EXTRA_DATE, "25 Oktober 2026")
                putExtra(DetailActivity.EXTRA_TIME, "13.00 - 16.00 WIB")
                putExtra(DetailActivity.EXTRA_LOCATION, "Lab. Komputer Lt. 3")
                putExtra(DetailActivity.EXTRA_DESC, "Workshop UI/UX Design")
                putExtra(DetailActivity.EXTRA_IMAGE, R.drawable.workshop)
                putExtra(DetailActivity.EXTRA_PHONE, "082198765432")
            }
            startActivity(intent)
        }

        _cardEvent.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_TITLE, "Campus Fair 2026")
                putExtra(DetailActivity.EXTRA_CATEGORY, "EVENT")
                putExtra(DetailActivity.EXTRA_SUBTITLE, "\"Temukan Peluang untuk Masa Depanmu\"")
                putExtra(DetailActivity.EXTRA_DATE, "28 Oktober 2026")
                putExtra(DetailActivity.EXTRA_TIME, "08.00 - 15.00 WIB")
                putExtra(DetailActivity.EXTRA_LOCATION, "Lapangan Kampus XYZ")
                putExtra(DetailActivity.EXTRA_DESC, "Campus Fair 2026")
                putExtra(DetailActivity.EXTRA_IMAGE, R.drawable.event)
                putExtra(DetailActivity.EXTRA_PHONE, "083812345678")
            }
            startActivity(intent)
        }

        _btnAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}