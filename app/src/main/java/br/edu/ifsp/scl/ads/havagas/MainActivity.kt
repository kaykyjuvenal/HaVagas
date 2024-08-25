package br.edu.ifsp.scl.ads.havagas

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        """amb.estadoCivilSp.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val estadoCivil = (view as TextView).text.toString()
                if (estadoCivil == "Casado"){
                    amb.conjugeLl.visibility = View.VISIBLE
                }
                else {
                    amb.conjugeLl.visibility = View.GONE
                    amb.nomeConjugeEt.setText("")
                    amb.sobrenomeEt.setText("")
                }
                // iMPLEMENTAR O LIMPAR
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //NSA
            }


        }
        amb.salvarBt.setOnClickListener{
            val formulario  = Formulario(amb.nomeEt.text.toString(),
                amb.sobrenomeEt.text.toString(),
                amb.emailEt.text.toString(),
                amb.estadoCivilSp.selectedItem.toString(),
                amb.sexoRg.checkedRadioButtonId.toString()
            )
            Toast.makeText(this@MainActivity,formulario.toString(),Toast.LENGTH_SHORT).show()
        }
        amb.limparBt.setOnClickListener{
            amb.nomeEt.text.clear()
            amb.sobrenomeEt.text.clear()
            amb.emailEt.text.clear()
            amb.estadoCivilSp.setSelection(0)
            amb.sexoRg.clearCheck()
            Toast.makeText(this@MainActivity,"Limpado!",Toast.LENGTH_SHORT).show()
        }
"""
    }
}