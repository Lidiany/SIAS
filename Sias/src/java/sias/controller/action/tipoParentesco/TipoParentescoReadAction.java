package sias.controller.action.tipoParentesco;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.TipoParentescoDAO;
import sias.model.pojo.TipoParentesco;

public class TipoParentescoReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String descricao = input.getString("descricao");
        if (descricao != null && !descricao.isEmpty()){
            criteria.put(TipoParentescoDAO.CRITERION_DESCRICAO_I_LIKE, descricao);
        }
        List<TipoParentesco> tipoParentescos = ServiceLocator.getTipoParentescoService().readByCriteria(criteria);
        output.setValue("lista", tipoParentescos);
        return consequence;
    }
}
