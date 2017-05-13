package com.example.android.miwok;

/**
 * Created by orzeab on 5/12/2017.
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = -1;
    private int mSoundResourceId = -1;

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId) {
        this(defaultTranslation, miwokTranslation);
        mImageResourceId = imageResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int soundResourceId) {
        this(defaultTranslation, miwokTranslation, imageResourceId);
        mSoundResourceId = soundResourceId;
    }

    /**
     * Get the default translation of the word
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the image resource ID of the word
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Checks if the Word has an corresponding image
     */
    public boolean hasImage() {
        return mImageResourceId != -1;
    }

    /**
     * Returns the associated sound resource id
     */
    public int getSoundResourceId() {
        return mSoundResourceId;
    }
}
