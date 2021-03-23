//package ru.budkin;
//
//import ru.budkin.model.Car;
//import ru.budkin.repositories.CarRepositoryImpl;
//
//import java.time.LocalTime;
//import java.util.HashSet;
//import java.util.Scanner;
//import java.util.Set;
//
//public class Main {
//    public static void main(String[] args) {
//
//        CarRepositoryImpl serviceWork = new CarRepositoryImpl();
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Введите время когда ");
//        String time = sc.next();
//        LocalTime inputTime = LocalTime.parse(time);
//        String service = sc.next();
//
//        switch (service){
//            case ("помыть"):
//                serviceWork.washCar();
//                break;
//            case ("полировать"):
//                serviceWork.polishCar();
//                break;
//            case ("пылесосить"):
//                serviceWork.vacuumCar();
//                break;
//            default:
//                System.out.println("Напишите услугу");
//                break;
//
//        }
//
//        Set<Car> set = new HashSet<>();
//
//        Car car = new Car(1,inputTime, service);
//        Car car1 = new Car(1,inputTime, service);
//
//        set.add(car);
//        set.add(car1);
//
//        System.out.println(car);
//    }
//}
