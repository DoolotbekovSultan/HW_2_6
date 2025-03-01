package com.sultan.hw_2_6;

public class Food {
    private int image;
    private String name;
    private float rating;
    private int price;

    public Food(int image, String name, float rating, int price) {
        this.image = image;
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public float getRating() {
        return rating;
    }

    public int getPrice() {
        return price;
    }
}
