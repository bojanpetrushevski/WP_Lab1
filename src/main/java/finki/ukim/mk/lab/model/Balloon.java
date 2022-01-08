package finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Balloon {
    String name;
    String description;
    Long id;
    Manufacturer manufacturer;

    public Balloon(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = (long) (Math.random() * 1000);
    }
}
