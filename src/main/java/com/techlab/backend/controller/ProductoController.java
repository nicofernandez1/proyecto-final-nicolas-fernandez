package com.techlab.backend.controller;

import com.techlab.backend.dto.ProductoDTO;
import com.techlab.backend.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService service;

    // CREATE
    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@Valid @RequestBody ProductoDTO dto) {
        ProductoDTO creado = service.crear(dto);
        URI ubicacion = URI.create("/productos" + creado.getId());
        return ResponseEntity.created(ubicacion).body(creado);
    }

    // READ - Todos
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // READ - Uno
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> listarProducto(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id,@Valid @RequestBody ProductoDTO dto) {
        return ResponseEntity.ok(service.actualizar(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarProducto(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
