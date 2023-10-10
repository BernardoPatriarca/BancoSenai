package com.Banco.BancoSenai.Service;

import com.Banco.BancoSenai.Model.M_Transferencia;
import com.Banco.BancoSenai.Repository.R_Transferencia;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Transferencia {
    private static R_Transferencia r_transferencia;

    public S_Transferencia(R_Transferencia r_transferencia) {
        this.r_transferencia = r_transferencia;
    }

    public static String transferir(String agencia, String quantia, String nome, String cpf, String conta) {
        boolean podeSalvar = true;
        String mensagem = "";

        if (podeSalvar) {
            M_Transferencia m_transferencia = new M_Transferencia();
            m_transferencia.setAgencia(Long.parseLong(agencia));
            m_transferencia.setQuantia(Double.parseDouble(quantia));
            m_transferencia.setCpf(Long.parseLong(cpf));
            m_transferencia.setNome(nome);
            m_transferencia.setConta(Long.parseLong(conta));


            try {
                r_transferencia.save(m_transferencia);
                mensagem += "Transferencia realizada com sucesso";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Algo de errado aconteceu, tente novamente";
            }
        }
        return mensagem;
    }
}