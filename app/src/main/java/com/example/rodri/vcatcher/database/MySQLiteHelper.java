package com.example.rodri.vcatcher.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by rodri on 11/2/2016.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    // Arrays that will get the data rom getResources()
    private String[] levels;
    private String[] games;

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

    /** Define the tables columns */

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


    /** Create tables */

    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " ("
            + KEY_ID + " INTEGER AUTOINCREMENT, "
            + KEY_NAME + " TEXT NOT NULL, "
            + COLUMN_USERNAME + " TEXT NOT NULL, "
            + COLUMN_PASSWORD + " TEXT NOT NULL, "
            + "PRIMARY KEY (" + KEY_ID + "));";

    private static final String CREATE_TABLE_WORD = "CREATE TABLE " + TABLE_WORD + " ("
            + KEY_ID + " INTEGER AUTOINCREMENT, "
            + KEY_NAME + " TEXT NOT NULL, "
            + COLUMN_TRANSLATION + " TEXT NOT NULL, "
            + COLUMN_HAS_IMAGE + " SMALLINT NOT NULL, "
            + "PRIMARY KEY (" + KEY_ID + "));";

    private static final String CREATE_TABLE_IMAGE = "CREATE TABLE " + TABLE_IMAGE + " ("
            + KEY_ID + " INTEGER AUTOINCREMENT, "
            + COLUMN_PATH + " TEXT NOT NULL, "
            + COLUMN_SIZE + " INTEGER NOT NULL, "
            + "PRIMARY KEY (" + KEY_ID + "));";

    private static final String CREATE_TABLE_WORD_IMAGE = "CREATE TABLE " + TABLE_WORD_IMAGE + " ("
            + COLUMN_WORD_ID + " INTEGER, "
            + COLUMN_IMAGE_ID + " INTEGER NOT NULL, "
            + "PRIMARY KEY (" + COLUMN_WORD_ID + "), "
            + "FOREIGN KEY (" + COLUMN_WORD_ID + ") REFERENCES " + TABLE_WORD + "(" + KEY_ID + "), "
            + "FOREIGN KEY (" + COLUMN_IMAGE_ID + ") REFERENCES "  +TABLE_IMAGE + "(" + KEY_ID + "));";

    private static final String CREATE_TABLE_WORD_DETAILS = "CREATE TABLE " + TABLE_WORD_DETAILS + " ("
            + KEY_ID + " INTEGER AUTOINCREMENT, "
            + COLUMN_WORD_ID + " INTEGER NOT NULL, "
            + COLUMN_LAST_PRACTICED + " DATE NOT NULL, "
            + COLUMN_STRENGTH + " INTEGER NOT NULL, "
            + COLUMN_CORRECT_TIMES + " INTEGER NOT NULL, "
            + COLUMN_INCORRECT_TIMES + " INTEGER NOT NULL, "
            + "PRIMARY KEY (" + KEY_ID + "), "
            + "FOREIGN KEY (" + COLUMN_WORD_ID  + ") REFERENCES " + TABLE_WORD + "(" + KEY_ID + "));";

    private static final String CREATE_TABLE_LEVEL = "CREATE TABLE " + TABLE_LEVEL + " ("
            + KEY_ID + " INTEGER AUTOINCREMENT, "
            + COLUMN_NUM + " INTEGER NOT NULL, "
            + COLUMN_EXPERIENCE + " INTEGER NOT NULL"
            + "PRIMARY KEY (" + KEY_ID + "));";

    private static final String CREATE_TABLE_USER_LEVEL = "CREATE TABLE " + TABLE_USER_LEVEL + " ("
            + KEY_ID + " INTEGER AUTOINCREMENT, "
            + COLUMN_USER_ID + " INTEGER NOT NULL, "
            + COLUMN_NUM + " INTEGER NOT NULL, "
            + COLUMN_CURRENT_EXPERIENCE + " INTEGER NOT NULL, "
            + "PRIMARY KEY (" + KEY_ID + "), "
            + "FOREIGN KEY (" + COLUMN_USER_ID + ") REFERENCES " + TABLE_USER + "(" + KEY_ID + "));";

    private static final String CREATE_TABLE_REMINDER = "CREATE TABLE " + TABLE_REMINDER + " ("
            + KEY_ID + " INTEGER AUTOINCREMENT, "
            + COLUMN_DATE + " DATE NOT NULL, "
            + COLUMN_MESSAGE + " TEXT, "
            + "PRIMARY KEY (" + KEY_ID + "));";

    private static final String CREATE_TABLE_GAME = "CREATE TABLE " + TABLE_GAME + " ("
            + KEY_ID + " INTEGER AUTOINCREMENT, "
            + KEY_NAME + " TEXT NOT NULL, "
            + "PRIMARY KEY (" + KEY_ID + "));";

    private static final String CREATE_TABLE_USER_GAME = "CREATE TABLE " + TABLE_USER_GAME + " ("
            + COLUMN_USER_ID + " INTEGER NOT NULL, "
            + COLUMN_GAME_ID + " INTEGER NOT NULL, "
            + COLUMN_WINS + " INTEGER NOT NULL, "
            + COLUMN_LOSSES + " INTEGER NOT NULL, "
            + "PRIMARY KEY(" + COLUMN_USER_ID + ", " + COLUMN_GAME_ID + "), "
            + "FOREIGN KEY(" + COLUMN_USER_ID + ") REFERENCES " + TABLE_USER + "(" + KEY_ID + "), "
            + "FOREIGN KEY(" + COLUMN_GAME_ID + ") REFERENCES " + TABLE_GAME + "(" + KEY_ID + "));";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // get data from getResources() and put them in levels and games array
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_WORD);
        db.execSQL(CREATE_TABLE_IMAGE);
        db.execSQL(CREATE_TABLE_WORD_IMAGE);
        db.execSQL(CREATE_TABLE_WORD_DETAILS);
        db.execSQL(CREATE_TABLE_LEVEL);
        db.execSQL(CREATE_TABLE_USER_LEVEL);
        db.execSQL(CREATE_TABLE_REMINDER);
        db.execSQL(CREATE_TABLE_GAME);
        db.execSQL(CREATE_TABLE_USER_GAME);
        populateLevelTable(db);
        populateGameTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(), "Upgrading from version " + oldVersion + " to " + newVersion
            + ". The old data will be deleted.");

        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORD);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORD_IMAGE);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORD_DETAILS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_LEVEL);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_LEVEL);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_REMINDER);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_GAME);
            onCreate(db);
        }
    }

    // Implement those methods later
    private void populateLevelTable(SQLiteDatabase db) {

    }

    private void populateGameTable(SQLiteDatabase db) {

    }
}
