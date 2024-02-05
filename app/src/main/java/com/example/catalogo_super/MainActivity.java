package com.example.catalogo_super;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;

import com.example.catalogo_super.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final int PHOTO_REQUEST_CODE = 1000;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.saveButton.setOnClickListener(v -> {
            String superheroName = binding.heroNameEdit.getText().toString();
            String alterEgo = binding.alterEgoEdit.getText().toString();
            String bio = binding.bioEdit.getText().toString();
            float rating = binding.powerBar.getRating();
            openDetailActivity(superheroName,alterEgo,bio,rating);
        });

        binding.heroImages.setOnClickListener(v->{
            openCamera();
        });
    }

    private void openCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,PHOTO_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK && resultCode == PHOTO_REQUEST_CODE){
            Bitmap bitmap = data.getExtras().getParcelable("data");
            binding.heroImages.setImageBitmap(bitmap);
        }
    }

    private void openDetailActivity(String superheroName, String alterEgo, String bio, float rating){

        Superhero superhero = new Superhero(superheroName,alterEgo,bio,rating);

        Intent intent = new Intent(this,DetallActivity.class);
        intent.putExtra("SUPERHERO_KEY", superhero);

        startActivity(intent);
    }
}