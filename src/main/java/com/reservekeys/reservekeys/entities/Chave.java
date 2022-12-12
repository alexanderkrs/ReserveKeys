package com.reservekeys.reservekeys.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.lang.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_chave")
public class Chave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "numero_chave", nullable = false)
    private Long num;

    @Column(name = "local_chave", nullable = false)
    private String local;

    @Column(name = "descricao_chave", nullable = false)
    private String desc;

    @Column(name = "status_chave", nullable = false)
    private Status status;

/*
    @OneToMany(mappedBy = "chave")
    private List<Movimentacao> enderecos;
    */

}


