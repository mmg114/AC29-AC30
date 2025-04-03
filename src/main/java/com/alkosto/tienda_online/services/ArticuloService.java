package com.alkosto.tienda_online.services;

import com.alkosto.tienda_online.domain.Articulo;
import com.alkosto.tienda_online.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService implements IArticuloService {

    @Autowired
    private ArticuloRepository repo;

    @Override
    public List<Articulo> findByAll() {
        return repo.findAll();
    }
}
