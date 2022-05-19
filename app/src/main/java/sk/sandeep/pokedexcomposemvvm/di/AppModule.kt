package sk.sandeep.pokedexcomposemvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sk.sandeep.pokedexcomposemvvm.network.remote.PokemonApi
import sk.sandeep.pokedexcomposemvvm.repository.PokemonRepository
import sk.sandeep.pokedexcomposemvvm.util.Constants.BASE_URL
import javax.inject.Singleton

/**
SingletonComponent::class : it Mean that the provider define in appModule will be live as
long as our application does
 * */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(pokemonApi: PokemonApi): PokemonRepository {
        return PokemonRepository(api = pokemonApi)
    }


    @Singleton
    @Provides
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokemonApi::class.java)
    }
}
