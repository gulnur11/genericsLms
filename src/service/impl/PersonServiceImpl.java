package service.impl;

import dao.GenericDao;
import dao.PersonDaoImpl;
import model.Person;
import service.GenericService;

import java.util.List;

public class PersonServiceImpl implements  GenericService<Person> {

    private final GenericDao<Person> genericDao = new PersonDaoImpl();


    @Override
    public String add(List<Person> newPerson) {
        return genericDao.add(newPerson);
    }

    @Override
    public Person getById(Long id) {
        return genericDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return genericDao.getAll();
    }

    @Override
    public List<Person> sortByName() {
        return genericDao.sortByName();
    }

    @Override
    public List<Person> filterByGender() {
        return genericDao.filterByGender();
    }

    @Override
    public List<Person> clear() {
        return genericDao.clear();
    }





}
