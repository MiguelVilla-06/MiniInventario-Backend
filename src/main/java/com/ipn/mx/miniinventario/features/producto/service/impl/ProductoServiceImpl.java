package com.ipn.mx.miniinventario.features.producto.service.impl;

import com.ipn.mx.miniinventario.core.entidades.Producto;
import com.ipn.mx.miniinventario.features.producto.repository.ProductoRepository;
import com.ipn.mx.miniinventario.features.producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl  implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        productoRepository.deleteById(id);
    }
}
