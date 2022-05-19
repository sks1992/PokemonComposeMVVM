package sk.sandeep.pokedexcomposemvvm.network.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sk.sandeep.pokedexcomposemvvm.models.PokemonDetailApiResponse
import sk.sandeep.pokedexcomposemvvm.models.PokemonListApiResponse

interface PokemonApi {
    /*
    * Calling any API endpoint without a resource ID or name will return a paginated list
    *  of available resources for that API. By default, a list "page" will contain up to 20
    *  resources. If you would like to change this just add a 'limit' query parameter to the
    *  GET request, e.g. ?limit=60. You can use 'offset' to move to the next page,
    *  e.g. ?limit=60&offset=60.*/
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListApiResponse

    /* Here in url we can see  https://pokeapi.co/api/v2/pokemon/ditto that ditto is nat a
    * query parameter it is a path parameter*/
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): PokemonDetailApiResponse
}