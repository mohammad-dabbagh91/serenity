package com.serenitydojo.people;

import com.serenitydojo.people.*;
import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.serenitydojo.people.Person.Gender.FEMALE;
import static com.serenitydojo.people.Person.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;


public class PersonTest {

        Person sam = new Person("Sam", FEMALE, 30, "Green");
        Person bill = new Person("Bill", MALE, 40, "Blue");
        Person tim = new Person("Tim", MALE, 10, "Red");
        Person suzan = new Person("Suzan", FEMALE, 40, "Red");
        Person johnny = new Person("Johnny", MALE, 58, "Blue");

//        List<Person> people = new ArrayList<>();
//        people.add(sam);
//        people.add(bill);
//        people.add(tim);
//        people.add(suzan);


        List<Person> allThePeople = Arrays.asList(sam, bill, tim, suzan, johnny);


    @Test
    public void ICanSearchForPeopleByAge(){
        // Search for people under 35

        PeopleDatabase people = new PeopleDatabase(allThePeople);

        List<Person> peopleUnder35 = people.findPeopleUnder35();

        System.out.println(peopleUnder35);
        assertThat(peopleUnder35).contains(sam, tim);
    }

    @Test
    public void ICanSearchForPeopleBetween20And40(){
        PeopleDatabase people = new PeopleDatabase(allThePeople);
        List<Person> matchingPeople = people.findPeopleBetween(20, 40);
        System.out.println(matchingPeople);
        assertThat(matchingPeople).contains(sam, bill, suzan);
    }

    @Test
    public void ICanSearchForPeopleWhoLikeRed(){
        PeopleDatabase people = new PeopleDatabase(allThePeople);
        List<Person> peopleWhoLikeRed = people.findPeopleWhoLikeRed();
        System.out.println(peopleWhoLikeRed);
        assertThat(peopleWhoLikeRed).contains(tim, suzan);
    }

    @Test
    public void ICanSearchForPeopleWhoLikeRedOrWhoAre30orUnder(){
        PeopleDatabase people = new PeopleDatabase(allThePeople);
        LikeRedOrUnder30 likeRedOrUnder30 = new LikeRedOrUnder30();
        List<Person> matchingPeople = people.findAllThePeopleWho(likeRedOrUnder30);
        System.out.println(matchingPeople);
        assertThat(matchingPeople).contains(sam, tim, suzan);
    }

    @Test
    public void ICanSearchForPeopleWhoLikeGreen(){
        PeopleDatabase people = new PeopleDatabase(allThePeople);
        LikeGreen likeGreen= new LikeGreen();
        List<Person> matchingPeople = people.findAllThePeopleWho(likeGreen);
        System.out.println(matchingPeople);
        assertThat(matchingPeople).contains(sam);
    }

    @Test // Lambda here
    public void ICanSearchForPeopleWhoLikeBlue(){
        PeopleDatabase people = new PeopleDatabase(allThePeople);

//        PersonChecker likeBlue= new PersonChecker() {
//            @Override // Creating Anonymous class
//            public boolean test(Person person) {
//                return (person.getFavouriteColor().equals("Blue"));
//            }
//        };

        PersonChecker likeBlue= person -> (person.getFavouriteColor().equals("Blue"));

        List<Person> matchingPeople = people.findAllThePeopleWho(likeBlue);
        System.out.println(matchingPeople);
        assertThat(matchingPeople).contains(bill, johnny);
    }

    @Test
    public void searchForPeopleWhoAreAbove50(){
        PeopleDatabase people = new PeopleDatabase(allThePeople);

        PersonChecker peopleAbove50 = person -> person.getAge() >= 50;
        //Predicate<Person> peopleAbove50 = person -> person.getAge() >= 50;

        List<Person> peopleAbove50Are = people.findAllThePeopleWho(peopleAbove50);
        System.out.println(peopleAbove50Are);
        assertThat(peopleAbove50Are).containsExactly(johnny);
    }

    @Test
    public void searchForPeopleWhoAdoreRedColor(){
        PeopleDatabase people = new PeopleDatabase(allThePeople);
        Predicate<Person> peopleWhoAdoreRedColor = person -> person.getFavouriteColor().equalsIgnoreCase("red");
        List<Person> peopleWhoAdoreRedColorAre = people.findAllThePeopleWhoPredicate(peopleWhoAdoreRedColor);
        System.out.println(peopleWhoAdoreRedColorAre);

    }

    // Streams go here
    @Test
    public void peopleCanEarnPoints(){
        allThePeople.parallelStream().forEach(
                        person -> {
                            person.earnPoints(100);
                            System.out.println("POINTS FOR " + person.getName() + " = " + person.getPoints());
                        }
        );

    }


    @Test
    public void peopleCanEarnPointsPeaks(){
        allThePeople.stream()
                .peek(person ->  System.out.println("POINTS FOR " + person.getName() + " = " + person.getPoints()))
                .peek(person ->  person.earnPoints(100))
                .forEach(person -> System.out.println("UPDATED POINTS FOR " + person.getName() + " = " + person.getPoints()));
    }


    @Test
    public void peopleCanEarnPointsExtracting(){
       List<String> allTheColors = allThePeople.stream()
                .map(Person::getFavouriteColor) // .map(person -> person.getFavouriteColor())
                .sorted() //.sorted(Comparator.reverseOrder()) //.sorted(Comparator.naturalOrder()) //.sorted(Comparator.comparing(color -> color.length()))
                .distinct()
            .collect(Collectors.toList());

        System.out.println(allTheColors);

    }

    @Test
    public void peopleCanEarnPointsConvertingToIntAndGettingSum(){
        int allTheColors = allThePeople.stream()
                .map(Person::getFavouriteColor) // .map(person -> person.getFavouriteColor())
                .sorted() //.sorted(Comparator.reverseOrder()) //.sorted(Comparator.naturalOrder()) //.sorted(Comparator.comparing(color -> color.length()))
                .distinct()
                .mapToInt(color -> color.length())
                .sum();

        System.out.println(allTheColors);

    }

    @Test
    public void peopleCanEarnPointsConvertingToIntAndGettingMaxOrMin(){
        OptionalInt allTheColors = allThePeople.stream()
                .map(Person::getFavouriteColor) // .map(person -> person.getFavouriteColor())
                .filter(color -> color.equals("pink"))
                .sorted() //.sorted(Comparator.reverseOrder()) //.sorted(Comparator.naturalOrder()) //.sorted(Comparator.comparing(color -> color.length()))
                .distinct()
                .mapToInt(color -> color.length())
                .max();  //.min();

        System.out.println(allTheColors);

    }




}
