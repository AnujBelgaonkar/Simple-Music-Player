package com.example.basic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textViewDuration;
    private TextView textViewElapsed;
    private ListView songListView;
    private TextView songTitleTextView;
    private SeekBar seekBar;
    private ImageButton playButton, pauseButton, nextButton, prevButton;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private ArrayList<Song> songs;
    private int currentSongIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songListView = findViewById(R.id.songListView);
        songTitleTextView = findViewById(R.id.songTitleTextView);
        seekBar = findViewById(R.id.seekBar);
        playButton = findViewById(R.id.playButton);
        pauseButton = findViewById(R.id.pauseButton);
        nextButton = findViewById(R.id.nextButton);
        prevButton = findViewById(R.id.prevButton);
        textViewDuration = findViewById(R.id.textViewDuration);
        textViewElapsed = findViewById(R.id.textViewElapsed);
        songs = new ArrayList<>();
        String description1 = "Ishq Mein Dil Bana Hai\n" +
                "Ishq Mein Dil Fanna Hai Ho\n" +
                "\n" +
                "Mita De Ya Bana De\n" +
                "Maine Tujhko Chuna Hai Ho Ho\n" +
                "\n" +
                "Tere Saare Rang Odh Ke Dhang Odh Ke\n" +
                "Tera Hua Main Sabko Chhod Ke Ho Ho Ho\n" +
                "Ishq Ni Karna Naap Tol Ke Raaj Khol Ke\n" +
                "Aaya Hoon Main Sabko Bol Ke Ho\n" +
                "\n" +
                "Oh Main Taan Chaleya Teri Oar\n" +
                "Tera Chaleya Hai Zor\n" +
                "Tera Hoya Main Yaar Ve\n" +
                "Bhuleya Ae Sansaar Ve\n" +
                "\n" +
                "Chaleya Teri Oar\n" +
                "Tera Chaleya Hai Zor\n" +
                "Tera Hoya Main Yaar Ve\n" +
                "Bhuleya Ae Sansaar Ve\n" +
                "\n" +
                "Jag Tere Liye Chhodiya\n" +
                "Dil Tere Sang Jodiya\n" +
                "Ab Tera Main Toh Ho Gaya\n" +
                "Paa Ke Tujhe Main Kho Gaya\n" +
                "\n" +
                "Jag Tere Liye Chhodiya\n" +
                "Dil Tere Sang Jodiya\n" +
                "Ab Tera Main Toh Ho Gaya\n" +
                "Paa Ke Tujhe Main Kho Gaya\n" +
                "Kho Gaya Haan\n" +
                "\n" +
                "Ishq Mein Dil Bana Hai\n" +
                "Ishq Mein Dil Fanna Hai Ho\n" +
                "Ho Ho Ho\n" +
                "\n" +
                "Hansa De Ya Rula De\n" +
                "Maine Tujhko Chuna Hai Oh\n" +
                "Oh Ho Ho\n" +
                "\n" +
                "Duniya Kehti\n" +
                "Ishq Bhool Hai Befizool Hai\n" +
                "Humko Toh Dil Se\n" +
                "Kubool Hai Oh Oh Ho Ho\n" +
                "\n" +
                "Tujhme Dikhta\n" +
                "Rabb Ka Noor Hai Ek Suroor Hai\n" +
                "Tu Hai Apna Yeh Guroor Hai Oh\n" +
                "Oh Oh Ho\n" +
                "\n" +
                "Ve Main Taan Chaliya Teri Oar\n" +
                "Tera Chaleya Hai Zor\n" +
                "Teri Hoyi Main Yaar Ve\n" +
                "Bhuleya Ae Sansar Ve\n" +
                "\n" +
                "Chaleya Teri Oar\n" +
                "Tera Chaleya Hai Zor\n" +
                "Teri Hoyi Main Yaar Ve\n" +
                "Bhuleya Ae Sansar Ve\n" +
                "\n" +
                "Tu Ishq-e-Khwab Khwaab Sa Hai\n" +
                "Mera Behisaab Sa Hai\n" +
                "Tere Labb Choom Loon Main\n" +
                "Urdu Ki Kitaab Sa Hai\n" +
                "\n" +
                "Ishq-e-Khwab Khwaab Sa Hai\n" +
                "Mera Behisaab Sa Hai\n" +
                "Tere Labb Choom Loon Main\n" +
                "Urdu Ki Kitaab Sa Hai\n" +
                "\n" +
                "Jag Tere Liye Chhodiya\n" +
                "Ishq Mein Dil Fanna Hai\n" +
                "Dil Tere Sang Jodiya\n" +
                "Ishq Mein Dil Fanna Hai Ho Ho\n" +
                "\n" +
                "Ab Tera Main Toh Ho Gaya\n" +
                "Paa Ke Tujhe Main Kho Gaya\n" +
                "Jag Tere Liye Chhodiya\n" +
                "Mita De Ya Bana De\n" +
                "\n" +
                "Dil Tere Sang Jodiya\n" +
                "Maine Tujhko Chuna Hai Ho Ho\n" +
                "Paa Ke Tujhe Main Kho Gaya\n" +
                "Kho Gaya Haan\n";

        String description2="Mujhko Itna Bataye Koyi\n" +
                "Kaise Tujhse Dil Na Lagaye Koyi\n" + "Rabba Ne Tujhko Banane Mein\n" + "Kardi Hai Husn Ki Khaali Tijoriyan\n" + "\n" +
                "Kajal Ki Siyahi Se Likhi\n" +
                "Hai Tune Jaane\n" +
                "Kitno Ki Love Story’an\n" +
                "\n" +
                "Kesariya Tera Ishq Hai Piya\n" +
                "Rang Jaaun Jo Main Hath Lagaun\n" +
                "Din Beete Saara Teri Fikr Mein\n" +
                "Rain Saari Teri Khair Manaun\n" +
                "\n" +
                "Kesariya Tera Ishq Hai Piya\n" +
                "Rang Jaaun Jo Main Hath Lagaun\n" +
                "Din Beete Saara Teri Fikr Mein\n" +
                "Rain Saari Teri Khair Manaun\n" +
                "\n" +
                "Patjhad Ke Mausam Mein Bhi\n" +
                "Rangi Chanaron Jaisi\n" +
                "Jhanke Sannnaton Mein Tu\n" +
                "Veena Ke Taaron Jaisi\n" +
                "\n" +
                "Hmm Sadiyon Se Bhi Lambi Yeh\n" +
                "Mann Ki Amavasein Hain\n" +
                "Aur Tu Phuljhadiyon Wale\n" +
                "Tyoharon Jaisi\n" +
                "\n" +
                "Chanda Bhi Deewana Hai Tera\n" +
                "Jalti Hai Tujhse\n" +
                "Saari Chhakoriyan\n" +
                "\n" +
                "Kajal Ki Siyahi Se Likhi\n" +
                "Hai Tune Jaane\n" +
                "Kitno Ki Love Story’an\n" +
                "\n" +
                "Kesariya Tera Ishq Hai Piya\n" +
                "Rang Jaaun Jo Main Hath Lagaun\n" +
                "Din Beete Saara Teri Fikr Mein\n" +
                "Rain Saari Teri Khair Manaun\n" +
                "\n" +
                "Kesariya Tera Ishq Hai Piya\n" +
                "Rang Jaaun Jo Main Hath Lagaun\n" +
                "Din Beete Saara Teri Fikr Mein\n" +
                "Rain Saari Teri Khair Manaun\n" +
                "\n" +
                "Kesariya Tera Ishq Hai Piya\n" +
                "Ishq Hai Piya\n" +
                "Kesariya Tera Ishq Hai Piya\n" +
                "Ishq Hai Piya\n" +
                "\n" +
                "Piya Ishq Hai Piya\n" +
                "Ishq Hai Piya\n" +
                "Kesariya Tera Ishq Hai Piya\n" +
                "Rang Jaaun Jo Main Hath Lagaun\n";

        String description3 = "Mainu Chadheya Ishq Mein Rang Tera\n" +
                "Ik Ho Gaya Ang Mera Ang Tera\n" +
                "Rabb Mileya Jad Mileya\n" +
                "Maahi Mainu Sang Tera\n" +
                "\n" +
                "Na Hoke Bhi Kareeb Tu\n" +
                "Hamesha Paas Tha\n" +
                "Ke Sau Janam Bhi Dekhta\n" +
                "Main Tera Raasta\n" +
                "\n" +
                "Na Hoke Bhi Kareeb Tu\n" +
                "Hamesha Paas Tha\n" +
                "Ke Sau Janam Bhi Dekhti\n" +
                "Main Tera Raasta\n" +
                "\n" +
                "Jo Bhi Hai Sab Mera\n" +
                "Tere Hawale Kar Diya\n" +
                "Jism Ka Har Ruaan\n" +
                "Tere Hawale Kar Diya\n" +
                "\n" +
                "Jo Bhi Hai Sab Mera\n" +
                "Tere Hawaale Kar Diya\n" +
                "Jism Ka Har Ruaan\n" +
                "Tere Hawaale Kar Diya\n" +
                "\n" +
                "Dekha Zamaana Saara Bharam Hai\n" +
                "Ishq Ibadat Ishq Karam Hai\n" +
                "Mera Thikana Teri Hi Dehleez Hai\n" +
                "\n" +
                "Ho Main Hoon Deewarein\n" +
                "Chhat Hai Piya Tu\n" +
                "Rabb Ki Mujhe Nemat Hai Piya Tu\n" +
                "Mere Liye Tu Barkat Ka Taweez Hai\n" +
                "\n" +
                "Zara Kabhi Meri Nazar Se\n" +
                "Khud Ko Dekh Bhi\n" +
                "Hai Chaand Mein Bhi Daag\n" +
                "Par Na Tujhme Ek Bhi\n" +
                "\n" +
                "Khud Pe Hak Mera\n" +
                "Tere Hawaale Kar Diya\n" +
                "Jism Ka Har Ruaan\n" +
                "Tere Hawaale Kar Diya\n" +
                "\n" +
                "Jo Bhi Hai Sab Mera\n" +
                "Tere Hawale Kar Diya\n" +
                "Jism Ka Har Ruaan\n" +
                "Tere Hawale Kar Diya\n" +
                "\n" +
                "Mainu Chadheya Ishq Mein Rang Tera\n" +
                "Ik Ho Gaya Ang Mera Ang Tera\n" +
                "Rabb Mileya Jad Mileya\n" +
                "Maahi Mainu Sang Tera\n";
        songs.add(new Song("Chaleya", "JAWAN", R.drawable.chaleya,description1));
        songs.add(new Song("Kesariya", "BHRAHMASTRA", R.drawable.kesariya,description2));
        songs.add(new Song("Tere Hawale", "LAL SINGH CHADDHA", R.drawable.terehawale,description3));
        songs.add(new Song("Song 3", "Movie 1", R.drawable.music, "This is song 3"));
        songs.add(new Song("Song 4", "Movie 2", R.drawable.music, "This is song 4"));
        songs.add(new Song("Song 5", "Movie 3", R.drawable.music, "This is song 4"));
        songs.add(new Song("Song 6", "Movie 4", R.drawable.music, "This is song 6"));
        songs.add(new Song("Song 7", "Movie 5", R.drawable.music, "This is song 7"));
        songs.add(new Song("Song 8", "Movie 6", R.drawable.music, "This is song 8"));
        songs.add(new Song("Song 9", "Movie 7", R.drawable.music, "This is song 9"));
        songs.add(new Song("Song 10", "Movie 8", R.drawable.music, "This is song 10"));

        currentSongIndex = 0;
        Song initialSong = songs.get(currentSongIndex);
        playSong(initialSong);

        final SongAdapter adapter = new SongAdapter(this, songs);
        songListView.setAdapter(adapter);

        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSongIndex = position;
                Song selectedSong = songs.get(position);
                playSong(selectedSong);
                showSongDetails(selectedSong);
                play();
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNext();
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPrevious();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playNext();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress * 1000);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void playSong(Song song) {
        int rawResourceId = 0;

        if (song.getTitle().equals("Chaleya")) {
            rawResourceId = R.raw.chaleya;
        } else if (song.getTitle().equals("Kesariya")) {
            rawResourceId = R.raw.kesariya;
        } else if (song.getTitle().equals("Tere Hawale")) {
            rawResourceId = R.raw.terehawale;
        }
        else{
            rawResourceId = R.raw.music;
        }

        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(this, rawResourceId);
        songTitleTextView.setText(song.getTitle());
        seekBar.setMax(mediaPlayer.getDuration() / 1000);
        int duration = mediaPlayer.getDuration();
        textViewDuration.setText(formatTime(duration));
        updateSeekBar();
    }

    private void play() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            updateSeekBar();
        }
    }

    private void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    private void playNext() {
        if (currentSongIndex < songs.size() - 1) {
            currentSongIndex++;
        } else {
            currentSongIndex = 0;
        }
        Song nextSong = songs.get(currentSongIndex);
        playSong(nextSong);
        play();
    }

    private void playPrevious() {
        if (currentSongIndex > 0) {
            currentSongIndex--;
        } else {
            currentSongIndex = songs.size() - 1;
        }
        Song prevSong = songs.get(currentSongIndex);
        playSong(prevSong);
        play();
    }


    private void updateSeekBar() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            seekBar.setProgress(mediaPlayer.getCurrentPosition() / 1000);
            textViewElapsed.setText(formatTime(currentPosition));
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateSeekBar();
                }
            }, 1000);
        }
    }

    private String formatTime(int millis) {
        int seconds = (millis / 1000) % 60;
        int minutes = (millis / (1000 * 60)) % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
    private void showSongDetails(Song song) {
        Intent intent = new Intent(this, SongDetailsActivity.class);
        intent.putExtra("songTitle", song.getTitle());
        intent.putExtra("songMovie", song.getMovie());
        intent.putExtra("photoResourceId", song.getPhotoResourceId());
        intent.putExtra("rawResourceId", getRawResourceId(song));
        intent.putExtra("songDescription", song.getDescription());
        startActivity(intent);
    }

    private int getRawResourceId(Song song) {
        if (song.getTitle().equals("Chaleya")) {
            return R.raw.chaleya;
        } else if (song.getTitle().equals("Kesariya")) {
            return R.raw.kesariya;
        } else if (song.getTitle().equals("Tere Hawale")) {
            return R.raw.terehawale;
        }
        return 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
