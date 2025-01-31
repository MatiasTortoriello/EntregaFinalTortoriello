package com.coderhouse.models;


import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Factura")
public class Factura {

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
                                                     
  private Long id; 

  @ManyToOne 
  @JoinColumn(name = "cliente_id", nullable = false) 
  private Cliente cliente; 

  @Column(name = "created_at", nullable = false) 
  @Temporal(TemporalType.TIMESTAMP) 
  private Date createdAt; 

  @Column(name = "total", nullable = false) 
  private double total; 
  
  @Column(name = "numeroFactura", nullable = false) 
  private String numeroFactura; 
  
  @Column(name = "cantidadProductosVendidos", nullable = false)
  private double cantidadProductosVendidos; 

  @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)                                                                               // con la clase FacturaDetalle
  private List<FacturaDetalle> facturaDetalle; 


}