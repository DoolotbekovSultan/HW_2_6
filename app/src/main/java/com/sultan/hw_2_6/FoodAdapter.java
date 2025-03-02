package com.sultan.hw_2_6;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sultan.hw_2_6.databinding.FoodCardBinding;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<Food> foods;

    public FoodAdapter(ArrayList<Food> foods) {
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodCardBinding binding = FoodCardBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FoodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(foods.get(position));
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public void search(String string) {
        string = string.toLowerCase();
        for (int i = 0; i < getItemCount(); i ++) {
            if (foods.get(i).getName().toLowerCase().equals(string)) {
                moveToFirst(i);
                return;
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public void moveToFirst(int currentPosition) {
        Food currentFood = foods.remove(currentPosition);
        foods.add(0, currentFood);
        notifyDataSetChanged();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        FoodCardBinding binding;

        public FoodViewHolder(FoodCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }



        @SuppressLint("SetTextI18n")
        public void bind(Food food) {

            binding.foodImage.setImageResource(food.getImage());
            binding.foodPrice.setText("$" + food.getPrice());
            binding.foodName.setText(food.getName());
            binding.foodRating.setRating(food.getRating());

            if(getAdapterPosition() == 0) {
                    binding.foodCard.setBackgroundResource(R.drawable.ic_active_food_background);
                    Resources res = itemView.getContext().getResources();
                    float density = res.getDisplayMetrics().density;
                    ViewGroup.LayoutParams imageParams = binding.foodImage.getLayoutParams();
                    ViewGroup.LayoutParams cardParams = binding.foodCard.getLayoutParams();
                    ViewGroup.MarginLayoutParams nameParams = (ViewGroup.MarginLayoutParams) binding.foodName.getLayoutParams();
                    nameParams.topMargin = (int) (3 * density);
                    binding.foodName.setLayoutParams(nameParams);
                    imageParams.width = (int) (157 * density);
                    imageParams.height = (int) (147 * density);
                    cardParams.width = (int) (204 * density);
                    cardParams.height = (int) (252 * density);
                    binding.foodImage.setLayoutParams(imageParams);
                    binding.foodCard.setLayoutParams(cardParams);
                    binding.foodPrice.setTextColor(Color.WHITE);
                    binding.foodName.setTextColor(Color.WHITE);
                    binding.foodPrice.setTextSize(30);
            } else {
                binding.foodCard.setBackgroundResource(R.drawable.ic_food_background);
                Resources res = itemView.getContext().getResources();
                float density = res.getDisplayMetrics().density;
                ViewGroup.LayoutParams imageParams = binding.foodImage.getLayoutParams();
                ViewGroup.LayoutParams cardParams = binding.foodCard.getLayoutParams();
                ViewGroup.MarginLayoutParams nameParams = (ViewGroup.MarginLayoutParams) binding.foodName.getLayoutParams();
                nameParams.topMargin = (int) (26 * density);
                binding.foodName.setLayoutParams(nameParams);
                imageParams.width = (int) (117 * density);
                imageParams.height = (int) (110 * density);
                cardParams.width = (int) (185.38 * density);
                cardParams.height = (int) (229 * density);
                binding.foodImage.setLayoutParams(imageParams);
                binding.foodCard.setLayoutParams(cardParams);
                int color = ContextCompat.getColor(itemView.getContext(), R.color.gray2);
                binding.foodPrice.setTextColor(color);
                binding.foodName.setTextColor(color);
                binding.foodPrice.setTextSize(15);
            }

            binding.getRoot().setOnClickListener(view -> {
                int currentPosition = getAdapterPosition();
                moveToFirst(currentPosition);
            });
        }

    }
}
