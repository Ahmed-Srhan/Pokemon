package com.example.pokemon.model;

import java.util.ArrayList;

public class PokemonResponse {
    private int count;
    private String previous, next;
    private ArrayList<Pokemon> results;

    public PokemonResponse(int count, String previous, String next, ArrayList<Pokemon> results) {
        this.count = count;
        this.previous = previous;
        this.next = next;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
