package com.example.restaurant;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    //Done by ANKUNDA DOREEN    2017/BIT/149
    //2019 Doreen Copyright


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
         getMenuInflater().inflate(R.menu.item,menu);
        return super.onCreateOptionsMenu(menu);

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                return true;


            case R.id.help:
                setfragment(new Help());

            case R.id.settings:


            case R.id.faqs:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    void setfragment (Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
    }

    @Override
    public void onStart(){
        super.onStart();
    }


    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onResume(){
        super.onResume();
    }



    public void button4(View view) {
        Intent mintent = new Intent(MainActivity.this, listView.class);
        startActivity(mintent);
    }

    public void button5(View view) {
        Intent mintent = new Intent(MainActivity.this, ActivityOne.class);
        startActivity(mintent);

    }

    public void button6(View view) {
        Intent mintent = new Intent(MainActivity.this, ActivityTwo.class);
        startActivity(mintent);
    }

}












