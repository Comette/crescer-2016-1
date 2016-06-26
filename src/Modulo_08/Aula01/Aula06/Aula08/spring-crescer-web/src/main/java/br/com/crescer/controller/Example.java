package br.com.crescer.controller;

import br.com.crescer.dominio.Pessoa;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Example {

    @RequestMapping(value = "/")
    String toIndex(@RequestParam(required = false) String name, Model model) {
        String nome = name != null ? name : "Nome Default";
        model.addAttribute("name", nome);
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/dataAtual")
    public Date date() {
        return new Date();
    }

    @ResponseBody
    @RequestMapping(value = "/pessoa.json", method = RequestMethod.POST)
    public List<Pessoa> list(@RequestBody Pessoa p) {
        p.setNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }
}
