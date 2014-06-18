package sias.controller.action.uf;

import static org.mentawai.core.Action.SUCCESS;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class UfDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getUfService().delete(id);
        return SUCCESS;
    }
    
}
