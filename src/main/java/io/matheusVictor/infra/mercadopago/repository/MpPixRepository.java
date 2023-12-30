package io.matheusVictor.infra.mercadopago.repository;

import io.matheusVictor.domain.dto.PixDTO;
import io.matheusVictor.domain.repositories.PixRepository;
import io.matheusVictor.infra.mercadopago.dto.MpPixDTO;
import io.matheusVictor.infra.mercadopago.dto.MpPixPayerDTO;
import io.matheusVictor.infra.mercadopago.dto.MpPixResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.UUID;

@ApplicationScoped
public class MpPixRepository implements PixRepository {

    @Inject
    @RestClient
    RestClientMp restClientMp;

    @ConfigProperty(name = "mp.token")
    String mpToken;

    private final String MP_PAYMENT_ID = "pix";


    @Override
    public PixDTO create(PixDTO dto) {
        String token = "Bearer ".concat(mpToken);
        String idempotencyKey = UUID.randomUUID().toString();

        MpPixPayerDTO payerDTO = new MpPixPayerDTO();
        MpPixDTO pixDTO = new MpPixDTO();
        payerDTO.setEmail(dto.getEmail());

        pixDTO.setAmount(dto.getAmount());
        pixDTO.setDescription(dto.getDescription());
        pixDTO.setPaymentMethodId(MP_PAYMENT_ID);
        pixDTO.setPayer(payerDTO);

        MpPixResponse response = restClientMp.createPix(token, idempotencyKey, pixDTO);

        dto.setEmv(response.getPoi().getTrxData().getEmv());
        dto.setBase64(response.getPoi().getTrxData().getBase64());

        return dto;
    }
}
