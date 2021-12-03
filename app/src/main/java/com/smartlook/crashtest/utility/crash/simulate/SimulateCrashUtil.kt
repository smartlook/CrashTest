package com.smartlook.crashtest.utility.crash.simulate

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.smartlook.sdk.smartlook.Smartlook
import java.io.InvalidObjectException
import java.lang.Exception
import java.lang.IllegalArgumentException

class SimulateCrashUtil {

    fun simulateAndTrackCrash(context: Context, crashType: CrashType) {
        simulateAndTrackCrashFakeStackFirst(context, crashType)
    }

    private fun simulateAndTrackCrashFakeStackFirst(context: Context, crashType: CrashType) {
        simulateAndTrackCrashFakeStackSecond(context, crashType)
    }

    private fun simulateAndTrackCrashFakeStackSecond(context: Context, crashType: CrashType) {
        try {
            throw when(crashType) {
                CrashType.NULL_POINTER -> NullPointerException()
                CrashType.ILLEGAL_ARGUMENT -> IllegalArgumentException()
                CrashType.INVALID_OBJECT -> InvalidObjectException("reasonable reason")
            }
        } catch (e: Exception) {
            Smartlook.forceCrash(
                Log.getStackTraceString(e),
                "MainActivity"
            )
            Toast.makeText(context, "Tracked: ${e.javaClass.simpleName}", Toast.LENGTH_SHORT).show()
        }
    }

}