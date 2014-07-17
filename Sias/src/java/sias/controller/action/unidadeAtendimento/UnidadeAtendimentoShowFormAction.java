package sias.controller.action.unidadeAtendimento;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Municipio;
import sias.model.pojo.Uf;
import sias.model.pojo.UnidadeAtendimento;

public class UnidadeAtendimentoShowFormAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        UnidadeAtendimento unidadeAtendimento = null;
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            unidadeAtendimento = ServiceLocator.getUnidadeAtendimentoService().readById(id);
           /* output.setValue("id", unidadeAtendimento.getId());
            output.setValue("nome", unidadeAtendimento.getNome());
            output.setValue("numerounidade", unidadeAtendimento.getNumeroUnidade());
            output.setValue("responsavel", unidadeAtendimento.getResponsavel());
            output.setValue("telefone", unidadeAtendimento.getTelefone());
            output.setValue("logradouro", unidadeAtendimento.getLogradouro());
            output.setValue("numero", unidadeAtendimento.getNumero());
            output.setValue("complementoendereco", unidadeAtendimento.getComplementoEndereco());
            output.setValue("bairro", unidadeAtendimento.getBairro());
            output.setValue("municipio.id", unidadeAtendimento.getMunicipio().getId());
            output.setValue("uf.id", unidadeAtendimento.getUf().getId());
            output.setValue("cep", unidadeAtendimento.getCep());*/
            output.setValue("unidadeatendimento", unidadeAtendimento);
            consequence = "UPDATE";
        }
        this.preload(unidadeAtendimento);
        return consequence;
    }
    
    private void preload(UnidadeAtendimento unidadeAtendimento) throws Exception{
        Map<String, Object> criteria = new HashMap<String, Object>();
        
        criteria.clear();
        List<Municipio> municipios = ServiceLocator.getMunicipioService().readByCriteria(criteria);
        
        Map<Long, String> municipioOptions = new LinkedHashMap<Long, String>();
        for(Municipio municipio : municipios) {
            municipioOptions.put(municipio.getId(), municipio.getNome());
        }
        output.setValue("municipioOptions", municipioOptions);
        
        criteria.clear();
        List<Uf> ufs = ServiceLocator.getUfService().readByCriteria(criteria);
        
        Map<Long, String> ufOptions = new LinkedHashMap<Long, String>();
        for(Uf uf: ufs) {
            ufOptions.put(uf.getId(), uf.getNome());
        }
        output.setValue("ufOptions", ufOptions);
    }
}