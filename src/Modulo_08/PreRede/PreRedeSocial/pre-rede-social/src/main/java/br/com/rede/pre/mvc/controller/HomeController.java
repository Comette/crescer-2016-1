package br.com.rede.pre.mvc.controller;

import br.com.rede.pre.dominio.model.Usuario;
import br.com.rede.pre.dominio.service.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @Autowired
    UsuarioServico servico;
    
    @RequestMapping(value = "/")
    String toIndex(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", servico.usuarios());
        return "index";
    }
}
