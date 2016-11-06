package com.example.rodri.vcatcher.database;

import android.content.Context;
import android.database.SQLException;
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
    private String[] imageColumns = {
            MySQLiteHelper.KEY_ID,
            MySQLiteHelper.COLUMN_PATH,
            MySQLiteHelper.COLUMN_SIZE
    };
    private String[] wordImageColumns = {
            MySQLiteHelper.COLUMN_WORD_ID,
            MySQLiteHelper.COLUMN_IMAGE_ID
    };
    private String[] wordDetailsColumns = {
            MySQLiteHelper.KEY_ID,
            MySQLiteHelper.COLUMN_WORD_ID,
            MySQLiteHelper.COLUMN_LAST_PRACTICED,
            MySQLiteHelper.COLUMN_STRENGTH,
            MySQLiteHelper.COLUMN_CORRECT_TIMES,
            MySQLiteHelper.COLUMN_INCORRECT_TIMES
    };
    private String[] levelColumns = {
            MySQLiteHelper.KEY_ID,
            MySQLiteHelper.COLUMN_NUM,
            MySQLiteHelper.COLUMN_EXPERIENCE
    };
    private String[] userLevelColumns = {
            MySQLiteHelper.KEY_ID,
            MySQLiteHelper.COLUMN_USER_ID,
            MySQLiteHelper.COLUMN_NUM,
            MySQLiteHelper.COLUMN_CURRENT_EXPERIENCE
    };
    private String[] reminderColumns = {
            MySQLiteHelper.KEY_ID,
            MySQLiteHelper.COLUMN_DATE,
            MySQLiteHelper.COLUMN_MESSAGE
    };
    private String[] gameColumns = {
            MySQLiteHelper.KEY_ID,
            MySQLiteHelper.KEY_NAME
    };
    private String[] userGameColumns = {
            MySQLiteHelper.COLUMN_USER_ID,
            MySQLiteHelper.COLUMN_GAME_ID,
            MySQLiteHelper.COLUMN_WINS,
            MySQLiteHelper.COLUMN_LOSSES
    };

    public MyDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    /** --- CREATE --- */

}
