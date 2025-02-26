package com.sultan.hw_2_6;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class Category {
    Drawable image;
    String text;

    public Category(Drawable image, String text) {
        this.image = image;
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
