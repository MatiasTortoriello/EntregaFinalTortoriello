package com.coderhouse.dtos;

import java.util.Date;
import java.util.List;

import com.coderhouse.models.Cliente;
import com.coderhouse.models.FacturaDetalle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaDTO {
	
	 private Long id;
	 
	    private Date createdAt;
	    
	    private double total;
	    
	    private double cantidadProductosVendidos;
	    
	    private Cliente cliente;
	    
	    private List<FacturaDetalle> detalle;
	    
		
}