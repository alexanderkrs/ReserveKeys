package com.reservekeys.reservekeys.repositories;

import com.reservekeys.reservekeys.entities.Chave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChaveRepository extends JpaRepository<Chave,Long> {

    @Query(value = "SELECT * FROM tb_chave", nativeQuery = true)
    List<Chave> findAllByNum();

}
