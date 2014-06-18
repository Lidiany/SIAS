package sias.controller.action.colaborador;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class ColaboradorDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getColaboradorService().delete(id);
        return SUCCESS;
    }
    
}
