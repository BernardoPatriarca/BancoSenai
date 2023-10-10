package com.Banco.BancoSenai.Service;

import com.Banco.BancoSenai.Model.M_Usuario;
import com.Banco.BancoSenai.Repository.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class S_Usuario {
    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        this.r_usuario =  r_usuario;
    }

    public static M_Usuario verificaLogin(String cpf, String senha){
        cpf = S_Generico.limparNumero(cpf);

        if(S_Generico.textoEstaVazio(cpf)){
            return null;
        }else if(S_Generico.textoEstaVazio(senha)){
            return null;
        }
        return r_usuario.findByCpfESenha(Long.parseLong(cpf),
                senha);
    }
    public static String cadastrarUsuario( String nome,  String cpf,  String dataNascimento,  String rg,  String email,  String telefone,  String cep,  String estado, String  cidade, String  bairro,  String rua, String numero, String senha) {
        boolean podeSalvar = true;
        String mensagem = "";

        if (S_Generico.textoEstaVazio(nome)) {
            podeSalvar = false;
            mensagem += "nome nao preenchido";
        }

        if (!S_Generico.validarEmail(email)) {
            podeSalvar = false;
            mensagem += "email nao preenchido e invalido";
        }

        if(podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setNome(nome);
            m_usuario.setCpf(Long.parseLong(cpf));
            m_usuario.setDataNascimento(LocalDate.parse(dataNascimento));
            m_usuario.setRg(Long.parseLong(rg));
            m_usuario.setEmail(email);
            m_usuario.setTelefone(Long.parseLong(telefone));
            m_usuario.setCep(Long.parseLong(cep));
            m_usuario.setEstado(estado);
            m_usuario.setCidade(cidade);
            m_usuario.setBairro(bairro);
            m_usuario.setRua(rua);
            m_usuario.setNumero(Long.parseLong(numero));
            m_usuario.setSenha(senha);

            try{
                r_usuario.save(m_usuario);
                mensagem += "Cadastro efeituado com sucesso";
            }catch (DataIntegrityViolationException e){
                mensagem += "Algo deu errado, tente novamente";
            }
        }
        return mensagem;
    }
}