package ru.yandex.android.andrew.englishcards;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //statusTextView = (TextView)findViewById(R.id.statusTextView);
        //startService(new Intent(this, EnglishCardDaemon.class));

    }

}
