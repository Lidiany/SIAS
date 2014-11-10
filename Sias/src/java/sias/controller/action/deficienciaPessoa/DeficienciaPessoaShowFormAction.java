package sias.controller.action.deficienciaPessoa;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.DeficienciaPessoa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoDeficiencia;

public class DeficienciaPessoaShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        DeficienciaPessoa deficienciaPessoa = null;
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            deficienciaPessoa = ServiceLocator.getDeficienciaPessoaService().readById(id);
            output.setValue("deficienciapessoa", deficienciaPessoa);
            consequence = "UPDATE";
        }
        this.preload(deficienciaPessoa);

        return consequence;
    }

    private void preload(DeficienciaPessoa deficienciaPessoa) throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();

        criteria.clear();
        List<TipoDeficiencia> tipoDeficiencias = ServiceLocator.getTipoDeficienciaService().readByCriteria(criteria);

        Map<Long, String> tipoDeficienciaOptions = new LinkedHashMap<Long, String>();
        for (TipoDeficiencia tipoDeficiencia : tipoDeficiencias) {
            tipoDeficienciaOptions.put(tipoDeficiencia.getId(), tipoDeficiencia.getDescricao());
        }

        output.setValue("tipoDeficienciaOptions", tipoDeficienciaOptions);

        criteria.clear();
        List<Pessoa> pessoas = ServiceLocator.getPessoaService().readByCriteria(criteria);

        Map<Long, String> pessoaOptions = new LinkedHashMap<Long, String>();
        for (Pessoa pessoa : pessoas) {
            pessoaOptions.put(pessoa.getId(), pessoa.getNome());
        }

        output.setValue("pessoaOptions", pessoaOptions);
    }

}
