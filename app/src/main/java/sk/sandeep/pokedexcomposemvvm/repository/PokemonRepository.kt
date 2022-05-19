package sk.sandeep.pokedexcomposemvvm.repository

import dagger.hilt.android.scopes.ActivityScoped
import sk.sandeep.pokedexcomposemvvm.models.PokemonDetailApiResponse
import sk.sandeep.pokedexcomposemvvm.models.PokemonListApiResponse
import sk.sandeep.pokedexcomposemvvm.network.remote.PokemonApi
import sk.sandeep.pokedexcomposemvvm.util.Resource
import javax.inject.Inject

/**
ActivityScoped:Scope annotation for bindings that should exist for the life of an activity.
 * */
@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonListApiResponse> {
        val response = try {
            api.getPokemonList(limit = limit, offset = offset)
        } catch (e: Exception) {
            return Resource.Error("An unKnown error occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDetailApiResponse> {
        val response = try {
            api.getPokemonInfo(name = pokemonName)
        } catch (e: Exception) {
            return Resource.Error(message = "an Unknown error occur")
        }
        return Resource.Success(data = response)
    }
}