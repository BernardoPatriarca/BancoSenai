package com.Banco.BancoSenai.Service;

import com.Banco.BancoSenai.Model.M_Deposito;
import com.Banco.BancoSenai.Repository.R_Deposito;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Deposito {
    private static R_Deposito r_deposito;

    public S_Deposito(R_Deposito r_deposito) {
        this.r_deposito = r_deposito;
    }

    public static String depositar(String quantia, String conta, String cpf) {
        boolean podeSalvar = true;
        String mensagem = "";

        if(podeSalvar){
            M_Deposito m_deposito = new M_Deposito();
            m_deposito.setQuantia(Double.parseDouble(quantia));
            m_deposito.setCpf(Long.parseLong(cpf));
            m_deposito.setConta(Long.parseLong(conta));


            try{
                r_deposito.save(m_deposito);
                mensagem += "depostio realizada com sucesso";
            }catch (DataIntegrityViolationException e){
                mensagem += "Algo de errado aconteceu, tente novamente";
            }
        }
        return mensagem;
    }
}