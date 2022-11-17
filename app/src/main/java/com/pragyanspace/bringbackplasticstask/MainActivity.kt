package com.pragyanspace.bringbackplasticstask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.pragyanspace.bringbackplasticstask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.piebutton.setOnClickListener {
            var subjectList= arrayOf<String>(binding.subject1.text.toString(),binding.subject2.text.toString(),binding.subject3.text.toString(),binding.subject4.text.toString(),binding.subject5.text.toString())
            var marksList=arrayOf<Float>(binding.marks1.text.toString().toFloat(),binding.marks2.text.toString().toFloat(),binding.marks3.text.toString().toFloat(),binding.marks4.text.toString().toFloat(),binding.marks5.text.toString().toFloat())
            var Intent= Intent(this@MainActivity,PieGraphActivity::class.java)
            Intent.putExtra("subjects",subjectList)
            Intent.putExtra("marks",marksList)
            startActivity(Intent)
        }
        binding.radarbutton.setOnClickListener {
            var subjectList= arrayOf<String>(binding.subject1.text.toString(),binding.subject2.text.toString(),binding.subject3.text.toString(),binding.subject4.text.toString(),binding.subject5.text.toString())
            var marksList=arrayOf<Float>(binding.marks1.text.toString().toFloat(),binding.marks2.text.toString().toFloat(),binding.marks3.text.toString().toFloat(),binding.marks4.text.toString().toFloat(),binding.marks5.text.toString().toFloat())
            var Intent= Intent(this@MainActivity,RadarGraphActivity::class.java)
            Intent.putExtra("subjects",subjectList)
            Intent.putExtra("marks",marksList)
            startActivity(Intent)
        }
    }
}