package finki.ukim.mk.lab.service;

import finki.ukim.mk.lab.model.Balloon;
import java.util.List;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
}
