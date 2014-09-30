package sias.controller.action.pessoa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.dao.PessoaDAO;
import sias.model.pojo.Pessoa;

public class PessoaReadAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Map<String, Object> criteria = new HashMap<String, Object>();
        String nome = input.getString("nome");
        if (nome != null && !nome.isEmpty()) {
            criteria.put(PessoaDAO.CRITERION_NOME_I_LIKE, nome);
        }
        String cpf = input.getString("cpf");
        if (cpf != null && !cpf.isEmpty()){
            criteria.put(PessoaDAO.CRITERION_CPF_I_LIKE, cpf);
        }
        String nis = input.getString("nis");
        if(nis != null && !nis.isEmpty()){
            criteria.put(PessoaDAO.CRITERION_NIS_I_LIKE, nis);
        }
        List<Pessoa> pessoas = ServiceLocator.getPessoaService().readByCriteria(criteria);
        output.setValue("lista", pessoas);
        
        return consequence;
    }
    
}
