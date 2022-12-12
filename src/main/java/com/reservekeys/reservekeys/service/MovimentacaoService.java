package com.reservekeys.reservekeys.service;

import com.reservekeys.reservekeys.entities.Chave;
import com.reservekeys.reservekeys.entities.Movimentacao;
import com.reservekeys.reservekeys.entities.Status;
import com.reservekeys.reservekeys.exceptions.service.ServiceException;
import com.reservekeys.reservekeys.repositories.ChaveRepository;
import com.reservekeys.reservekeys.repositories.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @GetMapping
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }

    @Autowired
    private ChaveRepository chaveRepository;
    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void emprestar(String nomePessoa, Long idChave) {
      Chave chave = chaveRepository.findById(idChave).orElseThrow(() ->new ServiceException("Não existe chave com o id"));
//            chave.setStatus(Status.DISPONIVEL);
            if(chave.getStatus().equals(Status.DISPONIVEL)) {
                String date = formatDate.format(LocalDate.now());
                repository.save(new Movimentacao(nomePessoa, date, chave)); // ta pegando o obj movimentação, mas ta mandando só
                chave.setStatus(Status.INDISPONIVEL);
                chaveRepository.save(chave);
               // throw new ServiceException("Chave emprestado com sucesso"); não existe exceção como mensagem de sucesso
            } else {
                throw new ServiceException("Chave já se contra emprestada");
            }

    }

    public void devolver(Long idChave) {
        Chave chave = chaveRepository.findById(idChave).orElseThrow(() ->new ServiceException("Não existe chave com o id"));
        if (chave.getStatus().equals(Status.INDISPONIVEL)) {
            String date = formatDate.format(LocalDate.now());
            Movimentacao movimentacao = repository.existeMovimentacao(idChave);
            System.out.println(movimentacao);
            movimentacao.setData_devolucao(date);
            chave.setStatus(Status.DISPONIVEL);
            repository.save(movimentacao);
        } else {
            throw new ServiceException("Chave disponível");
        }
    }
}
