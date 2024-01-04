package io.matheusVictor.infra.mercadopago.service;

import io.matheusVictor.domain.dto.PixDTO;
import io.matheusVictor.domain.usecases.CreatePix;
import io.matheusVictor.infra.mercadopago.repository.MpPixRepository;
import io.matheusVictor.service.PixService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PixServiceImpl implements PixService {

    @Inject
    MpPixRepository mpPixRepository;

    @Override
    public PixDTO genPix(PixDTO dto) {
        CreatePix createPix = new CreatePix(mpPixRepository);
        return createPix.execute(dto);
    }
}
