package sias.controller.action.tipoDeficiencia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.TipoDeficienciaDAO;
import sias.model.pojo.TipoDeficiencia;

public class TipoDeficienciaReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String descricao = input.getString("descricao");
        if (descricao != null && !descricao.isEmpty()) {
            criteria.put(TipoDeficienciaDAO.CRITERION_DESCRICAO_I_LIKE, descricao);
        }
        List<TipoDeficiencia> tipoDeficiencia = ServiceLocator.getTipoDeficienciaService().readByCriteria(criteria);
        output.setValue("lista", tipoDeficiencia);
        return consequence;
    }
}
