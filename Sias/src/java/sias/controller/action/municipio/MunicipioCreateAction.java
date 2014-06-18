package sias.controller.action.municipio;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Municipio;
import sias.model.pojo.Uf;

public class MunicipioCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("nome", input.getString("nome"));
        form.put("uf.id", input.getLong("uf.id"));
        Map<String, String> error = ServiceLocator.getMunicipioService().validateForCreate(form);
        if (error == null || error.isEmpty()){
            Municipio municipio = new Municipio();
            municipio.setNome((String) form.get("nome"));
            Uf uf = ServiceLocator.getUfService().readById((Long) form.get("uf.id"));
            municipio.setUf(uf);
            ServiceLocator.getMunicipioService().create(municipio);
            consequence = SUCCESS;
        }else {
            output.setValue("error", error);
        }
        return consequence;
    }
    
}
