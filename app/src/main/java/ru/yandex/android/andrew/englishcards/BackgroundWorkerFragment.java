package ru.yandex.android.andrew.englishcards;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackgroundWorkerFragment extends Fragment {


    public BackgroundWorkerFragment() {
        // Required empty public constructor
    }
    /* this fragment have not UI interface. It not return his view.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }*/

    @Override
    public void onAttach(Activity activity){
       // get here safe proof for Activity
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // create here background threads and tasks
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        // run here created in onCreate threads and tasks
    }




}
