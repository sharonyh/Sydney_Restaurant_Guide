package com.example.sydneyrestaurantguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<Restaurant> restaurantList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurantList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);
        recyclerAdapter = new RecyclerAdapter(restaurantList);

        initData();
        initRecyclerView();


    }

    private void initRecyclerView(){
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(restaurantList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void initData() {

        //add dividers between each item in list

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);


        //add items to recyclerList
        restaurantList = new ArrayList<>();
        restaurantList.add(new Restaurant("Memory Tongue Hotpot", "4.0", "Chinese", "436 Victoria Ave., Chatswood"));
        restaurantList.add(new Restaurant("Dead Ringer", "4.5", "Australian", "413 Bourke St., Surry Hills"));
        restaurantList.add(new Restaurant("Mr Wong", "4.2", "Cantonese", "3 Bridge Ln., Sydney"));
        restaurantList.add(new Restaurant("Cafe Amici", "4.9", "Italian", "1/355 Kent St., Sydney"));
        restaurantList.add(new Restaurant("Gazzi", "4.8", "Mediterranean", "World Square Shopping Center, Sydney"));
        restaurantList.add(new Restaurant("Oiden", "4.6", "Japanese", "537-551 George St., Sydney"));
        restaurantList.add(new Restaurant("The Naked Duck", "4.4", "Australian", "14/1-25 Harbour St., Sydney"));
        restaurantList.add(new Restaurant("Din Tai Fung", "4.1", "Taiwanese", "World Square Shopping Center, Sydney"));
        restaurantList.add(new Restaurant("Pendolino", "4.5", "Italian", "412-414 George St., Sydney"));
        restaurantList.add(new Restaurant("Home Thai Restaurant", "4.2", "Thai", "299 Sussex St., Sydney"));
    }


}
