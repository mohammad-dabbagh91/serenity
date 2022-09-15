package com.serenitydojo.people;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PeopleDatabase {

    List<Person> allThePeople;

    public PeopleDatabase(List<Person> allThePeople) {
        this.allThePeople = allThePeople;
    }

    public List<Person> findPeopleUnder35() {
        List<Person> peopleUnder35 = new ArrayList<>();
        for (Person person: allThePeople) {
            if (person.getAge() < 35){
                peopleUnder35.add(person);
            }
        }
        return peopleUnder35;
    }

    public List<Person> findPeopleWhoLikeRed() {
        List<Person> peopleWhoLikeRed = new ArrayList<>();
        for (Person person: allThePeople) {
            if (person.getFavouriteColor().equalsIgnoreCase("red")){
                peopleWhoLikeRed.add(person);
            }
        }
        return peopleWhoLikeRed;
    }

    public List<Person> findPeopleBetween(int lowestAge, int highestAge) {
        List<Person> matchingPeople = new ArrayList<>();
        for (Person person: allThePeople) {
            if (person.getAge() <= highestAge && person.getAge() >= lowestAge){
                matchingPeople.add(person);
            }
        }
        return matchingPeople;
    }

    public List<Person> findAllThePeopleWho(PersonChecker check) {
        List<Person> matchingPeople = new ArrayList<>();
        for (Person person: allThePeople) {
            if (check.test(person)){
                matchingPeople.add(person);
            }
        }
        return matchingPeople;
    }

    public List<Person> findAllThePeopleWhoPredicate(Predicate check) {
        List<Person> matchingPeople = new ArrayList<>();
        for (Person person: allThePeople) {
            if (check.test(person)){
                matchingPeople.add(person);
            }
        }
        return matchingPeople;
    }

}
