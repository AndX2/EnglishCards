package ru.yandex.android.andrew.englishcards.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import ru.yandex.android.andrew.englishcards.Constants;
import ru.yandex.android.andrew.englishcards.model.BackgroundService;

/**
 * Created by Andrew on 06.11.2015.
 */
public class OnLoadReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, BackgroundService.class));
        Log.d(Constants.LOG_DEBUG_TAG, "boot complited receiver onReceive");
    }
}
