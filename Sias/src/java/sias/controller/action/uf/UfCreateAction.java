package sias.controller.action.uf;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Uf;

public class UfCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Monando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("nome", input.getString("nome"));
        form.put("sigla", input.getString("sigla"));
        //Validando
        Map<String, String> error = ServiceLocator.getUfService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            Uf uf = new Uf();
            uf.setNome((String) form.get("nome"));
            uf.setSigla((String) form.get("sigla"));
            //Persistindo
            ServiceLocator.getUfService().create(uf);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
    return consequence;
    }

}
