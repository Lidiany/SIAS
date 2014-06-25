package sias.controller.action.tipoEscolaridade;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoEscolaridade;

public class TipoEscolaridadeUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("tipoEscolaridade.id"));
        form.put("codigo", input.getString("tipoEscolaridade.codigo"));
        form.put("descricao", input.getString("tipoEscolaridade.descricao"));
        form.put("ativo", input.getString("tipoEscolaridade.ativo"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoEscolaridadeService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoEscolaridade tipoEscolaridade = new TipoEscolaridade();
            tipoEscolaridade.setId((Long) form.get("id"));
            tipoEscolaridade.setCodigo((String) form.get("codigo"));
            tipoEscolaridade.setDescricao((String) form.get("descricao"));
            tipoEscolaridade.setAtivo((String) form.get("ativo"));
            //Persistindo
            ServiceLocator.getTipoEscolaridadeService().update(tipoEscolaridade);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
