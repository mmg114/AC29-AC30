package com.alkosto.tienda_online.controller;


import com.alkosto.tienda_online.domain.Articulo;
import com.alkosto.tienda_online.services.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/articulo")
public class ArticulosController {
    @Autowired
    private IArticuloService articuloService;

    @GetMapping
    public ResponseEntity<List<Articulo>> getAll(){
        return new ResponseEntity<>(articuloService.findByAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> getArticuloById(@PathVariable int id){
        Articulo articulo = new Articulo();
        return new ResponseEntity<>(articulo,HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<Articulo> modifyArticulo(@RequestBody Articulo articulo){
        return new ResponseEntity<>( articuloService.update(articulo),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Articulo> saveArticulo(@RequestBody Articulo articulo){
        return new ResponseEntity<>( articuloService.save(articulo),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticulo(@PathVariable Long id){
        Articulo articulo = new Articulo();
        articulo.setId(id);
        articuloService.deleteById(articulo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
