package com.coderhouse.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "producto_venta")

@Schema(description = "Modelo que representa la venta de los productos", title = "Modelo de Venta de Productos")
public class VentaDeProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "Nombre", length = 30, nullable = false)
    private String nombre;

	@Column(name = "Nombre", length = 50, nullable = false)
    private String descripcion;

	@Column(name = "Nombre", length = 30, nullable = false)
    private double precio;

	@Column(name = "Nombre", length = 30, nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}