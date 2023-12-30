package io.matheusVictor.domain.usecases;

import io.matheusVictor.domain.dto.PixDTO;
import io.matheusVictor.domain.entities.PixBO;
import io.matheusVictor.domain.mappers.PixMapper;
import io.matheusVictor.domain.repositories.PixRepository;

public class CreatePix {
    private PixRepository repository;

    public CreatePix(PixRepository repository) {
        this.repository = repository;
    }

    public PixDTO execute(PixDTO dto) {
        PixBO pixBO = PixMapper.toBO(dto);
        PixDTO createdPix = repository.create(dto);
        pixBO.updateEmvData(createdPix.getEmv(), createdPix.getBase64(), createdPix.getExpiration());
        return createdPix;
    }
}
