package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<Car> winners;

    public GameResult(List<Car> winners) {
        this.winners = winners;
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .map(Name::toString)
                .collect(Collectors.toList());
    }

    public int getWinnersPosition() {
        return winners.get(0).getPositionIndex();
    }
}