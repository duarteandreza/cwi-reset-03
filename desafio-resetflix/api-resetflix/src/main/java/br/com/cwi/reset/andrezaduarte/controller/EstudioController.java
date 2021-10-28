package br.com.cwi.reset.andrezaduarte.controller;


import br.com.cwi.reset.andrezaduarte.FakeDatabase;
import br.com.cwi.reset.andrezaduarte.model.Estudio;
import br.com.cwi.reset.andrezaduarte.request.EstudioRequest;
import br.com.cwi.reset.andrezaduarte.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estudio> consultarEstudios(@RequestParam String filtroNome) throws Exception {
        return this.estudioService.listarEstudios(filtroNome);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Estudio consultarEstudio (@PathVariable Integer id) throws Exception {
        return this.estudioService.consultarEstudio(id);
    }

}
