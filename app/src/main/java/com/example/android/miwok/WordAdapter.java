package com.example.android.miwok;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    ArrayList<Word> mWord;

    public WordAdapter(Context context, ArrayList<Word> objects) {
        super(context, 0, objects);
        mWord = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check to see if the view was re-used or not
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = mWord.get(position);
        // Populate Default translation TextView
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Populate Miwok translation TextView
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Return the view
        return listItemView;
    }
}
