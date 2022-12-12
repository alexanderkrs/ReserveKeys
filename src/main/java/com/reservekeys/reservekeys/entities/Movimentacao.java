package com.reservekeys.reservekeys.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.lang.*;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pessoa_movimentacao")
    private String pessoa;

    @Column(name = "data_emprestimo_movimentacao")
    private String data_emprestimo;

    @Column(name = "data_devolucao_movimentacao")
    private String data_devolucao;

    @ManyToOne
    @JoinColumn(name = "id_chave")
    private Chave chave;

    public Movimentacao(String pessoa, String data_emprestimo, Chave chave) {
        this.pessoa = pessoa;
        this.data_emprestimo = data_emprestimo;
        this.chave = chave;
    }

    public Movimentacao(String pessoa, String data_emprestimo, String data_devolucao, Chave chave) {
        this.pessoa = pessoa;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
        this.chave = chave;
    }


}
