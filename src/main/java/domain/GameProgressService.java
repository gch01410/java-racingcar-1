package domain;

import java.util.ArrayList;
import java.util.List;

public class GameProgressService {
    private GameMovingStrategy strategy;
    private List<Car> cars;

    public GameProgressService(GameMovingStrategy strategy, List<String> names) {
        this.strategy = strategy;
        cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public GameResult raceByRound(GameResult gameResult) {
        List<Car> racingCars = cars;

        if (gameResult != null) {
            racingCars = gameResult.getCars();
        }

        for (Car car : racingCars) {
            car.move(strategy.getMovingNum());
        }

        return new GameResult(racingCars);
    }
}
