package com.example.user_registeration;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.user_registeration.Interface.ItemClickListener;
import com.example.user_registeration.Model.Category;
import com.example.user_registeration.ViewHolder.MenuViewHolder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static android.view.View.*;
import static com.example.user_registeration.R.*;

public class MainMenu extends AppCompatActivity {

    FirebaseDatabase fireData;
    DatabaseReference ref;
    ImageAdapter mAdapter;

    RecyclerView recycler_menu;
    RecyclerView.LayoutManager layoutManager;
    private List<Category> cat;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main_menu);

        fireData=FirebaseDatabase.getInstance();
        ref=fireData.getReference("Menu");

        toolbar=findViewById(R.id.toolbarMain);
        toolbar.setTitle("MENU");

        recycler_menu=findViewById(R.id.recycler_menu);
        recycler_menu.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycler_menu.setLayoutManager(layoutManager);

        cat= new ArrayList<>();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Category cate = postSnapshot.getValue(Category.class);
                    cat.add(cate);
                }

                mAdapter= new ImageAdapter(MainMenu.this, cat);

                recycler_menu.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainMenu.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Going to cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



    }



}








