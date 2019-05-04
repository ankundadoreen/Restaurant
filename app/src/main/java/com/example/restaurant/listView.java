package com.example.restaurant;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class listView extends Menu  {

    ListView listview;
    ArrayList array;
    ArrayAdapter adapter;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listview = (ListView) findViewById(R.id.listView);
        array = new ArrayList<>();
        array.add("Rice");
        array.add("Matooke");
        array.add("Posho");
        array.add("Meat");
        array.add("Peas");
        array.add("Rolex");
        array.add("Chips");
        array.add("Beef stew");
        array.add("Gnuts");
        array.add("Salad");
        array.add("Ice cream");
        array.add("Greens");
        array.add("Omelette");
        array.add("Pizza");
        array.add("Gnuts");
        array.add("Gnuts");
        array.add("Gnuts");
        array.add("Gnuts");
        array.add("Gnuts");
        array.add("Gnuts");


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        listview.setAdapter(adapter);

    }
    }