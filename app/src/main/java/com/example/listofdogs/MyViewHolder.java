package com.example.listofdogs;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{

        public void setCatImage(ImageView CatImage) {
            this.CatImage = CatImage;
        }

        public ImageView getCatImage() {
            return CatImage;
        }

        private ImageView CatImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            CatImage = itemView.findViewById(R.id.CatImage);

        }
    }

