package sias.controller.action.unidadeAtendimento;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Municipio;
import sias.model.pojo.UnidadeAtendimento;

public class UnidadeAtendimentoShowFormAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            UnidadeAtendimento unidadeAtendimento = ServiceLocator.getUnidadeAtendimentoService().readById(id);
            output.setValue("unidadeAtendimento", unidadeAtendimento);
            consequence = "UPDATE";
        }
        this.preload();
        return consequence;
    }
    
    private void preload() throws Exception{
        Map<String, Object> criteria = new HashMap<String, Object>();
        
        List<Municipio> municipios = ServiceLocator.getMunicipioService().readByCriteria(criteria);
        
        Map<Long, String> municipioOptions = new LinkedHashMap<Long, String>();
        for(Municipio municipio : municipios) {
            municipioOptions.put(municipio.getId(), municipio.getNome());
        }
        output.setValue("municipioOptions", municipioOptions);
    }
}