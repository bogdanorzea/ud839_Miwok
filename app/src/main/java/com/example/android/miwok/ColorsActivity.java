package com.example.android.miwok;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, prepareFragment())
                .commit();
    }

    private Fragment prepareFragment() {
        Bundle bundle = new Bundle();

        // Generate the list of word to display
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        // Put the word list and the color Id to the bundle
        bundle.putParcelableArrayList("WORD_LIST", words);
        bundle.putInt("COLOR_ID", R.color.category_colors);

        //Create new CategoryFragment and set the arguments
        Fragment ret = new CategoryFragment();
        ret.setArguments(bundle);

        // Return the new fragment with the attached arguments
        return ret;
    }
}
