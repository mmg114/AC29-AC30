package com.alkosto.tienda_online.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Articulo {
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String referencia;
}
