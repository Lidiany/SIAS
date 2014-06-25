package sias.controller.action.tipoOcupacao;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class TipoOcupacaoDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getTipoOcupacaoService().delete(id);
        return SUCCESS;
    }
}
