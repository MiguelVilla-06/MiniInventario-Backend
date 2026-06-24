package com.ipn.mx.miniinventario.core.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", nullable = false)
    private Long idCategoria;

    @Size(min = 4, max = 50)
    @Column(name = "nombrecategoria", nullable = false, length = 50)
    private String nombreCategoria;

    @Column(name = "descripcioncategoria", nullable = false, length = 100)
    private String descripcionCategoria;

    @Column(name = "createat", nullable = true)
    private LocalDate createAt;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Producto> productos = new HashSet<Producto>();

    @PrePersist
    public void prePersist() {
        this.createAt = LocalDate.now();
    }
}
