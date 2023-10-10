package com.Banco.BancoSenai.Repository;

import com.Banco.BancoSenai.Model.M_Deposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Deposito extends JpaRepository<M_Deposito, Long> {

}