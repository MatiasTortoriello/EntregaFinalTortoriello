package com.coderhouse.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.VentaDeProducto;

public interface VentaDeProductoRepository extends JpaRepository<VentaDeProducto, Long> {
}