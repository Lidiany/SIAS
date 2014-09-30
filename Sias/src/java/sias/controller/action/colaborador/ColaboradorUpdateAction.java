package sias.controller.action.colaborador;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

public class ColaboradorUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("colaborador.id"));
        form.put("nome", input.getString("colaborador.nome"));
        form.put("cpf", input.getString("colaborador.cpf"));
        form.put("numeroRg", input.getString("colaborador.numeroRg"));
        form.put("orgaoExpedidor", input.getString("colaborador.orgaoExpedidor"));
        form.put("dataemissao", input.getString("colaborador.dataEmissao"));
        form.put("ufEmissao.id", input.getLong("colaborador.ufEmissao.id"));
        form.put("cargo", input.getString("colaborador.cargo"));
        form.put("funcao", input.getString("colaborador.funcao"));
        form.put("telefone", input.getString("colaborador.telefone"));
        form.put("logradouro", input.getString("colaborador.logradouro"));
        form.put("numero", input.getString("colaborador.numero"));
        form.put("bairro", input.getString("colaborador.bairro"));
        form.put("complementoEndereco", input.getString("colaborador.complementoEndereco"));
        form.put("municipio.id", input.getLong("colaborador.municipio.id"));
        form.put("uf.id", input.getLong("colaborador.uf.id"));
        form.put("cep", input.getString("colaborador.cep"));
        form.put("unidadeatendimento.id", input.getLong("colaborador.unidadeAtendimento.id"));
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
            colaborador.setDataEmissao(new Date(sdf.parse(input.getString("colaborador.dataEmissao")).getTime()));
            Long ufEmissaoId = (Long) form.get("ufEmissao.id");
            colaborador.setUfEmissao(ServiceLocator.getUfService().readById(ufEmissaoId));
            colaborador.setCargo((String) form.get("cargo"));
            colaborador.setFuncao((String) form.get("funcao"));
            colaborador.setTelefone((String) form.get("telefone"));
            colaborador.setLogradouro((String) form.get("logradouro"));
            colaborador.setNumero((String) form.get("numero"));
            colaborador.setBairro((String) form.get("bairro"));
            colaborador.setComplementoEndereco((String) form.get("complementoEndereco"));
            Long municipioId = (Long) form.get("municipio.id");
            colaborador.setMunicipio(ServiceLocator.getMunicipioService().readById(municipioId));
            Long ufId = (Long) form.get("uf.id");
            colaborador.setUf(ServiceLocator.getUfService().readById(ufId));
            colaborador.setCep((String) form.get("cep"));
            Long unidadeAtendimentoId = (Long) form.get("unidadeatendimento.id");
            colaborador.setUnidadeAtendimento(ServiceLocator.getUnidadeAtendimentoService().readById(unidadeAtendimentoId));
            //Persistindo
            ServiceLocator.getColaboradorService().update(colaborador);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
            this.preload();
        }
        return consequence;

    }

    private void preload() throws Exception {
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
            ufOptions.put(uf.getId(), uf.getSigla());
        }

        output.setValue("ufOptions", ufOptions);

        criteria.clear();
        List<Uf> ufemissaos = ServiceLocator.getUfService().readByCriteria(criteria);

        Map<Long, String> ufEmissaoOptions = new LinkedHashMap<Long, String>();
        for (Uf ufemissao : ufemissaos) {
            ufEmissaoOptions.put(ufemissao.getId(), ufemissao.getSigla());
        }

        output.setValue("ufEmissaoOptions", ufEmissaoOptions);

        criteria.clear();
        List<UnidadeAtendimento> unidadeAtendimentos = ServiceLocator.getUnidadeAtendimentoService().readByCriteria(criteria);

        Map<Long, String> unidadeAtendimentoOptions = new LinkedHashMap<Long, String>();
        for (UnidadeAtendimento unidadeAtendimento : unidadeAtendimentos) {
            unidadeAtendimentoOptions.put(unidadeAtendimento.getId(), unidadeAtendimento.getNome());
        }

        output.setValue("unidadeAtendimentoOptions", unidadeAtendimentoOptions);
    }

}
