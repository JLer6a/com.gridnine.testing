package ru.budkin.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void addNewCar(T entity);
    Optional<T> find(Long id);
    List<T> findAll();
}
