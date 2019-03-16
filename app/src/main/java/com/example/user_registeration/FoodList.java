package com.example.user_registeration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FoodList extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference ref;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Food");
        ref.child("Dessert").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             for(int i=1;i<=6;i++)
             {

             }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        imageView=findViewById(R.id.food_list);

        recyclerView=findViewById(R.id.recycler_food);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        startActivity(new Intent(FoodList.this, FoodDetail.class));



    }
}
/*class CustomAdapter2 extends ArrayAdapter<String> {
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
*/
