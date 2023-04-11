package com.example.sample

import android.R.attr.scrollY
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val errors = listOf(
        error("P0040", "Error 1 Title", "Error 1 Description", "Error 1 Cause"),
        error("P0041", "Error 2 Title", "Error 2 Description", "Error 2 Cause"),
        error("P0042", "Error 3 Title", "Error 3 Description", "Error 3 Cause"),
    )

    val selected = 0

    val error_title : TextView by lazy { findViewById(R.id.error_title) }
    val error_description : TextView by lazy { findViewById(R.id.error_description) }
    val error_cause : TextView by lazy { findViewById(R.id.error_cause) }
    val button1 : Button by lazy { findViewById(R.id.button1) }
    val button2 : Button by lazy { findViewById(R.id.button2) }
    val button3 : Button by lazy { findViewById(R.id.button3) }

    val scrollView : ScrollView by lazy { findViewById(R.id.car_sv) }
    val imageView : ImageView by lazy { findViewById(R.id.car) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        init()
        initListeners()
    }

    fun init() {
        error_title.text = errors[selected].error_title
        error_description.text = errors[selected].error_description
        error_cause.text = errors[selected].error_cause
        button1.text = errors[0].error_code
        button2.text = errors[1].error_code
        button3.text = errors[2].error_code
        button1.setBackgroundColor(resources.getColor(R.color.blue))
        button2.setBackgroundColor(resources.getColor(R.color.white))
        button3.setBackgroundColor(resources.getColor(R.color.white))
        button1.setTextColor(resources.getColor(R.color.white))
        button2.setTextColor(resources.getColor(R.color.blue))
        button3.setTextColor(resources.getColor(R.color.blue))

        scrollView.minimumHeight = resources.getDimensionPixelSize(R.dimen.car_height);
    }

    fun initListeners() {
        button1.setOnClickListener {
            error_title.text = errors[0].error_title
            error_description.text = errors[0].error_description
            error_cause.text = errors[0].error_cause
            button1.setBackgroundColor(resources.getColor(R.color.blue))
            button2.setBackgroundColor(resources.getColor(R.color.white))
            button3.setBackgroundColor(resources.getColor(R.color.white))
            button1.setTextColor(resources.getColor(R.color.white))
            button2.setTextColor(resources.getColor(R.color.blue))
            button3.setTextColor(resources.getColor(R.color.blue))
        }
        button2.setOnClickListener {
            error_title.text = errors[1].error_title
            error_description.text = errors[1].error_description
            error_cause.text = errors[1].error_cause
            button1.setBackgroundColor(resources.getColor(R.color.white))
            button2.setBackgroundColor(resources.getColor(R.color.blue))
            button3.setBackgroundColor(resources.getColor(R.color.white))
            button1.setTextColor(resources.getColor(R.color.blue))
            button2.setTextColor(resources.getColor(R.color.white))
            button3.setTextColor(resources.getColor(R.color.blue))
        }
        button3.setOnClickListener {
            error_title.text = errors[2].error_title
            error_description.text = errors[2].error_description
            error_cause.text = errors[2].error_cause
            button1.setBackgroundColor(resources.getColor(R.color.white))
            button2.setBackgroundColor(resources.getColor(R.color.white))
            button3.setBackgroundColor(resources.getColor(R.color.blue))
            button1.setTextColor(resources.getColor(R.color.blue))
            button2.setTextColor(resources.getColor(R.color.blue))
            button3.setTextColor(resources.getColor(R.color.white))
        }
        scrollView.setOnScrollChangeListener { view, i, i1, i2, i3 -> // Calculate the scroll position as a percentage of the image height
            var scale = 1 - scrollY.toFloat() / imageView.height
            if (scale > 1) {
                scale = 1f
            } else if (scale < 0.5) {
                scale = 0.5f
            }
            imageView.scaleX = scale * 2
            imageView.scaleY = scale * 2

            val newHeight = (400 * scale).toInt()
            scrollView.minimumHeight = newHeight
        }
    }
}