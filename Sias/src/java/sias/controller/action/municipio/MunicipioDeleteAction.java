package sias.controller.action.municipio;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class MunicipioDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getMunicipioService().delete(id);
        return SUCCESS;
    }
    
}
