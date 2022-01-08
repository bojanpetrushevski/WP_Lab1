package finki.ukim.mk.lab.service.impl;

import finki.ukim.mk.lab.model.Manufacturer;
import finki.ukim.mk.lab.repository.BalloonRepository;
import finki.ukim.mk.lab.repository.ManufacturerRepository;
import finki.ukim.mk.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> listAll() {
        return this.manufacturerRepository.findAll();
    }
}
