package service.impl;

import dao.AnimalDaoImpl;
import dao.GenericDao;
import model.Animal;
import service.GenericService;

import java.util.ArrayList;
import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal> {

    private final GenericDao<Animal> genericDao = new AnimalDaoImpl();

 @Override
    public String add(List<Animal> animal) {
            return genericDao.add(animal);

    }

    @Override
    public Animal getById(Long id) {
        return genericDao.getById(id);
    }

    @Override
    public List<Animal> getAll() {
        return genericDao.getAll();
    }

    @Override
    public List<Animal> sortByName() {
        return genericDao.sortByName();
    }

    @Override
    public List<Animal> filterByGender() {
        return genericDao.filterByGender();
    }

    @Override
    public List<Animal> clear() {
        return genericDao.clear();
    }




}
