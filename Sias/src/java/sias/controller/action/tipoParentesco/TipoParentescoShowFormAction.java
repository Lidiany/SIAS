package sias.controller.action.tipoParentesco;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoParentesco;

public class TipoParentescoShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            TipoParentesco tipoParentesco = ServiceLocator.getTipoParentescoService().readById(id);
            output.setValue("tipoParentesco", tipoParentesco);
            consequence = "UPDATE";
        }
        return consequence;
    }
}
