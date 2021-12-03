# Setting the API key
To enable Smartlook SDK recording in this application you need to configure `API key`. 

First you need to locate the `App` class, that can be found at:
```
CrashTest/app/src/main/java/com/smartlook/crashtest/App.kt
```

Then you need to place your application key into `Smartlook.SetupOptionsBuilder`:

```kotlin
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        // TODO: Add your Smartlook API key here:
        val smartlookBuilder = Smartlook.SetupOptionsBuilder("YOUR API KEY HERE").apply {
            //TODO: Uncomment this to force new session on every application run
            //startNewSession()
        }


        Smartlook.enableLogging(listOf(LogAspect.ALL))
        Smartlook.setupAndStartRecording(smartlookBuilder.build())
    }
}
```

Note that api key can be prefixed by `alfa_`/`beta_` if you want to record to non-production enviroment.
