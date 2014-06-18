package sias.controller.action.colaborador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.ColaboradorDAO;
import sias.model.pojo.Colaborador;

public class ColaboradorReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        if (nome != null && !nome.isEmpty()) {
            criteria.put(ColaboradorDAO.CRITERION_NOME_I_LIKE, nome);
        }
        List<Colaborador> colaboradores = ServiceLocator.getColaboradorService().readByCriteria(criteria);
        output.setValue("lista", colaboradores);
        return consequence;
    }
    
}
