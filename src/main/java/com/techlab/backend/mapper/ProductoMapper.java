package com.techlab.backend.mapper;

import com.techlab.backend.dto.ProductoDTO;
import com.techlab.backend.entity.Producto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductoMapper {
    public ProductoDTO convertirADto(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setCategoria(producto.getCategoria());
        dto.setDescripcion(producto.getDescripcion());
        dto.setStock(producto.getStock());
        return dto;
    }

    public Producto convertirAEntidad(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCategoria(dto.getCategoria());
        producto.setDescripcion(dto.getDescripcion());
        producto.setStock(dto.getStock());
        return producto;
    }

    public List<ProductoDTO> convertirListaADto(List<Producto> productos) {
        return productos.stream()
                .map(this::convertirADto)
                .toList();
    }
}
