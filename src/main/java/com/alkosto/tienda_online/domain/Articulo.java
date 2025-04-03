package com.alkosto.tienda_online.domain;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Articulo {
    private int id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private String referencia;

}
