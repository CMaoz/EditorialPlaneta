package com.example.maoz1.editorialplaneta;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class Main2Activity extends MainActivity {

    EditText eID, eNombredl, eNombreda, eNombreqp, eNumtel;
    Button bIngresar, bLeer, bEditar, bEliminar;

    ContactosSqliteHelper contactosSqliteHelper;
    SQLiteDatabase dbContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main2);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.frame);
        getLayoutInflater().inflate(R.layout.activity_main2, contentFrameLayout);

        eNombredl = (EditText) findViewById(R.id.enombredl);
        eNombreda = (EditText) findViewById(R.id.enombreda);
        eNombreqp = (EditText) findViewById(R.id.enombredp);
        eNumtel = (EditText) findViewById(R.id.etel);
        bIngresar = (Button) findViewById(R.id.bIngresar);
        bEditar = (Button) findViewById(R.id.bEditar);
        bLeer = (Button) findViewById(R.id.bLeer);
        bEliminar = (Button) findViewById(R.id.bEliminar);

        contactosSqliteHelper = new ContactosSqliteHelper(this, "Prestamos", null, 1);
        dbContactos = contactosSqliteHelper.getWritableDatabase();
    }

    public void onClick(View view) {

        int id = view.getId();
        final String nombredl, nombreda, nombreqp, numtel, uuid;

        nombredl = eNombredl.getText().toString();
        nombreda = eNombreda.getText().toString();
        nombreqp = eNombreqp.getText().toString();
        numtel = eNumtel.getText().toString();

        ContentValues data = new ContentValues();

        switch (id) {
            case R.id.bIngresar:

                //ContentValues data = new ContentValues();
                data.put("name", nombredl);
                data.put("nombreda", nombreda);
                data.put("nombreqp", nombreqp);
                data.put("numtel", numtel);

                dbContactos.insert("contactos", null, data);
                clean();

                break;

            case R.id.bLeer:

                Cursor c = dbContactos.rawQuery("SELECT * FROM contactos WHERE name='" + nombredl + "'", null);
                if (c.moveToFirst()) {
                    eNombreda.setText(c.getString(2));
                    eNombreqp.setText(c.getString(3));
                    eNumtel.setText(c.getString(4));
                } else {
                    Toast.makeText(this, "No hay reservas", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.bEditar:


                data.put("nombreda", nombreda);
                data.put("nombreqp", nombreqp);
                data.put("numtel", numtel);


                dbContactos.update("contactos", data, "name = '" + nombredl + "'", null);
                clean();

                break;

            case R.id.bEliminar:

                dbContactos.delete("contactos", "name = '" + nombredl + "'", null);
                clean();

                break;
        }


    }

    private void clean() {

        eNombredl.setText("");
        eNombreda.setText("");
        eNombreqp.setText("");
        eNumtel.setText("");
    }
}
