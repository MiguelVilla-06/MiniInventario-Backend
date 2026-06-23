package com.ipn.mx.miniinventario.features.producto.repository;

import com.ipn.mx.miniinventario.core.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Producto p WHERE p.idCategoria.idCategoria = :idCategoria")
    void eliminarProductosPorCategoriaId(@Param("idCategoria") Long idCategoria);
}
