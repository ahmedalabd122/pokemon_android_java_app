package com.example.pokemon.repository;

import com.example.pokemon.model.PokemonResponse;
import com.example.pokemon.network.PokemonApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;


public class Repository {
    private final PokemonApiService pokemonApiService;

    @Inject
    public Repository(PokemonApiService pokemonApiService) {
        this.pokemonApiService = pokemonApiService;
    }

    public Observable<PokemonResponse> getPokemons() {
        return pokemonApiService.getPokemons();
    }

}
