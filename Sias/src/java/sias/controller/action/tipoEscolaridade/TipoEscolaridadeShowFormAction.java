package sias.controller.action.tipoEscolaridade;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoEscolaridade;

public class TipoEscolaridadeShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            TipoEscolaridade tipoEscolaridade = ServiceLocator.getTipoEscolaridadeService().readById(id);
            output.setValue("tipoEscolaridade", tipoEscolaridade);
            consequence = "UPDATE";
        }
        return consequence;
    }
}
