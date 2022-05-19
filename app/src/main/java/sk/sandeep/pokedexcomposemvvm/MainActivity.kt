package sk.sandeep.pokedexcomposemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import sk.sandeep.pokedexcomposemvvm.navigation.NavigationRoute
import sk.sandeep.pokedexcomposemvvm.ui.theme.PokedexComposeMVVMTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexComposeMVVMTheme {
                NavigationRoute()
            }
        }
    }
}

