package com.serenitydojo.people;

public class LikeGreen implements PersonChecker{
        public boolean test(Person person){
            return (person.getFavouriteColor().equals("Green"));
        }
    }