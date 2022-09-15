package com.serenitydojo;

//import org.junit.Test;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Miscellaneous {

    @Test
    public void excludingChars(){
        String text = "JOD 1234.987";
        String keepCharsOnly = text.replaceAll("[?:^\\d.]", "");
        String keepCharsOnly2 = text.replaceAll("[\\d.]", "");  // To be removed
        String keepCharsOnly3 = text.replaceAll("[\\d\\W]", "");  // To be removed
        String keepNumsOnly = text.replaceAll("[^\\d.]", "");
        String keepNumsOnly2 = text.replaceAll("[^?:\\d.]", ""); // To be removed
        String keepNumsOnly3 = text.replaceAll("[^\\d\\W]", "");  // To be removed
        System.out.println("keepCharsOnly: "+keepCharsOnly);
        System.out.println("keepCharsOnly2: "+keepCharsOnly2); // To be removed
        System.out.println("keepCharsOnly3: "+keepCharsOnly3); // To be removed
        System.out.println("keepNumsOnly: "+keepNumsOnly);
        System.out.println("keepNumsOnly2: "+keepNumsOnly2); // To be removed
        System.out.println("keepNumsOnly3: "+keepNumsOnly3); // To be removed
        double amount = Double.parseDouble(keepNumsOnly);
        System.out.println("Amount is: "+amount);
    }
    @Test
    public void excludingSymbols(){
        String text = "0:N.2'4]6}7";
//        System.out.println("text is: "+text.replaceAll("^\\W", "@"));
//        System.out.println("text split is:"+text.split("^\\W").length);
//
//        System.out.println("text is: "+text.replaceAll("[^\\W]", "@"));
//        System.out.println("text split is:"+text.split("[^\\W]").length);
//
//        System.out.println("text is: "+text.replaceAll("\\W", "@"));
//        System.out.println("text split is:"+text.split("\\W").length);
//
//        System.out.println("text is: "+text.replaceAll("[\\W]", "@"));
//        System.out.println("text split is:"+text.split("[\\W]").length);
//
//        System.out.println("text is: "+text.replaceAll("[^.]", "@"));
//        System.out.println("text split is:"+text.split("[^.]").length);
//
//        System.out.println("text is: "+text.replaceAll("[?:^\\d.^.]", "@"));
//        System.out.println("text split is:"+text.split("[?:^\\d.^.]").length);

//        System.out.println("text is: "+text.replaceAll("[?:.*]", "@"));
//        System.out.println("text split is:"+text.split("[?:.*]").length);

        System.out.println("text is: "+text.replaceAll("[?.*]", "@"));
        System.out.println("text split is:"+text.split("[?.*]").length);

        System.out.println("text is: "+text.replaceAll("[^?.]", "@"));
        System.out.println("text split is:"+text.split("[^?.]").length);

        System.out.println("text is: "+text.replaceAll("[0-9]*", ""));

    }


    @Test
    public void splitingStringAndIterating(){
        String value = "0|1|4|6|20";

        String[] valueString = value.split("\\W");

        for (String desiredValue: valueString) {
            int parsingDesiredValue = Integer.parseInt(desiredValue);
            if(parsingDesiredValue == 4) {
                System.out.println(parsingDesiredValue);
            }
        }

//        List<String> colors = Arrays.asList(valueString);
//        List<String> filteredColors = colors.stream()
//                .filter(color -> color.startsWith("20"))
//                .sorted()
//                .collect(Collectors.toList());
//        System.out.println(filteredColors);


    }

    @Test
    public void keepsCharsOnly(){
        String text = "JOD 1234.987";
        String keepCharsOnly = text.replaceAll("[?:^\\d.]", "");
        System.out.println(keepCharsOnly);
    }

    @Test
    public void keepsNumericValueOnly(){
        String text = "JOD 1234.987";
        String keepNumsOnly = text.replaceAll("[^\\d.]", "");
        System.out.println(keepNumsOnly);
        double amount = Double.parseDouble(keepNumsOnly);
        System.out.println(amount);
    }

    @Test
    public void splitMethod(){
        String x = "A|B|C|D|E";
        String[] z = x.split("\\W");
        StringBuilder b = new StringBuilder();
        StringBuilder fb = new StringBuilder();
        int i  = 0;
        for (String val: z) {

            i = i+1;
            System.out.println(i);
            if(i == z.length) {

            }else {
                b.append(val).append("@");
            }
        }
        String newVal = b.toString();
        String[] hi = newVal.replaceAll("@", "|").split("\\W");
        int h = 0;
        for (String hello: hi) {
            h = h+1;
            if(h != hi.length){
                fb.append(hello).append("|");
            }else {
                fb.append(hello);

            }

        }

        newVal = fb.toString();

        System.out.println(newVal);
    }


    // fibonacci sequence not recommended way
    @Test
    public void fibonacciSequence(){

        ArrayList<Integer> fS = new ArrayList<>();

        int initialValue = 0;
        int previousValue = 1;
        int newValue = 1;

        for (int i = 0; i<=20; i++){

            if(initialValue != 0){
                //do nothing
            }else{
                fS.add(initialValue);
                fS.add(newValue);
            }

            newValue = previousValue + initialValue;
            fS.add(newValue);
            initialValue = previousValue;
            previousValue = newValue;
        }
        System.out.println(fS);
    }


    // fibonacci sequence the results would exceed the counter
    @Test
    public void perfectFibboSolutions(){
        ArrayList<Integer> fs = new ArrayList<>();
        fs.add(0);
        fs.add(1);

        for(int i = 0; i <= 20; i++) {
            int previousValue = fs.size() - 2;
            int lastValue = fs.size() - 1;
            int newValue = fs.get(previousValue) + fs.get(lastValue);
            fs.add(newValue);
        }
        System.out.println(fs);
    }

    // fibonacci sequence the perfect one with retrieving results conforming the counter
    @Test
    public void fibboSequence(){

        int previousValue = 0;
        int lastValue = 0;
        int newValue = 0 ;
        ArrayList<Integer> fs = new ArrayList<>();

        for(int i = 0; i <= 20; i++){
            fs.add(newValue);
             previousValue = fs.size() - 2;
             lastValue = fs.size() - 1;

             try {
                 newValue = fs.get(previousValue) + fs.get(lastValue);
             }catch(Throwable t){
                 previousValue = 0;
                 lastValue = 1;
                 newValue = 1;

             }
        }
        System.out.println(fs);
    }




    ////////// Arrays and random values and histogram
    @Test
    public static int[] randomArray(int size) {
        Random random = new Random();
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        return a;
    }

    @Test
    public static int inRange(int[] a, int low, int high) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= low && a[i] < high) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void countTheNumberOfScoresInEachGradeRange(){

        int[] scores = randomArray(30);
        int a = inRange(scores, 90, 100);
        int b = inRange(scores, 80, 90);
        int c = inRange(scores, 70, 80);
        int d = inRange(scores, 60, 70);
        int f = inRange(scores, 0, 60);

        System.out.println(f);
    }

    @Test
    public void generateRandonMunBetweenGivenVals(){

        List<String> listOfSomething = new ArrayList<>();
        listOfSomething.add("hi");
        listOfSomething.add("bye");

        int index = listOfSomething.size();
        System.out.println(index);

        int high = index;
        int low = 0;
            Random r = new Random();
            int result = r.nextInt(high-low) + low;
            System.out.println(result);
    }


    @Test
    public void splittingPagerText(){
        String currentPage = "6...6";
        System.out.println(currentPage);

        String[] currentPageArray = currentPage.split("\\W");
        int index = currentPageArray.length;
        String realNum = currentPageArray[index-1];


         System.out.println(realNum);
    }



}
