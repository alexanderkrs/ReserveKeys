package com.reservekeys.reservekeys.repositories;

import com.reservekeys.reservekeys.entities.Chave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChaveRepository extends JpaRepository<Chave,Long> {

}
