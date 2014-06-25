package sias.controller.action.tipoOcupacao;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoOcupacao;

public class TipoOcupacaoUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("tipoOcupacao.id"));
        form.put("codigo", input.getString("tipoOcupacao.codigo"));
        form.put("descricao", input.getString("tipoOcupacao.descricao"));
        form.put("ativo", input.getString("tipoOcupacao.ativo"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoOcupacaoService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoOcupacao tipoOcupacao = new TipoOcupacao();
            tipoOcupacao.setId((Long) form.get("id"));
            tipoOcupacao.setCodigo((String) form.get("codigo"));
            tipoOcupacao.setDescricao((String) form.get("descricao"));
            tipoOcupacao.setAtivo((String) form.get("ativo"));
            //Persistindo
            ServiceLocator.getTipoOcupacaoService().update(tipoOcupacao);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
