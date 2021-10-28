package br.com.cwi.reset.andrezaduarte.service;

import br.com.cwi.reset.andrezaduarte.FakeDatabase;
import br.com.cwi.reset.andrezaduarte.exception.CanseiDeCriarExceptionCustomizadaException;
import br.com.cwi.reset.andrezaduarte.model.Ator;
import br.com.cwi.reset.andrezaduarte.model.PersonagemAtor;
import br.com.cwi.reset.andrezaduarte.repositories.PersonagemAtorRepository;
import br.com.cwi.reset.andrezaduarte.request.PersonagemRequest;
import br.com.cwi.reset.andrezaduarte.validator.PersonagemRequestCamposObrigatoriosValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonagemAtorService {

    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;

    @Autowired
    private AtorService atorService;

    public PersonagemAtor cadastrarPersonagemAtor(PersonagemRequest personagemRequest) throws Exception {
        final Ator ator = atorService.consultarAtor(personagemRequest.getIdAtor());
        PersonagemAtor personagemAtor = new PersonagemAtor(personagemRequest.getIdAtor(), personagemRequest.getNomePersonagem(),personagemRequest.getDescricaoPersonagem(),personagemRequest.getTipoAtuacao());
        PersonagemAtorRepository.save(personagemAtor);

        return personagemAtor;
    }

    public List<PersonagemAtor> consultarPersonagemAtor(String nome) throws Exception {
        personagemAtorRepository.FindAll();
    }

    private void validarPersonagensAtoresFilme(final List<PersonagemRequest> personagens) throws Exception {
        if (personagens.isEmpty()) {
            throw new CanseiDeCriarExceptionCustomizadaException("Esta validação não estava nas regras.");
        }

        final Set<PersonagemRequest> personagemRequestSet = new HashSet<>();

        for (PersonagemRequest personagemRequest : personagens) {
            new PersonagemRequestCamposObrigatoriosValidator().accept(personagemRequest);

            /**
             * A linha: "if (personagemRequestSet.contains(personagemRequest))"
             *
             * Cai na implementação do Set abaixo
             * Implementação macro
             * https://docs.oracle.com/javase/7/docs/api/java/util/Set.html#contains(java.lang.Object)
             *
             * Que por sua vez chama o equals da classe da chave
             * Na prática:
             * PersonagemRequest.equals(PersonagemRequest);
             * {@link br.com.cwi.reset.josealencar.request.PersonagemRequest#equals(Object)}
             */
            if (personagemRequestSet.contains(personagemRequest)) {
                throw new CanseiDeCriarExceptionCustomizadaException("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
            } else {
                personagemRequestSet.add(personagemRequest);
            }
        }
    }

    public List<PersonagemAtor> cadastrarPersonagensFilme(final List<PersonagemRequest> personagens) throws Exception {
        validarPersonagensAtoresFilme(personagens);

        final List<PersonagemAtor> personagensAtores = new ArrayList<>();

        for (PersonagemRequest request : personagens) {
            personagensAtores.add(cadastrarPersonagemAtor(request));
        }

        return personagensAtores;
    }
}