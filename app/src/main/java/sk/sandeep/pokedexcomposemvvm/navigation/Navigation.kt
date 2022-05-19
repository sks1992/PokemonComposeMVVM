package sk.sandeep.pokedexcomposemvvm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import sk.sandeep.pokedexcomposemvvm.ui.screens.pokemon_info.PokemonDetailScreen
import sk.sandeep.pokedexcomposemvvm.ui.screens.pokemon_list.PokemonListScreen
import java.util.*

@Composable
fun NavigationRoute() {
    /** rememberNavController : Creates a NavHostController that handles the adding of
     * the ComposeNavigator and DialogNavigator. */
    val navController = rememberNavController()
    /** NavHost :
     * Provides in place in the Compose hierarchy for self contained navigation to occur.
     * Once this is called, any Composable within the given NavGraphBuilder can be navigated
    to from the provided navController
    navController - the navController for this host
    startDestination - the route for the start destination
    modifier - The modifier to be applied to the layout.
    route - the route for the graph
    builder - the builder used to construct the graph
     * */
    NavHost(navController = navController, startDestination = "pokemon_list_screen") {
        /**
         * Add the Composable to the NavGraphBuilder
        route - route for the destination
        arguments - list of arguments to associate with destination
        deepLinks - list of deep links to associate with the destinations
        content - composable for the destination
         */
        composable(route = "pokemon_list_screen") {
            PokemonListScreen(navController = navController)
        }
        //to pass arguments , we treat route as url and add argument to end of route
        //like : route = "pokemon_detail_screen/{dominantColor}/{pokemonName}"
        composable(route = "pokemon_detail_screen/{dominantColor}/{pokemonName}",
            arguments = listOf(
                navArgument(name = "dominantColor") {
                    type = NavType.IntType
                },
                navArgument(name = "pokemonName") {
                    type = NavType.StringType
                }
            )) {
            val dominantColor = remember {
                val color = it.arguments?.getInt("dominantColor")
                color?.let { Color(it) } ?: Color.White
            }

            val pokemonName = remember {
                it.arguments?.getString("pokemonName")
            }

            PokemonDetailScreen(
                dominantColor = dominantColor,
                pokemonName = pokemonName?.lowercase(Locale.ROOT) ?: "",
                navController = navController,
            )
        }
    }
}