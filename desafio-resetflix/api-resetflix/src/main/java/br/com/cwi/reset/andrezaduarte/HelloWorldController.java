package br.com.cwi.reset.andrezaduarte;

import br.com.cwi.reset.andrezaduarte.exception.NomeNaoInformadoException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    
    @GetMapping
    public String helloWorld() throws Exception {
        throw new NomeNaoInformadoException();
        //return "Minha API resetflix está UP!!!";
    }
}