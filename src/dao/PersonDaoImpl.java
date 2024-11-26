package dao;

import enums.Gender;
import model.Person;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PersonDaoImpl implements GenericDao<Person> {

    private List<Person> people = new ArrayList<>();


    @Override
    public String add(List<Person> newPerson) {
        people.addAll(newPerson);
        return "Ийгиликтуу кошулду !";
    }


    @Override
    public Person getById(Long id) {
        try{
        for (Person person : people) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        throw new IllegalArgumentException("Мындай  " + id + " ID де адам табылган жок.");
    }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }return null;
    }


    @Override
    public List<Person> getAll() {
        return new ArrayList<>(people);
    }

    @Override
    public List<Person> sortByName() {
        List<Person> sortedPeople = new ArrayList<>(people);

        System.out.println("1- баскычта ascending, 2- баскычта descending :");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            sortedPeople.sort(new Comparator<Person>() {
                @Override
                public int compare(Person p1, Person p2) {
                    return p1.getName().compareTo(p2.getName());
                }
            });
        } else if (choice == 2) {
            sortedPeople.sort(new Comparator<Person>() {
                @Override
                public int compare(Person p1, Person p2) {
                    return p2.getName().compareTo(p1.getName());
                }
            });
        } else {
            System.out.println("Туура танданыз! ");
            sortedPeople.sort(new Comparator<Person>() {
                @Override
                public int compare(Person p1, Person p2) {
                    return p1.getName().compareTo(p2.getName());
                }
            });
        }

        return sortedPeople;
    }


    @Override
    public List<Person> filterByGender() {
        System.out.println("1- баскычта Female , 2- баскычта Male:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        Gender selectedGender;

        if (choice == 1) {
            selectedGender = Gender.FEMALE;
        } else if (choice == 2) {
            selectedGender = Gender.MALE;
        } else {
            System.out.println("Ийгиликсиз болду. Кайра 1- баскычта Female , 2- баскычта Male: ");
            return new ArrayList<>();
        }

        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender() == selectedGender) {
                filteredPeople.add(person);
            }
        }

        return filteredPeople;
    }



    @Override
    public List<Person> clear() {
        people.clear();
        System.out.println("Ийгиликтуу очурулду");
        return new ArrayList<>();
    }
}
