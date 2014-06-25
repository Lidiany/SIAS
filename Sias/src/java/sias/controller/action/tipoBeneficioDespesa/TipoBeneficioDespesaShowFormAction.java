package sias.controller.action.tipoBeneficioDespesa;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoBeneficioDespesa;

public class TipoBeneficioDespesaShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            TipoBeneficioDespesa tipoBeneficioDespesa = ServiceLocator.getTipoBeneficioDespesaService().readById(id);
            output.setValue("tipoBeneficioDespesa", tipoBeneficioDespesa);
            consequence = "UPDATE";
        }
        return consequence;
    }
}
