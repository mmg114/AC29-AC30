package com.alkosto.tienda_online.controller;


import com.alkosto.tienda_online.domain.Articulo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/api/v1/articulo")
public class ArticulosController {

    @GetMapping
    public String getArticulo(){
        return "get Articulo";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> getArticuloById(@PathVariable int id){
        Articulo articulo = new Articulo();
        return new ResponseEntity<>(articulo,HttpStatus.ACCEPTED);
    }

    @PutMapping
    public String modifyArticulo(){
        return "modify Articulo";
    }

    @PostMapping
    public String saveArticulo(){
        return "save Articulo";
    }

    @DeleteMapping
    public String deleteArticulo(){
        return "delete Articulo";
    }

}
