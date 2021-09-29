package com.cartoes.apirest.model.repository;

import com.cartoes.apirest.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {

    @Query("SELECT u from Cartao u where u.id > :id")
    public List<Cartao> findAllMoreThan(@Param("id") int id);

    Cartao findById(int id);

}
