package com.example.admin.newkommunalka02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Admin on 25.02.2016.
 */
public class DatabaseHelperTarif extends SQLiteOpenHelper implements BaseColumns {

    public static final String DATABASE_NAME = "tarif.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_TABLE = "c_water";

    public static final String TABLE_CRIMEA = "crimea";
    public static final String TABLE_VOLIN = "volin";
    public static final String TABLE_VINICA = "vinica";
    public static final String TABLE_DONETSK = "donetsk";
    public static final String TABLE_DNEPR = "dnepr";
    public static final String TABLE_JITOMIR = "jitomir";
    public static final String TABLE_ZAKARPATIA = "zakarpatia";
    public static final String TABLE_ZAPOR = "zapor";
    public static final String TABLE_IVANOFR = "ivanofr";
    public static final String TABLE_KIEVSKI = "kievski";
    public static final String TABLE_KIROVOGRAD = "kirovograd";
    public static final String TABLE_LUGANSK = "lugansk";
    public static final String TABLE_LVOV = "lvov";
    public static final String TABLE_NIKOLAEV = "nikolaev";
    public static final String TABLE_ODESSA = "odessa";
    public static final String TABLE_POLTAVA = "poltava";
    public static final String TABLE_ROVNO = "rovno";
    public static final String TABLE_SUMI = "sumi";
    public static final String TABLE_TERNOPOL = "ternopol";
    public static final String TABLE_HARKOV = "harkov";
    public static final String TABLE_HERSON = "herson";
    public static final String TABLE_HMELNITSK = "hmelnitsk";
    public static final String TABLE_CHERKASI = "cherkasi";
    public static final String TABLE_CHERNOVCI = "chernovci";
    public static final String TABLE_CHERNIGOV = "chernigov";
    public static final String TABLE_KIEV = "kiev";


    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_WATER = "region_cwater";
    public static final String COLUMN_INWATER = "in_cwater";
    public static final String COLUMN_OUTWATER = "out_cwater";



    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_CRIMEA = "create table "
            + TABLE_CRIMEA + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_VOLIN = "create table "
            + TABLE_VOLIN + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_VINICA = "create table "
            + TABLE_VINICA + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_DONETSKT = "create table "
            + TABLE_DONETSK + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_DNEPR = "create table "
            + TABLE_DNEPR + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_JITOMIR = "create table "
            + TABLE_JITOMIR + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_ZAKARPATIA = "create table "
            + TABLE_ZAKARPATIA + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_ZAPOR = "create table "
            + TABLE_ZAPOR + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_IVANOFR = "create table "
            + TABLE_IVANOFR + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_KIEVSKI = "create table "
            + TABLE_KIEVSKI + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_KIROVOGRAD = "create table "
            + TABLE_KIROVOGRAD + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_LUGANSK = "create table "
            + TABLE_LUGANSK + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_LVOV = "create table "
            + TABLE_LVOV + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";


    private static final String DATABASE_CREATE_NIKOLAEV = "create table "
            + TABLE_NIKOLAEV + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_ODESSA = "create table "
            + TABLE_ODESSA + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_POLTAVA = "create table "
            + TABLE_POLTAVA + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_ROVNO = "create table "
            + TABLE_ROVNO + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_SUMI = "create table "
            + TABLE_SUMI + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_TERNOPOL = "create table "
            + TABLE_TERNOPOL + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_HARKOV = "create table "
            + TABLE_HARKOV + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_HERSON = "create table "
            + TABLE_HERSON + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_HMELNITSK = "create table "
            + TABLE_HMELNITSK + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_CHERKASI = "create table "
            + TABLE_CHERKASI + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_CHERNOVCI = "create table "
            + TABLE_CHERNOVCI + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_CHERNIGOV = "create table "
            + TABLE_CHERNIGOV + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";

    private static final String DATABASE_CREATE_KIEV = "create table "
            + TABLE_KIEV + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_WATER
            + " text not null, " + COLUMN_INWATER + " integer, " + COLUMN_OUTWATER
            + " integer);";


    public DatabaseHelperTarif(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelperTarif(Context context, String name, SQLiteDatabase.CursorFactory factory,
                               int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelperTarif(Context context, String name, SQLiteDatabase.CursorFactory factory,
                               int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        db.execSQL(DATABASE_CREATE_CRIMEA);
        db.execSQL(DATABASE_CREATE_DNEPR);
        db.execSQL(DATABASE_CREATE_DONETSKT);
        db.execSQL(DATABASE_CREATE_CHERKASI);
        db.execSQL(DATABASE_CREATE_CHERNIGOV);
        db.execSQL(DATABASE_CREATE_CHERNOVCI);
        db.execSQL(DATABASE_CREATE_HARKOV);
        db.execSQL(DATABASE_CREATE_HERSON);
        db.execSQL(DATABASE_CREATE_HMELNITSK);
        db.execSQL(DATABASE_CREATE_IVANOFR);
        db.execSQL(DATABASE_CREATE_JITOMIR);
        db.execSQL(DATABASE_CREATE_KIEV);
        db.execSQL(DATABASE_CREATE_KIEVSKI);
        db.execSQL(DATABASE_CREATE_KIROVOGRAD);
        db.execSQL(DATABASE_CREATE_LUGANSK);
        db.execSQL(DATABASE_CREATE_LVOV);
        db.execSQL(DATABASE_CREATE_NIKOLAEV);
        db.execSQL(DATABASE_CREATE_ODESSA);
        db.execSQL(DATABASE_CREATE_POLTAVA);
        db.execSQL(DATABASE_CREATE_ROVNO);
        db.execSQL(DATABASE_CREATE_SUMI);
        db.execSQL(DATABASE_CREATE_TERNOPOL);
        db.execSQL(DATABASE_CREATE_VINICA);
        db.execSQL(DATABASE_CREATE_VOLIN);
        db.execSQL(DATABASE_CREATE_ZAKARPATIA);
        db.execSQL(DATABASE_CREATE_ZAPOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);
        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_CRIMEA);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_VOLIN);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_VINICA);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_DONETSK);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_DNEPR);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_JITOMIR);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_ZAKARPATIA);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_ZAPOR);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_IVANOFR);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_KIEVSKI);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_KIROVOGRAD);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_LUGANSK);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_LVOV);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_NIKOLAEV);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_ODESSA);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_POLTAVA);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_ROVNO);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_SUMI);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_TERNOPOL);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_HARKOV);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_HERSON);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_HMELNITSK);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_CHERKASI);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_CHERNOVCI);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_CHERNIGOV);
        db.execSQL("DROP TABLE IF IT EXISTS " + TABLE_KIEV);


        // Создаём новую таблицу
        onCreate(db);
    }

    public void onDelete (){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_VOLIN, null, null);
        db.delete(TABLE_VINICA, null, null);
        db.delete(TABLE_DONETSK, null, null);
        db.delete(TABLE_DNEPR, null, null);
        db.delete(TABLE_JITOMIR, null, null);
        db.delete(TABLE_ZAKARPATIA, null, null);
        db.delete(TABLE_ZAPOR, null, null);
        db.delete(TABLE_IVANOFR, null, null);
        db.delete(TABLE_KIEVSKI, null, null);
        db.delete(TABLE_KIROVOGRAD, null, null);
        db.delete(TABLE_LUGANSK, null, null);
        db.delete(TABLE_LVOV, null, null);
        db.delete(TABLE_NIKOLAEV, null, null);
        db.delete(TABLE_ODESSA, null, null);
        db.delete(TABLE_POLTAVA, null, null);
        db.delete(TABLE_ROVNO, null, null);
        db.delete(TABLE_SUMI, null, null);
        db.delete(TABLE_TERNOPOL, null, null);
        db.delete(TABLE_HARKOV, null, null);
        db.delete(TABLE_HERSON, null, null);
        db.delete(TABLE_HMELNITSK, null, null);
        db.delete(TABLE_CHERKASI, null, null);
        db.delete(TABLE_CHERNOVCI, null, null);
        db.delete(TABLE_CHERNIGOV, null, null);
        db.delete(TABLE_KIEV, null, null);
        db.close();
    }

    // Добавляем новый контакт
    public void addArchiveItemTarif(String string, ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(string, null, values);
        db.close();
    }
    // Добавляем новый контакт
    public void addArchiveItemCrimea(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_CRIMEA, null, values);
        db.close();
    }
    // Добавляем новый контакт
    public void addArchiveItemVinica(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_VINICA, null, values);
        db.close();
    }
    // Добавляем новый контакт
    public void addArchiveItemVolin(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_VOLIN, null, values);
        db.close();
    }
    public void addArchiveItemDnepr(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_DNEPR, null, values);
        db.close();
    }
    public void addArchiveItemDoneck(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_DONETSK, null, values);
        db.close();
    }
    public void addArchiveItemJitomir(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_JITOMIR, null, values);
        db.close();
    }
    public void addArchiveItemZakarpatia(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_ZAKARPATIA, null, values);
        db.close();
    }
    public void addArchiveItemZapor(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_ZAPOR, null, values);
        db.close();
    }
    public void addArchiveItemIvanoFr(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_IVANOFR, null, values);
        db.close();
    }
    public void addArchiveItemKievski(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_KIEVSKI, null, values);
        db.close();
    }
    public void addArchiveItemKirovograd(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_KIROVOGRAD, null, values);
        db.close();
    }
    public void addArchiveItemLygansk(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_LUGANSK, null, values);
        db.close();
    }
    public void addArchiveItemLvov(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_LVOV, null, values);
        db.close();
    }
    public void addArchiveItemNikolaev(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_NIKOLAEV, null, values);
        db.close();
    }
    public void addArchiveItemOdessa(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_ODESSA, null, values);
        db.close();
    }
    public void addArchiveItemPoltava(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_POLTAVA, null, values);
        db.close();
    }
    public void addArchiveItemRovno(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_ROVNO, null, values);
        db.close();
    }
    public void addArchiveItemSymi(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_SUMI, null, values);
        db.close();
    }
    public void addArchiveItemTernopol(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_TERNOPOL, null, values);
        db.close();
    }
    public void addArchiveItemHarkov(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_HARKOV, null, values);
        db.close();
    }
    public void addArchiveItemHerson(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_HERSON, null, values);
        db.close();
    }
    public void addArchiveItemHmelnitsk(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_HMELNITSK, null, values);
        db.close();
    }
    public void addArchiveItemCherkasi(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_CHERKASI, null, values);
        db.close();
    }
    public void addArchiveItemChernigov(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_CHERNIGOV, null, values);
        db.close();
    }
    public void addArchiveItemChernovci(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_CHERNOVCI, null, values);
        db.close();
    }
    public void addArchiveItemKiev(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // Вставляем строку в таблицу
        db.insert(TABLE_KIEV, null, values);
        db.close();
    }
    // Получить контакт
    public ArchiveItemTarif getArchiveItemTarif(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DATABASE_TABLE, new String[] { COLUMN_ID,
                        COLUMN_WATER, COLUMN_INWATER, COLUMN_OUTWATER }, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ArchiveItemTarif archiveItemTarif = new ArchiveItemTarif(Integer.parseInt(cursor.getString(0)),
                (cursor.getString(1)), cursor.getString(2), (cursor.getString(3)));
        return archiveItemTarif;
    }

    // Получить все контакты
    public ArrayList<ArchiveItemTarif> getArchiveItemTarif() {
        ArrayList contactList = new ArrayList<>();
        // Выбираем всю таблицу
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Проходим по всем строкам и добавляем в список
        if (cursor.moveToFirst()) {
            do {
                ArchiveItemTarif archiveItemTarif = new ArchiveItemTarif();
                archiveItemTarif.setTarifId(Integer.parseInt(cursor.getString(0)));
                archiveItemTarif.setTarifCwater(cursor.getString(1));
                archiveItemTarif.setInCWater(cursor.getString(2));
                archiveItemTarif.setOutCWater(cursor.getString(3));
                contactList.add(archiveItemTarif);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    // Получить число контактов
    public int getArchiveItemTarifCount() {
        String countQuery = "SELECT * FROM " + DATABASE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();

        cursor.close();

        return count;
    }

    // Обновить контакт
    public int updateArchiveItemTarif(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WATER, archiveItemTarif.getTarifCwater());
        values.put(COLUMN_INWATER, archiveItemTarif.getInCWater());
        values.put(COLUMN_OUTWATER, archiveItemTarif.getOutCWater());

        // обновляем строку
        return db.update(DATABASE_TABLE, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(archiveItemTarif.getTarifId()) });
    }
    // Удалить контакт
    public void deleteArchiveItemTarif(ArchiveItemTarif archiveItemTarif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE, COLUMN_ID + " = ?",
                new String[] { String.valueOf(archiveItemTarif.getTarifId()) });
        db.close();
    }
}
