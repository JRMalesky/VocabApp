package com.example.darkness7245.vocabapp.model;

/**
 * Created by Student on 5/14/2017.
 */

public class Dictionary {

    private String word;
    private String type;
    private String definition;

    public Dictionary(String word, String type,String definition) {
        this.word = word;
        this.type = type;
        this.definition=definition;

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
