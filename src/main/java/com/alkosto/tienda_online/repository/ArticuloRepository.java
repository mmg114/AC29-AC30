package com.alkosto.tienda_online.repository;

import com.alkosto.tienda_online.domain.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {


    Articulo findByReferencia(String referencia);
}
