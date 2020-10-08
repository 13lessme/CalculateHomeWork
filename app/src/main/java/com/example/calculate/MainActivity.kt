package com.example.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import java.lang.Exception

class MainActivity : AppCompatActivity() {
private var a: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        But1.setOnClickListener { chisla("1", true) }
        But2.setOnClickListener { chisla("2", true) }
        But3.setOnClickListener { chisla("3", true) }
        But4.setOnClickListener { chisla("4", true) }
        But5.setOnClickListener { chisla("5", true) }
        But6.setOnClickListener { chisla("6", true) }
        But7.setOnClickListener { chisla("7", true) }
        But8.setOnClickListener { chisla("8", true) }
        But9.setOnClickListener { chisla("9", true) }
        But0.setOnClickListener { chisla("0", true) }
        But10.setOnClickListener { chisla(".", false) }

        ButGray1.setOnClickListener {
            number.text = ""
            result.text = ""
        }
        ButGray2.setOnClickListener {
            try {
                var c: Long = number.text.toString().toLong()
                c *= -1
                number.text = c.toString()
            }catch (e: Exception){}
        }
        ButGray3.setOnClickListener {chisla("%", false)}


        ButFun1.setOnClickListener { chisla( "/", false) }
        ButFun2.setOnClickListener { chisla( "*", false) }
        ButFun3.setOnClickListener { chisla( "-", false) }
        ButFun4.setOnClickListener { chisla( "+", false) }

        ButFun5.setOnClickListener {
            try {
                val expression = ExpressionBuilder(number.text.toString()).build()
                val result = expression.evaluate()
                val longResult = expression.evaluate().toLong()
                if(result == longResult.toDouble())
                    number.text = longResult.toString()
                else
                    number.text = result.toString()

            } catch (e:Exception) {
                Log.d("Exception", " message : " + e.message)
            }
        }



    }
    private fun chisla(a: String, b: Boolean){
        if(b){
            result.text = ""
            number.append(a)
        }else{
            number.append(a)
            result.text = ""
        }
        result()
    }
    private fun result(){
        try {
            val expression = ExpressionBuilder(number.text.toString()).build()
            val Result = expression.evaluate()
            val longResult = Result.toLong()
            if (Result == longResult.toDouble()) {
                result.text = longResult.toString()
            } else {
                result.text = Result.toString()
            }
        }catch (e: Exception){

        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("i", number.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        number.text = savedInstanceState.getString("i")
    }

}










