package com.smartlook.crashtest

import android.app.Application
import com.smartlook.sdk.smartlook.Smartlook
import com.smartlook.sdk.smartlook.util.logging.annotation.LogAspect

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO: Add your Smartlook API key here:
        val smartlookBuilder = Smartlook.SetupOptionsBuilder("").apply {
            //TODO: Uncomment this to force new session on every application run
            startNewSession()
        }


        Smartlook.enableLogging(listOf(LogAspect.ALL))
        Smartlook.setupAndStartRecording(smartlookBuilder.build())
    }
}