package com.Banco.BancoSenai.Controller;

import com.Banco.BancoSenai.Service.S_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Usuario {
    @GetMapping("/cadastro")
    public String getCadastro() {
        return "Cadastros/cadastro";
    }
    @PostMapping("/cadastro")
    public String cadastrarUsuario(@RequestParam("nome") String nome,
                                   @RequestParam("cpf") String cpf,
                                   @RequestParam("dataNascimento") String dataNascimento,
                                   @RequestParam("rg") String rg,
                                   @RequestParam("email") String email,
                                   @RequestParam("telefone") String telefone,
                                   @RequestParam("cep") String cep,
                                   @RequestParam("estado") String estado,
                                   @RequestParam("cidade") String cidade,
                                   @RequestParam("bairro") String bairro,
                                   @RequestParam("rua") String rua,
                                   @RequestParam("numero") String numero,
                                   @RequestParam("senha") String senha) {

        S_Usuario.cadastrarUsuario(nome, cpf, dataNascimento, rg, email, telefone, cep, estado, cidade, bairro, rua, numero, senha);
        return "Login/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("usuario", null);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getLogin(HttpSession session){
        if(session.getAttribute("usuario") != null) {
            return "redirect:/Home";
        }else{
            return "Login/login";
        }
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin(@RequestParam("cpf") String cpf,
                             @RequestParam("senha") String senha,
                             HttpSession session){
        session.setAttribute("usuario", S_Usuario.verificaLogin(cpf, senha));
        if(session.getAttribute("usuario") == null){
            return false;
        }else{
            return true;
        }
    }

}
