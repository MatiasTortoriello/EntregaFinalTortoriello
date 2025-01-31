package com.coderhouse.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Productos")
public class Producto {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "Nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "precio", length = 30, nullable = false)
	private Float precio;
	
	@Column(name = "descripcion", length = 50, nullable = false)
	private Float descripcion;

	@Column(name = "stock", length = 10, nullable = false)
	private Float stock;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "productos_por_cliente", 
			joinColumns = @JoinColumn(name = "producto_id"), 
			inverseJoinColumns = @JoinColumn(name = "cliente_id"))
	@JsonIgnore
	
	private List<Cliente> clientes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;

}