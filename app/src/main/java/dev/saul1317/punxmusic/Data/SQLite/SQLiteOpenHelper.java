package dev.saul1317.punxmusic.Data.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    private static final String DATABASE_NAME = "punxmusic_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = SQLiteOpenHelper.class.getSimpleName();

    public SQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLiteTables.CREAR_TABLA_INSTRUMENTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SQLiteTables.TABLA_INSTRUMENTO);
        onCreate(sqLiteDatabase);
    }
}
