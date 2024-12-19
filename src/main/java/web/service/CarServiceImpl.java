package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars;

    public CarServiceImpl() {
        cars = Arrays.asList(
                new Car("KIA", 10, 1),
                new Car("BMW", 20, 2),
                new Car("Ford", 30, 3),
                new Car("Volvo", 40, 4),
                new Car("Nissan", 50, 5)
        );
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count >= cars.size() || count < 1) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }

}
