package sias.model;

import sias.model.base.service.BaseBeneficioDespesaService;
import sias.model.base.service.BaseColaboradorService;
import sias.model.base.service.BaseDeficienciaPessoaService;
import sias.model.base.service.BaseFormaIngressoService;
import sias.model.base.service.BaseMunicipioService;
import sias.model.base.service.BasePessoaService;
import sias.model.base.service.BaseTipoBeneficioDespesaService;
import sias.model.base.service.BaseTipoDeficienciaService;
import sias.model.base.service.BaseTipoEscolaridadeService;
import sias.model.base.service.BaseTipoEspecificidadeSocialService;
import sias.model.base.service.BaseTipoOcupacaoService;
import sias.model.base.service.BaseTipoParentescoService;
import sias.model.base.service.BaseUfService;
import sias.model.base.service.BaseUnidadeAtendimentoService;
import sias.model.service.BeneficioDespesaService;
import sias.model.service.ColaboradorService;
import sias.model.service.DeficienciaPessoaService;
import sias.model.service.FormaIngressoService;
import sias.model.service.MunicipioService;
import sias.model.service.PessoaService;
import sias.model.service.TipoBeneficioDespesaService;
import sias.model.service.TipoDeficienciaService;
import sias.model.service.TipoEscolaridadeService;
import sias.model.service.TipoEspecificidadeSocialService;
import sias.model.service.TipoOcupacaoService;
import sias.model.service.TipoParentescoService;
import sias.model.service.UfService;
import sias.model.service.UnidadeAtendimentoService;

public class ServiceLocator {

    public static BaseUfService getUfService() {
        return new UfService();
    }
    
    public static BaseMunicipioService getMunicipioService() {
        return new MunicipioService();
    }
    
    public static BaseColaboradorService getColaboradorService() {
        return new ColaboradorService();
    }
    
    public static BaseFormaIngressoService getFormaIngressoService() {
        return new FormaIngressoService();
    }
    
    public static BasePessoaService getPessoaService() {
        return new PessoaService();
    }
    
    public static BaseTipoBeneficioDespesaService getTipoBeneficioDespesaService() {
        return new TipoBeneficioDespesaService();
    }
    
    public static BaseTipoDeficienciaService getTipoDeficienciaService() {
        return new TipoDeficienciaService();
    }
    
    public static BaseTipoEscolaridadeService getTipoEscolaridadeService() {
        return new TipoEscolaridadeService();
    }
    
    public static BaseTipoEspecificidadeSocialService getTipoEspecificidadeSocialService() {
        return new TipoEspecificidadeSocialService();
    }
    
    public static BaseTipoOcupacaoService getTipoOcupacaoService() {
        return new TipoOcupacaoService();
    }
    
    public static BaseTipoParentescoService getTipoParentescoService() {
        return new TipoParentescoService();
    }
    
    public static BaseUnidadeAtendimentoService getUnidadeAtendimentoService() {
        return new UnidadeAtendimentoService();
    }
    
    public static BaseDeficienciaPessoaService getDeficienciaPessoaService(){
        return new DeficienciaPessoaService();
    }
    
    public static BaseBeneficioDespesaService getBeneficioDespesaService(){
        return new BeneficioDespesaService();
    }
}
