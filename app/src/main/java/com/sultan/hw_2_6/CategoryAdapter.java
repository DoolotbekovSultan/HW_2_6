package com.sultan.hw_2_6;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sultan.hw_2_6.databinding.ItemCategoryHolderBinding;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private ArrayList<Category> categories;
    private CategoryAdapter.OnCategoryClickListener onCategoryClickListener;

    public CategoryAdapter(ArrayList<Category> categories, OnCategoryClickListener onCategoryClickListener) {
        this.categories = categories;
        this.onCategoryClickListener = onCategoryClickListener;
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

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private ItemCategoryHolderBinding binding;

        public CategoryViewHolder(ItemCategoryHolderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Category category, int position){
            binding.categoryImage.setImageResource(category.getImage());
            binding.categoryText.setText(category.getText());
            if (position == 0) {
                binding.cardView.setBackgroundResource(R.drawable.ic_active_category_background);
            } else {
                binding.cardView.setBackgroundResource(R.drawable.ic_category_background);
            }
            binding.getRoot().setOnClickListener(view -> {
                onCategoryClickListener.onCategoryClick(category);
            });
        }
    }

    public interface OnCategoryClickListener {
        void onCategoryClick(Category category);
    }
}
