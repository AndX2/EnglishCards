package ru.yandex.android.andrew.englishcards.model;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

import ru.yandex.android.andrew.englishcards.Constants;
import ru.yandex.android.andrew.englishcards.model.DBHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackgroundWorkerFragment extends Fragment {

    private DBHelper dbHelper;
    private SharedPreferences sharedPreferences;
    private MapperDB store;

    public BackgroundWorkerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        // create here background threads and tasks
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        dbHelper = new DBHelper(getActivity());
        firstInitData();
        store = new MapperDB(dbHelper.openDataBase());


        // run here created in onCreate threads and tasks
    }

    private void firstInitData(){
        sharedPreferences = getActivity().getSharedPreferences(Constants.APP_PREFERENCE, Context.MODE_PRIVATE);
        if (!sharedPreferences.getBoolean(Constants.IS_FIRST_LAUNCH, false)) {
            Log.d(Constants.LOG_DEBUG_TAG, "retainFragment call db create method");
            dbCreate();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(Constants.IS_FIRST_LAUNCH, true);
            editor.apply();
        }
    }

    private void dbCreate() {
        try {
            dbHelper.createDataBase();
            Log.d(Constants.LOG_DEBUG_TAG, "dbCreate complete");
        } catch (IOException e) {
            Log.d(Constants.LOG_DEBUG_TAG, "dbCreate Error " + e);
        }
    }
}
