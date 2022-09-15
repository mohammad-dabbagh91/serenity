package com.serenitydojo.model;

public class Feeder {

    public FoodType feeds(AnimalType animal, boolean isPremium) {

        /*
        if (animal.equals("Cat")) {
            return(isPremium) ? "Salmon": "Tuna";
        } else if (animal.equals("Dog")) {
            return(isPremium) ? "Deluxe Dog Food": "Dog Food";
        } else {
            return(isPremium) ? "Lettuce": "Cabbage";
        }*/

        switch (animal) {
            case CAT:
                return(isPremium) ? FoodType.SALMON : FoodType.TUNA;

            case DOG:
                return(isPremium) ? FoodType.DELUXE_DOG_FOOD : FoodType.DOG_FOOD;

            default:
                return(isPremium) ? FoodType.LETTUCE : FoodType.CABBAGE;
        }
    }
}
