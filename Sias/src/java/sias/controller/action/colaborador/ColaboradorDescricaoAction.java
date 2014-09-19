package sias.controller.action.colaborador;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Colaborador;

public class ColaboradorDescricaoAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Long id = input.getLong("id");
        Colaborador colaborador = ServiceLocator.getColaboradorService().readById(id);
        output.setValue("id", colaborador.getId());
        output.setValue("nome", colaborador.getNome());
        output.setValue("cpf", colaborador.getCpf());
        output.setValue("numerorg", colaborador.getNumeroRg());
        output.setValue("orgaoexpedidor", colaborador.getOrgaoExpedidor());
        output.setValue("dataemissao", colaborador.getDataEmissao());
        output.setValue("ufemissao.sigla", colaborador.getUfEmissao().getSigla());
        output.setValue("cargo", colaborador.getCargo());
        output.setValue("funcao", colaborador.getFuncao());
        output.setValue("telefone", colaborador.getTelefone());
        output.setValue("logradouro", colaborador.getLogradouro());
        output.setValue("numero", colaborador.getNumero());
        output.setValue("complementoendereco", colaborador.getComplementoEndereco());
        output.setValue("bairro", colaborador.getBairro());
        output.setValue("municipio.nome", colaborador.getMunicipio().getNome());
        output.setValue("uf.id", colaborador.getUf());
        output.setValue("cep", colaborador.getCep());
        output.setValue("unidadeatendimento.id", colaborador.getUnidadeAtendimento());
        return consequence;
    }
    
}