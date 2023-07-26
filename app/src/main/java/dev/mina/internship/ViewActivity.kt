package dev.mina.internship

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val mainTextView: TextView = findViewById(R.id.textView)

        mainTextView.text = "New Text"

        val button: Button = findViewById(R.id.btn_hello_world)
        button.setOnClickListener {
            // asd asd asd as// asd
            mainTextView.text = "Click text"
        }
        val text = mainTextView.text

        sumNumbers(1, 6)
    }
}

/**
 * this function get two numbers and multiply one by 3 and then sum them
 *
 * @param firstNumber the first number to be multiplied by 3
 * @param secondNumber the second number to be added to the other one
 *
 * @return an Int number for the sum of the operations
 */
fun sumNumbers(firstNumber: Int, secondNumber: Int): Int {
    return (firstNumber * 3) + secondNumber
}