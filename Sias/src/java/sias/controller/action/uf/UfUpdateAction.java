package sias.controller.action.uf;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Uf;

public class UfUpdateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("uf.id"));
        form.put("nome", input.getString("uf.nome"));
        form.put("sigla", input.getString("uf.sigla"));
        //Validando
        Map<String, String> error = ServiceLocator.getUfService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Uf uf = new Uf();
            uf.setId((Long) form.get("id"));
            uf.setNome((String) form.get("nome"));
            uf.setSigla((String) form.get("sigla"));
            //Persistindo
            ServiceLocator.getUfService().update(uf);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
    
}
