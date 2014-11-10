package sias.controller.action.deficienciaPessoa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.DeficienciaPessoaDAO;
import sias.model.pojo.DeficienciaPessoa;

public class DeficienciaPessoaReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<DeficienciaPessoa> deficienciaPessoas = ServiceLocator.getDeficienciaPessoaService().readByCriteria(criteria);
        output.setValue("lista", deficienciaPessoas);
        return consequence;
    }
    
}
