package ru.yandex.android.andrew.englishcards;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ru.yandex.android.andrew.englishcards.model.BackgroundWorkerFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    BackgroundWorkerFragment backgroundWorkerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Log.d(Constants.LOG_DEBUG_TAG, "Main activity call on create");
        //startService(new Intent(this, BackgroundService.class));
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.top_ui_container, new TopFragment());
        fragmentTransaction.add(R.id.bottom_ui_container, new BottomFragment());
        fragmentTransaction.add(R.id.central_ui_container, new CentralFragment());
        if ((BackgroundWorkerFragment)fragmentManager.findFragmentByTag(Constants.BACKGROUND_WORKER_FRAGMENT_TAG)==null){
            backgroundWorkerFragment = new BackgroundWorkerFragment();
            fragmentTransaction.add(backgroundWorkerFragment, Constants.BACKGROUND_WORKER_FRAGMENT_TAG);
        }
        fragmentTransaction.commit();

        BackgroundWorkerFragment backgroundWorkerFragment = (BackgroundWorkerFragment)
                fragmentManager.findFragmentByTag(Constants.BACKGROUND_WORKER_FRAGMENT_TAG);

        //startService(new Intent(this, EnglishCardDaemon.class));

    }

}
