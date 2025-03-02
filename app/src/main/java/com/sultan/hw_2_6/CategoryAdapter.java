package com.sultan.hw_2_6;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sultan.hw_2_6.databinding.ItemCategoryHolderBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<Category> categories;

    public CategoryAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryHolderBinding binding = ItemCategoryHolderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bind(categories.get(position), position);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public void search(String string) {
        string = string.toLowerCase();
        for (int i = 0; i < getItemCount(); i ++) {
            if (categories.get(i).getText().toLowerCase().equals(string)) {
                moveToFirst(i);
                return;
            }
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    public void moveToFirst(int currentPosition) {
        Category currentCategory = categories.remove(currentPosition);
        categories.add(0, currentCategory);
        notifyDataSetChanged();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private ItemCategoryHolderBinding binding;

        public CategoryViewHolder(ItemCategoryHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


        public void bind(Category category, int position){
            binding.categoryText.setText(category.getText());
            if (position == 0) {
                binding.cardView.setBackgroundResource(R.drawable.ic_active_category_background);
                binding.categoryImage.setImageResource(category.getImages()[1]);
            } else {
                binding.cardView.setBackgroundResource(R.drawable.ic_category_background);
                binding.categoryImage.setImageResource(category.getImages()[0]);
            }
            binding.getRoot().setOnClickListener(view -> {
                int currentPosition = getAdapterPosition();
                moveToFirst(currentPosition);
            });
        }
    }
}
