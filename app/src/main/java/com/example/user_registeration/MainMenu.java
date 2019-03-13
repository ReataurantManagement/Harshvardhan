package com.example.user_registeration;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.zip.Inflater;

import static android.view.View.*;

public class MainMenu extends AppCompatActivity {

    ListView listView;
    String[] mainmenu;
    int[] images={R.drawable.entree,R.drawable.maincourse,R.drawable.dessert};
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Resources res=getResources();
        mainmenu=res.getStringArray(R.array.MainMenu);
        toolbar=findViewById(R.id.toolbarMain);
        toolbar.setTitle("MENU");


        listView=findViewById(R.id.Mmenu);

        CustomAdapter adapter = new CustomAdapter(this, mainmenu, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                Toast.makeText(MainMenu.this, "Selected course", Toast.LENGTH_SHORT).show();
                switch(position) {
                    case 0:
                        intent = new Intent(MainMenu.this, FoodList.class);
                        intent.putExtra("Course", listView.getItemAtPosition(position).toString());
                        startActivity(intent);

                        break;
                    case 1:
                        intent = new Intent(MainMenu.this, FoodList.class);
                        intent.putExtra("Course", listView.getItemAtPosition(position).toString());
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainMenu.this, FoodList.class);
                        intent.putExtra("Course", listView.getItemAtPosition(position).toString());
                        startActivity(intent);
                        break;
                }
            }
        });


    }
}

class CustomAdapter extends ArrayAdapter<String>{
    Context context;
    String[] mainMenu;
    int[] images;
    public CustomAdapter( Context c, String[] menu, int[] imgs) {
        super(c, R.layout.single_row, R.id.Mmenu,menu);
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


