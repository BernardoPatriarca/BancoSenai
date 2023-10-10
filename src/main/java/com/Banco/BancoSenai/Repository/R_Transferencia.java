package com.Banco.BancoSenai.Repository;

import com.Banco.BancoSenai.Model.M_Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Transferencia extends JpaRepository<M_Transferencia, Long> {

}
