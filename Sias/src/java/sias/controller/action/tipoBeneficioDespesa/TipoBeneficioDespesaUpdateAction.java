package sias.controller.action.tipoBeneficioDespesa;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoBeneficioDespesa;

public class TipoBeneficioDespesaUpdateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("tipoBeneficioDespesa.id"));
        form.put("descricao", input.getString("tipoBeneficioDespesa.descricao"));
        form.put("tipo", input.getString("tipoBeneficioDespesa.tipo"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoBeneficioDespesaService().validateForUpdate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoBeneficioDespesa tipoBeneficioDespesa = new TipoBeneficioDespesa();
            tipoBeneficioDespesa.setId((Long) form.get("id"));
            tipoBeneficioDespesa.setDescricao((String) form.get("descricao"));
            tipoBeneficioDespesa.setTipo((String) form.get("tipo"));
            //Persistindo
            ServiceLocator.getTipoBeneficioDespesaService().update(tipoBeneficioDespesa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
