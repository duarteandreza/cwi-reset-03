package br.com.cwi.reset.andrezaduarte.service;

import br.com.cwi.reset.andrezaduarte.FakeDatabase;
import br.com.cwi.reset.andrezaduarte.exception.*;
import br.com.cwi.reset.andrezaduarte.model.Estudio;
import br.com.cwi.reset.andrezaduarte.request.EstudioRequest;
import br.com.cwi.reset.andrezaduarte.validator.BasicInfoRequiredValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {

        this.fakeDatabase = fakeDatabase;

    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {
        new BasicInfoRequiredValidator().accept(estudioRequest.getNome(),estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade(), TipoDominioException.ESTUDIO);

        List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();

        for (Estudio estudioCadastrado : estudiosCadastrados) {
            if (estudioCadastrado.getNome().equalsIgnoreCase(estudioRequest.getNome())) {
                throw new CadastroDuplicadoException(TipoDominioException.ESTUDIO.getSingular(), estudioRequest.getNome());
            }
        }

        Integer idGerado = estudiosCadastrados.size() + 1;
        Estudio estudio = new Estudio(idGerado, estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());
        fakeDatabase.persisteEstudio(estudio);
    }

    public List<Estudio> listartarEstudios() throws Exception {


        final List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        if (estudios.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ESTUDIO.getSingular(), TipoDominioException.ESTUDIO.getPlural());
        }

        return estudios;
    }

    public List<Estudio> listarEstudios(final String filtroNome) throws Exception {
        final List<Estudio> estudiosCadastrados = fakeDatabase.recuperaEstudios();

        if (estudiosCadastrados.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ESTUDIO.getSingular(), TipoDominioException.ESTUDIO.getPlural());
        }

        final List<Estudio> retorno = new ArrayList<>();

        if (filtroNome != null) {
            for (Estudio estudio : estudiosCadastrados) {
                final boolean containsFilter = estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter) {
                    retorno.add(estudio);
                }
            }
        } else {
            retorno.addAll(estudiosCadastrados);
        }

        if (retorno.isEmpty()) {
            throw new FiltroNomeNaoEncontrado("Estudio", filtroNome);
        }

        return retorno;
    }

    public Estudio consultarEstudio(Integer id) throws Exception {
        if (id == null) {
            throw new IdNaoInformado();
        }

        final List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        for (Estudio estudio : estudios) {
            if (estudio.getId().equals(id)) {
                return estudio;
            }
        }
        throw new ConsultaIdInvalidoException(TipoDominioException.ESTUDIO.getSingular(), id);
    }
}