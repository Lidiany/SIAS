package sias.controller.action.pessoa;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoOcupacao;

public class PessoaTrabalhoRendaAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
        Pessoa pessoa = ServiceLocator.getPessoaService().readById(id);
        output.setValue("pessoa", pessoa);
        output.setValue("aposentadopensionista", input.getString("aposentadopensionista"));
        output.setValue("qualificacaoProfissional", input.getString("qualificacaoProfissional"));
        output.setValue("dataRenda", new Date());
        output.setValue("renda", input.getFloat("renda"));
        
        List<TipoOcupacao> tipoOcupacaoList = ServiceLocator.getTipoOcupacaoService().readByCriteria(new HashMap<String, Object>());

        Map<Long, String> tipoOcupacaoOptions = new LinkedHashMap<Long, String>();
        for (TipoOcupacao tipoOcupacao : tipoOcupacaoList) {
            tipoOcupacaoOptions.put(tipoOcupacao.getId(), tipoOcupacao.getDescricao());
        }
        output.setValue("tipoOcupacaoOptions", tipoOcupacaoOptions);
        return SUCCESS;
    }

}
