package sias.controller.action.beneficioDespesa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.BeneficioDespesa;

public class BeneficioDespesaReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<BeneficioDespesa> beneficioDespesas = ServiceLocator.getBeneficioDespesaService().readByCriteria(criteria);
        output.setValue("lista", beneficioDespesas);
        return consequence;
        
    }
    
}
