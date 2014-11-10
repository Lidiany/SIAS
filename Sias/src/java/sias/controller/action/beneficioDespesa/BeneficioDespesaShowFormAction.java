package sias.controller.action.beneficioDespesa;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.BeneficioDespesa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoBeneficioDespesa;

public class BeneficioDespesaShowFormAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        BeneficioDespesa beneficioDespesa = null;
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            beneficioDespesa = ServiceLocator.getBeneficioDespesaService().readById(id);
            output.setValue("beneficioDespesa", beneficioDespesa);
            consequence = "UPDATE";
        }
        this.preload(beneficioDespesa);
        return consequence;
    }
    
    private void preload (BeneficioDespesa beneficioDespesa) throws Exception{
        Map<String, Object> criteria = new HashMap<String, Object>();
        
        criteria.clear();
        List<TipoBeneficioDespesa> tipoBeneficioDespesas = ServiceLocator.getTipoBeneficioDespesaService().readByCriteria(criteria);
        
        Map<Long, String> tipoBeneficioDespesaOptions = new LinkedHashMap<Long, String>();
        for (TipoBeneficioDespesa tipoBeneficioDespesa : tipoBeneficioDespesas) {
            tipoBeneficioDespesaOptions.put(tipoBeneficioDespesa.getId(), tipoBeneficioDespesa.getDescricao());
        }
        
        output.setValue("tipoBeneficioDespesaOptions", tipoBeneficioDespesaOptions);
        
        criteria.clear();
        List<Pessoa> pessoas = ServiceLocator.getPessoaService().readByCriteria(criteria);
        
        Map<Long, String> pessoaOptions = new LinkedHashMap<Long, String>();
        for (Pessoa pessoa : pessoas) {
            pessoaOptions.put(pessoa.getId(), pessoa.getNome());
        }
        
        output.setValue("pessoaOptions", pessoaOptions);
    }
}
