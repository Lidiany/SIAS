package sias.controller;

import org.mentawai.core.ActionConfig;
import org.mentawai.core.ApplicationManager;
import org.mentawai.core.Forward;
import org.mentawai.core.Redirect;
import sias.controller.action.TesteAction;
import sias.controller.action.colaborador.ColaboradorCreateAction;
import sias.controller.action.colaborador.ColaboradorDeleteAction;
import sias.controller.action.colaborador.ColaboradorReadAction;
import sias.controller.action.colaborador.ColaboradorShowFormAction;
import sias.controller.action.colaborador.ColaboradorUpdateAction;
import sias.controller.action.municipio.MunicipioCreateAction;
import sias.controller.action.municipio.MunicipioDeleteAction;
import sias.controller.action.municipio.MunicipioReadAction;
import sias.controller.action.municipio.MunicipioShowFormAction;
import sias.controller.action.municipio.MunicipioUpdateAction;
import sias.controller.action.tipoEspecificidadeSocial.TipoEspecificidadeSocialCreateAction;
import sias.controller.action.tipoEspecificidadeSocial.TipoEspecificidadeSocialDeleteAction;
import sias.controller.action.tipoEspecificidadeSocial.TipoEspecificidadeSocialReadAction;
import sias.controller.action.tipoEspecificidadeSocial.TipoEspecificidadeSocialShowFormAction;
import sias.controller.action.tipoEspecificidadeSocial.TipoEspecificidadeSocialUpdateAction;
import sias.controller.action.uf.UfCreateAction;
import sias.controller.action.uf.UfDeleteAction;
import sias.controller.action.uf.UfReadAction;
import sias.controller.action.uf.UfShowFormAction;
import sias.controller.action.uf.UfUpdateAction;
import sias.controller.action.unidadeAtendimento.UnidadeAtendimentoCreateAction;
import sias.controller.action.unidadeAtendimento.UnidadeAtendimentoDeleteAction;
import sias.controller.action.unidadeAtendimento.UnidadeAtendimentoReadAction;
import sias.controller.action.unidadeAtendimento.UnidadeAtendimentoShowFormAction;
import sias.controller.action.unidadeAtendimento.UnidadeAtendimentoUpdateAction;
import static org.mentawai.core.ApplicationManager.ERROR;
import static org.mentawai.core.ApplicationManager.SUCCESS;

public class AppManager extends ApplicationManager {

    @Override
    public void loadActions() {
        //Configurar App.
        ActionConfig ac = null;

        //Action de Inicio
        ac = new ActionConfig("Teste", TesteAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/teste.page"));
        this.add(ac);
        
        //TipoEspecificidadeSocial
        ac = new ActionConfig("TipoEspecificidadeSocialRead", TipoEspecificidadeSocialReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/tipoEspecificidadeSocial/list.page"));
        this.add(ac);

        ac = new ActionConfig("TipoEspecificidadeSocialShowForm", TipoEspecificidadeSocialShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/tipoEspecificidadeSocial/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/TipoEspecificidadeSocial/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoEspecificidadeSocialCreate", TipoEspecificidadeSocialCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoEspecificidadeSocialRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoEspecificidadeSocial/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoEspecificidadeSocialUpdate", TipoEspecificidadeSocialUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoEspecificidadeSocialRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoEspecificidadeSocial/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoEspecificidadeSocialDelete", TipoEspecificidadeSocialDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("TipoEspecificidadeSocialRead.mtw"));
        this.add(ac);

        //UF
        ac = new ActionConfig("UfRead", UfReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/uf/list.page"));
        this.add(ac);

        ac = new ActionConfig("UfShowForm", UfShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/uf/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/uf/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("UfCreate", UfCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UfRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/uf/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("UfUpdate", UfUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UfRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/uf/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("UfDelete", UfDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("UfRead.mtw"));
        this.add(ac);
        
        //Municipio
        ac = new ActionConfig("MunicipioRead", MunicipioReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/municipio/list.page"));
        this.add(ac);

        ac = new ActionConfig("MunicipioShowForm", MunicipioShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/municipio/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/municipio/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("MunicipioCreate", MunicipioCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("MunicipioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("MunicipioShowForm.mtw"));
        this.add(ac);

        ac = new ActionConfig("MunicipioDelete", MunicipioDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("MunicipioRead.mtw"));
        this.add(ac);

        ac = new ActionConfig("MunicipioUpdate", MunicipioUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("MunicipioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("MunicipioShowForm.mtw"));
        this.add(ac);

        //Colaborador
        ac = new ActionConfig("ColaboradorRead", ColaboradorReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/colaborador/list.page"));
        this.add(ac);

        ac = new ActionConfig("ColaboradorShowForm", ColaboradorShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/colaborador/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/colaborador/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("ColaboradorCreate", ColaboradorCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("ColaboradorRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/colaborador/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("ColaboradorUpdate", ColaboradorUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("ColaboradorRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/colaborador/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("ColaboradorDelete", ColaboradorDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("ColaboradorRead.mtw"));
        this.add(ac);

        //Unidade Atendimento
        ac = new ActionConfig("UnidadeAtendimentoRead", UnidadeAtendimentoReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/unidadeAtendimento/list.page"));
        this.add(ac);

        ac = new ActionConfig("UnidadeAtendimentoShowForm", UnidadeAtendimentoShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/unidadeAtendimento/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/unidadeAtendimento/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("UnidadeAtendimentoCreate", UnidadeAtendimentoCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UnidadeAtendimentoRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/unidadeAtendimento/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("UnidadeAtendimentoUpdate", UnidadeAtendimentoUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("UnidadeAtendimentoRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/unidadeAtendimento/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("UnidadeAtendimentoDelete", UnidadeAtendimentoDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("UnidadeAtendimentoRead.mtw"));
        this.add(ac);
    }        
}
