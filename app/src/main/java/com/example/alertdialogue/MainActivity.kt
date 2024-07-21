package com.example.alertdialogue



import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


var text5 :Int = 0
class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        var btn: Button? = null
        var text1: TextView? = null
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        text1=findViewById(R.id.textView)
        btn=findViewById(R.id.button)
        btn?.setOnClickListener{
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.alertdialog2)
            val btn1 = dialog.findViewById<Button>(R.id.bt_sum)
            val btn2 = dialog.findViewById<Button>(R.id.bt_sub)
            val btn3 = dialog.findViewById<Button>(R.id.bt_reset)
            val tex = dialog.findViewById<EditText>(R.id.TEXT)




            btn1.setOnClickListener{
                if(tex.text.toString().isEmpty()){
                    tex.setText("0")
                }

                text5 = tex.text.toString().toInt() + text1.text.toString().toInt()
                text1?.setText(text5.toString())
                dialog.dismiss()
            }
            btn2.setOnClickListener{
                if(tex.text.toString().isEmpty()){
                    tex.setText("0")
                }
                text5 = text1.text.toString().toInt()  - tex.text.toString().toInt()
                text1?.setText(text5.toString())
                dialog.dismiss()
            }
            btn3.setOnClickListener{
                text5 =0
                text1?.setText(text5.toString())
                dialog.dismiss()
            }

            dialog.show()

        }



    }
}