import enums.Gender;
import model.Animal;
import model.Person;
import service.GenericService;
import service.impl.AnimalServiceImpl;
import service.impl.PersonServiceImpl;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GenericService<Person> personService = new PersonServiceImpl();
        GenericService<Animal> animalGenericService = new AnimalServiceImpl();

        List<Person> people = new ArrayList<>();
        people.add(new Person(1L, "Alice", 25, Gender.FEMALE));
        people.add(new Person(2L, "Bob", 30, Gender.MALE));
        people.add(new Person(3L, "Charlie", 22, Gender.MALE));
        people.add(new Person(4L, "David", 35, Gender.MALE));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(1L, "Tiger", 2, Gender.FEMALE));
        animals.add(new Animal(2L, "Dolphin", 1, Gender.MALE));
        animals.add(new Animal(3L, "Giraph", 4, Gender.MALE));
        animals.add(new Animal(4L, "Gerhard", 3, Gender.FEMALE));


        try {
            while (true) {
                System.out.println("1. Adding people: ");

                System.out.println("2. Get People by Id: ");

                System.out.println("3. Get All People: ");

                System.out.println("4. Sort People by name: ");

                System.out.println("5. Filter People byGender: ");

                System.out.println("6. Clear People : ");

                System.out.println("7. Adding animal: ");

                System.out.println("8. Get animal by Id: ");

                System.out.println("9. Get All animals: ");

                System.out.println("10. Sort animal by name: ");

                System.out.println("11. Filter animal byGender: ");

                System.out.println("12. Clear animals : ");

                System.out.println("SELECT METHOD: ");
                int selection = scanner.nextInt();
                scanner.nextLine();

                if (selection == 15) {
                    System.out.println("EXIT ! ");
                    break;
                }

                switch (selection) {
                    case 1 -> {
                        System.out.println("Adding people: " + personService.add(people));
                    }
                    case 2 -> {
                        System.out.println("Get People by Id: " + personService.getById(5L));
                    }
                    case 3 -> {
                        System.out.println("Get All People: " + personService.getAll());
                    }
                    case 4 -> {
                        System.out.println("Sort People by name: " + personService.sortByName());

                    }
                    case 5 -> {
                        System.out.println("Filter People byGender: " + personService.filterByGender());
                    }
                    case 6 -> {
                        System.out.println("Clear People : " + personService.clear());
                    }
                    case 7 -> {
                        System.out.println("Adding animals: " + animalGenericService.add(animals));
                    }
                    case 8 -> {
                        System.out.println("Get by Id animals: " + animalGenericService.getById(1L));
                    }
                    case 9 -> {
                        System.out.println("Get all animals: " + animalGenericService.getAll());
                    }
                    case 10 -> {
                        System.out.println("Sort by name animals: " + animalGenericService.sortByName());
                    }
                    case 11 -> {
                        System.out.println("Filter byGender animals: " + animalGenericService.filterByGender());
                    }
                    case 12 -> {
                        System.out.println("Clear animals: " + animalGenericService.clear());
                    }
                    default -> System.out.println("Method not found!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("It's not numerals!");
        }finally {
            System.out.println("Operation is over!");
        }













    }
}