package sias.controller.action.pessoa;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
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

public class PessoaCreateAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = ERROR;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Montando o mapa
        Map<String, Object> form = new HashMap<String, Object>();
        form.put("tipoParentesco.id", input.getLong("pessoa.tipoParentesco.id"));
        form.put("numeroOrdem", input.getInt("pessoa.numeroOrdem"));
        form.put("dataInclusao", input.getString("pessoa.dataInclusao"));
        form.put("formaIngresso.id", input.getLong("pessoa.formaIngresso.id"));
        form.put("nome", input.getString("pessoa.nome"));
        form.put("nomePai", input.getString("pessoa.nomePai"));
        form.put("nomeMae", input.getString("pessoa.nomeMae"));
        form.put("sexo", input.getString("pessoa.sexo"));
        form.put("dataNascimento", input.getString("pessoa.dataNascimento"));
        form.put("classificacaoEtaria", input.getString("pessoa.classificacaoEtaria"));
        form.put("nacionalidade", input.getString("pessoa.nacionalidade"));
        form.put("ufNacionalidade.id", input.getLong("pessoa.ufNacionalidade.id"));
        form.put("municipioNacionalidade.id", input.getLong("pessoa.municipioNacionalidade.id"));
        form.put("raca", input.getString("pessoa.raca"));
        form.put("estadoCivil", input.getString("pessoa.estadoCivil"));
        form.put("telefone", input.getString("pessoa.telefone"));
        form.put("dataAtualizacaoCadastro", input.getString("pessoa.dataAtualizacaoCadastro"));
        form.put("complementoPessoa", input.getString("pessoa.complementoPessoa"));
        form.put("cpf", input.getString("pessoa.cpf"));
        form.put("nis", input.getString("pessoa.nis"));
        form.put("numeroRg", input.getString("pessoa.numeroRg"));
        form.put("orgaoExpedidor", input.getString("pessoa.orgaoExpedidor"));
        form.put("dataEmissaoRg", input.getString("pessoa.dataEmissaoRg"));
        form.put("ufRg", input.getLong("pessoa.ufRg"));
        form.put("numeroCtps", input.getString("pessoa.numeroCtps"));
        form.put("serie", input.getString("pessoa.serie"));
        form.put("dataEmissaoCtps", input.getString("pessoa.dataEmissaoCtps"));
        form.put("ufCtps", input.getLong("pessoa.ufCtps"));
        form.put("numeroTituloEleitoral", input.getString("pessoa.numeroTituloEleitoral"));
        form.put("zona", input.getString("pessoa.zona"));
        form.put("secao", input.getString("pessoa.secao"));
        form.put("tipoCertidao", input.getString("pessoa.tipoCertidao"));
        form.put("cartorioCertidao", input.getString("pessoa.cartorioCertidao"));
        form.put("numeroTermo", input.getString("pessoa.numeroTermo"));
        form.put("livro", input.getString("pessoa.livro"));
        form.put("folha", input.getString("pessoa.folha"));
        form.put("dataEmissaoCn", input.getString("pessoa.dataEmissaoCn"));
        form.put("ufCn", input.getLong("pessoa.ufCn"));
        form.put("tipoLogradouro", input.getString("pessoa.tipoLogradouro"));
        form.put("logradouro", input.getString("pessoa.logradouro"));
        form.put("numero", input.getString("pessoa.numero"));
        form.put("complementoEndereco", input.getString("pessoa.complementoEndereco"));
        form.put("bairro", input.getString("pessoa.bairro"));
        form.put("uf.id", input.getLong("pessoa.uf.id"));
        form.put("municipio.id", input.getLong("pessoa.municipio.id"));
        form.put("cep", input.getString("pessoa.cep"));
        form.put("localizacao", input.getString("pessoa.localizacao"));
        form.put("pontoReferencia", input.getString("pessoa.pontoReferencia"));
        form.put("abrigo", input.getString("pessoa.abrigo"));
        form.put("dataAtualizacaoEndereco", input.getString("pessoa.dataAtualizacaoEndereco"));
        form.put("tipoResidencia", input.getString("pessoa.tipoResidencia"));
        form.put("complementoImovel", input.getString("pessoa.complementoImovel"));
        form.put("areaRisco", input.getString("pessoa.areaRisco"));
        form.put("complementoHabitacional", input.getString("pessoa.complementoHabitacional"));
        form.put("dataAtualizacaoHabitacional", input.getString("pessoa.dataAtualizacaoHabitacional"));
        form.put("tipoEspecificidadeSocial.id", input.getLong("pessoa.tipoEspecificidadeSocial.id"));
        form.put("dataDesligamento", input.getString("pessoa.dataDesligamento"));
        form.put("motivoDesligamento", input.getString("pessoa.motivoDesligamento"));
        form.put("lerEscrever", input.getString("pessoa.lerEscrever"));
        form.put("frequenciaEscolar", input.getString("pessoa.frequenciaEscolar"));
        form.put("tipoEscolaridade.id", input.getLong("pessoa.tipoEscolaridade.id"));
        form.put("tipoDeficiencia.id", input.getLong("pessoa.tipoDeficiencia.id"));
        form.put("tipoOcupacao.id", input.getLong("pessoa.tipoOcupacao.id"));
        form.put("qualificacaoProfissional", input.getString("pessoa.qualificacaoProfissional"));
        form.put("dataRenda", input.getString("pessoa.dataRenda"));
        form.put("renda", input.getFloat("pessoa.renda"));
        form.put("aposentadoPensionista", input.getString("pessoa.aposentadoPensionista"));
        form.put("tipoBeneficioDespesa.id", input.getLong("pessoa.tipoBeneficioDespesa.id"));
        Map<String, String> error = ServiceLocator.getPessoaService().validateForCreate(form);
        if (error == null || error.isEmpty()) {
            Pessoa pessoa = new Pessoa();
            TipoParentesco tipoParentesco = ServiceLocator.getTipoParentescoService().readById((Long) form.get("tipoParentesco.id"));
            pessoa.setTipoParentesco(tipoParentesco);
            pessoa.setNumeroOrdem((Integer) form.get("numeroOrdem"));
            pessoa.setDataInclusao(new Date(sdf.parse((String)form.get("dataInclusao")).getTime()));
            FormaIngresso formaIngresso = ServiceLocator.getFormaIngressoService().readById((Long) form.get("formaIngresso.id"));
            pessoa.setFormaIngresso(formaIngresso);
            pessoa.setNome((String) form.get("nome"));

            pessoa.setNomePai((String) form.get("nomePai"));
            pessoa.setNomeMae((String) form.get("nomeMae"));
            pessoa.setSexo((String) form.get("sexo"));

            String dataNascimento = (String)form.get("dataNascimento");
            if (dataNascimento != null && (!dataNascimento.isEmpty())) {
                pessoa.setDataNascimento(new Date(sdf.parse(dataNascimento).getTime()));
            }

            pessoa.setClassificacaoetaria((String) form.get("classificacaoEtaria"));
            pessoa.setNacionalidade((String) form.get("nacionalidade"));

            Uf ufNacionalidade = ServiceLocator.getUfService().readById((Long) form.get("ufNacionalidade.id"));
            pessoa.setUfNacionalidade(ufNacionalidade);

            Municipio municipioNacionalidade = ServiceLocator.getMunicipioService().readById((Long) form.get("municipioNacionalidade.id"));
            pessoa.setMunicipioNacionalidade(municipioNacionalidade);

            pessoa.setRaca((String) form.get("raca"));
            pessoa.setEstadoCivil((String) form.get("estadoCivil"));
            pessoa.setTelefone((String) form.get("telefone"));
            
            String dataAtualizacaoCadastro = input.getString("dataAtualizacaoCadastro");
            if (dataAtualizacaoCadastro != null && (!dataAtualizacaoCadastro.isEmpty())) {
                pessoa.setDataAtualizacaoCadastro(new Date(sdf.parse(dataAtualizacaoCadastro).getTime()));
            }
            
            pessoa.setComplementoPessoa((String) form.get("complementoPessoa"));

            pessoa.setCpf((String) form.get("cpf"));
            pessoa.setNis((String) form.get("nis"));
            pessoa.setNumeroRg((String) form.get("numeroRg"));
            pessoa.setOrgaoExpedidor((String) form.get("orgaoExpedidor"));
            
            String dataEmissaoRg = input.getString("dataEmissaoRg");
            if (dataEmissaoRg != null && (!dataEmissaoRg.isEmpty())) {
                pessoa.setDataEmissaoRg(new Date(sdf.parse(dataEmissaoRg).getTime()));
            }
            
            Uf ufRg = ServiceLocator.getUfService().readById((Long) form.get("ufRg"));
            pessoa.setUfRg(ufRg);

            pessoa.setNumeroCtps((String) form.get("numeroCtps"));
            pessoa.setSerie((String) form.get("serie"));
            
            String dataEmissaoCtps = input.getString("dataEmissaoCtps");
            if (dataEmissaoCtps != null && (!dataEmissaoCtps.isEmpty())) {
                pessoa.setDataEmissaoCtps(new Date(sdf.parse(dataEmissaoCtps).getTime()));
            }
            
            Uf ufCtps = ServiceLocator.getUfService().readById((Long) form.get("ufCtps"));
            pessoa.setUfCtps(ufCtps);

            pessoa.setNumeroTituloEleitoral((String) form.get("numeroTituloEleitoral"));
            pessoa.setZona((String) form.get("zona"));
            pessoa.setSecao((String) form.get("secao"));
            pessoa.setTipoCertidao((String) form.get("tipoCertidao"));
            pessoa.setCartorioCertidao((String) form.get("cartorioCertidao"));
            pessoa.setNumeroTermo((String) form.get("numeroTermo"));
            pessoa.setLivro((String) form.get("livro"));
            pessoa.setFolha((String) form.get("folha"));
            
            String dataEmissaoCn = input.getString("dataEmissaoCn");
            if (dataEmissaoCn != null && (!dataEmissaoCn.isEmpty())) {
                pessoa.setDataEmissaoCn(new Date(sdf.parse(dataEmissaoCn).getTime()));
            }
            
            Uf ufCn = ServiceLocator.getUfService().readById((Long) form.get("ufCn"));
            pessoa.setUfCn(ufCn);

            pessoa.setTipoLogradouro((String) form.get("tipoLogradouro"));
            pessoa.setLogradouro((String) form.get("logradouro"));
            pessoa.setNumero((String) form.get("numero"));
            pessoa.setComplementoEndereco((String) form.get("complementoEndereco"));
            pessoa.setBairro((String) form.get("bairro"));
            
            Uf uf = ServiceLocator.getUfService().readById((Long) form.get("uf.id"));
            pessoa.setUf(uf);
            
            Municipio municipio = ServiceLocator.getMunicipioService().readById((Long) form.get("municipio.id"));
            pessoa.setMunicipio(municipio);
            
            pessoa.setCep((String) form.get("cep"));
            pessoa.setLocalizacao((String) form.get("localizacao"));
            pessoa.setPontoReferencia((String) form.get("pontoReferencia"));
            pessoa.setAbrigo((String) form.get("abrigo"));
            
            String dataAtualizacaoEndereco = input.getString("dataAtualizacaoEndereco");
            if (dataAtualizacaoEndereco != null && (!dataAtualizacaoEndereco.isEmpty())) {
                pessoa.setDataAtualizacaoEndereco(new Date(sdf.parse(dataAtualizacaoEndereco).getTime()));
            }
            
            pessoa.setTipoResidencia((String) form.get("tipoResidencia"));
            pessoa.setComplementoImovel((String) form.get("complementoImovel"));
            pessoa.setAreaRisco((String) form.get("areaRisco"));
            pessoa.setComplementoHabitacional((String) form.get("complementoHabitacional"));
            
            String dataAtualizacaoHabitacional = input.getString("dataAtualizacaoHabitacional");
            if (dataAtualizacaoHabitacional != null && (!dataAtualizacaoHabitacional.isEmpty())) {
                pessoa.setDataAtualizacaoHabitacional(new Date(sdf.parse(dataAtualizacaoHabitacional).getTime()));
            }
            
            TipoEspecificidadeSocial tipoEspecificidadeSocial = ServiceLocator.getTipoEspecificidadeSocialService().readById((Long) form.get("tipoEspecificidadeSocial.id"));
            pessoa.setTipoEspecificidadeSocial(tipoEspecificidadeSocial);
            
            TipoBeneficioDespesa tipoBeneficioDespesa = ServiceLocator.getTipoBeneficioDespesaService().readById((Long) form.get("tipoBeneficioDespesa.id"));
            pessoa.setTipoBeneficioDespesa(tipoBeneficioDespesa);
            
            pessoa.setLerEscrever((String) form.get("lerEscrever"));
            pessoa.setFrequenciaEscolar((String) form.get("frequenciaEscolar"));
            
            TipoEscolaridade tipoEscolaridade = ServiceLocator.getTipoEscolaridadeService().readById((Long) form.get("tipoEscolaridade.id"));
            pessoa.setTipoEscolaridade(tipoEscolaridade);
            
            TipoDeficiencia tipoDeficiencia = ServiceLocator.getTipoDeficienciaService().readById((Long) form.get("tipoDeficiencia.id"));
            pessoa.setTipoDeficiencia(tipoDeficiencia);
            
            TipoOcupacao tipoOcupacao = ServiceLocator.getTipoOcupacaoService().readById((Long) form.get("tipoOcupacao.id"));
            pessoa.setTipoOcupacao(tipoOcupacao);
            
            pessoa.setQualificacaoProfissional((String) form.get("qualificacaoProfissional"));
            
            String dataRenda = input.getString("dataRenda");
            if (dataRenda != null && (!dataRenda.isEmpty())) {
                pessoa.setDataRenda(new Date(sdf.parse(dataRenda).getTime()));
            }
            
            pessoa.setRenda((Float) form.get("renda"));
            pessoa.setAposentadoPensionista((String) form.get("aposentadoPensionista"));
            
            String dataDesligamento = input.getString("dataDesligamento");
            if (dataDesligamento != null && (!dataDesligamento.isEmpty())) {
                pessoa.setDataDesligamento(new Date(sdf.parse(dataDesligamento).getTime()));
            }
            
            pessoa.setMotivoDesligamento((String) form.get("motivoDesligamento"));

            ServiceLocator.getPessoaService().create(pessoa);
            consequence = SUCCESS;
        } else {
            output.setValue("error", error);
        }

        return consequence;
    }

}
