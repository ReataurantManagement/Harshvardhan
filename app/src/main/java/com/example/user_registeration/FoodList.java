package com.example.user_registeration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FoodList extends AppCompatActivity {

    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference ref;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        imageView=findViewById(R.id.food_list);

        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        ref=database.getReference("Food");

        recyclerView=findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FoodList.this, FoodDetail.class));

            }
        });
    }
}
class CustomAdapter2 extends ArrayAdapter<String> {
    Context context;
    String[] mainMenu;
    int[] images;
    public CustomAdapter2( Context c, String[] menu, int[] imgs) {
        super(c, R.layout.food_item, R.id.Mmenu,menu);
        this.context=c;
        this.mainMenu=menu;
        this.images=imgs;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View row=inflater.inflate(R.layout.single_row,parent,false);
        ImageView myImage=row.findViewById(R.id.srimageView);
        TextView myText=row.findViewById(R.id.srtextView);

        myImage.setImageResource(images[position]);
        myText.setText(mainMenu[position]);
        return row;

    }
}


