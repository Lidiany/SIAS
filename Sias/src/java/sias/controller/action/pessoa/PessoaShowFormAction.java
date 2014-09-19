package sias.controller.action.pessoa;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.FormaIngresso;
import sias.model.pojo.Municipio;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoBeneficioDespesa;
import sias.model.pojo.TipoDeficiencia;
import sias.model.pojo.TipoEscolaridade;
import sias.model.pojo.TipoEspecificidadeSocial;
import sias.model.pojo.TipoOcupacao;
import sias.model.pojo.TipoParentesco;
import sias.model.pojo.Uf;

public class PessoaShowFormAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = "CREATE";
        Pessoa pessoa = null;
        Long id = input.getLong("id");
        if (id != null && id > 0) {
            pessoa = ServiceLocator.getPessoaService().readById(id);
            output.setValue("pessoa", pessoa);
            consequence = "UPDATE";
        }
        this.preload(pessoa);
        return consequence;
    }

    private void preload(Pessoa pessoa) throws Exception {
        Map<String, Object> criteria = new HashMap<String, Object>();

        criteria.clear();
        List<Municipio> municipios = ServiceLocator.getMunicipioService().readByCriteria(criteria);

        Map<Long, String> municipioOptions = new LinkedHashMap<Long, String>();
        for (Municipio municipio : municipios) {
            municipioOptions.put(municipio.getId(), municipio.getNome());
        }
        output.setValue("municipioOptions", municipioOptions);

        criteria.clear();
        List<Municipio> municipioNacionalidades = ServiceLocator.getMunicipioService().readByCriteria(criteria);

        Map<Long, String> municipioNacionalidadeOptions = new LinkedHashMap<Long, String>();
        for (Municipio municipio : municipioNacionalidades) {
            municipioNacionalidadeOptions.put(municipio.getId(), municipio.getNome());
        }
        output.setValue("municipioNacionalidadeOptions", municipioNacionalidadeOptions);

        criteria.clear();
        List<Uf> ufs = ServiceLocator.getUfService().readByCriteria(criteria);

        Map<Long, String> ufOptions = new LinkedHashMap<Long, String>();
        for (Uf uf : ufs) {
            ufOptions.put(uf.getId(), uf.getSigla());
        }
        output.setValue("ufOptions", ufOptions);
        
        criteria.clear();
        List<Uf> ufNacionalidades = ServiceLocator.getUfService().readByCriteria(criteria);

        Map<Long, String> ufNacionalidadeOptions = new LinkedHashMap<Long, String>();
        for (Uf uf : ufNacionalidades) {
            ufNacionalidadeOptions.put(uf.getId(), uf.getSigla());
        }
        output.setValue("ufNacionalidadeOptions", ufNacionalidadeOptions);
        
        criteria.clear();
        List<FormaIngresso> formaIngressos = ServiceLocator.getFormaIngressoService().readByCriteria(criteria);

        Map<Long, String> formaIngressoOptions = new LinkedHashMap<Long, String>();
        for (FormaIngresso formaIngresso : formaIngressos) {
            formaIngressoOptions.put(formaIngresso.getId(), formaIngresso.getDescricao());
        }
        output.setValue("formaIngressoOptions", formaIngressoOptions);

        criteria.clear();
        List<TipoEscolaridade> tipoEscolaridades = ServiceLocator.getTipoEscolaridadeService().readByCriteria(criteria);

        Map<Long, String> tipoEscolaridadeOptions = new LinkedHashMap<Long, String>();
        for (TipoEscolaridade tipoEscolaridade : tipoEscolaridades) {
            tipoEscolaridadeOptions.put(tipoEscolaridade.getId(), tipoEscolaridade.getDescricao());
        }
        output.setValue("tipoEscolaridadeOptions", tipoEscolaridadeOptions);

        criteria.clear();
        List<TipoOcupacao> tipoOcupacaos = ServiceLocator.getTipoOcupacaoService().readByCriteria(criteria);

        Map<Long, String> tipoOcupacaoOptions = new LinkedHashMap<Long, String>();
        for (TipoOcupacao tipoOcupacao : tipoOcupacaos) {
            tipoOcupacaoOptions.put(tipoOcupacao.getId(), tipoOcupacao.getDescricao());
        }
        output.setValue("tipoOcupacaoOptions", tipoOcupacaoOptions);

        criteria.clear();
        List<TipoParentesco> tipoParentescos = ServiceLocator.getTipoParentescoService().readByCriteria(criteria);

        Map<Long, String> tipoParentescoOptions = new LinkedHashMap<Long, String>();
        for (TipoParentesco tipoParentesco : tipoParentescos) {
            tipoParentescoOptions.put(tipoParentesco.getId(), tipoParentesco.getDescricao());
        }
        output.setValue("tipoParentescoOptions", tipoParentescoOptions);

        criteria.clear();
        List<TipoEspecificidadeSocial> tipoEspecificidadeSocials = ServiceLocator.getTipoEspecificidadeSocialService().readByCriteria(criteria);

        Map<Long, String> tipoEspecificidadeSocialOptions = new LinkedHashMap<Long, String>();
        for (TipoEspecificidadeSocial tipoEspecificidadeSocial : tipoEspecificidadeSocials) {
            tipoEspecificidadeSocialOptions.put(tipoEspecificidadeSocial.getId(), tipoEspecificidadeSocial.getDescricao());
        }
        output.setValue("tipoEspecificidadeSocialOptions", tipoEspecificidadeSocialOptions);

        criteria.clear();
        List<TipoDeficiencia> tipoDeficiencias = ServiceLocator.getTipoDeficienciaService().readByCriteria(criteria);

        Map<Long, String> tipoDeficienciaOptions = new LinkedHashMap<Long, String>();
        for (TipoDeficiencia tipoDeficiencia : tipoDeficiencias) {
            tipoDeficienciaOptions.put(tipoDeficiencia.getId(), tipoDeficiencia.getDescricao());
        }
        output.setValue("tipoDeficienciaOptions", tipoDeficienciaOptions);

        criteria.clear();
        List<TipoBeneficioDespesa> tipoBeneficioDespesas = ServiceLocator.getTipoBeneficioDespesaService().readByCriteria(criteria);

        Map<Long, String> tipoBeneficioDespesaOptions = new LinkedHashMap<Long, String>();
        for (TipoBeneficioDespesa tipoBeneficioDespesa : tipoBeneficioDespesas) {
            tipoBeneficioDespesaOptions.put(tipoBeneficioDespesa.getId(), tipoBeneficioDespesa.getDescricao());
        }
        output.setValue("tipoBeneficioDespesaOptions", tipoBeneficioDespesaOptions);

        criteria.clear();
        Map<String, String> racaOptions = new LinkedHashMap<String, String>();
        racaOptions.put("Branco", "Branco");
        racaOptions.put("Negro", "Negro");
        racaOptions.put("Pardo", "Pardo");
        racaOptions.put("Amarelo", "Amarelo");
        output.setValue("racaOptions", racaOptions);
        
        criteria.clear();
        Map<String, String> estadoCivilOptions = new LinkedHashMap<String, String>();
        estadoCivilOptions.put("Solteiro", "Solteiro");
        estadoCivilOptions.put("Casado", "Casado");
        estadoCivilOptions.put("Separado", "Separado");
        estadoCivilOptions.put("Viúvo", "Viúvo");
        output.setValue("estadoCivilOptions", estadoCivilOptions);
        
        criteria.clear();
        Map<String, String> tipoCertidaoOptions = new LinkedHashMap<String, String>();
        tipoCertidaoOptions.put("Nascimento", "Nascimento");
        tipoCertidaoOptions.put("Casamento", "Casamento");
        output.setValue("tipoCertidaoOptions", tipoCertidaoOptions);
        
        criteria.clear();
        Map<String, String> tipoLogradouroOptions = new LinkedHashMap<String, String>();
        tipoLogradouroOptions.put("Rua", "Rua");
        tipoLogradouroOptions.put("Av.", "Av.");
        output.setValue("tipoLogradouroOptions", tipoLogradouroOptions);
        
        criteria.clear();
        Map<String, String> tipoResidenciaOptions = new LinkedHashMap<String, String>();
        tipoResidenciaOptions.put("Própria", "Própria");
        tipoResidenciaOptions.put("Alugada", "Alugada");
        tipoResidenciaOptions.put("Cedida", "Cedida");
        tipoResidenciaOptions.put("Ocupada", "Ocupado");
        output.setValue("tipoResidenciaOptions", tipoResidenciaOptions);
        
        criteria.clear();
        Map<String, String> complementoImovelOptions = new LinkedHashMap<String, String>();
        complementoImovelOptions.put("Ótimo", "Ótimo");
        complementoImovelOptions.put("Bom", "Bom");
        complementoImovelOptions.put("Regular", "Regular");
        output.setValue("complementoImovelOptions", complementoImovelOptions);
        
        criteria.clear();
        
        Map<String, String> classificacaoEtariaOptions = new LinkedHashMap<String, String>();
        classificacaoEtariaOptions.put("0 à 12 anos - Criança", "0 à 12 anos - Criança");
        classificacaoEtariaOptions.put("13 à 17 anos - Adolescente", "13 à 17 anos - Adolescente");
        classificacaoEtariaOptions.put("18 à 21 anos - Jovem", "18 à 21 anos - Jovem");
        classificacaoEtariaOptions.put("22 à 59 anos - Adulto", "22 à 59 anos - Adulto");
        classificacaoEtariaOptions.put("60 anos acima - Idoso", "60 anos acima - Idoso");
        output.setValue("classificacaoEtariaOptions", classificacaoEtariaOptions);
    }
}
