package com.example.restaurant.ContentProvider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restaurant.R;

public class EmployeesRecords extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_records);
    }
    public void onClickAddName(View view) {
        // Add a new employee record
        ContentValues values = new ContentValues();
        values.put(EmployeesProvider.NAME,
                ((EditText)findViewById(R.id.editText2)).getText().toString());

        values.put(EmployeesProvider.NUMBER,
                ((EditText)findViewById(R.id.editText3)).getText().toString());

        Uri uri = getContentResolver().insert(
                EmployeesProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }
    public void onClickRetrieveEmployees(View view) {
        // Retrieve Employees records
        String URL = "content://com.android.prov.EmployeesProvider";

        Uri employees = Uri.parse(URL);
        Cursor c = managedQuery(employees, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(EmployeesProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( EmployeesProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( EmployeesProvider.NUMBER)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}
