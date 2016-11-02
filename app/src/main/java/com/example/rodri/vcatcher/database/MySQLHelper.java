package com.example.rodri.vcatcher.database;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rodri on 11/2/2016.
 */

public class MySQLHelper extends SQLiteOpenHelper {

    // Database name
    private static final String DATABASE_NAME = "vcatcher.db";

    // Database version
    private static final int DATABASE_VERSION = 1;


    // Database tables
    public static final String TABLE_USER = "user";
    public static final String TABLE_WORD = "word";
    public static final String TABLE_IMAGE = "image";
    public static final String TABLE_WORD_IMAGE = "word_image";
    public static final String TABLE_WORD_DETAILS = "word_details";
    public static final String TABLE_LEVEL = "level";
    public static final String TABLE_USER_LEVEL = "user_level";
    public static final String TABLE_REMINDER = "reminder";
    public static final String TABLE_GAME = "game";
    public static final String TABLE_USER_GAME = "user_game";

    // Common column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";

    // user column names
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    // word column names
    public static final String COLUMN_TRANSLATION = "translation";
    public static final String COLUMN_HAS_IMAGE = "has_image";

    // image column names
    public static final String COLUMN_PATH = "path";
    public static final String COLUMN_SIZE = "size";

    // word_image column names
    public static final String COLUMN_WORD_ID = "word_id";
    public static final String COLUMN_IMAGE_ID = "image_id";

    // word_details column names
    // word_id
    public static final String COLUMN_LAST_PRACTICED = "last_practiced";
    public static final String COLUMN_STRENGTH = "strength";
    public static final String COLUMN_CORRECT_TIMES = "correct_times";
    public static final String COLUMN_INCORRECT_TIMES = "incorrect_times";

    // level column names
    public static final String COLUMN_NUM = "num";
    public static final String COLUMN_EXPERIENCE = "experience";

    // user_level column names
    public static final String COLUMN_USER_ID = "user_id";
    // num
    public static final String COLUMN_CURRENT_EXPERIENCE = "current_experience";

    // reminder column names
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_MESSAGE = "message";

    // game column names
    // id and name

    // user_game column names
    // user_id
    public static final String COLUMN_GAME_ID = "game_id";
    public static final String COLUMN_WINS = "wins";
    public static final String COLUMN_LOSSES = "losses";


}
