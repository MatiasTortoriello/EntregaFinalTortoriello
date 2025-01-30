package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "Clientes")
public class Cliente {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
	private Long id;	
	
	@Column(name = "Nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "Apellido", length = 50, nullable = false)
	private String apellido;

	@Column(unique = true, nullable = false) // Va a ser Unico y No Nulo
	private int dni;


	@ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();

	private LocalDateTime createdAt;


}