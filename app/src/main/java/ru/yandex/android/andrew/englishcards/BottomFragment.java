package ru.yandex.android.andrew.englishcards;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import ru.yandex.android.andrew.englishcards.controller.AnswersFragmentAdapter;
import ru.yandex.android.andrew.englishcards.controller.WordItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment{

    private ArrayList<WordItem> answersList;
    private AnswersFragmentAdapter answersFragmentAdapter;

    public BottomFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        GridView gridAnswers = (GridView)view.findViewById(R.id.grid_answers);

        answersList = getStubWordItem(Constants.COUNT_ANSWERS_IN_BOTTOM_FRAGMENT);
        answersFragmentAdapter = new AnswersFragmentAdapter(getContext(), answersList);
        gridAnswers.setAdapter(answersFragmentAdapter);
        gridAnswers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: create here worker select of answer
                Log.d(Constants.LOG_DEBUG_TAG, "onClick answer # " + position);
            }
        });
        return view;
    }

    // TODO: change it method to getter data from sourse
    private ArrayList<WordItem> getStubWordItem(int count){
        ArrayList<WordItem> arrayList = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < count; i++){
            int j = random.nextInt(1000);
            WordItem wordItem = new WordItem(j, "word " + j, "translate " +j);
            arrayList.add(wordItem);
        }
        return arrayList;
    }



}
