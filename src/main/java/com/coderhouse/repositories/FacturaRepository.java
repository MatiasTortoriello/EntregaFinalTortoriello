package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.coderhouse.models.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Query("SELECT MAX(CAST(SUBSTRING(f.numeroFactura, 6) AS LONG)) FROM Factura f WHERE f.numeroFactura LIKE :year%")
    Long findLastNumberForYear(String year);
}