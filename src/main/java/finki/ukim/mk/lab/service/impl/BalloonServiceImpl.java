package finki.ukim.mk.lab.service.impl;

import finki.ukim.mk.lab.model.Balloon;
import finki.ukim.mk.lab.repository.BalloonRepository;
import finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return this.balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Invalid value of argument");
        }

        return this.balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public void save(Long id, String name, String description, Long manufacturerId) {
        this.balloonRepository.saveBalloon(id, name, description, manufacturerId);
    }

    @Override
    public void delete(Long id) {
        this.balloonRepository.deleteBalloon(id);
    }

    @Override
    public Balloon getBalloonById(Long id) {
        return this.balloonRepository.getBalloonById(id).orElseThrow();
    }
}
