package sias.controller.action.uf;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Uf;

public class UfShowFormAction extends BaseAction{

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            Uf uf = ServiceLocator.getUfService().readById(id);
            output.setValue("uf", uf);
            consequence = "UPDATE";
        }
        return consequence;
    }
    
}
