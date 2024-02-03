package com.example.catalogo_super;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.catalogo_super.databinding.ActivityDetallBinding;
import com.example.catalogo_super.databinding.ActivityMainBinding;

public class DetallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetallBinding binding = ActivityDetallBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // creamos una variable con multiples valores como un json
        Bundle extras = getIntent().getExtras();
        // tomamos los valores y los ponemos en variables locales
        String superheroName = extras.getString("superhero_name");
        String alterEgo = extras.getString("alter_ego");
        String bio = extras.getString("bio");
        float rating = extras.getFloat("rating");

        binding.heroName.setText(superheroName);
        binding.alterEgoText.setText(alterEgo);
        binding.bioText.setText(bio);
        binding.ratingBar.setRating(rating);

    }
}