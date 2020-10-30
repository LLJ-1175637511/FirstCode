package com.example.getphonexyzdata

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mSensorManager: SensorManager
    private var degree = 0.0
    private val sensorListener: SensorEventListener = object : SensorEventListener {
        var accelerometerValues = FloatArray(3)
        var magenticValues = FloatArray(3)
        override fun onSensorChanged(sensorEvent: SensorEvent) {

            //判断当前是加速度传感器还是地磁传感器
            if (sensorEvent.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                accelerometerValues = sensorEvent.values.clone()
            } else if (sensorEvent.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
                magenticValues = sensorEvent.values.clone()
            }
            val R = FloatArray(9)
            val values = FloatArray(3)
            SensorManager.getRotationMatrix(R, null, accelerometerValues, magenticValues)
            SensorManager.getOrientation(R, values)
            if (System.currentTimeMillis() - timestamp >= 200){
                val finalDegree = Math.toDegrees(values[0].toDouble())
                degree = if (finalDegree<0.0){
                    360 + finalDegree
                }else{
                    finalDegree
                }
                val ydegree = Math.toDegrees(values[1].toDouble())
                val zdegree = Math.toDegrees(values[2].toDouble())
                Log.d(TAG, "degree:$degree ydegree:$ydegree zdegree:$zdegree")
                timestamp = System.currentTimeMillis()
            }
        }

        override fun onAccuracyChanged(sensor: Sensor, i: Int) {

        }
    }

    private var timestamp = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val magenticSensor: Sensor =
            mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

        val accelerometerSensor: Sensor =
            mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        mSensorManager.registerListener(sensorListener, magenticSensor, SensorManager.SENSOR_DELAY_GAME)

        mSensorManager.registerListener(
            sensorListener,
            accelerometerSensor,
            SensorManager.SENSOR_DELAY_GAME
        )

    }
    
    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(sensorListener)
    }

    override fun onResume() {
        super.onResume()

        val magenticSensor: Sensor =
            mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

        val accelerometerSensor: Sensor =
            mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mSensorManager.registerListener(sensorListener, magenticSensor, SensorManager.SENSOR_DELAY_GAME)

        mSensorManager.registerListener(
            sensorListener,
            accelerometerSensor,
            SensorManager.SENSOR_DELAY_GAME
        )
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
