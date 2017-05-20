package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    ArrayList<Word> mWord;
    int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> objects, int colorResourceId) {
        super(context, 0, objects);
        mWord = objects;
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check to see if the view was re-used or not
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Word currentWord = mWord.get(position);
        // Populate Default translation TextView
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Populate Miwok translation TextView
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //Populate image if it exists
        ImageView wordImageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            wordImageView.setImageResource(currentWord.getImageResourceId());
            wordImageView.setVisibility(View.VISIBLE);
        } else {
            wordImageView.setVisibility(View.GONE);
        }

        // Set layout background
        LinearLayout lay = (LinearLayout) listItemView.findViewById(R.id.word_layout);
        lay.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));

        // Set background color for play icon
        ImageView playIcon = (ImageView) listItemView.findViewById(R.id.playIcon);
        playIcon.setBackgroundColor(ContextCompat.getColor(getContext(), mColorResourceId));

        // Return the view
        return listItemView;
    }
}
