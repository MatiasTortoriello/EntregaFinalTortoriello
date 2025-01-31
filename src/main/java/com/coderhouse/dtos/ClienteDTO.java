package com.coderhouse.dtos;

import java.util.List;

import com.coderhouse.models.Factura;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

    private Long id;
    
    private String nombre;
    
    private String apellido;
    
    private String dni;
    
   private List<FacturaDTO> facturas;
    
}