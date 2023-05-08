package com.example.pokemon.repository;

import androidx.lifecycle.LiveData;

import com.example.pokemon.database.PokemonDao;
import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.PokemonResponse;
import com.example.pokemon.network.PokemonApiServices;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {
    private PokemonApiServices pokemonApiServices;
    private PokemonDao pokemonDao;

    @Inject
    public Repository(PokemonApiServices pokemonApiServices, PokemonDao pokemonDao) {
        this.pokemonApiServices = pokemonApiServices;
        this.pokemonDao = pokemonDao;
    }


    public Observable<PokemonResponse> getPokemons() {
        return pokemonApiServices.getPokemons();
    }

    public void insetPokemon(Pokemon pokemon) {
        pokemonDao.insertPokemon(pokemon);
    }

    public void deletePokemon(Pokemon pokemon) {
        pokemonDao.deletePokemon(pokemon.getName());
    }

    public LiveData<List<Pokemon>> getFavPokemons() {
        return pokemonDao.getFavPokemons();
    }


}