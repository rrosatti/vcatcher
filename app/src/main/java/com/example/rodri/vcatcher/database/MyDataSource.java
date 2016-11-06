package com.example.rodri.vcatcher.database;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rodri on 11/5/2016.
 */

public class MyDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] userColumns = {
            MySQLiteHelper.KEY_ID,
            MySQLiteHelper.KEY_NAME,
            MySQLiteHelper.COLUMN_USERNAME,
            MySQLiteHelper.COLUMN_PASSWORD
    };
    private String[] wordColumns = {
            MySQLiteHelper.KEY_ID,
            MySQLiteHelper.KEY_NAME,
            MySQLiteHelper.COLUMN_TRANSLATION,
            MySQLiteHelper.COLUMN_HAS_IMAGE
    };
}
