package com.Banco.BancoSenai.Service;

import com.Banco.BancoSenai.Model.M_Saldo;
import com.Banco.BancoSenai.Model.M_Usuario;
import com.Banco.BancoSenai.Repository.R_Saldo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
@Service
public class S_Saldo {
    private static R_Saldo r_saldo;

    public S_Saldo(R_Saldo r_saldo) {
        this.r_saldo = r_saldo;
    }

    public static M_Usuario verificaSaldo(String saldo) {

        return r_saldo.findBySaldo(Double.parseDouble(saldo));
    }
    public static String transferirSaldo(String agencia,String quantia,String nome,String cpf,String conta) {
        boolean podeSalvar = true;
        String mensagem = "";

        if(podeSalvar){
            M_Saldo m_saldo = new M_Saldo();
            m_saldo.setAgencia(Long.parseLong(agencia));
            m_saldo.setQuantia(Double.parseDouble(quantia));
            m_saldo.setNome(nome);
            m_saldo.setCpf(Long.parseLong(cpf));
            m_saldo.setConta(Long.parseLong(conta));

            try{
                r_saldo.save(m_saldo);
                mensagem += "Deu Bom";
            }catch (DataIntegrityViolationException e){
                mensagem += "Deu Ruim";
            }
        }
        return mensagem;
    }
}
