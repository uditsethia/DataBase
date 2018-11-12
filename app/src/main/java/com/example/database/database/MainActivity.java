package com.example.database.database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);
        Log.d("Insert","In");
        db.addContact(new Contact("Udit","9874850583"));
        db.addContact(new Contact("UditA","9874850582"));
        db.addContact(new Contact("UditB","9874850581"));
        db.addContact(new Contact("UditC","9874850580"));
        // update contact
        Contact contactUp = db.readContact(1);
        int num = db.upDate(contactUp);
        Log.d("Update",contactUp.getName()+" "+contactUp.getPhoneNumber());
        Log.d("Reading","Reading all");

        List<Contact> contactList = db.getAllContacts();
        for(Contact c : contactList){
            String log = c.getId()+" "+c.getName()+" "+c.getPhoneNumber()+" .";
            Log.d("Contact",log);
        }
    }
}
