package br.com.cwi.reset.andrezaduarte;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {

            this.fakeDatabase = fakeDatabase;
        }

        public void cadastrarDiretor(DiretorRequest diretorRequest) throws CampoObrigatorioException, NomeSobrenomeException, DataNascimentoInvalidaException, AnoInicioAtividadeInvalidoException, MesmoNomeException {

        if (diretorRequest.getNome() == null) throw new CampoObrigatorioException("nome");
        if (diretorRequest.getDataNascimento() == null) throw new CampoObrigatorioException("data de nascimento");
        if (diretorRequest.getAnoInicioAtividade() == null) throw new CampoObrigatorioException("ano de início da atividade");

        if (diretorRequest.getNome().length() < 2) throw new NomeSobrenomeException();

        if (LocalDate.now().compareTo(diretorRequest.getDataNascimento()) < 0) throw new DataNascimentoInvalidaException();

        if (diretorRequest.getDataNascimento().getYear() > diretorRequest.getAnoInicioAtividade()) throw new AnoInicioAtividadeInvalidoException();

        }

    public List<Diretor> listarDiretores(String filtroNome) throws SemFiltroException, NenhumCadastradoException {

        if (fakeDatabase.recuperaDiretores().size() == 0) throw new NenhumCadastradoException();

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        List<Diretor> diretoresFiltrados = new ArrayList<>();
        for (Diretor i : diretores) {
            if (i.getNome().contains(filtroNome)) diretoresFiltrados.add(i);

        }

        if (diretoresFiltrados == 0) throw new SemFiltroException(filtroNome);

        return diretoresFiltrados;
    }

    public Diretor consultarDiretor(Integer id) throws CampoObrigatorioException, NenhumEncontradoIdException {

        if (id == null) throw new CampoObrigatorioException("id");
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        Diretor diretorEncontrado = null;

        for (Diretor i : diretores) {
            if (Diretor.getId() == id) {
                diretorEncontrado = i;
            }
        }

        if (diretorEncontrado == null) throw new NenhumEncontradoIdException();
        return diretorEncontrado;
    }

}
