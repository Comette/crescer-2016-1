package br.com.rede.pre.mvc.controller;

import br.com.rede.pre.dominio.model.Usuario;
import br.com.rede.pre.dominio.service.UsuarioServico;
import br.com.rede.pre.mvc.model.LoginModel;
import br.com.rede.pre.mvc.model.UsuarioLogadoModel;
import br.com.rede.pre.mvc.service.ServicoSessao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    UsuarioServico servico;

    @RequestMapping(value = "/")
    String toIndex(Model model) {
        model.addAttribute("login", new LoginModel());
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute LoginModel login) {
        Usuario usuarioLogado = servico.buscaPorEmailSenha(login.getEmail(), login.getSenha());
        if (usuarioLogado != null) {
            ServicoSessao.criar(new UsuarioLogadoModel(usuarioLogado));                    
            return home(usuarioLogado);
        } else {
            return new ModelAndView("index");
        }
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homeT(){
        if(ServicoSessao.getUsuarioLogado() != null){
            return new ModelAndView("home", "usuario", ServicoSessao.getUsuarioLogado());
        }else{
            return new ModelAndView("index");
        }
    }
    
    private ModelAndView home(Usuario usuario){         
        return new ModelAndView("home", "usuario", usuario);
    }
    
}
