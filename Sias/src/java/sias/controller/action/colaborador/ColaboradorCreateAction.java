package sias.controller.action.colaborador;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Colaborador;
import sias.model.pojo.Municipio;
import sias.model.pojo.UnidadeAtendimento;

public class ColaboradorCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("nome", input.getString("nome"));
        form.put("cpf", input.getString("cpf"));
        form.put("numeroRg", input.getString("numeroRg"));
        form.put("orgaoExpedidor", input.getString("orgaoExpedidor"));
        form.put("dataEmissao", input.getString("dataEmissao"));
        form.put("uf", input.getString("uf"));
        form.put("cargo", input.getString("cargo"));
        form.put("funcao", input.getString("funcao"));
        form.put("telefone", input.getString("telefone"));
        form.put("logradouro", input.getString("logradouro"));
        form.put("numero", input.getString("numero"));
        form.put("bairro", input.getString("bairro"));
        form.put("complementoEndereco", input.getString("complementoEndereco"));
        form.put("municipio.id", input.getLong("municipio.id"));
        form.put("cep", input.getString("cep"));
        form.put("unidadeAtendimento.id", input.getLong("unidadeAtendimento.id"));
        //Validando
        Map<String, String> error = ServiceLocator.getColaboradorService().validateForCreate(form);
        if (error == null || error.isEmpty()){
            //Monto o pojo
            Colaborador colaborador = new Colaborador();
            colaborador.setNome((String)  form.get("nome"));
            colaborador.setCpf((String) form.get("cpf"));
            colaborador.setNumeroRg((String) form.get("numeroRg"));
            colaborador.setOrgaoExpedidor((String) form.get("orgaoExpedidor"));
            colaborador.setDataEmissao((java.util.Date) form.get("dataEmissao"));
            colaborador.setUf((String) form.get("uf"));
            colaborador.setCargo((String) form.get("cargo"));
            colaborador.setFuncao((String) form.get("funcao"));
            colaborador.setTelefone((String) form.get("telefone"));
            colaborador.setLogradouro((String) form.get("logradouro"));
            colaborador.setNumero((String) form.get("numero"));
            colaborador.setBairro((String) form.get("bairro"));
            colaborador.setComplementoEndereco((String) form.get("complementoEndereco"));
            Municipio municipio = ServiceLocator.getMunicipioService().readById((Long) form.get("municicpio.id"));
            colaborador.setMunicipio(municipio);
            colaborador.setCep((String) form.get("cep"));
            UnidadeAtendimento unidadeAtendimento = ServiceLocator.getUnidadeAtendimentoService().readById((Long) form.get("unidadeAtendimento.id"));
            colaborador.setUnidadeAtendimento(unidadeAtendimento);
            //Persistindo
            ServiceLocator.getColaboradorService().create(colaborador);
            consequence = SUCCESS;
        }else {
            output.setValue("error", error);
        }
        return consequence;
    }
    
}