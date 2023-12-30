package io.matheusVictor.infra.mercadopago.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class MpPixResponse {


    @JsonbProperty("point_of_interaction")
    private MpPixPoiDTO poi;

    public MpPixPoiDTO getPoi() {
        return poi;
    }

    public void setPoi(MpPixPoiDTO poi) {
        this.poi = poi;
    }
}
