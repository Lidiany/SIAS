package sias.controller.action.colaborador;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Colaborador;
import sias.model.pojo.Municipio;
import sias.model.pojo.UnidadeAtendimento;

public class ColaboradorShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            Colaborador colaborador = ServiceLocator.getColaboradorService().readById(id);
            output.setValue("colaborador", colaborador);
            consequence = "UPDATE";
        }
        this.preload();
        return consequence;
    }

    private void preload() throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();

        List<Municipio> municipios = ServiceLocator.getMunicipioService().readByCriteria(criteria);
        List<UnidadeAtendimento> unidadeAtendimentos = ServiceLocator.getUnidadeAtendimentoService().readByCriteria(criteria);
        
        Map<Long, String> municipioOptions = new LinkedHashMap<Long, String>();
        for (Municipio municipio : municipios) {
            municipioOptions.put(municipio.getId(), municipio.getNome());
        }

        Map<Long, String> unidadeAtendimentoOptions = new LinkedHashMap<Long, String>();
        for (UnidadeAtendimento unidadeAtendimento: unidadeAtendimentos) {
            unidadeAtendimentoOptions.put(unidadeAtendimento.getId(), unidadeAtendimento.getNome());
        }
        
        output.setValue("municipioOptions", municipioOptions);
        output.setValue("unidadeAtendimentoOptions", unidadeAtendimentoOptions);
    }
}


