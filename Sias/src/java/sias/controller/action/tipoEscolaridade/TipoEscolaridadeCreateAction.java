package sias.controller.action.tipoEscolaridade;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoEscolaridade;

public class TipoEscolaridadeCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("codigo", input.getString("codigo"));
        form.put("descricao", input.getString("descricao"));
        form.put("ativo", input.getString("ativo"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoEscolaridadeService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoEscolaridade tipoEscolaridade = new TipoEscolaridade();
            tipoEscolaridade.setCodigo((String) form.get("codigo"));
            tipoEscolaridade.setDescricao((String) form.get("descricao"));
            tipoEscolaridade.setAtivo((String) form.get("ativo"));
            //Persistindo
            ServiceLocator.getTipoEscolaridadeService().create(tipoEscolaridade);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
