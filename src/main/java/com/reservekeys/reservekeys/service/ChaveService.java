package com.reservekeys.reservekeys.service;

import com.reservekeys.reservekeys.entities.Chave;
import com.reservekeys.reservekeys.repositories.ChaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ChaveService {
    @Autowired
    private ChaveRepository repository;

    @GetMapping
    public List<Chave> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public Chave findById(Long id) {
        Optional<Chave> chave = repository.findById(id);
        return chave.get();
    }

    @GetMapping
    public Chave insert(@RequestBody Chave chave) {
        Chave result = repository.save(chave);
        return result;
    }

    public void remover(Long id){
        repository.deleteById(id);
    }



}
