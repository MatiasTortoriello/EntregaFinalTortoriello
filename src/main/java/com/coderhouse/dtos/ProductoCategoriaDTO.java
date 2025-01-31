package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Asignacion Categoria DTO", title = "Asignaciones DTO")
public class ProductoCategoriaDTO {

    @Schema(description = "Producto ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "01")
    private Long productoId;

    @Schema(description = "Categoria ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "01")
    private Long categoriaId;
}