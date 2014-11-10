package sias.controller.action.beneficioDespesa;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;

public class BeneficioDespesaDeleteAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        ServiceLocator.getBeneficioDespesaService().delete(id);
        return SUCCESS;
    }
    
}
