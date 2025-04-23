package org.example; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarInventory {

    Map<String, Car> carMap = new HashMap<>();

    public CarInventory() {
      
    }

    public void addCar(Car car) {
        if (car == null || carMap.containsKey(car.getModel())) {
            throw new IllegalArgumentException();
        }
        carMap.put(car.getModel(), car);
    }

    public Car getCar(String model) {
        if (carMap.containsKey(model)) {
            return carMap.get(model);
        }
        else {
            return null;
        }
    }

    public Car sellCar(String model) {
      Car foundCar = carMap.get(model);

      if (foundCar != null) {
          carMap.remove(model);
          return foundCar;
      }
      else {
          return null;
      }
    }

    public void updateCarPrice(String model, double newPrice) {
      Car foundCar = carMap.get(model);

      if (foundCar != null) {
          foundCar.setPrice(newPrice);
      }
    }

    public List<Car> findCarsByMake(String make) {
        List<Car> filteredCars = new ArrayList<>();

        carMap.forEach((key, value) -> {
            if (value.getMake().equals(make)) {
                filteredCars.add(carMap.get(key));
            }
        });
        return filteredCars;
    }

    public int getCarCount() {
        return carMap.size();
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );


    }
}