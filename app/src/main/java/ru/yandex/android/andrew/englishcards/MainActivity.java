package ru.yandex.android.andrew.englishcards;

import android.app.Activity;
import android.content.res.AssetManager;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import ru.yandex.android.andrew.englishcards.model.BackgroundService;

public class MainActivity extends AppCompatActivity {
    TextView statusTextView;
    public boolean soundON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Log.d(Constants.LOG_DEBUG_TAG, "Main activity call on create");
        startService(new Intent(this, BackgroundService.class));
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.top_ui_container, new TopFragment());
        fragmentTransaction.add(R.id.bottom_ui_container, new BottomFragment());
        fragmentTransaction.add(R.id.central_ui_container, new CentralFragment());
        fragmentTransaction.commit();


        //startService(new Intent(this, EnglishCardDaemon.class));

    }
    public void onClickMuteButton(){

    }

}
