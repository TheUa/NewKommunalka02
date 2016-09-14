package com.example.admin.newkommunalka02;

/**
 * Created by Admin on 01.02.2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper implements BaseColumns {

    public static final String DATABASE_NAME = "mydatabase.db";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_TABLE = "cats";

    public static final String DATABASE_ELECTRO = "electro";

    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_COUNT = "archive_count";
    public static final String COLUMN_DATE = "archive_date";
    public static final String COLUMN_TIME = "archive_time";
    public static final String COLUMN_DESCRIPTION = "archive_description";

    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_COUNT
            + " integer, " + COLUMN_DATE + " text not null, " + COLUMN_TIME
            + " text not null, " + COLUMN_DESCRIPTION + " text not null);";

    private static final String DATABASE_CREATE_ELECTRO = "create table "
            + DATABASE_ELECTRO + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + COLUMN_COUNT
            + " integer, " + COLUMN_DATE + " text not null, " + COLUMN_TIME
            + " text not null, " + COLUMN_DESCRIPTION + " text not null);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
        db.execSQL(DATABASE_CREATE_ELECTRO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запишем в журнал
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_TABLE);
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_ELECTRO);
        // Создаём новую таблицу
        onCreate(db);
    }

    // Добавляем новый контакт
    public void addArchiveItem(ArchiveItem archiveItem, String table) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_COUNT, archiveItem.getArchiveCount());
        values.put(COLUMN_DATE, archiveItem.getArchiveDate());
        values.put(COLUMN_TIME, archiveItem.getArchiveTime());
        values.put(COLUMN_DESCRIPTION, archiveItem.getArchiveDescr());

        // Вставляем строку в таблицу
        db.insert(table, null, values);
        db.close();
    }

    // Получить контакт
    public ArchiveItem getArchiveItem(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DATABASE_TABLE, new String[] { COLUMN_ID,
                        COLUMN_COUNT, COLUMN_DATE, COLUMN_TIME, COLUMN_DESCRIPTION }, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ArchiveItem archiveItem = new ArchiveItem(Integer.parseInt(cursor.getString(0)),
                (cursor.getString(1)), cursor.getString(2), (cursor.getString(3)), (cursor.getString(4)));
        return archiveItem;
    }

    // Получить все контакты
    public ArrayList<ArchiveItem> getArchiveItem() {
        ArrayList contactList = new ArrayList<>();
        // Выбираем всю таблицу
        String selectQuery = "SELECT * FROM " + DATABASE_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Проходим по всем строкам и добавляем в список
        if (cursor.moveToFirst()) {
            do {
                ArchiveItem archiveItem = new ArchiveItem();
                archiveItem.setArchiveId(Integer.parseInt(cursor.getString(0)));
                archiveItem.setArchiveCount(cursor.getString(1));
                archiveItem.setArchiveDate(cursor.getString(2));
                archiveItem.setArchiveTime(cursor.getString(3));
                archiveItem.setArchiveDescr(cursor.getString(4));
                contactList.add(archiveItem);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return contactList;
    }

    // Получить число контактов
    public int getArchiveItemCount() {
        String countQuery = "SELECT * FROM " + DATABASE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();

        cursor.close();

        return count;
    }

    // Обновить контакт
    public int updateArchiveItem(ArchiveItem archiveItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_COUNT, archiveItem.getArchiveCount());
        values.put(COLUMN_DATE, archiveItem.getArchiveDate());
        values.put(COLUMN_TIME, archiveItem.getArchiveTime());
        values.put(COLUMN_DESCRIPTION, archiveItem.getArchiveDescr());

        // обновляем строку
        return db.update(DATABASE_TABLE, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(archiveItem.getArchiveId()) });
    }

    // Удалить контакт
    public void deleteArchiveItem(ArchiveItem archiveItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE, COLUMN_ID + " = ?",
                new String[] { String.valueOf(archiveItem.getArchiveId()) });
        db.close();
    }
}