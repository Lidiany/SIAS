package sias.controller.action.tipoOcupacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.TipoOcupacaoDAO;
import sias.model.pojo.TipoOcupacao;

public class TipoOcupacaoReadAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String descricao = input.getString("descricao");
        if (descricao != null && !descricao.isEmpty()){
            criteria.put(TipoOcupacaoDAO.CRITERION_DESCRICAO_I_LIKE, descricao);
        }
        List<TipoOcupacao> tipoOcupacaos = ServiceLocator.getTipoOcupacaoService().readByCriteria(criteria);
        output.setValue("lista", tipoOcupacaos);
        return consequence;
    }
}
