package sias.controller.action.unidadeAtendimento;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class UnidadeAtendimentoDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getUnidadeAtendimentoService().delete(id);
        return SUCCESS;
    }
    
}
