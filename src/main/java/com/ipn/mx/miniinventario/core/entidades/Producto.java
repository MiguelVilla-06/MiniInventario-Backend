package com.ipn.mx.miniinventario.core.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Producto")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
    private Long idProducto;

    @Size(min = 4, max = 50)
    @Column ( nullable = false, length = 50)
    private String nombreProducto;

    @Column (nullable = false, length = 100)
    private String descripcionProducto;

    @Column (nullable = false,  scale = 2)
    private double precioProducto;

    @Column (nullable = false)
    private int existencia;

    @Temporal(TemporalType.DATE)
    @Column (nullable = true, name="create_at")
    private LocalDate createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"productos", "hibernateLazyInitializer", "handler"})
    private Categoria idCategoria;
}
