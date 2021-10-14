package br.com.cwi.reset.andrezaduarte;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {

        this.fakeDatabase = fakeDatabase;
    }

    public void criarAtor(AtorRequest atorRequest) throws CampoObrigatorioException, NomeSobrenomeException, DataNascimentoInvalidaException, AnoInicioAtividadeInvalidoException, MesmoNomeException {

        if (atorRequest.getNome() == null) throw new CampoObrigatorioException("nome");
        if (atorRequest.getDataNascimento() == null) throw new CampoObrigatorioException("data de nascimento");
        if (atorRequest.getStatusCarreira() == null) throw new CampoObrigatorioException("status da carreira");
        if (atorRequest.getAnoInicioAtividade() == null)
            throw new CampoObrigatorioException("ano de início de atividade");

        if (atorRequest.getNome().length() < 2) throw new NomeSobrenomeException();

        if (LocalDate.now().compareTo(atorRequest.getDataNascimento()) < 0) throw new DataNascimentoInvalidaException();

        if (atorRequest.getDataNascimento().getYear() > atorRequest.getAnoInicioAtividade())
            throw new AnoInicioAtividadeInvalidoException();
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) throws NenhumCadastradoException, SemFiltroException {

        if (fakeDatabase.recuperaAtores().size() == 0) throw new NenhumCadastradoException();

        List<Ator> atores = fakeDatabase.recuperaAtores();
        List<Ator> atoresFiltrados = new ArrayList<>();
        for (Ator i : atores) {
            if (i.getStatusCarreira() == StatusCarreira.EM_ATIVIDADE) {
                if (i.getNome().contains(filtroNome)) atoresFiltrados.add(i);
            }
        }

        if (atoresFiltrados.size() == 0) throw new SemFiltroException(filtroNome);

        return atoresFiltrados;
    }

    public Ator consultarAtor(Integer id) throws CampoObrigatorioException, NenhumEncontradoIdException {
        if (id == null) throw new CampoObrigatorioException("id");
        List<Ator> atores = fakeDatabase.recuperaAtores();
        Ator atorencontrado = null;

        for (Ator i : atores) {
            if (Ator.getId() == id) {
                atorencontrado = i;
            }
        }

        if (atorencontrado == null) throw new NenhumEncontradoIdException();
        return atorencontrado;
    }

}

