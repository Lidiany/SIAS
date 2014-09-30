package sias.controller.action.tipoBeneficioDespesa;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.FormaIngresso;
import sias.model.pojo.Municipio;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoBeneficioDespesa;
import sias.model.pojo.TipoDeficiencia;
import sias.model.pojo.TipoEscolaridade;
import sias.model.pojo.TipoEspecificidadeSocial;
import sias.model.pojo.TipoOcupacao;
import sias.model.pojo.TipoParentesco;
import sias.model.pojo.Uf;

public class TipoBeneficioDespesaShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        TipoBeneficioDespesa tipoBeneficioDespesa = null;
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            tipoBeneficioDespesa = ServiceLocator.getTipoBeneficioDespesaService().readById(id);
            output.setValue("tipoBeneficioDespesa", tipoBeneficioDespesa);
            consequence = "UPDATE";
        }
        this.preload(tipoBeneficioDespesa);
        return consequence;
    }

    private void preload(TipoBeneficioDespesa tipoBeneficioDespesa) throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();

        criteria.clear();
        Map<String, String> tipoOptions = new LinkedHashMap<String, String>();
        tipoOptions.put("Benefício", "Benefício");
        tipoOptions.put("Despesa", "Despesa");
        output.setValue("tipoOptions", tipoOptions);

    }
}
