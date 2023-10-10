package com.Banco.BancoSenai.Model;

import jakarta.persistence.*;

@Entity
@Table(name="deposito")
public class M_Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double quantia;
    private long cpf;
    private long conta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getQuantia() {
        return quantia;
    }

    public void setQuantia(double quantia) {
        this.quantia = quantia;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getConta() {
        return conta;
    }

    public void setConta(long conta) {
        this.conta = conta;
    }
}
