package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.model.Balloon;
import finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {

    private final ManufacturerRepository manufacturerRepository;

    public BalloonRepository(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

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

    public void saveBalloon(Long id, String name, String description, Long manufacturerId){
        Optional<Manufacturer> manufacturer = manufacturerRepository.getManufacturerById(manufacturerId);

        if (manufacturer.isPresent()) {

            Optional<Balloon> existingBalloon = balloons.stream().filter(b -> b.getId().equals(id)).findFirst();

            if (existingBalloon.isPresent()) {
                existingBalloon.get().setName(name);
                existingBalloon.get().setDescription(description);
                existingBalloon.get().setManufacturer(manufacturer.get());
            }
            else {
                Balloon newBalloon = new Balloon(name, description);
                newBalloon.setManufacturer(manufacturer.get());
                balloons.add(newBalloon);
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void deleteBalloon(Long id) {
        balloons.removeIf(b -> b.getId().equals(id));
    }

    public Optional<Balloon> getBalloonById(Long id){
        return balloons.stream().filter(b -> b.getId().equals(id)).findFirst();
    }
}
