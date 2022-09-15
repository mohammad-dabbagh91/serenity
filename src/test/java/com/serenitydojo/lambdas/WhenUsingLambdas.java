package com.serenitydojo.lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WhenUsingLambdas {

    @Test
    public void printingOutColors(){
        List<String> colors = Arrays.asList("red", "green", "blue");

        /*for (String color: colors){
            printColorOf(color);
        }*/

        //colors.forEach(this:: printColorOf);
        //colors.forEach(color -> printColorOf(color));

        //colors.forEach(color -> System.out.println("Color: "+color));

        colors.forEach(
                color -> {
                    if(color.equals("red"))
                        System.out.println("It's RED!");
                    else
                        System.out.println(color);
                }

        );


    }

    public void printColorOf(String color){
        System.out.println("Color: "+color);
    }

    /////////////////////////////////////////////////

    @Test
    public void filteringColors(){
        List<String> colors = Arrays.asList("red", "blue", "grey-blue", "grey", "green", "gritty white");

        colors.stream()
                .filter(color -> color.startsWith("g"))
                .forEach(color ->  System.out.println("Color: "+color));


        List<String> filteredColors = colors.stream()
                .filter(color -> color.startsWith("g"))
                .map(color -> color.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(filteredColors);

    }


    @Test
    public void filndingMinLength(){
        List<String> colors = Arrays.asList("red", "blue", "grey-blue", "grey", "green", "gritty white");

        Optional<Integer>  minLength = colors.stream()
                .filter(color -> color.startsWith("g"))
                .map(String::length) // map(color -> color.length())
                .sorted()
                .findFirst();

        System.out.println(minLength);

        // OR I can say
        minLength.ifPresent(
                length -> System.out.println(length)
        );

    }

    @Test
    public void filndingMinLengthAnotherWay(){
        List<String> colors = Arrays.asList("red", "blue", "grey-blue", "grey", "green", "gritty white");

        Integer minLength = colors.stream()
                .filter(color -> color.startsWith("g"))
                .map(String::length) // map(color -> color.length())
                .sorted()
                .findFirst()
                .orElse(0);

        System.out.println(minLength);
    }

    @Test
    public void findingShortestColor(){
        List<String> colors = Arrays.asList("red", "blue", "grey-blue", "grey", "green", "gritty white");

        String shortesColor = colors.stream()
                .filter(color -> color.startsWith("g"))
                //.map(String::length) // map(color -> color.length())
                .map(String::toUpperCase) // .map(color -> color.toUpperCase())
                .sorted()
                .findFirst()
                .orElse("unknown");

        System.out.println(shortesColor);
    }

}
