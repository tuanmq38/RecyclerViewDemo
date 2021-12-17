package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] titles = {"Chapter One", "Chapter Two", "Chapter Three", "Chapter Four",
    "Chapter Five", "Chapter Six", "Chapter Seven", "Chapter Eight"};

    private String[] details = {"Item one details", "Item two details", "Item three details",
            "Item four details", "Item five details", "Item six details",
            "Item seven details", "Item eight details"};

    private int[] images = {R.drawable.android_image_1, R.drawable.android_image_2,
    R.drawable.android_image_3, R.drawable.android_image_4, R.drawable.android_image_5,
    R.drawable.android_image_6, R.drawable.android_image_7, R.drawable.android_image_8};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textViewTitle.setText(titles[i]);
        viewHolder.textViewDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView textViewTitle;
        TextView textViewDetail;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDetail = itemView.findViewById(R.id.textViewDetail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition() + 1;
                    Snackbar.make(v, "Click detected on the item " + position, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }
}
