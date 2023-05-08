package com.example.pokemon.di;

import android.app.Application;

import androidx.room.Room;

import com.example.pokemon.database.PokemonDao;
import com.example.pokemon.database.PokemonDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    public static PokemonDatabase providePokemonDatabase(Application application) {
        return Room.databaseBuilder(application, PokemonDatabase.class, "db_table")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static PokemonDao providePokemonDao(PokemonDatabase pokemonDatabase) {
        return pokemonDatabase.pokemonDao();
    }


}
