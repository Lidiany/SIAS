package sias.controller.action.tipoParentesco;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class TipoParentescoDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getTipoParentescoService().delete(id);
        return SUCCESS;
    }
}
