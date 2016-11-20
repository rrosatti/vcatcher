package com.example.rodri.vcatcher.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;

import com.example.rodri.vcatcher.model.Game;
import com.example.rodri.vcatcher.model.Image;
import com.example.rodri.vcatcher.model.Level;
import com.example.rodri.vcatcher.model.Reminder;
import com.example.rodri.vcatcher.model.User;
import com.example.rodri.vcatcher.model.UserGame;
import com.example.rodri.vcatcher.model.UserLevel;
import com.example.rodri.vcatcher.model.Word;

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

    public Reminder createReminder(long date, String message) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_DATE, date);
        values.put(MySQLiteHelper.COLUMN_MESSAGE, message);

        long insertedId = database.insert(MySQLiteHelper.TABLE_REMINDER, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_REMINDER, reminderColumns,
                MySQLiteHelper.KEY_ID + " = " + insertedId, null, null, null, null, null);

        if (isCursorEmpty(cursor)) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();

        Reminder newReminder = cursorToReminder(cursor);
        cursor.close();

        return newReminder;

    }

    public User createUser(String name, String username, String password) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_NAME, name);
        values.put(MySQLiteHelper.COLUMN_USERNAME, username);
        values.put(MySQLiteHelper.COLUMN_PASSWORD, password);

        long insertedId = database.insert(MySQLiteHelper.TABLE_USER, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_USER, userColumns,
                MySQLiteHelper.KEY_ID + " = " + insertedId, null, null, null, null, null);

        if (isCursorEmpty(cursor)) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();

        User newUser = cursorToUser(cursor);
        cursor.close();

        return newUser;
    }

    public UserGame createUserGame(long userId, long gameId, int wins, int losses) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_USER_ID, userId);
        values.put(MySQLiteHelper.COLUMN_GAME_ID, gameId);
        values.put(MySQLiteHelper.COLUMN_WINS, wins);
        values.put(MySQLiteHelper.COLUMN_LOSSES, losses);

        database.insert(MySQLiteHelper.TABLE_USER_GAME, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_USER_GAME, userGameColumns,
                MySQLiteHelper.COLUMN_USER_ID + " = " + userId + " AND " +
                        MySQLiteHelper.COLUMN_GAME_ID + " = " + gameId, null, null, null, null, null);

        if (isCursorEmpty(cursor)) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();

        UserGame newUserGame = cursorToUserGame(cursor);
        cursor.close();

        return newUserGame;
    }

    public UserLevel createUserLevel(long userId, int num, int currentExperience) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_USER_ID, userId);
        values.put(MySQLiteHelper.COLUMN_NUM, num);
        values.put(MySQLiteHelper.COLUMN_CURRENT_EXPERIENCE, currentExperience);

        long insertedId = database.insert(MySQLiteHelper.TABLE_USER_LEVEL, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_USER_LEVEL, userLevelColumns,
                MySQLiteHelper.KEY_ID + " = " + insertedId, null, null, null, null, null);

        if (isCursorEmpty(cursor)) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();

        UserLevel newUserLevel = cursorToUserLevel(cursor);
        cursor.close();

        return newUserLevel;
    }

    public Word createWord(String name, String translation, boolean hasImage) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.KEY_NAME, name);
        values.put(MySQLiteHelper.COLUMN_TRANSLATION, translation);
        int image = 0;
        if (hasImage)
            image = 1;
        values.put(MySQLiteHelper.COLUMN_HAS_IMAGE, image);

        long insertedId = database.insert(MySQLiteHelper.TABLE_WORD, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_WORD, wordColumns,
                MySQLiteHelper.KEY_ID + " = " + insertedId, null, null, null, null, null);

        if (isCursorEmpty(cursor)) {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();

        Word newWord = cursorToWord(cursor);
        cursor.close();

        return newWord;

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

    public Reminder cursorToReminder(Cursor cursor) {
        Reminder reminder = new Reminder();
        reminder.setId(cursor.getLong(0));
        reminder.setDate(cursor.getLong(1));
        reminder.setMessage(cursor.getString(2));
        return reminder;
    }

    public User cursorToUser(Cursor cursor) {
        User user = new User();
        user.setId(cursor.getLong(0));
        user.setName(cursor.getString(1));
        user.setUsername(cursor.getString(2));
        user.setPassword(cursor.getString(3));
        return user;
    }

    public UserGame cursorToUserGame(Cursor cursor) {
        UserGame userGame = new UserGame();
        userGame.setUserId(cursor.getLong(0));
        userGame.setGameId(cursor.getLong(1));
        userGame.setWins(cursor.getInt(2));
        userGame.setLosses(cursor.getInt(3));
        return userGame;
    }

    public UserLevel cursorToUserLevel(Cursor cursor) {
        UserLevel userLevel = new UserLevel();
        userLevel.setId(cursor.getLong(0));
        userLevel.setUserId(cursor.getLong(1));
        userLevel.setNum(cursor.getInt(2));
        userLevel.setCurrentExperience(cursor.getInt(3));
        return userLevel;
    }

    public Word cursorToWord(Cursor cursor) {
        Word word = new Word();
        word.setId(cursor.getLong(0));
        word.setName(cursor.getString(1));
        word.setTranslation(cursor.getString(2));
        boolean hasImage = false;
        if (cursor.getInt(3) == 1)
            hasImage = true;
        word.setHasImage(hasImage);
        return word;
    }

    /** --- EXTRAS --- */

    public boolean isCursorEmpty(Cursor cursor) {
        // if the cursor can move to first, than it means it is not empty (Duh!)
        if (cursor.moveToFirst()) {
            return false;
        } else {
            System.out.println("The cursor is empty!");
            return true;
        }
    }

}
