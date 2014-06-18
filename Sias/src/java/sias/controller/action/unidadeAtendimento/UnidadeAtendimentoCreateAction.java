package sias.controller.action.unidadeAtendimento;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Municipio;
import sias.model.pojo.UnidadeAtendimento;

public class UnidadeAtendimentoCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("nome", input.getString("nome"));
        form.put("numerounidade", input.getString("numerounidade"));
        form.put("responsavel", input.getString("responsavel"));
        form.put("telefone", input.getString("telefone"));
        form.put("logradouro", input.getString("logradouro"));
        form.put("numero", input.getString("numero"));
        form.put("complementoendereco", input.getString("complementoendereco"));
        form.put("bairro", input.getString("bairro"));
        form.put("cep", input.getString("cep"));
        form.put("municipio.id", input.getLong("municipio.id"));
        Map<String, String> error = ServiceLocator.getUnidadeAtendimentoService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setNome((String) form.get("nome"));
            unidadeAtendimento.setNumeroUnidade((String) form.get("numerounidade"));
            unidadeAtendimento.setResponsavel((String) form.get("responsavel"));
            unidadeAtendimento.setTelefone((String) form.get("telefone"));
            unidadeAtendimento.setLogradouro((String) form.get("logradouro"));
            unidadeAtendimento.setNumero((String) form.get("numero"));
            unidadeAtendimento.setComplementoEndereco((String) form.get("complementoendereco"));
            unidadeAtendimento.setBairro((String) form.get("bairro"));
            unidadeAtendimento.setCep((String) form.get("cep"));
            Municipio municipio = ServiceLocator.getMunicipioService().readById((Long) form.get("municipio.id"));
            unidadeAtendimento.setMunicipio(municipio);
            ServiceLocator.getUnidadeAtendimentoService().create(unidadeAtendimento);
            consequence = SUCCESS;
        }else {
            output.setValue("error", error);
        }
        return consequence;
    }
    
}
