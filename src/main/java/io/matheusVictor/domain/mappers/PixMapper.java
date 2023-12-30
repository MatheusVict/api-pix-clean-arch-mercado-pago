package io.matheusVictor.domain.mappers;

import io.matheusVictor.domain.dto.PixDTO;
import io.matheusVictor.domain.entities.PixBO;

public class PixMapper {

    public static PixDTO toDTO(PixBO pixBO) {
        PixDTO pixDTO = new PixDTO();
        pixDTO.setId(pixBO.getId().toString());
        pixDTO.setAmount(pixBO.getAmount());
        pixDTO.setEmail(pixBO.getEmail());
        pixDTO.setDescription(pixBO.getDescription());
        pixDTO.setEmv(pixBO.getEmv());
        pixDTO.setBase64(pixBO.getBase64());
        pixDTO.setExpiration(pixBO.getExpiration());
        return pixDTO;
    }

    public static PixBO toBO(PixDTO pixDTO) {
        return new PixBO(
                pixDTO.getId(),
                pixDTO.getAmount(),
                pixDTO.getEmail(),
                pixDTO.getDescription(),
                pixDTO.getEmv(),
                pixDTO.getBase64(),
                pixDTO.getExpiration()
        );
    }
}
