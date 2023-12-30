package io.matheusVictor.service;

import io.matheusVictor.domain.dto.PixDTO;
import io.matheusVictor.domain.usecases.CreatePix;
import io.matheusVictor.infra.mercadopago.repository.MpPixRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixService {

    @Inject
    MpPixRepository mpPixRepository;

    public PixDTO genPix(PixDTO dto) {
        CreatePix createPix = new CreatePix(mpPixRepository);
        return createPix.execute(dto);
    }
}
