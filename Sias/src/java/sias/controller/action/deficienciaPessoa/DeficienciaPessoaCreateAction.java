package sias.controller.action.deficienciaPessoa;

import java.util.HashMap;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.DeficienciaPessoa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoDeficiencia;

public class DeficienciaPessoaCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("descricao", input.getString("descricao"));
        form.put("tipodeficiencia.id", input.getLong("tipodeficiencia.id"));
        form.put("pessoa.id", input.getLong("pessoa.id"));
        //Validando
        Map<String, String> error = ServiceLocator.getDeficienciaPessoaService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            //Monto o pojo
            DeficienciaPessoa deficienciaPessoa = new DeficienciaPessoa();
            deficienciaPessoa.setDescricao((String) form.get("descricao"));
            TipoDeficiencia tipoDeficiencia = ServiceLocator.getTipoDeficienciaService().readById((Long) form.get("tipodeficiencia.id"));
            deficienciaPessoa.setTipoDeficiencia(tipoDeficiencia);
            Pessoa pessoa = ServiceLocator.getPessoaService().readById((Long) form.get("pessoa.id"));
            deficienciaPessoa.setPessoa(pessoa);
            //Persistindo
            ServiceLocator.getDeficienciaPessoaService().create(deficienciaPessoa);
            consequence = SUCCESS;

        } else {
            output.setValue("error", error);

        }

        return consequence;
    }
}
