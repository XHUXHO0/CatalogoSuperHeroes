package com.example.catalogo_super;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.catalogo_super.databinding.ActivityDetallBinding;
import com.example.catalogo_super.databinding.ActivityMainBinding;

public class DetallActivity extends AppCompatActivity {

    public static final String SUPERHERO_KEY = "superhero";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetallBinding binding = ActivityDetallBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // creamos una variable con multiples valores como un json
        Bundle extras = getIntent().getExtras();
        // se cambia getString por getParcelable pora tomar datos desde la clase que creamos
        Superhero superhero = extras.getParcelable("SUPERHERO_KEY");
        binding.heroName.setText(superhero.getName());
        binding.alterEgoText.setText(superhero.getAlterego());
        binding.bioText.setText(superhero.getBio());
        binding.ratingBar.setRating(superhero.getPower());

    }
}