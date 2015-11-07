package ru.yandex.android.andrew.englishcards.controller;

/**
 * Created by Andrew on 07.11.2015.
 */
public class WordItem {

    public WordItem(int _position, String _word, String _translate){
        positionInThousand = _position;
        word = _word;
        translate = _translate;
    }

    private int positionInThousand;
    private String word;
    private String translate;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    private int frequency;

    public int getPositionInThousand() {
        return positionInThousand;
    }

    public String getTranslate() {
        return translate;
    }

    public String getWord() {
        return word;
    }
}
