package com.example.piranti

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity : Button
    private lateinit var btnMoveActivityData : Button
    private lateinit var btnDialNumber : Button
    private lateinit var btnResultFromActivity : Button
    private lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveActivityData = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityData.setOnClickListener(this)

        btnDialNumber = findViewById(R.id.btn_dial_number)
        btnDialNumber.setOnClickListener(this)

        btnResultFromActivity = findViewById(R.id.btn_move_for_result)
        btnResultFromActivity.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
        WarnaReceived()
    }

    override fun onClick(v: View?) {
        if(v != null){
            when(v.id){
                R.id.btn_move_activity -> run{
                    val intent = Intent(this,MoveActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_move_activity_data -> run{
                    val intent = Intent(this,MoveActivityWithData::class.java)
                    val bundle = Bundle()
                    bundle.putString("Nama","Geza")
                    bundle.putString("Alamat","Karangploso")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                R.id.btn_dial_number -> run{
                    val dialNumber = "0859186074691"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dialNumber))
                    startActivity(intent)
                }
                R.id.btn_move_for_result -> run{
                    val intent = Intent(this,MoveActivityForResult::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun WarnaReceived(){
        val bundle = intent.extras
        val warna = bundle?.getString("Warna")
        tvResult.text = warna
    }
}


