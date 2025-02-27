package com.example.pokemon.model;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "fav_table")
public class Pokemon {

    @PrimaryKey(autoGenerate = true)
    private  int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    private String name;
    private String url;

    public Pokemon(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
