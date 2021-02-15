package fr.iutlens.mmi.rogue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class WinWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_window)
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val photo:Int = intent.getIntExtra(EXTRA_PHOTO, -1)
        val textView = findViewById<TextView>(R.id.textwin).apply {
            text = message
        }
        val photo2:ImageView = findViewById<ImageView>(R.id.image_icon).apply {
            setImageResource(photo)
        }


        val btn_click_me = findViewById<Button>(R.id.button_restart)
        btn_click_me.setOnClickListener {
            val intent = Intent(applicationContext, GameActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}