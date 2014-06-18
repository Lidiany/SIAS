package sias.controller.action.colaborador;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Colaborador;

public class ColaboradorUpdateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("colaborador.id"));
        form.put("nome", input.getString("colaborador.nome"));
        form.put("cpf", input.getString("colaborador.cpf"));
        form.put("numeroRg", input.getString("colaborador.numeroRg"));
        form.put("orgaoExpedidor", input.getString("colaborador.orgaoExpedidor"));
        form.put("dataEmissao", input.getString("colaborador.dataEmissao"));
        form.put("uf", input.getString("colaborador.uf"));
        form.put("cargo", input.getString("colaborador.cargo"));
        form.put("funcao", input.getString("colaborador.funcao"));
        form.put("telefone", input.getString("colaborador.telefone"));
        form.put("logradouro", input.getString("colaborador.logradouro"));
        form.put("numero", input.getString("colaborador.numero"));
        form.put("bairro", input.getString("colaborador.bairro"));
        form.put("complementoEndereco", input.getString("colaborador.complementoEndereco"));
        form.put("municipio.id", input.getLong("colaborador.municipio.id"));
        form.put("cep", input.getString("colaborador.cep"));
        form.put("unidadeAtendimento.id", input.getLong("colaborador.unidadeAtendimento.id"));
        //Validando
        Map<String, String> error = ServiceLocator.getColaboradorService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Colaborador colaborador = new Colaborador();
            colaborador.setId((Long) form.get("id"));
            colaborador.setNome((String) form.get("nome"));
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
            Long municipioId = (Long) form.get("municipio.id");
            colaborador.setMunicipio(ServiceLocator.getMunicipioService().readById(municipioId));
            colaborador.setCep((String) form.get("cep"));
            Long unidadeAtendimentoId = (Long) form.get("unidadeAtendimento.id");
            colaborador.setUnidadeAtendimento(ServiceLocator.getUnidadeAtendimentoService().readById(unidadeAtendimentoId));
            //Persistindo
            ServiceLocator.getColaboradorService().update(colaborador);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;

    }
    
}
