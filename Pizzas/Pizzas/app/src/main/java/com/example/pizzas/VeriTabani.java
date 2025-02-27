package com.example.pizzas;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class VeriTabani extends SQLiteOpenHelper {


    public VeriTabani( Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("create table kullanicitablosu(isim text,soyisim text,adres text,telefon text)");

    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists kullanicitablosu");
        onCreate(db);
    }

    public long saveNewUserData(String isim,String soyisim, String adres,String telefon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("isim", isim);
        cv.put("soyisim", soyisim);
        cv.put("adres", adres);
        cv.put("telefon", telefon);
        long recordid = db.insert("kullanicitablosu", null, cv);
        return recordid;
    }
    public int updateUserData(String eskiIsim, String yeniIsim, String soyisim, String adres, String telefon) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("isim", yeniIsim);
        cv.put("soyisim", soyisim);
        cv.put("adres", adres);
        cv.put("telefon", telefon);

        return db.update("kullanicitablosu", cv, "isim=?", new String[]{eskiIsim});
    }



}