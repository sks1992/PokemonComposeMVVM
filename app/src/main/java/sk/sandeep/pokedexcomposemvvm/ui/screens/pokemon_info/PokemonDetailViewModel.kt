package sk.sandeep.pokedexcomposemvvm.ui.screens.pokemon_info

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import sk.sandeep.pokedexcomposemvvm.models.PokemonDetailApiResponse
import sk.sandeep.pokedexcomposemvvm.repository.PokemonRepository
import sk.sandeep.pokedexcomposemvvm.util.Resource
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDetailApiResponse> {
        return repository.getPokemonInfo(pokemonName)
    }
}