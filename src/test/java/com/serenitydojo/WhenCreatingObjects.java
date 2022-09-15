package com.serenitydojo;

import com.serenitydojo.Cat;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class WhenCreatingObjects {

    @Test
    public void create_a_cat(){

        Cat Katy = new Cat("Katy", 5);

        String catName = Katy.getName();
        System.out.println("Cat's name is: "+catName);
        System.out.println("Katy's FavFood is: "+ Katy.getFavoriteFood());
        System.out.println("Cat's Noise is: "+Katy.makeNoise());

        System.out.println("fedFood is: "+Katy.getFedFood());

    }

    @Test
    public void listOfColors(){

        List<String> myColors = new ArrayList<>();

        myColors.add("Red");
        myColors.add("Crimson");
        myColors.add("Black");
        myColors.add("Red");

        for (String color: myColors) {
            System.out.println("My color is: "+color);
        }

        int indexOfBlackColor = myColors.indexOf("Black");
        System.out.println("indexOfBlackColor is: "+indexOfBlackColor);

        int indexOfRedColor = myColors.indexOf("Red");
        System.out.println("indexOfRedColor is: "+indexOfRedColor);

        int indexOfSecondRedColor = myColors.lastIndexOf("Red");
        System.out.println("indexOfSecondRedColor is: "+indexOfSecondRedColor);

        ///////////////////

        Set<String> myColorsSet = new HashSet<>();

        myColorsSet.add("Red");
        myColorsSet.add("Crimson");
        myColorsSet.add("Black");
        myColorsSet.add("Red");

        for (String colorSet: myColorsSet) {
            System.out.println("My Color Set: "+colorSet);
        }

        Assert.assertTrue(myColorsSet.contains("Crimson"), "mycolorSet doesn't contain Crimson");



    }

    @Test
    public void sortingAList(){
        List<String> names = Arrays.asList("joe", "sally", "pete", "sally", "paul");

        Collections.sort(names);

        System.out.println(names);
    }

    @Test
    public void findingMaxAndMin(){
        List<Integer> ages = Arrays.asList(10, 30, 50, 20, 15);
        System.out.println(Collections.max(ages));
        System.out.println(Collections.min(ages));
    }

    @Test
    public void combiningLists(){
        List<String> names = new ArrayList<>();
        names.add("joe");
        names.add("sally");
        names.add("pete");

        List<String> moreNames = new ArrayList<>();
        moreNames.add("paul");  // OR  names.add("paul");
        moreNames.add("petra"); // OR names.add("petra");

        names.addAll(moreNames);

        System.out.println("names before sorting: "+names);
        Collections.sort(names);
        System.out.println("names after sorting: "+names);
        names.removeAll(moreNames);
        System.out.println("names after detaching moreNames : "+names);

    }

    @Test
    public void creatingAMapMoreConcisely(){

        // The following Map.of is used in Java 9:  Map<String, Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);

        Map<String, Integer> numberOfBallsByColor = new HashMap<>();
        numberOfBallsByColor.put("red", 3);
        numberOfBallsByColor.put("green", 6);
        numberOfBallsByColor.put("blue", 5);

        int numberOfRedBalls = numberOfBallsByColor.get("red");
        //System.out.println("number of red balls is: "+numberOfRedBalls);

        Map<String, Integer> moreColors = new HashMap<>();
        moreColors.put("yellow", 10);
        moreColors.putAll(numberOfBallsByColor);

        System.out.println("moreColors Map is: "+moreColors);
        // moreColors Map is: {red=3, green=6, blue=5, yellow=10} that will be printed

        //System.out.println("Number of colors for white balls is: "+ moreColors.get("white"));
        //Number of colors for white balls is: null
        //System.out.println("Number of colors for white balls is: "+ moreColors.getOrDefault("white", 0));
        //Number of colors for white balls is: 0

        //System.out.println("Purple tennis balls are present: "+moreColors.containsKey("purple"));
        //Purple tennis balls are present: false

        // Replacing Values
        //moreColors.put("yellow", 20);
        //System.out.println("moreColors Map is: "+moreColors);
        // moreColors Map is: {red=3, green=6, blue=5, yellow=20}  The value here got updated

        moreColors.replace("pink", 15);
        //System.out.println("pint value is: "+moreColors.getOrDefault("pink", 0));
        // It will get updated if only is already existed

    }

    @Test
    public void iteratingOverMapKeys(){

        Map<String, Integer> numberOfBallsByColor = new HashMap<>();
        numberOfBallsByColor.put("red", 3);
        numberOfBallsByColor.put("green", 6);
        numberOfBallsByColor.put("blue", 5);

        System.out.println("Keys: "+numberOfBallsByColor.keySet());
        System.out.println("Values: "+numberOfBallsByColor.values());

        for(String key : numberOfBallsByColor.keySet()){

            int numberOfTennisBalls = numberOfBallsByColor.get(key);
            System.out.println("Key is: "+ key + "  value is: "+ numberOfTennisBalls);
        }

        // Another way of doing the exact same as above
        for (Map.Entry<String, Integer> entry : numberOfBallsByColor.entrySet()) {
            System.out.println(entry.getKey()+" => "+entry.getValue());
        }

        // Another way using lambda expression
        numberOfBallsByColor.entrySet().forEach(this::printColorOf);
    }
    private void printColorOf(Map.Entry<String, Integer> stringIntegerEntry) {
        System.out.println("lambda Color: "+ stringIntegerEntry);
    }

    // Removing element from a map


    }



