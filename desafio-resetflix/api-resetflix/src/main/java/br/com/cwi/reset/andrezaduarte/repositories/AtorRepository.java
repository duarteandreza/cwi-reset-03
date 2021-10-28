package br.com.cwi.reset.andrezaduarte.repositories;

import br.com.cwi.reset.andrezaduarte.model.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    Ator findbyNome(String nome);

    List<Ator> findAll();

    Ator findByAllId(Integer  id);

}
