package com.example.user_registeration;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user_registeration.Model.Category;
import com.example.user_registeration.ViewHolder.MenuViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private Context mContext;
    private List<Category> menu;
    private MenuViewHolder mvh;


    public ImageAdapter(Context context, List<Category> menus){
        mContext=context;
        menu=menus;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.menu_item, viewGroup, false);
        return new MenuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder menuViewHolder, int i) {
        Category mmenu=menu.get(i);
        menuViewHolder.txtMenu.setText(mmenu.getName());
        Picasso.with(mContext).load(mmenu.getImage())
                .fit()
                .centerCrop()
                .into(menuViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
