package sias.controller.action.tipoBeneficioDespesa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.TipoBeneficioDespesaDAO;
import sias.model.pojo.TipoBeneficioDespesa;

public class TipoBeneficioDespesaReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String descricao = input.getString("descricao");
        if (descricao != null && !descricao.isEmpty()) {
            criteria.put(TipoBeneficioDespesaDAO.CRITERION_DESCRICAO_I_LIKE, descricao);
        }
        List<TipoBeneficioDespesa> tipoBeneficioDespesa = ServiceLocator.getTipoBeneficioDespesaService().readByCriteria(criteria);
        output.setValue("lista", tipoBeneficioDespesa);
        return consequence;
    }
}
