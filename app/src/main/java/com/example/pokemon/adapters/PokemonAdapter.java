package com.example.pokemon.adapters;

import android.annotation.SuppressLint;
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
    private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
    private Context context;

    public PokemonAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.pokemonTextView.setText(pokemon.getName());

        Glide.with(context).load(pokemon.getUrl()).into(holder.pokemonImageView);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setPokemonList(ArrayList<Pokemon> PokemonList) {
        this.pokemonList = PokemonList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public Pokemon getPokemonAt(int position){
        return  pokemonList.get(position);
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        private  ImageView pokemonImageView;
        private  TextView pokemonTextView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonImageView = itemView.findViewById(R.id.pokemon_imageView);
            pokemonTextView = itemView.findViewById(R.id.pokemon_name_textView);
        }
    }
}
