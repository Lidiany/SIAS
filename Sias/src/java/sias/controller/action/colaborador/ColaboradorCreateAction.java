package sias.controller.action.colaborador;

import java.util.HashMap;
import java.util.Map;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Colaborador;
import sias.model.pojo.Municipio;
import sias.model.pojo.Uf;
import sias.model.pojo.UnidadeAtendimento;

public class ColaboradorCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {

        String consequence = ERROR;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("nome", input.getString("nome"));
        form.put("cpf", input.getString("cpf"));
        form.put("numerorg", input.getString("numerorg"));
        form.put("orgaoexpedidor", input.getString("orgaoexpedidor"));
        form.put("dataemissao", input.getString("dataemissao"));
        form.put("ufemissao.id", input.getLong("ufemissao.id"));
        form.put("cargo", input.getString("cargo"));
        form.put("funcao", input.getString("funcao"));
        form.put("telefone", input.getString("telefone"));
        form.put("logradouro", input.getString("logradouro"));
        form.put("numero", input.getString("numero"));
        form.put("bairro", input.getString("bairro"));
        form.put("complementoendereco", input.getString("complementoendereco"));
        form.put("municipio.id", input.getLong("municipio.id"));
        form.put("uf.id", input.getLong("uf.id"));
        form.put("cep", input.getString("cep"));
        form.put("unidadeatendimento.id", input.getLong("unidadeatendimento.id"));
        //Validando
        Map<String, String> error = ServiceLocator.getColaboradorService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo

            Colaborador colaborador = new Colaborador();
            colaborador.setNome((String) form.get("nome"));
            colaborador.setCpf((String) form.get("cpf"));
            colaborador.setNumeroRg((String) form.get("numerorg"));
            colaborador.setOrgaoExpedidor((String) form.get("orgaoexpedidor"));
            colaborador.setDataEmissao(new Date(sdf.parse(input.getString("dataemissao")).getTime()));
            Uf ufEmissao = ServiceLocator.getUfService().readById((Long) form.get("ufemissao.id"));
            colaborador.setUfEmissao(ufEmissao);
            colaborador.setCargo((String) form.get("cargo"));
            colaborador.setFuncao((String) form.get("funcao"));
            colaborador.setTelefone((String) form.get("telefone"));
            colaborador.setLogradouro((String) form.get("logradouro"));
            colaborador.setNumero((String) form.get("numero"));
            colaborador.setBairro((String) form.get("bairro"));
            colaborador.setComplementoEndereco((String) form.get("complementoendereco"));
            Municipio municipio = ServiceLocator.getMunicipioService().readById((Long) form.get("municipio.id"));
            colaborador.setMunicipio(municipio);
            Uf uf = ServiceLocator.getUfService().readById((Long) form.get("uf.id"));
            colaborador.setUf(uf);
            colaborador.setCep((String) form.get("cep"));
            UnidadeAtendimento unidadeAtendimento = ServiceLocator.getUnidadeAtendimentoService().readById((Long) form.get("unidadeatendimento.id"));
            colaborador.setUnidadeAtendimento(unidadeAtendimento);
            //Persistindo
            ServiceLocator.getColaboradorService().create(colaborador);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }

}
