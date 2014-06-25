package sias.controller.action.tipoEscolaridade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.TipoEscolaridadeDAO;
import sias.model.pojo.TipoEscolaridade;

public class TipoEscolaridadeReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String descricao = input.getString("descricao");
        if (descricao != null && !descricao.isEmpty()) {
            criteria.put(TipoEscolaridadeDAO.CRITERION_DESCRICAO_I_LIKE, descricao);
        }
        List<TipoEscolaridade> tipoEscolaridades = ServiceLocator.getTipoEscolaridadeService().readByCriteria(criteria);
        output.setValue("lista", tipoEscolaridades);
        return consequence;
    }
}
