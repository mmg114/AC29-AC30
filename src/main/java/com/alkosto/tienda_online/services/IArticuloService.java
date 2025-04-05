package com.alkosto.tienda_online.services;

import com.alkosto.tienda_online.domain.Articulo;

import java.util.List;

public interface IArticuloService {

    public List<Articulo> findByAll();

    void deleteById(Articulo articulo);


    Articulo save(Articulo articulo);

    Articulo update(Articulo articulo);
}
