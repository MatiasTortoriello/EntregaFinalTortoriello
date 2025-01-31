package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data

@Schema(description = "Fecha DTO", title = "Fecha DTO")
public class TimeApiResponseDTO {
    private String dateTime;
}