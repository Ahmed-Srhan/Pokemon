package com.example.pokemon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokemon.R;
import com.example.pokemon.model.Pokemon;

import java.util.ArrayList;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    private Context context;

    public PokemonAdapter(Context context) {
        this.context = context;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_pokemon, parent, false);

        return new PokemonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.tv_name.setText(pokemons.get(position).getName());
        Glide.with(context)
                .load(pokemons.get(position).getUrl())
                .into(holder.imageView);
    }

    public Pokemon getPokemonPosition(int position) {
        return pokemons.get(position);

    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        ImageView imageView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.textViewPokemonName);
            imageView = itemView.findViewById(R.id.imageViewPokemon);

        }
    }
}
