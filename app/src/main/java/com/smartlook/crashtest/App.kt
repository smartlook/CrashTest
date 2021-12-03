package com.smartlook.crashtest

import android.app.Application
import com.smartlook.sdk.smartlook.Smartlook
import com.smartlook.sdk.smartlook.util.logging.annotation.LogAspect

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO: Add your Smartlook API key here:
        val smartlookBuilder = Smartlook.SetupOptionsBuilder("85d3eb951c75ff51df3ca8c24cc4eb51efd68822").apply {
            //TODO: Uncomment this to force new session on every application run
            startNewSession()
        }


        Smartlook.enableLogging(listOf(LogAspect.ALL))
        Smartlook.setupAndStartRecording(smartlookBuilder.build())
    }
}