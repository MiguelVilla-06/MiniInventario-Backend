package com.ipn.mx.miniinventario.core.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "producto")
@ToString(exclude = "categoria")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Long idProducto;

    @Size(min = 4, max = 50)
    @Column(name = "nombreproducto", nullable = false, length = 50)
    private String nombreProducto;

    @Column(name = "descripcionproducto", nullable = false, length = 100)
    private String descripcionProducto;

    @Column(name = "precioproducto", nullable = false, scale = 2)
    private double precioProducto;

    @Column(name = "existencia", nullable = false)
    private int existencia;

    @Column(name = "createat", nullable = true)
    private LocalDate createAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcategoria", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnoreProperties({"productos", "hibernateLazyInitializer", "handler"})
    private Categoria categoria;

    @PrePersist
    public void prePersist() {
        this.createAt = LocalDate.now();
    }
}