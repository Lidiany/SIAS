package sias.controller.action.municipio;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Municipio;
import sias.model.pojo.Uf;

public class MunicipioShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Municipio municipio = null;
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            municipio = ServiceLocator.getMunicipioService().readById(id);
            output.setValue("municipio", municipio);
            consequence = "UPDATE";
        }
        this.preload(municipio);
        return consequence;
    }

    private void preload(Municipio municipio) throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();

        criteria.clear();
        List<Uf> ufs = ServiceLocator.getUfService().readByCriteria(criteria);

        Map<Long, String> ufOptions = new LinkedHashMap<Long, String>();
        for (Uf uf : ufs) {
            ufOptions.put(uf.getId(), uf.getSigla());
        }

        output.setValue("ufOptions", ufOptions);
    }
}
