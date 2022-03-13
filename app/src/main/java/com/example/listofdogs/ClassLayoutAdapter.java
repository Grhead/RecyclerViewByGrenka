package com.example.listofdogs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class ClassLayoutAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<URL> DataInCin = new ArrayList<>();

    public void setData(ArrayList<URL> DataInCin) {
        this.DataInCin = DataInCin;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        URL cat = DataInCin.get(position);
        MainThread MT = new MainThread();
        MT.newURL = cat;
        MT.start();
        MT.mainCallBack = new MainCallBack() {
            @Override
            public void BitLoader(Bitmap BT) {
                ((MainActivity)holder.getCatImage().getContext()).runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        holder.getCatImage().setImageBitmap(MT.BT);
                    }
            });
            };
        };
    }

    @Override
    public int getItemCount() {
        return DataInCin.size();
    }

}
