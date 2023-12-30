package io.matheusVictor.infra.mercadopago.repository;

import io.matheusVictor.infra.mercadopago.dto.MpPixDTO;
import io.matheusVictor.infra.mercadopago.dto.MpPixResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@ApplicationScoped
@RegisterRestClient(baseUri = "https://api.mercadopago.com/v1")
public interface RestClientMp {

    @POST
    @Path("/payments")
    @Consumes(MediaType.APPLICATION_JSON)
    MpPixResponse createPix(
            @HeaderParam("Authorization") String token,
            @HeaderParam("X-Idempotency-Key") String idempotency,
            MpPixDTO payload
    );
}
