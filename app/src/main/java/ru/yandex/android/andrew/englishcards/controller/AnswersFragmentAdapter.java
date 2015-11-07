package ru.yandex.android.andrew.englishcards.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ru.yandex.android.andrew.englishcards.Constants;
import ru.yandex.android.andrew.englishcards.R;

/**
 * Created by Andrew on 07.11.2015.
 */
public class AnswersFragmentAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<WordItem> data;

    public AnswersFragmentAdapter(Context context, ArrayList<WordItem> _data){
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        data = _data;
    }

    @Override
    public int getCount() {
        return Constants.COUNT_ANSWERS_IN_BOTTOM_FRAGMENT;
    }

    @Override
    public WordItem getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getPositionInThousand();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null){
            view = inflater.inflate(R.layout.cell_answer, null);
        }
        WordItem wordItem = data.get(position);
        TextView textView = (TextView)view.findViewById(R.id.answer);

        textView.setText(wordItem.getTranslate());
        return view;
    }
}
