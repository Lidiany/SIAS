package sias.controller.action.tipoEspecificidadeSocial;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoEspecificidadeSocial;

public class TipoEspecificidadeSocialShowFormAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            TipoEspecificidadeSocial tipoEspecificidadeSocial = ServiceLocator.getTipoEspecificidadeSocialService().readById(id);
            output.setValue("tipoEspecificidadeSocial", tipoEspecificidadeSocial);
            consequence = "UPDATE";
        }
        return consequence;
    }
    
}
