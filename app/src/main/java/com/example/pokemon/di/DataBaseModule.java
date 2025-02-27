package com.example.pokemon.di;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;

import com.example.pokemon.dp.PokemonDao;
import com.example.pokemon.dp.PokemonDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {
    @Provides
    @Singleton
    public  static PokemonDataBase provideDB(Application application){
        return Room.databaseBuilder(
                application,
                PokemonDataBase.class,
                "fav_db"
        ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public  static PokemonDao provideDBDao(@NonNull PokemonDataBase pokemonDataBase){
        return pokemonDataBase.pokemonDao();
    }
}
