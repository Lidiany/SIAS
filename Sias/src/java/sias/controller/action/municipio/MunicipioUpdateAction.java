package sias.controller.action.municipio;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Municipio;

public class MunicipioUpdateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("municipio.id"));
        form.put("nome", input.getString("municipio.nome"));
        form.put("uf.id", input.getLong("municipio.uf.id"));
        //Validando
        Map<String, String> error = ServiceLocator.getUfService().validateForUpdate(form);
        if (error == null || error.isEmpty()){
            //Monto o pojo
            Municipio municipio = new Municipio();
            municipio.setId((Long) form.get("id"));
            municipio.setNome((String) form.get("nome"));
            Long ufId = (Long) form.get("uf.id");
            municipio.setUf(ServiceLocator.getUfService().readById(ufId));
            //Persistindo
            ServiceLocator.getMunicipioService().update(municipio);
            consequence = SUCCESS;
        }else {
            output.setValue("error", error);
        }
        return consequence;
    }
    
}
