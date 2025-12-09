package com.techlab.backend.service;

import com.techlab.backend.dto.ProductoDTO;
import com.techlab.backend.entity.Producto;
import com.techlab.backend.exception.ProductoNoEncontradoException;
import com.techlab.backend.mapper.ProductoMapper;
import com.techlab.backend.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository repository;
    private final ProductoMapper mapper;

    public ProductoDTO crear(ProductoDTO dto) {
        Producto entidad = mapper.convertirAEntidad(dto);
        return mapper.convertirADto(repository.save(entidad));
    }

    public List<ProductoDTO> obtenerTodos() {
        return mapper.convertirListaADto(repository.findAll());
    }

    public ProductoDTO obtenerPorId(Long id) {
        Producto encontrado = repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("No existe producto con el id: " + id));
        return mapper.convertirADto(encontrado);
    }

    public ProductoDTO actualizar(Long id, ProductoDTO dto) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("No existe producto con el id: " + id));

        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCategoria(dto.getCategoria());
        producto.setStock(dto.getStock());
        producto.setDescripcion(dto.getDescripcion());
        return mapper.convertirADto(repository.save(producto));
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ProductoNoEncontradoException("No existe producto con el id: " + id);
        }

        repository.deleteById(id);
    }
}
