package sk.sandeep.pokedexcomposemvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokedexApplication : Application() {
    /** If we Want to Add Timber Library setUp We Can Do here*/

//    override fun onCreate() {
//        super.onCreate()
//       Timber.plant(Timber.DebugTree())
//    }
}
