package com.example.android.miwok;

import android.os.Parcel;
import android.os.Parcelable;

public class Word implements Parcelable{
    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = -1;
    private int mSoundResourceId = -1;

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int soundResourceId) {
        this(defaultTranslation, miwokTranslation);
        mSoundResourceId = soundResourceId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int soundResourceId) {
        this(defaultTranslation, miwokTranslation, soundResourceId);
        mImageResourceId = imageResourceId;
    }

    protected Word(Parcel in) {
        mDefaultTranslation = in.readString();
        mMiwokTranslation = in.readString();
        mImageResourceId = in.readInt();
        mSoundResourceId = in.readInt();
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

    /**
     * Returns the string representation of the {@link Word} object.
     */
    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mAudioResourceId=" + mSoundResourceId +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mDefaultTranslation);
        dest.writeString(mMiwokTranslation);
        dest.writeInt(mImageResourceId);
        dest.writeInt(mSoundResourceId);
    }

    @Override
    public int describeContents() {
        return hashCode();
    }
}
