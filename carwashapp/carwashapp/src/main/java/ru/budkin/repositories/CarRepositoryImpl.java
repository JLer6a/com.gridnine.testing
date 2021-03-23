package ru.budkin.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.budkin.model.Car;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CarRepositoryImpl implements CarRepository {


    @Autowired
    public DataSource dataSource;

    //Language = SQL
    public static final String SQL_FIND_BY_ID = "select * from carwash where id = ?";

    //Language = SQL
    public static final String SQL_FIND_ALL = "select * from carwash";

    //Language = SQL
    public static final String SQL_ADD_CAR = "insert into carwash (number_car, time_time, service_work) values (?,?,?)";

//
//    public void washCar() {
//        System.out.println("Помыть машину");
//    }
//
//    public void polishCar() {
//        System.out.println("Полировать машину");
//    }
//
//    public void vacuumCar() {
//        System.out.println("Пылесосить машину");
//    }

    @Override
    public void addNewCar(Car entity) {
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_ADD_CAR);
            statement.setInt(1,entity.getNumber());
            statement.setString(2, entity.getTime());
            statement.setString(3,entity.getService());

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
    public Optional<Car> find(Long id) {
        Connection connection = null;
        PreparedStatement statement  = null;
        ResultSet result = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1,id);
            result = statement.executeQuery();

            if (result.next()){
                Car car = Car.builder()
                        .id(result.getInt("id"))
                        .number(result.getInt("number_car"))
                        .time(result.getString("time_time"))
                        .service(result.getString("service_work"))
                        .build();

                return Optional.of(car);
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
    public List<Car> findAll() {
        Connection connection = null;
        PreparedStatement statement  = null;
        ResultSet result = null;

        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement(SQL_FIND_ALL);
            result = statement.executeQuery();

            List<Car> users = new ArrayList<>();

            while (result.next()){
                Car car = Car.builder()
                        .id(result.getInt("id"))
                        .number(result.getInt("number_car"))
                        .time(result.getString("time_time"))
                        .service(result.getString("service_work"))
                        .build();
                users.add(car);
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

