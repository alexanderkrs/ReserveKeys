package com.reservekeys.reservekeys.service;

import com.reservekeys.reservekeys.entities.Chave;
import com.reservekeys.reservekeys.entities.Movimentacao;
import com.reservekeys.reservekeys.entities.Status;
import com.reservekeys.reservekeys.exceptions.service.ServiceException;
import com.reservekeys.reservekeys.repositories.ChaveRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
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
        return obterChaveSeExiste(id).get();
    }

    @GetMapping
    public Chave insert(@RequestBody Chave chave) {
    List<Chave> chaves = repository.findAllByNum();
    for(Chave chave1: chaves) {
        if(chave1.getNum().equals(chave.getNum()) && chave1.getLocal().equals(chave.getLocal())) {
            throw new ServiceException("Chave já cadastrada.");
        }
    }
        if(chave.getLocal().isEmpty()) {
           throw new ServiceException("Campo em Branco!");
        }
        chave.setStatus(Status.DISPONIVEL);
        Chave result = repository.save(chave);
            return result;
    }

    private Optional<Chave> obterChaveSeExiste(Long id) {
        Optional<Chave> chave = repository.findById(id);

        if(!chave.isPresent()) {
            throw new ServiceException("Não existe Chave com o ID:"+id);
        }
        return chave;
    }

    public void remover(Long id){
        Optional<Chave> chaveOptional = obterChaveSeExiste(id);

        repository.deleteById(id);
    }

    public Chave alterar(Chave chave,Long id) {
        Optional<Chave> chaveOptional = obterChaveSeExiste(id);
        Chave chaveAlterada = chaveOptional.get();

        if(StringUtils.hasLength(chave.getDesc()) && StringUtils.hasLength(chave.getLocal())) {
                chaveAlterada.setDesc(chave.getDesc());
                chaveAlterada.setLocal(chave.getLocal());
                chaveAlterada.setNum(chave.getNum());
            }
            chaveAlterada = repository.save(chaveAlterada);

            return chaveAlterada;
        }
    }

