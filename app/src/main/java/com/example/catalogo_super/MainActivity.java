package com.example.catalogo_super;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.catalogo_super.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.saveButton.setOnClickListener(v -> {
            String superheroName = binding.heroNameEdit.getText().toString();
            String alterEgo = binding.alterEgoEdit.getText().toString();
            String bio = binding.bioEdit.getText().toString();
            float rating = binding.powerBar.getRating();
            openDetailActivity(superheroName,alterEgo,bio,rating);
        });
    }
    private void openDetailActivity(String superheroName,String alterEgo,String bio,float rating){
        Intent intent = new Intent(this,DetallActivity.class);
        intent.putExtra("superhero_name", superheroName);
        intent.putExtra("alter_ego", alterEgo);
        intent.putExtra("bio", bio);
        intent.putExtra("rating", rating);
        startActivity(intent);
    }
}