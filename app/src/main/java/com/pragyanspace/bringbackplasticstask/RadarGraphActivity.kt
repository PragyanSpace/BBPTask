package com.pragyanspace.bringbackplasticstask

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.mikephil.charting.charts.RadarChart
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class RadarGraphActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radar_graph)

        var radarChart=findViewById<RadarChart>(R.id.radarChart)
        var entries=ArrayList<RadarEntry>()
        var marks= intent?.extras?.get("marks") as Array<Float>
        var subjects= intent?.extras?.get("subjects") as Array<String>

        for(i in 0 until 5)
        {
            var entry= RadarEntry(marks.get(i))
            entries.add(entry)
        }

        var radarDataSet= RadarDataSet(entries,"marks")
        radarDataSet.colors= ColorTemplate.COLORFUL_COLORS.toList()
        radarDataSet.setValueTextColors(listOf(Color.BLACK))
        radarDataSet.valueTextSize=16f


        var radarData= RadarData(radarDataSet)
        radarChart?.data=radarData
        var xAxis=radarChart.xAxis
        xAxis=radarChart.xAxis
        xAxis.valueFormatter=IndexAxisValueFormatter(subjects)
        radarChart?.description?.isEnabled=false
        radarChart?.data=radarData
    }
}