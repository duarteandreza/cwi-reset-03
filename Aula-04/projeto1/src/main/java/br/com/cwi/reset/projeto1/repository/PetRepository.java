package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.List;

public interface PetRepository {

        Pet buscarPeloNome(String nome);

        Pet salvar(Pet filme);

        void delete(Pet filme);

        Pet atualizar(Pet filme);

        List<Pet> listarTodos();


}
