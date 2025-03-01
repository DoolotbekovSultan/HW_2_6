package com.sultan.hw_2_6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sultan.hw_2_6.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Category> categories = new ArrayList<>();
        ArrayList<Food> foods = new ArrayList<>();

        categories.add(new Category(R.drawable.ic_active_burger, getString(R.string.category_burgers)));
        categories.add(new Category(R.drawable.ic_pizza, getString(R.string.category_pizza)));
        categories.add(new Category(R.drawable.ic_chicken, getString(R.string.category_chicken)));

        foods.add(new Food(R.drawable.ic_burger, "Salad Burger", 4.5f, 12));
        foods.add(new Food(R.drawable.ic_burger, "Chicken Burger", 3.5f, 15));
        foods.add(new Food(R.drawable.ic_burger, "Mac Burger", 2f, 10));
        foods.add(new Food(R.drawable.ic_burger, "Mini Burger", 5f, 6));

        CategoryAdapter categoryAdapter = new CategoryAdapter(categories, category -> {
            // listener
        });

        FoodAdapter foodAdapter = new FoodAdapter(foods, food -> {
            // listener
        });

        binding.categories.setAdapter(categoryAdapter);
        LinearLayoutManager categoryLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.categories.setLayoutManager(categoryLinearLayoutManager);

        binding.foods.setAdapter(foodAdapter);
        LinearLayoutManager foodsLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.foods.setLayoutManager(foodsLinearLayoutManager);
    }
}