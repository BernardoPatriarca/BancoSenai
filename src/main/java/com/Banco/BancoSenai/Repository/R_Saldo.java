package com.Banco.BancoSenai.Repository;

import com.Banco.BancoSenai.Model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Saldo extends JpaRepository<M_Usuario, Long> {
    @Query(value = "SELECT * FROM usuario WHERE saldo = :saldo", nativeQuery = true)
    M_Usuario findBySaldo(@Param("saldo") double saldo);
}

