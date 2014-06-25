package sias.controller.action.formaIngresso;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.FormaIngresso;

public class FormaIngressoUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("formaIngresso.id"));
        form.put("codigo", input.getString("formaIngresso.codigo"));
        form.put("descricao", input.getString("formaIngresso.descricao"));
        form.put("ativo", input.getString("formaIngresso.ativo"));
        //Validando
        Map<String, String> error = ServiceLocator.getFormaIngressoService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            FormaIngresso formaIngresso = new FormaIngresso();
            formaIngresso.setId((Long) form.get("id"));
            formaIngresso.setCodigo((String) form.get("codigo"));
            formaIngresso.setDescricao((String) form.get("descricao"));
            formaIngresso.setAtivo((String) form.get("ativo"));
            //Persistindo
            ServiceLocator.getFormaIngressoService().update(formaIngresso);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
