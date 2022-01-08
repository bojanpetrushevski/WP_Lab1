package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ManufacturerRepository {
    List<Manufacturer> manufacturers = new ArrayList<>(List.of(
            new Manufacturer("M1", "C1", "A1"),
            new Manufacturer("M2", "C2", "A2"),
            new Manufacturer("M3", "C3", "A3"),
            new Manufacturer("M4", "C4", "A4"),
            new Manufacturer("M5", "C5", "A5"),
            new Manufacturer("M6", "C6", "A6"),
            new Manufacturer("M7", "C7", "A7"),
            new Manufacturer("M8", "C8", "A8"),
            new Manufacturer("M9", "C9", "A9"),
            new Manufacturer("M10", "C10", "A10")
    ));

    public List<Manufacturer> findAll() {
        return manufacturers;
    }

    public Optional<Manufacturer> getManufacturerById(Long id){
        return manufacturers.stream().filter(m -> m.getId().equals(id))
                .findFirst();
    }
}
