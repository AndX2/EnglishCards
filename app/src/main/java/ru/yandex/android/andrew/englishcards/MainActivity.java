package ru.yandex.android.andrew.englishcards;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView statusTextView;
    public boolean soundON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        //statusTextView = (TextView)findViewById(R.id.statusTextView);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.top_ui_container, new TopFragment());
        fragmentTransaction.add(R.id.bottom_ui_container, new BottomFragment());
        fragmentTransaction.add(R.id.central_ui_container, new CentralFragment());
        fragmentTransaction.commit();
        fragmentTransaction = null;


        //startService(new Intent(this, EnglishCardDaemon.class));

    }
    public void onClickMuteButton(){

    }

}
