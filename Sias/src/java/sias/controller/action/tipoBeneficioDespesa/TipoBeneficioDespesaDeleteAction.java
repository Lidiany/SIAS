package sias.controller.action.tipoBeneficioDespesa;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class TipoBeneficioDespesaDeleteAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getTipoBeneficioDespesaService().delete(id);
        return SUCCESS;
    }
}
