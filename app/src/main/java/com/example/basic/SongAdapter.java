package com.example.basic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Song song = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_song, parent, false);
        }

        TextView songTitleTextView = convertView.findViewById(R.id.songTitleTextView);
        TextView movieTextView = convertView.findViewById(R.id.movieTextView);
        ImageView songImageView = convertView.findViewById(R.id.songImageView);

        songTitleTextView.setText(song.getTitle());
        movieTextView.setText(song.getMovie());
        songImageView.setImageResource(song.getPhotoResourceId());

        return convertView;
    }
}
