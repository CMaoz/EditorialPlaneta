package com.example.maoz1.editorialplaneta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maoz1 on 1/11/2017.
 */

public class ContactosSqliteHelper extends SQLiteOpenHelper {

    String DATA_BASE_NAME = "Prestamos";
    int DATA_VERSION = 1;

    String sqlCreate = "CREATE TABLE contactos(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," + //0
            "name TEXT," +      //1
            "nombreda TEXT," +     //2
            "nombreqp TEXT," +    //3
            "numtel TEXT)";      //4

    public ContactosSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contactos");
        sqLiteDatabase.execSQL(sqlCreate);

    }
}
