package com.coderhouse.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.coderhouse.dtos.FacturaDTO;
import com.coderhouse.models.Factura;
import com.coderhouse.service.FacturaService;
import com.coderhouse.service.FacturacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Tag(name = "Facturas", description = "API para la gestión de facturas")
@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private FacturacionService facturacionService;

    @Operation(summary = "Obtener todas las facturas con detalles", description = "Obtiene una lista de todas las facturas con sus detalles")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de facturas obtenida con éxito"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<List<FacturaDTO>> getAllFacturas() {
        try {
            List<FacturaDTO> facturas = facturacionService.obtenerTodasLasFacturas();
            return ResponseEntity.ok(facturas); // 200
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @Operation(summary = "Obtener una factura por ID con detalles", description = "Obtiene una factura/compra específica por su ID con sus detalles")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Factura encontrada con éxito"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> getFacturaById(@PathVariable Long id) {
        try {
            FacturaDTO factura = facturacionService.obtenerFactura(id);
            return ResponseEntity.ok(factura); // 200
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @Operation(summary = "Crear una nueva factura", description = "Crea una nueva factura, pero se recomienda utilizar el servicio de compra")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Factura creada con éxito"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/create")
    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
        try {
            Factura facturaCreada = facturaService.crearFactura(factura);
            return ResponseEntity.status(HttpStatus.CREATED).body(facturaCreada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @Operation(summary = "Borrar una factura por ID", description = "Borra una factura específica por su ID, NO devuelve STOCK")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Factura borrada con éxito"),
        @ApiResponse(responseCode = "404", description = "Factura no encontrada"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacturaById(@PathVariable Long id) {
        try {
            facturaService.eliminarFactura(id);
            return ResponseEntity.noContent().build(); // 204
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 404
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }
}