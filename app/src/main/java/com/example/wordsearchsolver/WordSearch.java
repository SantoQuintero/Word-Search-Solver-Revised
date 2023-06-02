package com.example.wordsearchsolver;

import android.util.Log;

import java.util.ArrayList;

public class WordSearch {
    private String[][] wordSearchLetters;
    private ArrayList<String> wordSearchAnswers;

    public WordSearch(String wordSearchLetters, ArrayList<String> wordSearchAnswers)
    {
        this.wordSearchAnswers = wordSearchAnswers;
        this.wordSearchLetters = convertRawWS(wordSearchLetters);
    }

    public WordSearch()
    {
        wordSearchLetters = new String[1][1];
    }

    public void setWordSearchAnswers(ArrayList<String> wordSearchAnswers) {
        this.wordSearchAnswers = wordSearchAnswers;
    }

    public void setWordSearchLetters(String wordSearchLetters) {
        this.wordSearchLetters = convertRawWS(wordSearchLetters);
    }

    public String[][] getWordSearchLetters() {
        return wordSearchLetters;
    }

    public ArrayList<String> getWordSearchAnswers() {
        return wordSearchAnswers;
    }

    public String toString()
    {
        String result = "";
        for(int i = 0; i < wordSearchLetters.length;i++)
        {
            for(int j = 0; j<wordSearchLetters[i].length;j++)
            {
                result += wordSearchLetters[i][j] + " ";
            }
            result +="\n";
        }
        result +="\n";
        //System.out.println(result);
        //Log.i("info", result);
        return result;
    }

     private String[][] convertRawWS(String rawWS)
    {

        int count = 0;
        while(rawWS.charAt(count) !='.')
        {
            count++;
            //x value
        }
        //System.out.println(count);
        int rows = 1+((rawWS.length()-count)/(count+1));
       // System.out.println(rows);
        String[][] wordSearchRefined = new String[rows][count];
        rawWS = rawWS.replace(".", "");
        int allLetters = 0;
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0; j < count;j++)
            {
                if(i+1>=rows && j+1>=count)
                {
                    wordSearchRefined[i][j] = rawWS.substring(rawWS.length()-1);
                    //System.out.println(wordSearchRefined[i][j] + i + ", " + j);
                }
                else
                {
                    wordSearchRefined[i][j] = rawWS.substring(allLetters, allLetters+1);
                    //System.out.println(wordSearchRefined[i][j]);
                }

                allLetters++;
            }//
        }
        return wordSearchRefined;
    }

}
