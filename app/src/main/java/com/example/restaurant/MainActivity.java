package com.example.restaurant;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.security.Permission;
import java.security.PermissionCollection;


public class MainActivity extends AppCompatActivity {

    //Done by ANKUNDA DOREEN    2017/BIT/149
    //2019 Doreen Copyright

    private static  String BC_PERMISSION = "com.example.restaurant";


private static  String TAG = "BReceiver";

private BroadcastReceiver bReceiver = null;








    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver();
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




            case R.id.settings:


            case R.id.faqs:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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

    public void onDestroy(){
        super.onDestroy();

    }

    private void registerReceiver() {
        android.util.Log.d(TAG, "Receiver registered");
        Toast.makeText(this, "Receiver registered", Toast.LENGTH_SHORT).show();

        bReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String msg = intent.getStringExtra("msg");
                android.util.Log.d(TAG, "Receive broadcast" + msg);
                Toast.makeText(context, "Receive broadcast" + msg, Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("msg", msg + "Go through Receiver A");
                setResultExtras(bundle);
                abortBroadcast();

            }

        };

        IntentFilter intentFilter = new IntentFilter(("android.intent.action.main"));
        intentFilter.setPriority(1000);
        this.registerReceiver(bReceiver, intentFilter);
    }
    private void unregisterReceiver(){
      android.util.Log.d(TAG, "Receiver Unregistered ");
      Toast.makeText(this, "Receiver Unregistered", Toast.LENGTH_SHORT).show();
      this.unregisterReceiver(bReceiver);
    }

    private void sendBroadcast(){
        Intent intent = new Intent ("android.intent.action.example_broadcast");
        intent.putExtra("msg","Broadcast sent");
        sendBroadcast(intent, BC_PERMISSION);
    }

    void setfragment (Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
    }











    public void button4(View view) {
        Intent mintent = new Intent(MainActivity.this, listView.class);
        startActivity(mintent);
    }

    public void button5(View view) {
        String url="https://www.google.com/maps/@-0.6174896,30.656686,20z?fbclid=IwAR1VjQlb4ONydeje7J12NFiCy-OkQqnnwispG7GO4KWPXZQT7K2jCRY2MbQ";
        Intent mintent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.startActivity(mintent);

    }

    public void button6(View view) {
        Intent mintent = new Intent(MainActivity.this, ActivityTwo.class);
        startActivity(mintent);
    }

    public void createNotification(View view){

        Intent intent = new Intent(this, NotificationReceiver.class);
        PendingIntent mIntent = PendingIntent.getActivity(this,(int) System.currentTimeMillis(), intent, 0);

        Notification noti = new Notification.Builder(this)
                .setContentTitle("New Update from"+"Application")
                .setContentText("Update").setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(mIntent)
                .addAction(R.drawable.ic_launcher_background, "add",mIntent)
                .addAction(R.drawable.ic_launcher_background, "More",mIntent)
                .addAction(R.drawable.ic_launcher_background,"And more",mIntent).build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        noti.flags = Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, noti);


    }

}












