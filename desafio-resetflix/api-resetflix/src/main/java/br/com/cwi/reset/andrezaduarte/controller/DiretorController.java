package br.com.cwi.reset.andrezaduarte.controller;


import br.com.cwi.reset.andrezaduarte.FakeDatabase;
import br.com.cwi.reset.andrezaduarte.model.Diretor;
import br.com.cwi.reset.andrezaduarte.request.AtorRequest;
import br.com.cwi.reset.andrezaduarte.request.DiretorRequest;
import br.com.cwi.reset.andrezaduarte.service.AtorService;
import br.com.cwi.reset.andrezaduarte.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Diretor> listarDiretores(@RequestParam String filtroNome) throws Exception {
       return this.diretorService.listarDiretores(filtroNome);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception {
       return this.diretorService.consultarDiretor(id);
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void atualizarAtor (@PathVariable Integer id, @RequestBody AtorRequest) throws Exception {
//        diretorService.atualizarDiretor(id);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void removerAtor (@PathVariable Integer id) throws Exception {
//        diretorService.removerDiretor(id);
//    }


}
