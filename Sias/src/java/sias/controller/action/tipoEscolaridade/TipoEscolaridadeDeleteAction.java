package sias.controller.action.tipoEscolaridade;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class TipoEscolaridadeDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getTipoEscolaridadeService().delete(id);
        return SUCCESS;
    }
}
