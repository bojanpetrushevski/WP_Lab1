package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {
    List<Balloon> balloons = new ArrayList<>(List.of(
            new Balloon("Balloon 1", "This is Balloon 1"),
            new Balloon("Balloon 2", "This is Balloon 2"),
            new Balloon("Balloon 3", "This is Balloon 3"),
            new Balloon("Balloon 4", "This is Balloon 4"),
            new Balloon("Balloon 5", "This is Balloon 5"),
            new Balloon("Balloon 6", "This is Balloon 6"),
            new Balloon("Balloon 7", "This is Balloon 7"),
            new Balloon("Balloon 8", "This is Balloon 8"),
            new Balloon("Balloon 9", "This is Balloon 9"),
            new Balloon("Balloon 10", "This is Balloon 10")
    ));

    public List<Balloon> findAllBalloons() {
        return balloons;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        return balloons
                .stream()
                .filter(b -> b.getName().contains(text) || b.getDescription().contains(text))
                .collect(Collectors.toList());
    }
}
