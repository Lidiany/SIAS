package sias.controller.action.beneficioDespesa;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.BeneficioDespesa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoBeneficioDespesa;

public class BeneficioDespesaCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("datainicio", input.getDate("datainicio"));
        form.put("datatermino", input.getDate("datatermino"));
        form.put("valor", input.getFloat("valor"));
        form.put("dataatualizacao", input.getDate("dataatualizacao"));
        form.put("tipobeneficiodespesa.id", input.getLong("tipobeneficiodespesa.id"));
        form.put("pessoa.id", input.getLong("pessoa.id"));
        //Validando
        Map<String, String> error = ServiceLocator.getBeneficioDespesaService().validateForCreate(form);
        if (error == null || error.isEmpty()){
            //Monto o pojo
            BeneficioDespesa beneficioDespesa = new BeneficioDespesa();
            beneficioDespesa.setDataInicio(new Date (sdf.parse(input.getString("datainicio")).getTime()));
            beneficioDespesa.setDataTermino(new Date (sdf.parse(input.getString("datatermino")).getTime()));
            beneficioDespesa.setValor((Float) form.get("valor"));
            beneficioDespesa.setDataAtualizacao(new Date(sdf.parse(input.getString("dataatualizacao")).getTime()));
            TipoBeneficioDespesa tipoBeneficioDespesa = ServiceLocator.getTipoBeneficioDespesaService().readById((Long) form.get("tipobeneficiodespesa.id"));
            beneficioDespesa.setTipoBeneficioDespesa(tipoBeneficioDespesa);
            Pessoa pessoa = ServiceLocator.getPessoaService().readById((Long) form.get("pessoa.id"));
            beneficioDespesa.setPessoa(pessoa);
            //Persistindo
            ServiceLocator.getBeneficioDespesaService().create(beneficioDespesa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }
        return consequence;
    }
    
}
