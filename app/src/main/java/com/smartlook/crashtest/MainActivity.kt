package com.smartlook.crashtest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.smartlook.crashtest.utility.crash.simulate.CrashType
import com.smartlook.crashtest.utility.crash.simulate.SimulateCrashUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.b_simulate_null).setOnClickListener {
            simulateAndTrackCrash(CrashType.NULL_POINTER)
        }

        findViewById<Button>(R.id.b_simulate_illegal_argument).setOnClickListener {
            simulateAndTrackCrash(CrashType.ILLEGAL_ARGUMENT)
        }

        findViewById<Button>(R.id.b_simulate_invalid_object).setOnClickListener {
            simulateAndTrackCrash(CrashType.INVALID_OBJECT)
        }
    }

    private fun simulateAndTrackCrash(crashType: CrashType) {
        SimulateCrashUtil().simulateAndTrackCrash(this, crashType)
    }
}