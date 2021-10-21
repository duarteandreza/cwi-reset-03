package br.com.cwi.reset.andrezaduarte.service;

import br.com.cwi.reset.andrezaduarte.FakeDatabase;
import br.com.cwi.reset.andrezaduarte.exception.NomeNaoInformadoException;
import br.com.cwi.reset.andrezaduarte.exception.TipoDominioException;
import br.com.cwi.reset.andrezaduarte.model.Estudio;
import br.com.cwi.reset.andrezaduarte.request.EstudioRequest;
import br.com.cwi.reset.andrezaduarte.validator.BasicInfoRequiredValidator;

import java.util.List;

public class EstudioService {

    private FakeDatabase fakeDatabase;
    private Integer id;

    public EstudioService(FakeDatabase fakeDatabase) {

        this.fakeDatabase = fakeDatabase;
        this.id = 0;

    }

    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {
        new BasicInfoRequiredValidator().accept(estudioRequest.getNome(),estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade(), TipoDominioException.ESTUDIO);

        final Integer igGerado = estudiosCadastrados.size() + 1;

        Estudio estudio = new Estudio(this.id, estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());

        fakeDatabase.persisteEstudio(estudio);
    }

        final List<Estudio> estudiosCadastrados


}