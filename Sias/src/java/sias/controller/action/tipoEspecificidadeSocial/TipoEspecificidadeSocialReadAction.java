package sias.controller.action.tipoEspecificidadeSocial;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.TipoEspecificidadeSocialDAO;
import sias.model.pojo.TipoEspecificidadeSocial;

public class TipoEspecificidadeSocialReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String descricao = input.getString("descricao");
        if (descricao != null && !descricao.isEmpty()){
            criteria.put(TipoEspecificidadeSocialDAO.CRITERION_DESCRICAO_I_LIKE, descricao);
        }
        List<TipoEspecificidadeSocial> tipoespecificidadesociais = ServiceLocator.getTipoEspecificidadeSocialService().readByCriteria(criteria);
        output.setValue("lista", tipoespecificidadesociais);
        return consequence;
    }
    
}
