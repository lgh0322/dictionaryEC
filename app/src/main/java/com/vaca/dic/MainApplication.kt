package com.vaca.dic

import android.app.Application
import com.tencent.bugly.crashreport.CrashReport


class MainApplication : Application() {

    companion object {
        lateinit var application: Application
    }


    override fun onCreate() {
        super.onCreate()
        application = this
        CrashReport.initCrashReport(this, "3806c696e6", false);
    }


}