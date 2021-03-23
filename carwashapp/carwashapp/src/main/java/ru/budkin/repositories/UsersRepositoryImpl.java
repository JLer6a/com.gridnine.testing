package ru.budkin.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.budkin.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component(value = "usersRepositoryImpl")
public class UsersRepositoryImpl implements UsersRepository {

    @Autowired
    public DataSource dataSource;

    //Language = SQL
    public static final String SQL_FIND_BY_EMAIL = "select * from simple_user where email ilike ?";

    //Language = SQL
    public static final String SQL_ADD_USER = "insert into simple_user (email, password, username) values (?,?,?)";

    //Language = SQL
    public static final String SQL_FIND_BY_ID = "select * from simple_user where id = ?";

    //Language = SQL
    public static final String SQL_FIND_ALL = "select * from simple_user";

    @Override
    public List<User> findByEmail(String emailPattern) {

        Connection connection = null;
        PreparedStatement statement  = null;
        ResultSet result = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_EMAIL);
            statement.setString(1, "%" + emailPattern + "%");

            result = statement.executeQuery();

            List<User> users = new ArrayList<>();

            while (result.next()){
                User user = User.builder()
                        .id(result.getInt("id"))
                        .email(result.getString("email"))
                        .confirmCode(result.getString("confirmcode"))
                        .password(result.getString("password"))
                        .build();

                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ignored) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {
                }
            }
        }

    }

    @Override
    public void addNewUser(User entity) {

        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_ADD_USER);
            statement.setString(1,entity.getEmail());
            statement.setString(2, entity.getPassword());
            statement.setString(3,entity.getName());

            statement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ignored) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {
                }
            }
        }

    }

    @Override
    public Optional<User> find(Long id) {
        Connection connection = null;
        PreparedStatement statement  = null;
        ResultSet result = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1,id);
            result = statement.executeQuery();

            if (result.next()){
                User user = User.builder()
                        .id(result.getInt("id"))
                        .email(result.getString("email"))
                        .confirmCode(result.getString("confirmcode"))
                        .password(result.getString("password"))
                        .build();

                return Optional.of(user);
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ignored) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }

    @Override
    public List<User> findAll() {
        Connection connection = null;
        PreparedStatement statement  = null;
        ResultSet result = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_FIND_ALL);
            result = statement.executeQuery();

            List<User> users = new ArrayList<>();

            while (result.next()){
                User user = User.builder()
                        .id(result.getInt("id"))
                        .email(result.getString("email"))
                        .confirmCode(result.getString("confirmcode"))
                        .password(result.getString("password"))
                        .build();

                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ignored) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignored) {
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ignored) {
                }
            }
        }
    }
}


