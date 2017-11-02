package com.example.maoz1.editorialplaneta;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaActivity extends MainActivity {

    ContactosSqliteHelper contactosSqliteHelper;
    SQLiteDatabase dbContactos;
    RecyclerView recyclerView;
    ArrayList<User> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_lista, contentFrameLayout);

        contactosSqliteHelper = new ContactosSqliteHelper(this, "Prestamos", null, 1);
        dbContactos = contactosSqliteHelper.getWritableDatabase();

        usersList = new ArrayList<User>();

        Cursor cursor = dbContactos.rawQuery("SELECT * FROM contactos",null);
        if (cursor.moveToFirst()){
            do {
                User user = new User( String.valueOf(cursor.getInt(0)), cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),
                        cursor.getString(4));
                usersList.add(user);
            } while(cursor.moveToNext());
        } else {
            Toast.makeText(this, "No hay contactos", Toast.LENGTH_SHORT).show();
        }

        ContactosAdapter contactosAdapter = new ContactosAdapter(this, usersList);
        recyclerView = (RecyclerView) findViewById(R.id.recicler);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(contactosAdapter);
    }
}
