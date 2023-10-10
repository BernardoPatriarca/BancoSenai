package com.Banco.BancoSenai.Controller;

import com.Banco.BancoSenai.Service.S_Saldo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Saldo {

    @GetMapping("/saldo")
    public String getSaldo() {return "Saldo/saldo";
    }
    @GetMapping("/transferencia")
    public String getTransferencia() {return "Transferencia/transferencia";
    }
    @PostMapping("/transferir")
    public String transferirSaldo(@RequestParam("agencia") String agencia,
                                  @RequestParam("quantia") String quantia,
                                  @RequestParam("nome") String nome,
                                  @RequestParam("cpf") String cpf,
                                  @RequestParam("conta") String conta) {

        S_Saldo.transferirSaldo(agencia, quantia, nome, cpf, conta);
        return "/comprovanteDeTransferencia";
    }
    @GetMapping("/deposito")
    public String getDeposito() {return "Deposito/deposito";
    }
}
