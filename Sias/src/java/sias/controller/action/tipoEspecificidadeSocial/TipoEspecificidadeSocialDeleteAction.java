package sias.controller.action.tipoEspecificidadeSocial;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class TipoEspecificidadeSocialDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getTipoEspecificidadeSocialService().delete(id);
        return SUCCESS;
    }
}
