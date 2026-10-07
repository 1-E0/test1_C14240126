package test1.c14240126.app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.aboutRoot)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val _btnBack = findViewById<ImageView>(R.id.btnBack)
        val _tvDevName = findViewById<TextView>(R.id.tvDevName)
        val _tvDevNrp = findViewById<TextView>(R.id.tvDevNrp)
        val _tvDevEmail = findViewById<TextView>(R.id.tvDevEmail)
        val _tvDevPhone = findViewById<TextView>(R.id.tvDevPhone)

        _btnBack.setOnClickListener {
            finish()
        }
    }
}