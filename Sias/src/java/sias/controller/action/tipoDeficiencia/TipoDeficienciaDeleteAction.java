package sias.controller.action.tipoDeficiencia;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class TipoDeficienciaDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getTipoDeficienciaService().delete(id);
        return SUCCESS;
    }
}
