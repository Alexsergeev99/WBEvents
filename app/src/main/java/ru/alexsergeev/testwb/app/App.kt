package ru.alexsergeev.testwb.app

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.alexsergeev.data.di.dataModule
import ru.alexsergeev.presentation.BuildConfig
import ru.alexsergeev.testwb.di.modules.domainModule
import ru.alexsergeev.testwb.di.modules.presentationModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(BuildConfig.API_KEY)

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(presentationModule, dataModule, domainModule)
        }
    }


}