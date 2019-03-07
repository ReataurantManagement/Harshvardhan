package com.example.user_registeration;

public class Data_To_Database
{
    float parking,cordialty,quality,appeal,taste,ambience,comfort,hygiene;
    String extraFeedback;



        Data_To_Database(float parking,float cordialty, float quality, float appeal, float taste, float ambience, float comfort, float hygiene,String extraFeedback
        ) {
            this.parking = parking;
            this.cordialty = cordialty;
            this.quality = quality;
            this.appeal = appeal;
            this.taste = taste;
            this.ambience = ambience;
            this.comfort = comfort;
            this.hygiene = hygiene;
            this.extraFeedback=extraFeedback;
        }
    }
