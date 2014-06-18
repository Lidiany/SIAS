package sias.controller.action.uf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.UfDAO;
import sias.model.pojo.Uf;

public class UfReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
    String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        if (nome != null && !nome.isEmpty()){
            criteria.put(UfDAO.CRITERION_NOME_I_LIKE, nome);
        }
        List<Uf> uf = ServiceLocator.getUfService().readByCriteria(criteria);
        output.setValue("lista", uf);
        return consequence; 
    }
    
}
