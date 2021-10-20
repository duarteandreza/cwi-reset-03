package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.AvaliacaoForaDoPadraoException;
import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/filme")

public class FilmeController {
    @GetMapping
    public Filme consultarFilme() throws AvaliacaoForaDoPadraoException {
        Diretor diretor = new Diretor("João", LocalDate.of(1960,05,25), 50, Genero.MASCULINO);
        return new Filme ("Filme 1", "Filme de comédia", 120, 2015, 5, diretor);
    }

    
}
