package com.Banco.BancoSenai.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Home {
    @GetMapping("/Home")
    public String getHome(HttpSession session,
                          Model model){
        if(session.getAttribute("usuario") != null) {
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "Home/home";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/home")
    public String getPartialHome(HttpServletRequest request){
        // Verifique se a referência não é "/home" para evitar o ciclo de redirecionamento
        if(!request.getHeader("Referer").endsWith("/home")) {
            return "home/home";
        } else {
            return "redirect:/";
        }
    }
}
