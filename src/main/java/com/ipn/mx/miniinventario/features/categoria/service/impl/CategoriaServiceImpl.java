package com.ipn.mx.miniinventario.features.categoria.service.impl;

import com.ipn.mx.miniinventario.core.entidades.Categoria;
import com.ipn.mx.miniinventario.features.categoria.repository.CategoriaDAO;
import com.ipn.mx.miniinventario.features.categoria.service.CategoriaService;
import com.ipn.mx.miniinventario.features.producto.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoriaDAO categoriaRepository;

    @Transactional (readOnly = true)
    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Transactional (readOnly = true)
    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional
    @Override
    public void deleteById(Long id) {
        productoRepository.eliminarProductosPorCategoriaId(id);
        categoriaRepository.eliminarDirectoPorId(id);
    }
}
