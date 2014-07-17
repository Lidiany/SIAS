package sias.controller.action.colaborador;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Colaborador;
import sias.model.pojo.Municipio;
import sias.model.pojo.Uf;
import sias.model.pojo.UnidadeAtendimento;

public class ColaboradorShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Colaborador colaborador = null;
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            colaborador = ServiceLocator.getColaboradorService().readById(id);
         /*   output.setValue("id", colaborador.getId());
            output.setValue("nome", colaborador.getNome());
            output.setValue("cpf", colaborador.getCpf());
            output.setValue("numerorg", colaborador.getNumeroRg());
            output.setValue("orgaoexpedidor", colaborador.getOrgaoExpedidor());
            output.setValue("dataemissao", colaborador.getDataEmissao());
            output.setValue("ufemissao", colaborador.getUfEmissao());
            output.setValue("cargo", colaborador.getCargo());
            output.setValue("funcao", colaborador.getFuncao());
            output.setValue("telefone", colaborador.getTelefone());
            output.setValue("logradouro", colaborador.getLogradouro());
            output.setValue("numero", colaborador.getNumero());
            output.setValue("complementoendereco", colaborador.getComplementoEndereco());
            output.setValue("bairro", colaborador.getBairro());
            output.setValue("municipio.id", colaborador.getMunicipio().getId());
            output.setValue("uf.id", colaborador.getUf().getId());
            output.setValue("cep", colaborador.getCep());
            output.setValue("unidadeatendimento.id", colaborador.getUnidadeAtendimento());*/
            output.setValue("colaborador", colaborador);
            consequence = "UPDATE";
        }
        this.preload(colaborador);
        return consequence;
    }

    private void preload(Colaborador colaborador) throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();

        criteria.clear();
        List<Municipio> municipios = ServiceLocator.getMunicipioService().readByCriteria(criteria);

        Map<Long, String> municipioOptions = new LinkedHashMap<Long, String>();
        for (Municipio municipio : municipios) {
            municipioOptions.put(municipio.getId(), municipio.getNome());
        }
        output.setValue("municipioOptions", municipioOptions);

        criteria.clear();
        List<Uf> ufs = ServiceLocator.getUfService().readByCriteria(criteria);

        Map<Long, String> ufOptions = new LinkedHashMap<Long, String>();
        for (Uf uf : ufs) {
            ufOptions.put(uf.getId(), uf.getNome());
        }

        output.setValue("ufOptions", ufOptions);

        criteria.clear();
        List<UnidadeAtendimento> unidadeAtendimentos = ServiceLocator.getUnidadeAtendimentoService().readByCriteria(criteria);

        Map<Long, String> unidadeAtendimentoOptions = new LinkedHashMap<Long, String>();
        for (UnidadeAtendimento unidadeAtendimento : unidadeAtendimentos) {
            unidadeAtendimentoOptions.put(unidadeAtendimento.getId(), unidadeAtendimento.getNome());
        }

        output.setValue("unidadeAtendimentoOptions", unidadeAtendimentoOptions);
    }
}
