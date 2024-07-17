package ru.alexsergeev.testwb.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.alexsergeev.testwb.di.modules.dataModule
import ru.alexsergeev.testwb.di.modules.domainModule
import ru.alexsergeev.testwb.di.modules.presentationModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(presentationModule, dataModule, domainModule)
        }
    }
}