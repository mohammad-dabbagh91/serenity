package com.serenitydojo.exceptions;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class WhenWorkingWithExceptions {

    @Test
    public void shouldCountTheWordsInAString(){

        WordCounter wordCounter = new WordCounter();

        int numberOfWords = wordCounter.numberOfWordsIn("Some String");

        assertThat(numberOfWords).isEqualTo(2);

    }

    @Test
    public void shouldReturnZeroForANullString(){
        WordCounter wordCounter = new WordCounter();
        int numberOfWords = wordCounter.numberOfWordsIn(null);
        assertThat(numberOfWords).isEqualTo(0);
    }

    @Test
    public void shouldCountWordsInAFile() throws Exception{
        WordCounter wordCounter = new WordCounter();
        int numberOfWords = wordCounter.numberOfWordsInFile("src/main/resources/hello.txt");
        System.out.println(numberOfWords);
    }

    @Test//(expected = FileHasNoWordException.class)
    public void shouldReportAnErrorIfTheFileDoesNotExist()throws Exception{

            WordCounter wordCounter = new WordCounter();
            int numberOfWords = wordCounter.numberOfWordsInFile("file-does-not-exist.txt");
            System.out.println(numberOfWords);
    }

    @Test(expected = FileHasNoWordException.class)  // Remove the expected and the exception will be thrown
    public void shouldThrowMeaningFulExceptionIfThereAreNoWordsInTheFile() throws Exception{
        WordCounter wordCounter = new WordCounter();
        int numberOfWords = wordCounter.numberOfWordsInFile("src/main/resources/no_words.txt");
        System.out.println(numberOfWords);
    }

    @Test(expected = FileHasNoWordException.class)
    public void noWordsFoundInTheFile() throws Exception{
        WordCounter wordCounter = new WordCounter();
        wordCounter.now("src/main/resources/no_words.txt");
    }





    // For me Stream and Regex
    @Test
    public void testing(){
        WordCounter wordCounter = new WordCounter();
        wordCounter.words("0|02|1|20|3|4", "02");

    }


   
}
