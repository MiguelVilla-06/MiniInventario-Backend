package com.ipn.mx.miniinventario.core.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "Categoria")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( nullable = false)
    private Long idCategoria;

    @Size(min = 4, max = 50)
    @Column ( nullable = false, length = 50)
    private String nombreCategoria;

    @Column (nullable = false, length = 100)
    private String descripcionCategoria;

    @Column (name = "create_at", nullable = true) //Solo se usa name si el atributo se llama diferente a la tabla
    private LocalDate createAt;

    @OneToMany(mappedBy = "idCategoria", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Producto> productos = new HashSet<Producto>();
}
