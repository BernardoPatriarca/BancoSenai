package com.Banco.BancoSenai.Controller;

import com.Banco.BancoSenai.Service.S_Deposito;
import com.Banco.BancoSenai.Service.S_Transferencia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Servicos {
    @GetMapping("/deposito")
    public String getDeposito() {
        return "Deposito/deposito";
    }

    @GetMapping("/transferencia")
    public String getTransferencia() {
        return "Transferencia/transferencia";
    }

    @PostMapping("/transferencia")
    public String transferir(@RequestParam("agencia") String agencia,
                             @RequestParam("quantia") String quantia,
                             @RequestParam("nome") String nome,
                             @RequestParam("cpf") String cpf,
                             @RequestParam("conta") String conta) {

        S_Transferencia.transferir(agencia, quantia, nome, cpf, conta);
        return "Comprovate/comprovanteDeTrasferencia";
    }
    @PostMapping("/deposito")
    public String depositar(@RequestParam("conta") String conta,
                            @RequestParam("cpf") String cpf,
                            @RequestParam("quantia") String quantia) {

        S_Deposito.depositar(quantia, conta, cpf);
        return "Comprovate/comprovanteDeDeposito";
    }
}
