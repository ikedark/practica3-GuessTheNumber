package mx.edu.potros.practica3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.random.Random
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var minValue=0
    var maxValue=100
    var num:Int=0
    var won=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instancia el objeto del layout guessings
        val guessing : TextView = findViewById(R.id.guessings)
        val down: TextView = findViewById(R.id.down)
        val up: TextView = findViewById(R.id.up)
        val generate:Button = findViewById(R.id.generate)
        val guessed:Button = findViewById(R.id.guessed)

        //Método del clic del botón generate
        generate.setOnClickListener {
            num = Random.nextInt(minValue,maxValue)
            guessing.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        up.setOnClickListener {
            minValue=num
            if (checkingLimits()){
                num = Random.nextInt(minValue,maxValue)
                guessing.setText(num.toString())
            }else{
                guessing.setText("No puede ser :( me ganaste")
            }
        }

        down.setOnClickListener {
            maxValue=num
            if (checkingLimits()){
                num = Random.nextInt(minValue,maxValue)
                guessing.setText(num.toString())
            }else{
                guessing.setText(num.toString())
            }
        }

        guessed.setOnClickListener {
            if(!won){
                guessing.setText("Adiviné, tu numero es el "+ num)
                guessed.setText("Volver a jugar")
                won=true
            }else {
                generate.visibility=View.VISIBLE
                guessing.setText("Tap on generate to start")
                guessed.visibility=View.GONE
                resetValues()
            }
        }


    }

    fun resetValues(){
        var minValue=0
        var maxValue=100
        var num:Int=0
        var won=false
    }

    fun checkingLimits(): Boolean {
        return minValue!=maxValue
    }

}