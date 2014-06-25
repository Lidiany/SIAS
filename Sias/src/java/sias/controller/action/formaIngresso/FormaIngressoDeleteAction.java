package sias.controller.action.formaIngresso;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class FormaIngressoDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getFormaIngressoService().delete(id);
        return SUCCESS;
    }
}
