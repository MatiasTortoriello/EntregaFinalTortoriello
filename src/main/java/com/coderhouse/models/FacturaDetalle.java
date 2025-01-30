package com.coderhouse.models;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "factura_detalle") 
public class FacturaDetalle { 

  @Id 
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
                                                      
  private int facturaDetalleId;

  @ManyToOne
  @JoinColumn(name = "factura_id", foreignKey = @ForeignKey(name = "FK_FACTURA_DETALLE_FACTURA", value = ConstraintMode.NO_CONSTRAINT))
  @OnDelete(action = OnDeleteAction.CASCADE)  
  @JsonIgnore                                                   
  private Factura factura; 

  @ManyToOne 
  @JoinColumn(name = "producto_id", nullable = false) 
                                                     
  private Producto producto; 

  @Column(name = "precio", nullable = false) 
  private double precio; 
  
  @Column(name = "cantidad", nullable = false) 
  private int cantidad; 

}