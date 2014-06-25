package sias.controller.action.tipoParentesco;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoParentesco;

public class TipoParentescoUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("tipoParentesco.id"));
        form.put("codigo", input.getString("tipoParentesco.codigo"));
        form.put("descricao", input.getString("tipoParentesco.descricao"));
        form.put("ativo", input.getString("tipoParentesco.ativo"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoParentescoService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoParentesco tipoParentesco = new TipoParentesco();
            tipoParentesco.setId((Long) form.get("id"));
            tipoParentesco.setCodigo((String) form.get("codigo"));
            tipoParentesco.setDescricao((String) form.get("descricao"));
            tipoParentesco.setAtivo((String) form.get("ativo"));
            //Persistindo
            ServiceLocator.getTipoParentescoService().update(tipoParentesco);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}

