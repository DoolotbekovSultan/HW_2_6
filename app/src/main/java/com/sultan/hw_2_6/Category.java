package com.sultan.hw_2_6;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Category {
    int image;
    String text;

    public Category(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int  getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
