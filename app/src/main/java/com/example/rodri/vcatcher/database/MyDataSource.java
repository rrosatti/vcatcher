package com.example.rodri.vcatcher.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.rodri.vcatcher.model.Game;
import com.example.rodri.vcatcher.model.Image;
import com.example.rodri.vcatcher.model.Level;

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

    public Game createGame(String name) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_NAME, name);

        long insertedId = database.insert(MySQLiteHelper.TABLE_GAME, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_GAME, gameColumns,
                MySQLiteHelper.KEY_ID + " = " + insertedId, null, null, null, null, null);

        if (isCursorEmpty(cursor)) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();

        Game newGame = cursorToGame(cursor);
        cursor.close();

        return newGame;

    }

    public Image createImage(String path, int size) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_PATH, path);
        values.put(MySQLiteHelper.COLUMN_SIZE, size);

        long insertedId = database.insert(MySQLiteHelper.TABLE_IMAGE, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_IMAGE, imageColumns,
                MySQLiteHelper.KEY_ID + " = " + insertedId, null, null, null, null, null);

        if (isCursorEmpty(cursor)) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();

        Image newImage = cursorToImage(cursor);
        cursor.close();

        return newImage;

    }

    public Level createLevel(int num, int experience) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NUM, num);
        values.put(MySQLiteHelper.COLUMN_EXPERIENCE, experience);

        long insertedId = database.insert(MySQLiteHelper.TABLE_LEVEL, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_LEVEL, levelColumns,
                MySQLiteHelper.KEY_ID + " = " + insertedId, null, null, null, null, null);

        if (isCursorEmpty(cursor)) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();

        Level newLevel = cursorToLevel(cursor);
        cursor.close();

        return newLevel;

    }

    /** --- CURSOR TO --- */

    public Game cursorToGame(Cursor cursor) {
        Game game = new Game();
        game.setId(cursor.getLong(0));
        game.setName(cursor.getString(1));
        return game;
    }

    public Image cursorToImage(Cursor cursor) {
        Image image = new Image();
        image.setId(cursor.getLong(0));
        image.setPath(cursor.getString(1));
        image.setSize(cursor.getInt(2));
        return image;
    }

    public Level cursorToLevel(Cursor cursor) {
        Level level = new Level();
        level.setId(cursor.getLong(0));
        level.setNum(cursor.getInt(1));
        level.setExperience(cursor.getInt(2));
        return level;
    }

    /** --- EXTRAS --- */

    public boolean isCursorEmpty(Cursor cursor) {
        // if the cursor can move to first, than it means it is not empty (Duh!)
        if (cursor.moveToFirst()) {
            return false;
        } else {
            return true;
        }
    }

}
