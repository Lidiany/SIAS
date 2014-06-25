package sias.controller.action.tipoOcupacao;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoOcupacao;

public class TipoOcupacaoShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            TipoOcupacao tipoOcupacao = ServiceLocator.getTipoOcupacaoService().readById(id);
            output.setValue("tipoOcupacao", tipoOcupacao);
            consequence = "UPDATE";
        }
        return consequence;
    }
}
