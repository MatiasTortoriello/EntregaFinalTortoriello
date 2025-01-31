package com.coderhouse.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_de_venta")
@Schema(description = "Modelo que representa los detalles de la venta de los productos", title = "Modelo del detalle de la venta de Productos")
public class DetalleDeVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;

    
    @ManyToOne
    @JoinColumn(name = "producto_venta_id")
    private VentaDeProducto ventaDeProducto;
    private int cantidad;
    private double precio;
}