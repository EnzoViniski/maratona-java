package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Aula193_ComportamentoPorParametroTest01 {
    private static List<Car> cars = List.of(new Car("green", 2011), new Car("black", 1998), new Car("red", 2019));

    public static void main(String[] args) {
        System.out.println(filteredGreenCar(cars));
        System.out.println(filteredRedCar(cars));
        System.out.println(filteredByColor(cars, "green"));
        System.out.println(filteredByColor(cars, "red"));
        System.out.println("-----");
        System.out.println("Carros de 2015 para tras:");
        System.out.println(filteredByYear(cars, 2015));
    }

    private static List<Car> filteredGreenCar(List<Car> cars){
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars){
            if (car.getColor().equals("green")){
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }

    private static List<Car> filteredRedCar(List<Car> cars){
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars){
            if (car.getColor().equals("red")){
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }

    private static List<Car> filteredByColor(List<Car> cars, String color){
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars){
            if (car.getColor().equals(color)){
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }

    private static List<Car> filteredByYear(List<Car> cars, int year){
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars){
            if (car.getYear() < year){
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }


}
