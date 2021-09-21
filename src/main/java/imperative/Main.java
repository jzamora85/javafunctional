package imperative;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Jorge", Gender.MALE, 36),
                new Person("YAEL", Gender.FEMALE, 30)
        );

        List<Person> females = new ArrayList<>();

        for(Person person: people) {
          if(Gender.FEMALE.equals(person.gender)){
              females.add(person);
          }
        }

        for(Person female: females) {
            System.out.println(female);
        }

        people.stream().filter(person -> (Gender.FEMALE.equals(person.gender))).forEach(System.out::println);

        List<Person> people1 = people.stream().filter(person -> Gender.FEMALE.equals(person.gender)).collect(Collectors.toList());

        people1.forEach(System.out::println);

        System.out.println("List sorted");
        people.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList()).forEach(System.out::println);

        people.stream().max( Comparator.comparing(Person::getAge) ).ifPresent(System.out::println);

        System.out.println(people.stream().anyMatch(person -> person.getName().equals("Jorgito")));

    }

    static class Person {
        private final String name;
        private final Gender gender;
        private final Integer age;

        public Person(String name, Gender gender, Integer age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    ", age=" + age +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
