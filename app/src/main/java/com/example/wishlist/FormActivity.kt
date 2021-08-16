package com.example.wishlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class FormActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var sbNota: SeekBar
    private lateinit var tvNota: TextView
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etDescricao = findViewById(R.id.etDescricao)
        this.sbNota = findViewById(R.id.sbNota)
        this.tvNota = findViewById(R.id.tvNota)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.btCancelar = findViewById(R.id.btCancelar)

        this.sbNota.setOnSeekBarChangeListener(OnChange())

        this.btSalvar.setOnClickListener{ salvar() }
        this.btCancelar.setOnClickListener{ finish() }
    }

    fun salvar(){
        val descricao = this.etDescricao.text.toString()
        val nota = this.sbNota.progress
        val desejo = Desejo(descricao, nota)
        val intent = Intent()
        intent.putExtra("DESEJO", desejo)
        setResult(RESULT_OK, intent)
        finish()
    }

    inner class OnChange: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this@FormActivity.tvNota.text = progress.toString()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }
}