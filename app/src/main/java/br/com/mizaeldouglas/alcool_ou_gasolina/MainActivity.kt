package br.com.mizaeldouglas.alcool_ou_gasolina

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText

    private lateinit var textInputGasoline: TextInputLayout
    private lateinit var editGasoline: TextInputEditText

    private lateinit var buttonCalculate: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViewsInterface()
        buttonCalculate.setOnClickListener{
            calculate()
        }
    }

    private fun calculate() {
        val alcool = editAlcool.text.toString().toDouble()
        val gasoline = editGasoline.text.toString().toDouble()
         val resultValidation = validate(editAlcool.text.toString(), editGasoline.text.toString())

        if(resultValidation){
            val result = alcool / gasoline
            if (result >= 0.7){
                textResult.text = "Melhor utilizar Gasolina"
            }else{
                textResult.text = "Melhor utilizar Álcool"
            }
        }




    }

    private fun validate(pAlcool: String, pGasoline: String): Boolean {
        if (pAlcool.isEmpty() || pGasoline.isEmpty()){
            textInputAlcool.error = if (pAlcool.isEmpty()) "Campo obrigatório" else null
            textInputGasoline.error = if (pGasoline.isEmpty()) "Campo obrigatório" else null
            return false
        }
        return true
    }

    private fun initViewsInterface() {
        textInputAlcool = findViewById(R.id.text_input_alcool)
        editAlcool = findViewById(R.id.edit_alcool)

        textInputGasoline = findViewById(R.id.text_input_gasolina)
        editGasoline = findViewById(R.id.edit_gasolina)

        buttonCalculate = findViewById(R.id.btn_calc)
        textResult = findViewById(R.id.text_result)

    }


}