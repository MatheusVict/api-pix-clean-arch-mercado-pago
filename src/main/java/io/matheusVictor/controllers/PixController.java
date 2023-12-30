package io.matheusVictor.controllers;

import io.matheusVictor.domain.dto.PixDTO;
import io.matheusVictor.service.PixService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1")
public class PixController {

    @Inject
    PixService pixService;

    @POST
    @Path("/pix")
    @Produces(MediaType.APPLICATION_JSON)
    public PixDTO hello(PixDTO dto) {
        return pixService.genPix(dto);
    }
}
