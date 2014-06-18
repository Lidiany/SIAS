package sias.controller.action.tipoEspecificidadeSocial;

import java.util.HashMap;
import java.util.Map;
import static org.mentawai.core.Action.ERROR;
import static org.mentawai.core.Action.SUCCESS;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoEspecificidadeSocial;

public class TipoEspecificidadeSocialUpdateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("tipoEspecificidadeSocial.id"));
        form.put("descricao", input.getString("tipoEspecificidadeSocial.descricao"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoEspecificidadeSocialService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoEspecificidadeSocial tipoEspecificidadeSocial = new TipoEspecificidadeSocial();
            tipoEspecificidadeSocial.setId((Long) form.get("id"));
            tipoEspecificidadeSocial.setDescricao((String) form.get("descricao"));
            //Persistindo
            ServiceLocator.getTipoEspecificidadeSocialService().update(tipoEspecificidadeSocial);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
