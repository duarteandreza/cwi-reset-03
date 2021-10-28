package br.com.cwi.reset.andrezaduarte.repositories;

import br.com.cwi.reset.andrezaduarte.model.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Integer> {

    List<Diretor> findAll();

}