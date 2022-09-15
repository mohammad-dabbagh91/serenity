package com.serenitydojo.exceptions;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.Files.*;

public class WordCounter {

    public int numberOfWordsIn(String value) {
        if(value == null){
            return 0;
        }else {
            return value.split("\\W").length;
        }
    }

    public int numberOfWordsInFile(String filename) throws IOException{
        try{
        String fileContents = Files.readString(Paths.get(filename));
            System.out.println("got in try");
            int wordCount =  numberOfWordsIn(fileContents);
            if(wordCount == 0){
                throw new FileHasNoWordException("No words found in the file "+filename);
            }
            return wordCount;

        }catch (NoSuchFileException noSuchFile) {
            System.out.println("got in NoSuchFileException catch");
            throw new FileHasNoWordException("No words found in the non-existant file " + filename);
        }
    }




    public int now(String filename) throws IOException {
        String fileContents = Files.readString(Paths.get(filename));
        int wordCount =  numberOfWordsIn(fileContents);
        if(wordCount == 0) {
            throw new FileHasNoWordException("No words found in the file");
        }
        return 0;
    }





    // For me Stream and Regex
    public void words(String value, String num){

        int times = value.split("\\W").length;
        int index = times - 1;

        for(int start = 0 ; start<=index; start++ ){

            String values = value.split("\\W")[start];

            if(values.equals(num)){
                System.out.println(values + " its index: "+ start);
                break;
            }
        }

       //Arrays.stream(value.split("\\W")).iterator();

        //Pattern pattern = Pattern.compile("\\W", Pattern.CASE_INSENSITIVE);
        //Matcher matcher = pattern.matcher(value);

        }



}

