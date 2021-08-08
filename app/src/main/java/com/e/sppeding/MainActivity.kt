package com.e.sppeding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculete.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculete) {
            calculete()
        }

    }

    private fun calculete() {
        if (isEmpty()) {
            try {
                val distance = textDistance.text.toString().toFloat()
                val liter = textLiter.text.toString().toFloat()
                val autonomy = textAutomy.text.toString().toFloat()
                val value = (distance * liter) / autonomy
                textValue.text = "R$ ${"%.2f".format(value)} "
git

            } catch (nrf: NumberFormatException) {

                Toast.makeText(this, getString(R.string.validation_field_correct), Toast.LENGTH_SHORT)
                    .show()
            }

        } else {

            Toast.makeText(this, getString(R.string.validation_empty_field), Toast.LENGTH_SHORT)
                .show()

        }
    }

    private fun isEmpty(): Boolean {
        return (textDistance.text.toString() != ""
                && textLiter.text.toString() != " "
                && textDistance.text.toString() != "")
    }

}


