package sias.controller.action.municipio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.MunicipioDAO;
import sias.model.pojo.Municipio;

public class MunicipioReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        if (nome != null && !nome.isEmpty()) {
            criteria.put(MunicipioDAO.CRITERION_NOME_I_LIKE, nome);
        }
        List<Municipio> municipios = ServiceLocator.getMunicipioService().readByCriteria(criteria);
        output.setValue("lista", municipios);
        return consequence;
    }
    
}
