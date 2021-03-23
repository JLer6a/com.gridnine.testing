package ru.budkin.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepositoryy<T> {
    void addNewUser(T entity);
    Optional<T> find(Long id);
    List<T> findAll();
}
