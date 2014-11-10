package sias.controller.action.pessoa;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoEscolaridade;

public class PessoaEscolaridadeAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        Long id = input.getLong("id");
         Pessoa pessoa = ServiceLocator.getPessoaService().readById(id);
         output.setValue("pessoa", pessoa);
         output.setValue("lerEscrever", input.getString("lerEscrever"));
         output.setValue("frequenciaEscolar", input.getString("frequenciaEscolar"));
        
         List<TipoEscolaridade> tipoEscolaridadeList = ServiceLocator.getTipoEscolaridadeService().readByCriteria(new HashMap<String, Object>());

         Map<Long, String> tipoEscolaridadeOptions = new LinkedHashMap<Long, String>();
         for (TipoEscolaridade tipoEscolaridade : tipoEscolaridadeList) {
         tipoEscolaridadeOptions.put(tipoEscolaridade.getId(), tipoEscolaridade.getDescricao());
         }
         output.setValue("tipoEscolaridadeOptions", tipoEscolaridadeOptions);
         output.setValue("dataatualizacaoescolaridade", new Date());
         return SUCCESS;
         
        /*String consequence = ERROR;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        Long id = input.getLong("id");
        Pessoa pessoa = ServiceLocator.getPessoaService().readById(id);
        output.setValue("pessoa", pessoa);
        form.put("id", input.getLong("pessoa.id"));
        form.put("lerEscrever", input.getString("pessoa.lerEscrever"));
        form.put("frequenciaEscolar", input.getString("pessoa.frequenciaEscolar"));
        form.put("dataatualizacaoEscolaridade", input.getString("pessoa.dataAtualizacaoEscolaridade"));
        form.put("tipoEscolaridade.id", input.getLong("pessoa.tipoEscolaridade.id"));
        //Validando
        Map<String, String> error = ServiceLocator.getPessoaService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
//            Pessoa pessoa = new Pessoa();
            pessoa.setId((Long) form.get("id"));
            pessoa.setLerEscrever((String) form.get("lerEscrever"));
            pessoa.setFrequenciaEscolar((String) form.get("frequenciaEscolar"));

            String dataAtualizacaoEscolaridade = (String) form.get("dataAtualizacaoEscolaridade");
            if (dataAtualizacaoEscolaridade != null && (!dataAtualizacaoEscolaridade.isEmpty())) {
                pessoa.setDataAtualizacaoEscolaridade(new java.sql.Date(sdf.parse(dataAtualizacaoEscolaridade).getTime()));
            }

            //pessoa.setDataAtualizacaoEscolaridade(new java.sql.Date(sdf.parse((String)form.get("pessoa.dataAtualizacaoEscolaridade")).getTime()));
            Long tipoEscolaridadeId = (Long) form.get("tipoEscolaridade.id");
            pessoa.setTipoEscolaridade(ServiceLocator.getTipoEscolaridadeService().readById(tipoEscolaridadeId));

            //Persistindo
//            pessoa = (Pessoa) ServiceLocator.getPessoaService();
//            output.setValue("pessoa", pessoa);
            //ServiceLocator.getPessoaService().create(pessoa);
            consequence = SUCCESS;

        } else {
            output.setValue("error", error);
            this.preload();
        }
        return consequence;
        /*        */
    }

/*    private void preload() throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();

        criteria.clear();
        List<TipoEscolaridade> tipoEscolaridades = ServiceLocator.getTipoEscolaridadeService().readByCriteria(criteria);

        Map<Long, String> tipoEscolaridadeOptions = new LinkedHashMap<Long, String>();
        for (TipoEscolaridade tipoEscolaridade : tipoEscolaridades) {
            tipoEscolaridadeOptions.put(tipoEscolaridade.getId(), tipoEscolaridade.getDescricao());
        }
        output.setValue("tipoEscolaridadeOptions", tipoEscolaridadeOptions);

    }
*/
}
