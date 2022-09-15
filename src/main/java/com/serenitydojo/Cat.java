package com.serenitydojo;

import com.serenitydojo.model.AnimalType;
import com.serenitydojo.model.Feeder;
import com.serenitydojo.model.FoodType;

public class Cat extends Pet{

    private String favoriteFood;
    private int age;

    public static String usualFood(){return "tuna";}

    Feeder feedCat = new Feeder();

    private FoodType fedFood;

    public Cat(String name, int age){

        super(name);
        this.age = age;
        this.favoriteFood = usualFood();

        fedFood = feedCat.feeds(AnimalType.CAT, true);

    }


    public FoodType getFedFood(){
        return fedFood;
    }

    @Override
    public String makeNoise(){return "Meow";}

    public String getFavoriteFood(){
        return favoriteFood;
    }




}
