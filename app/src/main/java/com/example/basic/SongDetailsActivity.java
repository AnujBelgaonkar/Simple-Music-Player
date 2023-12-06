package com.example.basic;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SongDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("songTitle");
            String movie = intent.getStringExtra("songMovie");
            int photoResourceId = intent.getIntExtra("photoResourceId", 0);
            String description = intent.getStringExtra("songDescription");

            TextView titleTextView = findViewById(R.id.titleTextView);
            TextView movieTextView = findViewById(R.id.movieTextView);
            ImageView imageView = findViewById(R.id.imageView);
            TextView descriptionTextView = findViewById(R.id.descriptiontextView);

            titleTextView.setText(title);
            movieTextView.setText(movie);
            imageView.setImageResource(photoResourceId);
            descriptionTextView.setText(description);
        }
    }
}
