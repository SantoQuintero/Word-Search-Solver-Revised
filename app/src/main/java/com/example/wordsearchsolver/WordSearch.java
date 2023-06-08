package com.example.wordsearchsolver;

import android.util.Log;

import java.util.ArrayList;

public class WordSearch {

    private String[][] wordSearchLetters;
    private ArrayList<String> wordSearchAnswers;
    private ArrayList<String> wordsFound = new ArrayList<String>();

    //Gets a String as the word search and converts it into a 2D array with a method
    public WordSearch(String wordSearchLetters, ArrayList<String> wordSearchAnswers)
    {
        this.wordSearchAnswers = wordSearchAnswers;
        this.wordSearchLetters = convertRawWS(wordSearchLetters);
    }//end of populated constructor

    public WordSearch()
    {
        wordSearchLetters = new String[1][1];
    }//end of default constructor

    //Setters and Getters
    //{
        public void setWordSearchAnswers(ArrayList<String> wordSearchAnswers)
        {
            this.wordSearchAnswers = wordSearchAnswers;
        }//end of getter

        public void setWordSearchLetters(String wordSearchLetters)
        {
            this.wordSearchLetters = convertRawWS(wordSearchLetters);
        }//end of getter

        public String[][] getWordSearchLetters()
        {
            return wordSearchLetters;
        }//end of getter

        public ArrayList<String> getWordSearchAnswers()
        {
            return wordSearchAnswers;
        }//end of getter
    //}

    public void solve()
    {
        //goes through each answer word and practically each space checking to see if the
        //first letter of the answer word is the letter at the current position in the array
        for(String s : wordSearchAnswers)
        {
            boolean found = false;
            System.out.println("\n\n\t\t\tChecking: " + s+"\n\n");
            for(int i = 0; i < wordSearchLetters.length&&!found;i++)
            {
                for(int j = 0; j<wordSearchLetters[i].length&&!found;j++)
                {
                    if(wordSearchLetters[i][j].equalsIgnoreCase(s.substring(0,1)))
                    {
                        //if it is then it contiues to check the letter next to this letter to see if the next letter of answer word appears
//                        System.out.println("\n\n\nIf block has succeeded and now we are at:\ni: "
//                        + i + "\tj: " + j+"\n Both are apparently the first of " + s +", letter " +s.substring(0,1));
                        int count = 0;
                        while((count<s.length() && inBounds(i,j+count).equalsIgnoreCase(s.substring(count,count+1))))
                        {
//                            System.out.println("horiz------------I am in while\n inBounds gets: "
//                            + inBounds(i,j+count)  +"\nSubstring of count-count+1 gets: "+ s.substring(count,count+1));//this could be trouble

                            //once the last letter is found x spaces away from the first in
                            //the direction of the chain of letters, they are capitalized to indicate the location
                            if(count==s.length()-1 && wordSearchLetters[i][j+count].equalsIgnoreCase(s.substring(s.length()-1)))
                            {
                                //going to the right horizontally because the column number is increasing
                                System.out.println("Got here---------------lastlastlasst");
                                found=true;
                                for(int back = count; back>-1;back--)
                                {

                                    System.out.println("Got here--------------------------before uppercase");
                                    wordSearchLetters[i][j+back] = wordSearchLetters[i][j+back].toUpperCase();
                                    wordsFound.add(s);
                                }
                            }
                            count++;
//                          System.out.println("Count for while is: " + count);
                        }
//                        System.out.println("Entered?...Count: " + count+"\n inBounds gets: "
//                        + inBounds(i,j+count)  +"\nSubstring of count-count+1 gets: danger"/*+ s.substring(count,count+1)*/);

                        //up and down
                        //the aforementioned process is done more than once because the program
                        //needs to check if it is diagnol, horizontal, vertical, etc.

                        count = 0;
                        while((count<s.length() && inBounds(i+count,j).equalsIgnoreCase(s.substring(count,count+1))))
                        {
//                            System.out.println("Vert------------inside while\n inBounds gets: "
//                            + inBounds(i+count,j)  +"\nSubstring of count-count+1 gets: "+ s.substring(count,count+1));
//                            System.out.println("\n\n\nGOT HERE\n"+s.substring(count,count+1));
                            if(count==s.length()-1 &&wordSearchLetters[i+count][j].equalsIgnoreCase(s.substring(s.length()-1)))
                            {
                                //going to the down vertically because the row number is increasing
//                              System.out.println("Got here---------------lastlastlasst");
                                found=true;
                                for(int back = count; back>-1;back--)
                                {

                                    System.out.println("Got here--------------------------before uppercase");
                                    wordSearchLetters[i+back][j] = wordSearchLetters[i+back][j].toUpperCase();
                                    wordsFound.add(s);
                                }
                            }
                            count++;
//                          System.out.println("Count:(break) " + count);
                        }
//                        System.out.println("Count(1) = no enter... Count: " + count+"\n inBounds gets: "
//                        + inBounds(i +count,j)  +"\nSubstring of count-count+1 gets: "/*+ s.substring(count,count+1)*/);
                        count = 0;
                        while((count<s.length() && inBounds(i-count,j).equalsIgnoreCase(s.substring(count,count+1))))
                        {
                            //     System.out.println("Count(1) = no enter... Count: " + count+"\n inBounds gets: "
                            //     + inBounds(i-count,j)  +"\nSubstring of count-count+1 gets: "+ s.substring(count,count+1));
                            //     System.out.println("\n\\n\n\n\n\n\nGOT HERE\n\n\n\n\n\n\n"+s.substring(count,count+1));
                            if(count==s.length()-1 &&wordSearchLetters[i-count][j].equalsIgnoreCase(s.substring(s.length()-1)))
                            {
                                //going to the up vertically because the row number is decreasing
                                // System.out.println("Got here---------------lastlastlasst");
                                found=true;
                                for(int back = count; back>-1;back--)
                                {

                                    // System.out.println("Got here--------------------------before uppercase");
                                    wordSearchLetters[i-back][j] = wordSearchLetters[i-back][j].toUpperCase();
                                    wordsFound.add(s);
                                }
                            }
                            count++;
                            //System.out.println("Count:(break) " + count);
                        }
//                        System.out.println("Count(1) = no enter... Count: " + count+"\n inBounds gets: "
//                        + inBounds(i-count,j)  +"\nSubstring of count-count+1 gets: "/*+ s.substring(count,count+1)*/);


                        // //diagonally both//
                        count = 0;
                        while((count<s.length() && inBounds(i+count,j+count).equalsIgnoreCase(s.substring(count,count+1))))
                        {
                            //     System.out.println("Count(1) = no enter... Count: " + count+"\n inBounds gets: "
                            // + inBounds(i+count,j+count)  +"\nSubstring of count-count+1 gets: "+ s.substring(count,count+1));
                            //     System.out.println("\n\\n\n\n\n\n\nGOT HERE\n\n\n\n\n\n\n"+s.substring(count,count+1));
                            if(count==s.length()-1 &&wordSearchLetters[i+count][j+count].equalsIgnoreCase(s.substring(s.length()-1)))
                            {
                                //going down diagonally because the column and row number is increasing
                                //System.out.println("Got here---------------lastlastlasst");
                                found=true;
                                for(int back = count; back>-1;back--)
                                {

                                    //System.out.println("Got here--------------------------before uppercase");
                                    wordSearchLetters[i+back][j+back] = wordSearchLetters[i+back][j+back].toUpperCase();
                                    wordsFound.add(s);
                                }
                            }
                            count++;
                            //System.out.println("Count:(break) " + count);
                        }
                        // System.out.println("Count(1) = no enter... Count: " + count+"\n inBounds gets: "
                        // + inBounds(i +count,j+count)  +"\nSubstring of count-count+1 gets: "/*+ s.substring(count,count+1)*/);

                        count = 0;
                        while((count<s.length() && inBounds(i-count,j+count).equalsIgnoreCase(s.substring(count,count+1))))
                        {
                            // System.out.println("Count(1) = no enter... Count: " + count+"\n inBounds gets: "
                            // + inBounds(i-count,j+count)  +"\nSubstring of count-count+1 gets: "+ s.substring(count,count+1));
                            // System.out.println("\n\\n\n\n\n\n\nGOT HERE\n\n\n\n\n\n\n"+s.substring(count,count+1));
                            if(count==s.length()-1 &&wordSearchLetters[i-count][j+count].equalsIgnoreCase(s.substring(s.length()-1)))
                            {
                                //going up diagonally because the column number is increasing and the row number is decreasing
                                // System.out.println("Got here---------------lastlastlasst");
                                found=true;
                                for(int back = count; back>-1;back--)
                                {

                                    // System.out.println("Got here--------------------------before uppercase");
                                    wordSearchLetters[i-back][j+back] = wordSearchLetters[i-back][j+back].toUpperCase();
                                    wordsFound.add(s);
                                }
                            }
                            count++;
                            //System.out.println("Count:(break) " + count);
                        }
                        System.out.println("Count(1) = no enter... Count: " + count+"\n inBounds gets: "
                                + inBounds(i -count,j+count)  +"\nSubstring of count-count+1 gets: "/*+ s.substring(count,count+1)*/);
                    }
                }
            }
            // findStartLetter();
            // checkHoriz();
            // checkVert();
            // checkDiag();
        }
    }//end of solve

    private String inBounds(int i, int j)
    {
        if(i<0||!(i<wordSearchLetters.length  &&j<wordSearchLetters[i].length))
        {
            return "1";
        }
        else return wordSearchLetters[i][j];
    }//end of in bounds

    //Prints out the 2D array
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
        //displays the result of the search
        for(String s: wordSearchAnswers)
        {
            if(wordsFound.contains(s))
            {
                result += s + " --- was found\n";
            }
            else result+= s + " --- was NOT found\n";
        }
        return result;
    }//end of toString

    //Converts the String into a 2D array
     private String[][] convertRawWS(String rawWS)
    {

        int count = 0;
        while(rawWS.charAt(count) !='.')
        {
            count++;
            //x value or length of a row
        }

        //Gets the length of a column and refactors the initial string
        int rows = 1+((rawWS.length()-count)/(count+1));
        String[][] wordSearchRefined = new String[rows][count];
        rawWS = rawWS.replace(".", "");
        int allLetters = 0;

        //Populates the 2D array to be returned
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
            }
        }
        return wordSearchRefined;
    }//end of conversion method
}//end of WordSearch
