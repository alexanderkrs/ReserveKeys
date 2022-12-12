package com.reservekeys.reservekeys.controllers;


import com.reservekeys.reservekeys.entities.Chave;

import com.reservekeys.reservekeys.service.ChaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/chaves")
public class ChaveController {

    @Autowired
    private ChaveService service;

    @GetMapping
    public List<Chave> findAll(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Chave findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Chave insert(@RequestBody Chave chave){
        return service.insert(chave);
    }

    @DeleteMapping (path = "/{id}")
    public void remover(@PathVariable("id") Long id) {
     service.remover(id);
    }

    @PutMapping(path = "/{id}")
    public Chave alterar(@RequestBody Chave chave, @PathVariable("id") Long id ){
        return service.alterar(chave,id);

    }

}

