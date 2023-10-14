package com.example.vinothLearningApp

import android.content.pm.PackageManager
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private val RECORD_AUDIO_PERMISSION = android.Manifest.permission.RECORD_AUDIO
    private val REQUEST_PERMISSION_CODE = 101
    private var isRecording = false
    private var mediaRecorder: MediaRecorder? = null
    private var outputFile: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startStopButton = findViewById<Button>(R.id.startStopButton)
        val statusTextView = findViewById<TextView>(R.id.statusTextView)

        if (ContextCompat.checkSelfPermission(this, RECORD_AUDIO_PERMISSION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(RECORD_AUDIO_PERMISSION),
                REQUEST_PERMISSION_CODE
            )
        }

        startStopButton.setOnClickListener {
            if (isRecording) {
                stopRecording()
                statusTextView.text = "Status: Not Recording"
            } else {
                startRecording()
                statusTextView.text = "Status: Recording"
            }
            isRecording = !isRecording
            startStopButton.text = if (isRecording) "Stop Recording" else "Start Recording"
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_CODE && grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            // Permission granted, you can start recording here
        } else {
            // Permission denied, handle it accordingly
        }
    }

    private fun startRecording() {
        mediaRecorder = MediaRecorder()
        outputFile = "${Environment.getExternalStorageDirectory()}/"
        outputFile += SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(Date())
        outputFile += ".3gp"

        mediaRecorder?.apply {
            setAudioSource(MediaRecorder.AudioSource.MIC)
            setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            setOutputFile(outputFile)

            try {
                prepare()
                start()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun stopRecording() {
        mediaRecorder?.apply {
//            stop()
            release()
        }
        mediaRecorder = null
    }
}