package com.example.hero;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private ArrayList<Data> recyclerDataArrayList= new ArrayList<>();
    private ListView listView ;
    private listAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        ImageView imageView = findViewById(R.id.image_view);

        Intent intent=getIntent();
        basic mbasic = intent.getParcelableExtra("selected_note");



        Picasso.with(this)
                .load(mbasic.getImages().getMd())
                .into(imageView);
        recyclerDataArrayList.add(new Data("Name", mbasic.getName()));
        recyclerDataArrayList.add(new Data("id", mbasic.getId()));
        recyclerDataArrayList.add(new Data("Slug", mbasic.getSlug()));
        recyclerDataArrayList.add(new Data("", ""));
        recyclerDataArrayList.add(new Data("Intelligence", mbasic.getPowerstats().getIntelligence()));
        recyclerDataArrayList.add(new Data("Strength", mbasic.getPowerstats().getStrength()));
        recyclerDataArrayList.add(new Data("Speed", mbasic.getPowerstats().getSpeed()));
        recyclerDataArrayList.add(new Data("Durability", mbasic.getPowerstats().getDurability()));
        recyclerDataArrayList.add(new Data("Power", mbasic.getPowerstats().getPower()));
        recyclerDataArrayList.add(new Data("Combat", mbasic.getPowerstats().getCombat()));
        recyclerDataArrayList.add(new Data("", ""));
        recyclerDataArrayList.add(new Data("Gender", mbasic.getAppearance().getGender()));
        recyclerDataArrayList.add(new Data("Race", mbasic.getAppearance().getRace()));
        recyclerDataArrayList.add(new Data("Height", mbasic.getAppearance().getHeight().toString()));
        recyclerDataArrayList.add(new Data("Weight", mbasic.getAppearance().getWeight().toString()));
        recyclerDataArrayList.add(new Data("EyeColor", mbasic.getAppearance().getEyeColor()));
        recyclerDataArrayList.add(new Data("HairColor", mbasic.getAppearance().getHairColor()));
        recyclerDataArrayList.add(new Data("", ""));
        recyclerDataArrayList.add(new Data("Full Name", mbasic.getBiography().getFullName()));
        recyclerDataArrayList.add(new Data("Alter Egos", mbasic.getBiography().getAlterEgos()));
        recyclerDataArrayList.add(new Data("Aliases", mbasic.getBiography().getAliases().toString()));
        recyclerDataArrayList.add(new Data("Place of Birth", mbasic.getBiography().getPlaceOfBirth()));
        recyclerDataArrayList.add(new Data("First Appearance", mbasic.getBiography().getFirstAppearance()));
        recyclerDataArrayList.add(new Data("Publisher", mbasic.getBiography().getPublisher()));
        recyclerDataArrayList.add(new Data("Alignment", mbasic.getBiography().getAlignment()));
        recyclerDataArrayList.add(new Data("", ""));
        recyclerDataArrayList.add(new Data("Occupation", mbasic.getWork().getOccupation()));
        recyclerDataArrayList.add(new Data("Base", mbasic.getWork().getBase()));
        recyclerDataArrayList.add(new Data("", ""));
        recyclerDataArrayList.add(new Data("Group Affiliation", mbasic.getConnections().getGroupAffiliation()));
        recyclerDataArrayList.add(new Data("Relatives", mbasic.getConnections().getRelatives()));



        listView = findViewById(R.id.list_view);
        listAdapter = new listAdapter(getApplicationContext(), recyclerDataArrayList);
        listView.setAdapter(listAdapter);


    }


}
