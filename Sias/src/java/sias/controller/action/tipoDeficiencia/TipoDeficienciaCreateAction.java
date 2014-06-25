package sias.controller.action.tipoDeficiencia;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoDeficiencia;

public class TipoDeficienciaCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("codigo", input.getString("codigo"));
        form.put("descricao", input.getString("descricao"));
        form.put("ativo", input.getString("ativo"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoDeficienciaService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoDeficiencia tipoDeficiencia = new TipoDeficiencia();
            tipoDeficiencia.setCodigo((String) form.get("codigo"));
            tipoDeficiencia.setDescricao((String) form.get("descricao"));
            tipoDeficiencia.setAtivo((String) form.get("ativo"));
            //Persistindo
            ServiceLocator.getTipoDeficienciaService().create(tipoDeficiencia);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}