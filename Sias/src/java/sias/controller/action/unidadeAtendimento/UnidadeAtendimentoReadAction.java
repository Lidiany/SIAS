package sias.controller.action.unidadeAtendimento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.UnidadeAtendimentoDAO;
import sias.model.pojo.UnidadeAtendimento;

public class UnidadeAtendimentoReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        if (nome != null && !nome.isEmpty()) {
            criteria.put(UnidadeAtendimentoDAO.CRITERION_NOME_I_LIKE, nome);
        }
        List<UnidadeAtendimento> unidadeAtendimentos = ServiceLocator.getUnidadeAtendimentoService().readByCriteria(criteria);
        output.setValue("lista", unidadeAtendimentos);
        return consequence;
    
    }
    
}
