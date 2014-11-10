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
import sias.controller.action.beneficioDespesa.BeneficioDespesaCreateAction;
import sias.controller.action.beneficioDespesa.BeneficioDespesaDeleteAction;
import sias.controller.action.beneficioDespesa.BeneficioDespesaReadAction;
import sias.controller.action.beneficioDespesa.BeneficioDespesaShowFormAction;
import sias.controller.action.colaborador.ColaboradorDescricaoAction;
import sias.controller.action.deficienciaPessoa.DeficienciaPessoaCreateAction;
import sias.controller.action.deficienciaPessoa.DeficienciaPessoaDeleteAction;
import sias.controller.action.deficienciaPessoa.DeficienciaPessoaReadAction;
import sias.controller.action.deficienciaPessoa.DeficienciaPessoaShowFormAction;
import sias.controller.action.formaIngresso.FormaIngressoCreateAction;
import sias.controller.action.formaIngresso.FormaIngressoDeleteAction;
import sias.controller.action.formaIngresso.FormaIngressoReadAction;
import sias.controller.action.formaIngresso.FormaIngressoShowFormAction;
import sias.controller.action.formaIngresso.FormaIngressoUpdateAction;
import sias.controller.action.pessoa.PessoaCreateAction;
import sias.controller.action.pessoa.PessoaDeleteAction;
import sias.controller.action.pessoa.PessoaDescricaoAction;
import sias.controller.action.pessoa.PessoaEscolaridadeAction;
import sias.controller.action.pessoa.PessoaReadAction;
import sias.controller.action.pessoa.PessoaShowFormAction;
import sias.controller.action.pessoa.PessoaTrabalhoRendaAction;
import sias.controller.action.pessoa.PessoaUpdateAction;
import sias.controller.action.tipoBeneficioDespesa.TipoBeneficioDespesaCreateAction;
import sias.controller.action.tipoBeneficioDespesa.TipoBeneficioDespesaDeleteAction;
import sias.controller.action.tipoBeneficioDespesa.TipoBeneficioDespesaReadAction;
import sias.controller.action.tipoBeneficioDespesa.TipoBeneficioDespesaShowFormAction;
import sias.controller.action.tipoBeneficioDespesa.TipoBeneficioDespesaUpdateAction;
import sias.controller.action.tipoDeficiencia.TipoDeficienciaCreateAction;
import sias.controller.action.tipoDeficiencia.TipoDeficienciaDeleteAction;
import sias.controller.action.tipoDeficiencia.TipoDeficienciaReadAction;
import sias.controller.action.tipoDeficiencia.TipoDeficienciaShowFormAction;
import sias.controller.action.tipoDeficiencia.TipoDeficienciaUpdateAction;
import sias.controller.action.tipoEscolaridade.TipoEscolaridadeCreateAction;
import sias.controller.action.tipoEscolaridade.TipoEscolaridadeDeleteAction;
import sias.controller.action.tipoEscolaridade.TipoEscolaridadeReadAction;
import sias.controller.action.tipoEscolaridade.TipoEscolaridadeShowFormAction;
import sias.controller.action.tipoEscolaridade.TipoEscolaridadeUpdateAction;
import sias.controller.action.tipoOcupacao.TipoOcupacaoCreateAction;
import sias.controller.action.tipoOcupacao.TipoOcupacaoDeleteAction;
import sias.controller.action.tipoOcupacao.TipoOcupacaoReadAction;
import sias.controller.action.tipoOcupacao.TipoOcupacaoShowFormAction;
import sias.controller.action.tipoOcupacao.TipoOcupacaoUpdateAction;
import sias.controller.action.tipoParentesco.TipoParentescoCreateAction;
import sias.controller.action.tipoParentesco.TipoParentescoDeleteAction;
import sias.controller.action.tipoParentesco.TipoParentescoReadAction;
import sias.controller.action.tipoParentesco.TipoParentescoShowFormAction;
import sias.controller.action.tipoParentesco.TipoParentescoUpdateAction;
import sias.controller.action.unidadeAtendimento.UnidadeAtendimentoDescricaoAction;

public class AppManager extends ApplicationManager {

    @Override
    public void init() {
        this.setReqCharEncoding("UTF8");
    }

    @Override
    public void loadActions() {
        this.setReqCharEncoding("UTF8");
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
        ac.addConsequence("UPDATE", new Forward("jsp/tipoEspecificidadeSocial/updateForm.page"));
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
        ac.addConsequence(ERROR, new Forward("jsp/municipio/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("MunicipioUpdate", MunicipioUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("MunicipioRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/municipio/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("MunicipioDelete", MunicipioDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("MunicipioRead.mtw"));
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

        ac = new ActionConfig("ColaboradorDescricao", ColaboradorDescricaoAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/colaborador/descricao.page"));
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

        ac = new ActionConfig("UnidadeAtendimentoDescricao", UnidadeAtendimentoDescricaoAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/unidadeAtendimento/descricao.page"));
        this.add(ac);

        //Forma Ingresso
        ac = new ActionConfig("FormaIngressoRead", FormaIngressoReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/formaIngresso/list.page"));
        this.add(ac);

        ac = new ActionConfig("FormaIngressoShowForm", FormaIngressoShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/formaIngresso/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/formaIngresso/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("FormaIngressoCreate", FormaIngressoCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("FormaIngressoRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/formaIngresso/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("FormaIngressoUpdate", FormaIngressoUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("FormaIngressoRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/formaIngresso/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("FormaIngressoDelete", FormaIngressoDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("FormaIngressoRead.mtw"));
        this.add(ac);

        //Tipo Escolaridade
        ac = new ActionConfig("TipoEscolaridadeRead", TipoEscolaridadeReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/tipoEscolaridade/list.page"));
        this.add(ac);

        ac = new ActionConfig("TipoEscolaridadeShowForm", TipoEscolaridadeShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/tipoEscolaridade/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/tipoEscolaridade/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoEscolaridadeCreate", TipoEscolaridadeCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoEscolaridadeRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoEscolaridade/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoEscolaridadeUpdate", TipoEscolaridadeUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoEscolaridadeRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoEscolaridade/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoEscolaridadeDelete", TipoEscolaridadeDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("TipoEscolaridadeRead.mtw"));
        this.add(ac);

        //Tipo Ocupacao
        ac = new ActionConfig("TipoOcupacaoRead", TipoOcupacaoReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/tipoOcupacao/list.page"));
        this.add(ac);

        ac = new ActionConfig("TipoOcupacaoShowForm", TipoOcupacaoShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/tipoOcupacao/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/tipoOcupacao/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoOcupacaoCreate", TipoOcupacaoCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoOcupacaoRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoOcupacao/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoOcupacaoUpdate", TipoOcupacaoUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoOcupacaoRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoOcupacao/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoOcupacaoDelete", TipoOcupacaoDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("TipoOcupacaoRead.mtw"));
        this.add(ac);

        //Tipo Parentesco
        ac = new ActionConfig("TipoParentescoRead", TipoParentescoReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/tipoParentesco/list.page"));
        this.add(ac);

        ac = new ActionConfig("TipoParentescoShowForm", TipoParentescoShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/tipoParentesco/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/tipoParentesco/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoParentescoCreate", TipoParentescoCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoParentescoRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoParentesco/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoParentescoUpdate", TipoParentescoUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoParentescoRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoParentesco/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoParentescoDelete", TipoParentescoDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("TipoParentescoRead.mtw"));
        this.add(ac);

        //Tipo Deficiencia
        ac = new ActionConfig("TipoDeficienciaRead", TipoDeficienciaReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/tipoDeficiencia/list.page"));
        this.add(ac);

        ac = new ActionConfig("TipoDeficienciaShowForm", TipoDeficienciaShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/tipoDeficiencia/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/tipoDeficiencia/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoDeficienciaCreate", TipoDeficienciaCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoDeficienciaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoDeficiencia/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoDeficienciaUpdate", TipoDeficienciaUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoDeficienciaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoDeficiencia/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoDeficienciaDelete", TipoDeficienciaDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("TipoDeficienciaRead.mtw"));
        this.add(ac);

        //Tipo Beneficio Despesa
        ac = new ActionConfig("TipoBeneficioDespesaRead", TipoBeneficioDespesaReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/tipoBeneficioDespesa/list.page"));
        this.add(ac);

        ac = new ActionConfig("TipoBeneficioDespesaShowForm", TipoBeneficioDespesaShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/tipoBeneficioDespesa/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/tipoBeneficioDespesa/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoBeneficioDespesaCreate", TipoBeneficioDespesaCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoBeneficioDespesaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoBeneficioDespesa/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoBeneficioDespesaUpdate", TipoBeneficioDespesaUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("TipoBeneficioDespesaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/tipoBeneficioDespesa/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("TipoBeneficioDespesaDelete", TipoBeneficioDespesaDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("TipoBeneficioDespesaRead.mtw"));
        this.add(ac);

        //Pessoa
        ac = new ActionConfig("PessoaRead", PessoaReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/pessoa/list.page"));
        this.add(ac);

        ac = new ActionConfig("PessoaShowForm", PessoaShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/pessoa/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/pessoa/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("PessoaMembroFamilia", PessoaShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/pessoa/membroFamilia.page"));
        this.add(ac);

        ac = new ActionConfig("PessoaMembroEscolaridade", PessoaEscolaridadeAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/pessoa/membroEscolaridade.page"));
        this.add(ac);

        ac = new ActionConfig("PessoaTrabalhoRenda", PessoaTrabalhoRendaAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/pessoa/trabalhoRenda.page"));
        this.add(ac);

        ac = new ActionConfig("PessoaCreate", PessoaCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("PessoaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/pessoa/createForm.page"));
        this.add(ac);

        ac = new ActionConfig("PessoaUpdate", PessoaUpdateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("PessoaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/Pessoa/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("PessoaDelete", PessoaDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("PessoaRead.mtw"));
        this.add(ac);

        ac = new ActionConfig("PessoaComposicaoFamilia", PessoaReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/pessoa/composicaoFamilia.page"));
        this.add(ac);

        ac = new ActionConfig("PessoaDescricaoFamilia", PessoaDescricaoAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/pessoa/descricaoFamilia.page"));
        this.add(ac);

        //Beneficio/Despesa
        ac = new ActionConfig("BeneficioDespesaRead", BeneficioDespesaReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/beneficioDespesa/list.page"));
        this.add(ac);

        ac = new ActionConfig("BeneficioDespesaShowForm", BeneficioDespesaShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/beneficioDespesa/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/beneficioDespesa/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("BeneficioDespesaCreate", BeneficioDespesaCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("BeneficioDespesaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/beneficioDespesa/createForm.page"));
        this.add(ac);

        /*   ac = new ActionConfig("TipoBeneficioDespesaUpdate", TipoBeneficioDespesaUpdateAction.class);
         ac.addConsequence(SUCCESS, new Redirect("TipoBeneficioDespesaRead.mtw"));
         ac.addConsequence(ERROR, new Forward("jsp/tipoBeneficioDespesa/updateForm.page"));
         this.add(ac);
         */
        ac = new ActionConfig("BeneficioDespesaDelete", BeneficioDespesaDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("BeneficioDespesaRead.mtw"));
        this.add(ac);

        //Deficiência Pessoa
        ac = new ActionConfig("DeficienciaPessoaRead", DeficienciaPessoaReadAction.class);
        ac.addConsequence(SUCCESS, new Forward("jsp/deficienciaPessoa/list.page"));
        this.add(ac);

        ac = new ActionConfig("DeficienciaPessoaShowForm", DeficienciaPessoaShowFormAction.class);
        ac.addConsequence("CREATE", new Forward("jsp/deficienciaPessoa/createForm.page"));
        ac.addConsequence("UPDATE", new Forward("jsp/deficienciaPessoa/updateForm.page"));
        this.add(ac);

        ac = new ActionConfig("DeficienciaPessoaCreate", DeficienciaPessoaCreateAction.class);
        ac.addConsequence(SUCCESS, new Redirect("DeficienciaPessoaRead.mtw"));
        ac.addConsequence(ERROR, new Forward("jsp/deficienciaPessoa/createForm.page"));
        this.add(ac);

        /*   ac = new ActionConfig("TipoBeneficioDespesaUpdate", TipoBeneficioDespesaUpdateAction.class);
         ac.addConsequence(SUCCESS, new Redirect("TipoBeneficioDespesaRead.mtw"));
         ac.addConsequence(ERROR, new Forward("jsp/tipoBeneficioDespesa/updateForm.page"));
         this.add(ac);
         */
        ac = new ActionConfig("DeficienciaPessoaDelete", DeficienciaPessoaDeleteAction.class);
        ac.addConsequence(SUCCESS, new Forward("DeficienciaPessoaRead.mtw"));
        this.add(ac);

    }
}
