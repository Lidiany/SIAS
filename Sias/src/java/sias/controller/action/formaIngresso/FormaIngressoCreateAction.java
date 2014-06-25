package sias.controller.action.formaIngresso;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.FormaIngresso;

public class FormaIngressoCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("codigo", input.getString("codigo"));
        form.put("descricao", input.getString("descricao"));
        form.put("ativo", input.getString("ativo"));
        //Validando
        Map<String, String> error = ServiceLocator.getFormaIngressoService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            FormaIngresso formaIngresso = new FormaIngresso();
            formaIngresso.setCodigo((String) form.get("codigo"));
            formaIngresso.setDescricao((String) form.get("descricao"));
            formaIngresso.setAtivo((String) form.get("ativo"));
            //Persistindo
            ServiceLocator.getFormaIngressoService().create(formaIngresso);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
