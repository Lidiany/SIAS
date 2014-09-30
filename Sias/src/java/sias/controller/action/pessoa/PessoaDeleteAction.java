package sias.controller.action.pessoa;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class PessoaDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getPessoaService().delete(id);
        return SUCCESS;
    }
    
}
