package br.com.cwi.reset.andrezaduarte.controller;

import br.com.cwi.reset.andrezaduarte.FakeDatabase;
import br.com.cwi.reset.andrezaduarte.model.Ator;
import br.com.cwi.reset.andrezaduarte.request.AtorRequest;
import br.com.cwi.reset.andrezaduarte.response.AtorEmAtividade;
import br.com.cwi.reset.andrezaduarte.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws Exception {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping("/em_atividade")
    @ResponseStatus(HttpStatus.OK)
    public List<AtorEmAtividade> listarAtoresEmAtividade (@RequestParam String filtroNome) throws Exception {
        return this.atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ator consultarAtor(@PathVariable Integer id) throws Exception {
        return this.consultarAtor(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ator> consultarAtores() throws Exception {
        return this.atorService.consultarAtores();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarAtor (@PathVariable Integer id, @RequestBody AtorRequest) throws Exception {
        atorService.atualizarAtor(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerAtor (@PathVariable Integer id) throws Exception {
        atorService.removerAtor(id);
    }

}