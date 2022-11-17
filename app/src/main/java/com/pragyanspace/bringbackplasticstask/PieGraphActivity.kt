package com.pragyanspace.bringbackplasticstask

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class PieGraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_graph)

        var pieChart= findViewById<PieChart>(R.id.pieChart)
        var entries=ArrayList<PieEntry>()
        var marks= intent?.extras?.get("marks") as Array<Float>
        var subjects= intent?.extras?.get("subjects") as Array<String>
        for(i in 0 until 5)
        {
            Log.d("marks$i",marks.get(i).toString())
            var entry= PieEntry(marks.get(i),subjects.get(i))
            entries.add(entry)
        }
        var pieDataSet= PieDataSet(entries,"marks")
        pieDataSet.colors= ColorTemplate.COLORFUL_COLORS.toList()
        pieDataSet.setValueTextColors(listOf(Color.BLACK))
        pieDataSet.valueTextSize=16f


        var pieData= PieData(pieDataSet)
        pieChart?.data=pieData
        pieChart?.description?.isEnabled=false
        pieChart?.centerText="Marks"

        pieChart?.animate()
    }
}