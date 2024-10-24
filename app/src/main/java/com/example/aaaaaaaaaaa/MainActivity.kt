package com.example.aaaaaaaaaaa

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.aaaaaaaaaaa.ui.theme.AAAAAAAAAAATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AAAAAAAAAAATheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    zawd1()
                }
            }
        }
    }

    fun zawd1() {
        setContentView(R.layout.layout)
        val res: TextView = findViewById(R.id.result)

        val massWugillia: EditText = findViewById(R.id.mass_wugillia)
        val massMazut: EditText = findViewById(R.id.mass_mazut)
        val calculateButton: Button = findViewById(R.id.calculate)

        calculateButton.setOnClickListener {

            val w_Qri = 20.47
            val w_avyn = 0.8
            val w_Ar = 25.20
            val w_Gvyn = 1.5
            val w_ezy = 0.985
            val w_ktwS = 0.0
            val w_B = massWugillia.text.toString().toDoubleOrNull() ?: 0.0

            val w_ktw = calc_ktv(w_Qri, w_avyn, w_Ar, w_Gvyn, w_ezy, w_ktwS)
            val w = walowyj_wykyd(w_ktw, w_Qri, w_B)

            val m_Qri = 39.48
            val m_avyn = 1.0
            val m_Ar = 0.15
            val m_Gvyn = 0.0
            val m_ezy = 0.985
            val m_ktwS = 0.0
            val m_B = massMazut.text.toString().toDoubleOrNull() ?: 0.0

            val m_ktw = calc_ktv(m_Qri, m_avyn, m_Ar, m_Gvyn, m_ezy, m_ktwS)
            val m = walowyj_wykyd(m_ktw, m_Qri, m_B)

            res.text =
                "1.1. Показник емісії твердих частинок при спалюванні вугілля становитиме: $w_ktw г/ГДж;\n" +
                        "1.2. Валовий викид при спалюванні вугілля становитиме: $w т.;\n" +
                        "1.3. Показник емісії твердих частинок при спалюванні мазуту становитиме: $m_ktw г/ГДж;\n" +
                        "1.4. Валовий викид при спалюванні мазуту становитиме: $m т.;"

        }


    }

    fun calc_ktv(
        Qri: Double,
        avyn: Double,
        Ar: Double,
        Gvyn: Double,
        ezy: Double,
        ktvS: Double
    ): Double {

        val ktv = (1000000 / Qri) * avyn * (Ar / (100 - Gvyn)) * (1 - ezy) + ktvS
        return ktv
    }

    fun walowyj_wykyd(
        ktw: Double,
        Qri: Double,
        B: Double
    ): Double {
        val Etv = 0.000001 * ktw * Qri * B
        return Etv
    }
}
