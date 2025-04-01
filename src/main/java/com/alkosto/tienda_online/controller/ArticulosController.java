package com.alkosto.tienda_online.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articulo")
public class ArticulosController {

    @GetMapping
    public String getArticulo(){
        return "get Articulo";
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
