package br.com.cwi.reset.andrezaduarte.controller;

import br.com.cwi.reset.andrezaduarte.FakeDatabase;
import br.com.cwi.reset.andrezaduarte.model.Filme;
import br.com.cwi.reset.andrezaduarte.request.AtorRequest;
import br.com.cwi.reset.andrezaduarte.request.FilmeRequest;
import br.com.cwi.reset.andrezaduarte.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws Exception {
        filmeService.criarFilme(filmeRequest);
    }

    @GetMapping
    public List<Filme> consultarFilmes(
            @RequestParam String nomeFilme,
            @RequestParam String nomeDiretor,
            @RequestParam String nomePersonagem,
            @RequestParam String nomeAtor) throws Exception {
        return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void removerAtor (@PathVariable Integer id) throws Exception {
//        filmeService.removerFilme(id);
//    }

}