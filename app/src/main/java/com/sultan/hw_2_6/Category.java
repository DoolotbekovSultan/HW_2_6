package com.sultan.hw_2_6;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Category {
    int[] images;
    String text;

    public Category(int[] images, String text) {
        this.images = images;
        this.text = text;
    }

    public int[] getImages() {
        return images;
    }

    public String getText() {
        return text;
    }
}
