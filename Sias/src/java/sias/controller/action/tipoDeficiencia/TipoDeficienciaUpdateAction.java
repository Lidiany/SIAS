package sias.controller.action.tipoDeficiencia;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoDeficiencia;

public class TipoDeficienciaUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("tipoDeficiencia.id"));
        form.put("codigo", input.getString("tipoDeficiencia.codigo"));
        form.put("descricao", input.getString("tipoDeficiencia.descricao"));
        form.put("ativo", input.getString("tipoDeficiencia.ativo"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoDeficienciaService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoDeficiencia tipoDeficiencia = new TipoDeficiencia();
            tipoDeficiencia.setId((Long) form.get("id"));
            tipoDeficiencia.setCodigo((String) form.get("codigo"));
            tipoDeficiencia.setDescricao((String) form.get("descricao"));
            tipoDeficiencia.setAtivo((String) form.get("ativo"));
            //Persistindo
            ServiceLocator.getTipoDeficienciaService().update(tipoDeficiencia);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
