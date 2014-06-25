package sias.controller.action.formaIngresso;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.FormaIngresso;

public class FormaIngressoShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
     String consequence = "CREATE";
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            FormaIngresso formaIngresso = ServiceLocator.getFormaIngressoService().readById(id);
            output.setValue("formaIngresso", formaIngresso);
            consequence = "UPDATE";
        }
        return consequence;
    }
}
