package ru.yandex.android.andrew.englishcards.model;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import ru.yandex.android.andrew.englishcards.Constants;
import ru.yandex.android.andrew.englishcards.model.DBHelper;

/**
 * Created by Andrew on 06.11.2015.
 */
public class BackgroundService extends Service{

    private DBHelper dbHelper;
    SharedPreferences sharedPreferences;
    Handler backgroundServiceHandler;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(Constants.LOG_DEBUG_TAG, "service was onBind");

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.LOG_DEBUG_TAG, "service onCreate");
        sharedPreferences = getSharedPreferences(Constants.APP_PREFERENCE, Context.MODE_PRIVATE);
        sharedPreferences.getAll();
        if (!sharedPreferences.getBoolean(Constants.IS_FIRST_LAUNCH, false)) {
            Log.d(Constants.LOG_DEBUG_TAG, "service call init method");
            initFirstLaunch();
        }

    }

    private void initFirstLaunch(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // TODO: enable it for off init second and more start
        //editor.putBoolean(Constants.IS_FIRST_LAUNCH, true);
        editor.apply();
        AssetManager assetManager = getAssets();


    }

}
