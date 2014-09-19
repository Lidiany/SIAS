package sias.controller.action.unidadeAtendimento;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.UnidadeAtendimento;

public class UnidadeAtendimentoDescricaoAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Long id = input.getLong("id");
        UnidadeAtendimento unidadeAtendimento = ServiceLocator.getUnidadeAtendimentoService().readById(id);
        output.setValue("id", unidadeAtendimento.getId());
        output.setValue("nome", unidadeAtendimento.getNome());
        output.setValue("numerounidade", unidadeAtendimento.getNumeroUnidade());
        output.setValue("responsavel", unidadeAtendimento.getResponsavel());
        output.setValue("telefone", unidadeAtendimento.getTelefone());
        output.setValue("logradouro", unidadeAtendimento.getLogradouro());
        output.setValue("numero", unidadeAtendimento.getNumero());
        output.setValue("complementoendereco", unidadeAtendimento.getComplementoEndereco());
        output.setValue("bairro", unidadeAtendimento.getBairro());
        output.setValue("municipio.id", unidadeAtendimento.getMunicipio().getId());
        output.setValue("uf.sigla", unidadeAtendimento.getUf().getSigla());
        output.setValue("cep", unidadeAtendimento.getCep());
        return consequence;
    }
}
