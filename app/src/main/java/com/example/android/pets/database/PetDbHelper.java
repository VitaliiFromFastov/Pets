package com.example.android.pets.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;
import static com.example.android.pets.database.PetContract.PetEntry.COLUMN_PET_BREED;
import static com.example.android.pets.database.PetContract.PetEntry.COLUMN_PET_GENDER;
import static com.example.android.pets.database.PetContract.PetEntry.COLUMN_PET_NAME;
import static com.example.android.pets.database.PetContract.PetEntry.COLUMN_PET_WEIGHT;
import static com.example.android.pets.database.PetContract.PetEntry.GENDER_UNKNOWN;
import static com.example.android.pets.database.PetContract.PetEntry.TABLE_NAME;
import static com.example.android.pets.database.PetContract.PetEntry._ID;

/**
 * Created by Admin on 24.01.2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="shelter.db";
    public static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
            + TABLE_NAME+" ("+ _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PET_NAME +" TEXT NOT NULL, "
            + COLUMN_PET_BREED + " TEXT, "
            + COLUMN_PET_GENDER + " INTEGER DEFAULT "+ GENDER_UNKNOWN + ", "
            + COLUMN_PET_WEIGHT + " INTEGER DEFAULT 1)";
    private static final String DELETE_ENTRIES = "DROP TABLE " + TABLE_NAME;




    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL(DELETE_ENTRIES);
        onCreate(sqLiteDatabase);

    }
}
