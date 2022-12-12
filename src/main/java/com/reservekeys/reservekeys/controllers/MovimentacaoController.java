package com.reservekeys.reservekeys.controllers;

import com.reservekeys.reservekeys.entities.dto.MovimentacaoDTO;
import com.reservekeys.reservekeys.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/movimentacao")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService service;


    @PostMapping("/emprestar")
    public void emprestar(@RequestBody MovimentacaoDTO movimentacaoDTO){
        service.emprestar(movimentacaoDTO.getNomePessoa(), movimentacaoDTO.getIdChave());
    }

    @PutMapping("/devolver/{idChave}")
    public void devolver(@PathVariable Long idChave){

        service.devolver(idChave);
    }


}
