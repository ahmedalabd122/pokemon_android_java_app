package com.example.pokemon.network;


import com.example.pokemon.model.PokemonResponse;

import retrofit2.http.GET;
import io.reactivex.rxjava3.core.Observable;


public interface PokemonApiService {
    @GET("pokemon")
    Observable<PokemonResponse> getPokemons();
}
