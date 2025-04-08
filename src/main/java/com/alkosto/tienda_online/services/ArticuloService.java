package com.alkosto.tienda_online.services;

import com.alkosto.tienda_online.domain.Articulo;
import com.alkosto.tienda_online.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticuloService implements IArticuloService {

    @Autowired
    private ArticuloRepository repo;

    @Override
    @Transactional
    public List<Articulo> findByAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
    public void deleteById(Articulo articulo) {
        if (repo.existsById(articulo.getId())) {
           repo.deleteById(articulo.getId());
        }else{
            throw new RuntimeException("Articulo no encontrado");
        }
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
    public Articulo save(Articulo articulo) {
        if(articulo.getNombre()==null || articulo.getNombre().isEmpty()){
            throw new RuntimeException("Nombre del articulo no puede ser vacio");
        }

        if(articulo.getPrecio()==null || articulo.getPrecio().doubleValue()<1){
            throw new RuntimeException("El precio del articulo no puede ser vacio o menor que 1");
        }
        Articulo referenciaExistente=repo.findByReferencia(articulo.getReferencia());

        if(referenciaExistente!=null){
            throw new RuntimeException("Esta referencia ya existe: "+articulo.getReferencia());
        }

        return repo.save(articulo);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
    public Articulo update(Articulo articulo) {
        if (repo.existsById(articulo.getId())) {
           return repo.save(articulo);
        } else {
            throw new RuntimeException("Articulo no encontrado");
        }
    }

    @Override
    public Articulo findById(Long id) {
        return repo.findById(id).orElseThrow(()->new RuntimeException("Articulo no encontrado"));
    }
}
