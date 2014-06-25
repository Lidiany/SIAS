package sias.controller.action.tipoBeneficioDespesa;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.TipoBeneficioDespesa;

public class TipoBeneficioDespesaCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("id", input.getLong("id"));
        form.put("descricao", input.getString("descricao"));
        form.put("tipo", input.getString("tipo"));
        //Validando
        Map<String, String> error = ServiceLocator.getTipoBeneficioDespesaService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            TipoBeneficioDespesa tipoBeneficioDespesa = new TipoBeneficioDespesa();
            tipoBeneficioDespesa.setId((Long) form.get("id"));
            tipoBeneficioDespesa.setDescricao((String) form.get("descricao"));
            tipoBeneficioDespesa.setTipo((String) form.get("tipo"));
            //Persistindo
            ServiceLocator.getTipoBeneficioDespesaService().create(tipoBeneficioDespesa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
}
