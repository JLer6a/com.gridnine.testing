package ru.budkin.repositories;

import ru.budkin.model.User;

import java.util.List;

public interface UsersRepository extends CrudRepositoryy<User> {

    List<User> findByEmail (String emailPattern);
}
