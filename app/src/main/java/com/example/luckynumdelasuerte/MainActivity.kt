package com.example.luckynumdelasuerte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  buttGoo = findViewById<Button>(R.id.go_button)
        val entername = findViewById<EditText>(R.id.name)
        val enterage = findViewById<EditText>(R.id.age)
        buttGoo.setOnClickListener(){
            if (entername.text.isEmpty() || enterage.text.isEmpty()) {
                Toast.makeText(this, "Favor de ingresar los valores solicitados", Toast.LENGTH_LONG).show()
            }
            else{
                val valueN = entername.text.toString()
                val valueA = (enterage.text.toString()).toInt()
                if (valueA in 1..9) {
                    val num = valueA * 7
                    if (num in 14..63) {
                        val resNum = addDig(num)
                        if (resNum in 10..13) {
                            val resNum1 = addDig(resNum)
                            Toast.makeText(
                                this,
                                "Bienvenido $valueN tu número de la suerte es $resNum1",
                                Toast.LENGTH_LONG
                            ).show()
                        }else{
                            val resNu = addDig(resNum)
                            Toast.makeText(
                                this,
                                "Bienvenido $valueN tu número de la suerte es $resNu",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            this,
                            "Bienvenido $valueN tu número de la suerte es $num",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                else if (valueA <= 0){
                    Toast.makeText(this, "Edad no válida", Toast.LENGTH_LONG).show()
                }

                else if (valueA in 10..99) {
                    val resNum2 = addDig(valueA)
                    if (resNum2 in 1..9) {
                        Toast.makeText(
                            this,
                            "Bienvenido $valueN tu número de la suerte es $resNum2",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        val resNum3 = addDig(resNum2)
                        Toast.makeText(
                            this,
                            "Bienvenido $valueN tu número de la suerte es $resNum3",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else if (valueA >= 100) {
                    Toast.makeText(this, "Edad no válida", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}
fun addDig (Age:Int):Int{
    var num = Age
    var addDig=0
    while(num!=0){
        var lastDig=num%10
        num /= 10
        addDig+=lastDig
    }
    return addDig
}