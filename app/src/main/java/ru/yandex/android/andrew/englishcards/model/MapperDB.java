package ru.yandex.android.andrew.englishcards.model;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ru.yandex.android.andrew.englishcards.controller.WordItem;

/**
 * Created by Andrew on 08.11.2015.
 */
public class MapperDB {

    ArrayList<WordItem> cashWords;
    ArrayList<LearningWord> listCurrentWords;
    SQLiteDatabase database;

    public MapperDB(SQLiteDatabase db){
        database = db;
    }







    class LearningWord{
        private int id;
        private int level;

        public LearningWord(int _id, int _level){
            id = _id;
            level = _level;
        }

    }
}

