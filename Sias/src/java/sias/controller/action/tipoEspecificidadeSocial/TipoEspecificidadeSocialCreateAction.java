package sias.controller.action.tipoEspecificidadeSocial;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoEspecificidadeSocial;

public class TipoEspecificidadeSocialCreateAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Monando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("descricao", input.getString("descricao"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoEspecificidadeSocialService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoEspecificidadeSocial tipoEspecificidadeSocial = new TipoEspecificidadeSocial();
            tipoEspecificidadeSocial.setDescricao((String) form.get("descricao"));
            //Persistindo
            ServiceLocator.getTipoEspecificidadeSocialService().create(tipoEspecificidadeSocial);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
    return consequence;
    }
}
