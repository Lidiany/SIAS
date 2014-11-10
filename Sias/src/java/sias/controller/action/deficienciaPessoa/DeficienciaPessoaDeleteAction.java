package sias.controller.action.deficienciaPessoa;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class DeficienciaPessoaDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getDeficienciaPessoaService().delete(id);
        return SUCCESS;
    }
    
}
