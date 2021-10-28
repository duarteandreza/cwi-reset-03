package br.com.cwi.reset.andrezaduarte.repositories;


import br.com.cwi.reset.andrezaduarte.model.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

    List<Estudio> findAll();

}