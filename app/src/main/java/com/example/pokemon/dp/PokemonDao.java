package com.example.pokemon.dp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;


import com.example.pokemon.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertPokemon(Pokemon pokemon);

    @Query("delete from fav_table where id =:pokemonId")
    public void deletePokemon(int pokemonId);
    @Query("SELECT * FROM fav_table WHERE name = :name LIMIT 1")
    Pokemon getPokemonByName(String name);

    @Transaction
    default void insertIfNotExists(Pokemon pokemon) {
        if (getPokemonByName(pokemon.getName()) == null) {
            insertPokemon(pokemon);
        }
    }
    @Query("select * from fav_table")
    public LiveData<List<Pokemon>> getPokemons();
}