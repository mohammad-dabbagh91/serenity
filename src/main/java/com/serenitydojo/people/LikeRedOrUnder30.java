package com.serenitydojo.people;

public class LikeRedOrUnder30 implements PersonChecker{
        public boolean test(Person person){
            return (person.getFavouriteColor().equals("Red")
                    || person.getAge() <= 30
            );
        }
    }