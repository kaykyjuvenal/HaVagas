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
import br.edu.ifsp.scl.ads.havagas.Formulario

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.formacaoSp.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val formacao = (view as TextView).text.toString()
                if (formacao == "fundamental" || formacao ==  "médio"){
                    amb.anoFormaturaEt.visibility = View.VISIBLE
                }
                if (formacao == "especialização" || formacao == "graduação"){
                    amb.anoConclusaoEt.visibility = View.VISIBLE
                    amb.instituicaoEt.visibility = View.VISIBLE
                }
                if (formacao == "mestrado" || formacao == "doutorado"){
                    amb.anoConclusaoEt.visibility = View.VISIBLE
                    amb.instituicaoEt.visibility = View.VISIBLE
                    amb.tituloMonografiaEt.visibility = View.VISIBLE
                    amb.orientador.visibility = View.VISIBLE
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //NSA
                }
            }
        amb.salvarBt.setOnClickListener{
            val formulario  = Formulario(
                amb.nomeCompletoEt.text.toString(),
                amb.emailEt.text.toString(),
                amb.telefoneEt.text.toString(),
                amb.celularEt.text.toString(),
                amb.sexoRg.checkedRadioButtonId.toString(),
                amb.dataNascEt.text.toString(),
                amb.formacaoSp.selectedItem.toString(),
                amb.vagasInteresseEt.text.toString()
            )
            Toast.makeText(this@MainActivity,formulario.toString(),Toast.LENGTH_SHORT).show()
        }
        amb.limparBt.setOnClickListener{
            amb.nomeCompletoEt.text.clear()
            amb.emailEt.text.clear()
            amb.telefoneEt.text.clear()
            amb.celularEt.text.clear()
            amb.sexoRg.clearCheck()
            amb.dataNascEt.text.clear()
            amb.formacaoSp.setSelection(0)
            amb.vagasInteresseEt.text.clear()

            amb.anoConclusaoEt.visibility = View.GONE
            amb.instituicaoEt.visibility = View.GONE
            amb.tituloMonografiaEt.visibility = View.GONE
            amb.orientador.visibility = View.GONE

            Toast.makeText(this@MainActivity,"Limpado!",Toast.LENGTH_SHORT).show() }
    }
}