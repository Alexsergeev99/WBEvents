package ru.alexsergeev.testwb.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.alexsergeev.testwb.di.appModule
import ru.alexsergeev.testwb.di.authModule
import ru.alexsergeev.testwb.di.eventsModule
import ru.alexsergeev.testwb.di.groupsModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, eventsModule, groupsModule, authModule)
        }
    }
}