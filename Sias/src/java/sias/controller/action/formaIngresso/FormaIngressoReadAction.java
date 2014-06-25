package sias.controller.action.formaIngresso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.FormaIngressoDAO;
import sias.model.pojo.FormaIngresso;

public class FormaIngressoReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
    String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String descricao = input.getString("descricao");
        if (descricao != null && !descricao.isEmpty()){
            criteria.put(FormaIngressoDAO.CRITERION_DESCRICAO_I_LIKE, descricao);
        }
        List<FormaIngresso> formaIngressos = ServiceLocator.getFormaIngressoService().readByCriteria(criteria);
        output.setValue("lista", formaIngressos);
        return consequence; 
    }
    
}
