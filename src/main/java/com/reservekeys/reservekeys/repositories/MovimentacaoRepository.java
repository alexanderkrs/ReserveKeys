package com.reservekeys.reservekeys.repositories;

import com.reservekeys.reservekeys.entities.Chave;
import com.reservekeys.reservekeys.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    @Query(value = "SELECT * FROM tb_movimentacao", nativeQuery = true)
    List<Chave> findAllByKey();

    @Query("select max(m) from Movimentacao m " +  "where m.chave.id = :idChave " + "group by m.chave.id ")
    Movimentacao existeMovimentacao(@Param("idChave") Long idChave);

}

//SELECT * FROM (SELECT * FROM T_DEVEDORESCREDIT ORDER BY VALORATUAL DESC)
//        WHERE ROWNUM = 1 ;
