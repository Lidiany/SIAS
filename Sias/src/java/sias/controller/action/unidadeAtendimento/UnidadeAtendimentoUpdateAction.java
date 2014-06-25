package sias.controller.action.unidadeAtendimento;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.UnidadeAtendimento;

public class UnidadeAtendimentoUpdateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("unidadeatendimento.id"));
        form.put("nome", input.getString("unidadeatendimento.nome"));
        form.put("numerounidade", input.getString("unidadeatendimento.numerounidade"));
        form.put("responsavel", input.getString("unidadeatendimento.responsavel"));
        form.put("telefone", input.getString("unidadeatendimento.telefone"));
        form.put("logradouro", input.getString("unidadeatendimento.logradouro"));
        form.put("numero", input.getString("unidadeatendimento.numero"));
        form.put("complementoendereco", input.getString("unidadeatendimento.complementoendereco"));
        form.put("bairro", input.getString("unidadeatendimento.bairro"));
        form.put("cep", input.getString("unidadeatendimento.cep"));
        form.put("municipio.id", input.getLong("unidadeatendimento.municipio.id"));
        form.put("uf.id", input.getLong("unidadeatendimento.uf.id"));
        //Validando
        Map<String, String> error = ServiceLocator.getUnidadeAtendimentoService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId((Long) form.get("id"));
            unidadeAtendimento.setNome((String) form.get("nome"));
            unidadeAtendimento.setNumeroUnidade((String) form.get("numerounidade"));
            unidadeAtendimento.setResponsavel((String) form.get("responsavel"));
            unidadeAtendimento.setTelefone((String) form.get("telefone"));
            unidadeAtendimento.setLogradouro((String) form.get("logradouro"));
            unidadeAtendimento.setNumero((String) form.get("numero"));
            unidadeAtendimento.setComplementoEndereco((String) form.get("complementoendereco"));
            unidadeAtendimento.setBairro((String) form.get("bairro"));
            unidadeAtendimento.setCep((String) form.get("cep"));
            Long municipioId = (Long) form.get("municipio.id");
            unidadeAtendimento.setMunicipio(ServiceLocator.getMunicipioService().readById(municipioId));
            Long ufId = (Long) form.get("uf.id");
            unidadeAtendimento.setUf(ServiceLocator.getUfService().readById(ufId));
            //Persistindo
            ServiceLocator.getUnidadeAtendimentoService().update(unidadeAtendimento);
            consequence = SUCCESS;
        }else {
            output.setValue("error", error);
        }
        return consequence;
    }
    
}
