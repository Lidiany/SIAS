package sias.controller.action.tipoDeficiencia;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoDeficiencia;

public class TipoDeficienciaShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            TipoDeficiencia tipoDeficiencia = ServiceLocator.getTipoDeficienciaService().readById(id);
            output.setValue("tipoDeficiencia", tipoDeficiencia);
            consequence = "UPDATE";
        }
        return consequence;
    }
}
