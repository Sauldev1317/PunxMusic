package dev.saul1317.punxmusic.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dev.saul1317.punxmusic.Data.SQLite.SQLiteTables;
import dev.saul1317.punxmusic.Data.SQLite.SQLiteOpenHelper;
import dev.saul1317.punxmusic.Model.Instrumento;

public class Data {

    private SQLiteOpenHelper sqLiteOpenHelper;
    private Context context;

    public Data(Context context) {
        this.context = context;
        sqLiteOpenHelper = new SQLiteOpenHelper(context);
    }

    public long saveInstrument(Instrumento instrumento){
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SQLiteTables.CAMPO_ID_INSTRUMENTO, instrumento.getId());
        contentValues.put(SQLiteTables.CAMPO_NUMERO_MODELO, instrumento.getNumero_modelo());
        contentValues.put(SQLiteTables.CAMPO_NOMBRE, instrumento.getNombre());
        contentValues.put(SQLiteTables.CAMPO_DESCRIPCION, instrumento.getDescripcion());
        contentValues.put(SQLiteTables.CAMPO_PRECIO, instrumento.getPrecio());
        contentValues.put(SQLiteTables.CAMPO_INVENTARIO, instrumento.getInventario());
        contentValues.put(SQLiteTables.CAMPO_NUMERO_VENTA, instrumento.getNumero_ventas());
        contentValues.put(SQLiteTables.CAMPO_NUMERO_VISITAS, instrumento.getNumero_vistas());
        contentValues.put(SQLiteTables.CAMPO_URL_IMAGEN, instrumento.getUrl_imagen());
        contentValues.put(SQLiteTables.CAMPO_URL_VIDEO, instrumento.getUrl_video());
        long rowData = db.insert(SQLiteTables.TABLA_INSTRUMENTO, null, contentValues);
        db.close();
        return rowData;
    }

    public boolean checkedInstrument(String id_instrumento){
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
        //columns to fetch
        String[] columns = {
               SQLiteTables.CAMPO_ID_INSTRUMENTO
        };
        String selection = SQLiteTables.CAMPO_ID_INSTRUMENTO + " =? ";
        String[] arg = {id_instrumento};
        Cursor cursor = db.query(
                SQLiteTables.TABLA_INSTRUMENTO,
                columns,
                selection,
                arg,
                null,
                null,
                null,
                null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        if (count > 0){
            return true;
        }else {
            return false;
        }
    }

    public List<Instrumento> getAllShoppingCart(){
        List<Instrumento> instrumentoList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(
                SQLiteTables.TABLA_INSTRUMENTO,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        while(cursor.moveToNext()){
            Instrumento instrumento = new Instrumento();
            instrumento.setId(cursor.getString(0));
            instrumento.setNumero_modelo(cursor.getLong(1));
            instrumento.setNombre(cursor.getString(2));
            instrumento.setDescripcion(cursor.getString(3));
            instrumento.setPrecio(cursor.getLong(4));
            instrumento.setDescuento(cursor.getLong(5));
            instrumento.setInventario(cursor.getLong(6));
            instrumento.setNumero_ventas(cursor.getLong(7));
            instrumento.setNumero_vistas(cursor.getLong(8));
            instrumento.setUrl_imagen(cursor.getString(9));
            instrumento.setUrl_video(cursor.getString(10));
            instrumentoList.add(instrumento);
        }
        cursor.close();
        sqLiteDatabase.close();
        return instrumentoList;
    }

    public void updateInstrument(){

    }

    public void deleteInstrument(String id_instrumento){

    }

    public void deleteAllShoppingCart(){

    }
}
