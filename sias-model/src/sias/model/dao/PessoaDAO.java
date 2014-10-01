package sias.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
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

public class PessoaDAO implements BaseDAO<Pessoa> {

    public static final String CRITERION_NOME_I_LIKE = "1";
    public static final String CRITERION_MUNICIPIO_ID_EQ = "2";
    public static final String CRITERION_UF_ID_EQ = "3";
    public static final String CRITERION_FORMAINGRESSO_ID_EQ = "4";
    public static final String CRITERION_TIPOESCOLARIDADE_ID_EQ = "5";
    public static final String CRITERION_TIPOOCUPACAO_ID_EQ = "6";
    public static final String CRITERION_TIPOPARENTESCO_ID_EQ = "7";
    public static final String CRITERION_TIPOESPECIFICIDADESOCIAL_ID_EQ = "8";
    public static final String CRITERION_TIPOBENEFICIODESPESA_ID_EQ = "9";
    public static final String CRITERION_TIPODEFICIENCIA_ID_EQ = "10";
    public static final String CRITERION_CPF_I_LIKE = "11";
    public static final String CRITERION_NIS_I_LIKE = "12";

    @Override
    public void create(Pessoa e, Connection conn) throws Exception {
        String sql = "INSERT INTO pessoa(datainclusao, numeroordem, nome, nomemae, nomepai, nis, cpf, numerorg, orgaoexpedidor, dataemissaorg, ufrg_fk, numeroctps, serie, dataemissaoctps, ufctps_fk, numerotituloeleitoral, zona, secao, cartoriocertidao, numerotermo, livro, folha, dataemissaocn, ufcn_fk, tipocertidao, datanascimento, nacionalidade, ufnacionalidade_fk, municipionacionalidade_fk, sexo, raca, estadocivil, telefone, frequenciaescolar, lerescrever, qualificacaoprofissional, renda, datarenda, aposentadopensionista, arearisco, tiporesidencia, complementoimovel, logradouro, numero, complementoendereco, bairro, cep, pontoreferencia, localizacao, abrigo, tipologradouro, datadesligamento, motivodesligamento, complementopessoa, complementohabitacional, dataatualizacaocadastro, dataatualizacaoendereco, dataatualizacaohabitacional, formaingresso_fk, tipoescolaridade_fk, tipoocupacao_fk, uf_fk, municipio_fk, tipoparentesco_fk, tipoespecificidadesocial_fk, tipodeficiencia_fk, tipobeneficiodespesa_fk, pessoa_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setDate(++i, new Date(e.getDataInclusao().getTime()));
        ps.setInt(++i, e.getNumeroOrdem());
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getNomeMae());
        ps.setString(++i, e.getNomePai());
        ps.setString(++i, e.getNis());
        ps.setString(++i, e.getCpf());
        ps.setString(++i, e.getNumeroRg());
        ps.setString(++i, e.getOrgaoExpedidor());

        if (e.getDataEmissaoRg() != null) {
            ps.setDate(++i, e.getDataEmissaoRg());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        if (e.getUfRg() != null) {
            ps.setLong(++i, e.getUfRg().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getNumeroCtps());
        ps.setString(++i, e.getSerie());

        if (e.getDataEmissaoCtps() != null) {
            ps.setDate(++i, e.getDataEmissaoCtps());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        if (e.getUfCtps() != null) {
            ps.setLong(++i, e.getUfCtps().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getNumeroTituloEleitoral());
        ps.setString(++i, e.getZona());
        ps.setString(++i, e.getSecao());
        ps.setString(++i, e.getCartorioCertidao());
        ps.setString(++i, e.getNumeroTermo());
        ps.setString(++i, e.getLivro());
        ps.setString(++i, e.getFolha());

        if (e.getDataEmissaoCn() != null) {
            ps.setDate(++i, e.getDataEmissaoCn());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        if (e.getUfCn() != null) {
            ps.setLong(++i, e.getUfCn().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getTipoCertidao());

        if (e.getDataNascimento() != null) {
            ps.setDate(++i, e.getDataNascimento());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        ps.setString(++i, e.getNacionalidade());

        if (e.getUfNacionalidade() != null) {
            ps.setLong(++i, e.getUfNacionalidade().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        if (e.getMunicipioNacionalidade() != null) {
            ps.setLong(++i, e.getMunicipioNacionalidade().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getSexo());
        ps.setString(++i, e.getRaca());
        ps.setString(++i, e.getEstadoCivil());
        ps.setString(++i, e.getTelefone());
        ps.setString(++i, e.getFrequenciaEscolar());
        ps.setString(++i, e.getLerEscrever());
        ps.setString(++i, e.getQualificacaoProfissional());
        ps.setFloat(++i, e.getRenda());

        if (e.getDataRenda() != null) {
            ps.setDate(++i, e.getDataRenda());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        ps.setString(++i, e.getAposentadoPensionista());
        ps.setString(++i, e.getAreaRisco());
        ps.setString(++i, e.getTipoResidencia());
        ps.setString(++i, e.getComplementoImovel());
        ps.setString(++i, e.getLogradouro());
        ps.setString(++i, e.getNumero());
        ps.setString(++i, e.getComplementoEndereco());
        ps.setString(++i, e.getBairro());
        ps.setString(++i, e.getCep());
        ps.setString(++i, e.getPontoReferencia());
        ps.setString(++i, e.getLocalizacao());
        ps.setString(++i, e.getAbrigo());
        ps.setString(++i, e.getTipoLogradouro());

        if (e.getDataDesligamento() != null) {
            ps.setDate(++i, e.getDataDesligamento());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        ps.setString(++i, e.getMotivoDesligamento());
        ps.setString(++i, e.getComplementoPessoa());

        ps.setString(++i, e.getComplementoHabitacional());
        
        
        if (e.getDataAtualizacaoCadastro() != null) {
            ps.setDate(++i, e.getDataAtualizacaoCadastro());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        if (e.getDataAtualizacaoEndereco() != null) {
            ps.setDate(++i, e.getDataAtualizacaoEndereco());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        if (e.getDataAtualizacaoHabitacional() != null) {
            ps.setDate(++i, e.getDataAtualizacaoHabitacional());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        if (e.getFormaIngresso() != null) {
            ps.setLong(++i, e.getFormaIngresso().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        if (e.getTipoEscolaridade() != null) {
            ps.setLong(++i, e.getTipoEscolaridade().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoOcupacao() != null) {
            ps.setLong(++i, e.getTipoOcupacao().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getUf() != null) {
            ps.setLong(++i, e.getUf().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getMunicipio() != null) {
            ps.setLong(++i, e.getMunicipio().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoParentesco() != null) {
            ps.setLong(++i, e.getTipoParentesco().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoEspecificidadeSocial() != null) {
            ps.setLong(++i, e.getTipoEspecificidadeSocial().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoDeficiencia() != null) {
            ps.setLong(++i, e.getTipoDeficiencia().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoBeneficioDespesa() != null) {
            ps.setLong(++i, e.getTipoBeneficioDespesa().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getPessoa() != null) {
            ps.setLong(++i, e.getPessoa().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Pessoa readById(Long id, Connection conn) throws Exception {
        Pessoa e = null;
        String sql = "SELECT pessoa.*, formaingresso.id as formaingresso_id, formaingresso.descricao as formaingresso_descricao, tipoescolaridade.id as tipoescolaridade_id, tipoescolaridade.descricao as tipoescolaridade_descricao, tipoocupacao.id as tipoocupacao_id, tipoocupacao.descricao as tipoocupacao_descricao, uf1.id as uf_id, uf1.nome as uf_nome, uf1.sigla as uf_sigla, uf2.id as ufrg_id, uf2.sigla as ufrg_sigla, uf3.id as ufcn_id, uf3.sigla as ufcn_sigla, uf4.id as ufctps_id, uf4.sigla as ufctps_sigla, uf5.id as ufnacionalidade_id, uf5.sigla as ufnacionalidade_sigla, municipio1.id as municipio_id, municipio1.nome as municipio_nome, municipio2.id as municipionacionalidade_id, municipio2.nome as municipionacionalidade_nome, tipoparentesco.id as tipoparentesco_id, tipoparentesco.descricao as tipoparentesco_descricao, tipoespecificidadesocial.id as tipoespecificidadesocial_id, tipoespecificidadesocial.descricao as tipoespecificidadesocial_descricao, tipodeficiencia.id as tipodeficiencia_id, tipodeficiencia.descricao as tipodeficiencia_descricao, tipobeneficiodespesa.id as tipobeneficiodespesa_id, tipobeneficiodespesa.descricao as tipobeneficiodespesa_descricao, pessoa.id as pessoa_id FROM pessoa as pessoa LEFT JOIN formaingresso ON pessoa.formaingresso_fk = formaingresso.id LEFT JOIN tipoescolaridade ON pessoa.tipoescolaridade_fk = tipoescolaridade.id LEFT JOIN tipoocupacao ON pessoa.tipoocupacao_fk = tipoocupacao.id LEFT JOIN uf as uf1 ON pessoa.uf_fk = uf1.id LEFT JOIN uf as uf2 ON pessoa.ufrg_fk = uf2.id LEFT JOIN uf as uf3 ON pessoa.ufcn_fk = uf3.id LEFT JOIN uf as uf4 ON pessoa.ufctps_fk = uf4.id LEFT JOIN uf as uf5 ON pessoa.ufnacionalidade_fk = uf5.id LEFT JOIN municipio as municipio1 ON pessoa.municipio_fk = municipio1.id LEFT JOIN municipio as municipio2 ON pessoa.municipionacionalidade_fk = municipio2.id LEFT JOIN tipoparentesco ON pessoa.tipoparentesco_fk = tipoparentesco.id LEFT JOIN tipoespecificidadesocial ON pessoa.tipoespecificidadesocial_fk = tipoespecificidadesocial.id LEFT JOIN tipodeficiencia ON tipodeficiencia_fk = tipodeficiencia.id LEFT JOIN tipobeneficiodespesa ON tipobeneficiodespesa_fk = tipobeneficiodespesa.id LEFT JOIN pessoa as p ON p.pessoa_fk != pessoa.id WHERE pessoa.id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new Pessoa();
            e.setId(rs.getLong("id"));
            e.setDataInclusao(rs.getDate("datainclusao"));
            e.setNumeroOrdem(rs.getInt("numeroordem"));
            e.setNome(rs.getString("nome"));
            e.setNomeMae(rs.getString("nomemae"));
            e.setNomePai(rs.getString("nomepai"));
            e.setNis(rs.getString("nis"));
            e.setCpf(rs.getString("cpf"));
            e.setNumeroRg(rs.getString("numerorg"));
            e.setOrgaoExpedidor(rs.getString("orgaoexpedidor"));
            e.setDataEmissaoRg(rs.getDate("dataemissaorg"));

            Uf ufRg = new Uf();
            ufRg.setId(rs.getLong("ufrg_id"));
            ufRg.setSigla(rs.getString("ufrg_sigla"));
            e.setUfRg(ufRg);
            //e.setUfRg(rs.getString("ufrg"));

            e.setNumeroCtps(rs.getString("numeroctps"));
            e.setSerie(rs.getString("serie"));
            e.setDataEmissaoCtps(rs.getDate("dataemissaoctps"));

            Uf ufCtps = new Uf();
            ufCtps.setId(rs.getLong("ufctps_id"));
            ufCtps.setSigla(rs.getString("ufctps_sigla"));
            e.setUfCtps(ufCtps);
            //e.setUfCtps(rs.getString("ufctps"));

            e.setNumeroTituloEleitoral(rs.getString("numerotituloeleitoral"));
            e.setZona(rs.getString("zona"));
            e.setSecao(rs.getString("secao"));
            e.setCartorioCertidao(rs.getString("cartoriocertidao"));
            e.setNumeroTermo(rs.getString("numerotermo"));
            e.setLivro(rs.getString("livro"));
            e.setFolha(rs.getString("folha"));
            e.setDataEmissaoCn(rs.getDate("dataemissaocn"));

            Uf ufCn = new Uf();
            ufCn.setId(rs.getLong("ufcn_id"));
            ufCn.setSigla(rs.getString("ufcn_sigla"));
            e.setUfCn(ufCn);
            //e.setUfCn(rs.getString("ufcn"));

            e.setTipoCertidao(rs.getString("tipocertidao"));
            e.setDataNascimento(rs.getDate("datanascimento"));
            e.setNacionalidade(rs.getString("nacionalidade"));

            Uf ufNacionalidade = new Uf();
            ufNacionalidade.setId(rs.getLong("ufnacionalidade_id"));
            ufNacionalidade.setSigla(rs.getString("ufnacionalidade_sigla"));
            e.setUfNacionalidade(ufNacionalidade);
            //e.setUfNacionalidade(rs.getString("ufnacionalidade"));

            Municipio municipioNacionalidade = new Municipio();
            municipioNacionalidade.setId(rs.getLong("municipionacionalidade_id"));
            municipioNacionalidade.setNome(rs.getString("municipionacionalidade_nome"));
            e.setMunicipioNacionalidade(municipioNacionalidade);
            //e.setMunicipioNacionalidade(rs.getString("municipionacionalidade"));

            e.setSexo(rs.getString("sexo"));
            e.setRaca(rs.getString("raca"));
            e.setEstadoCivil(rs.getString("estadocivil"));
            e.setTelefone(rs.getString("telefone"));
            e.setFrequenciaEscolar(rs.getString("frequenciaescolar"));
            e.setLerEscrever(rs.getString("lerescrever"));
            e.setQualificacaoProfissional(rs.getString("qualificacaoprofissional"));
            e.setRenda(rs.getFloat("renda"));
            e.setDataRenda(rs.getDate("datarenda"));
            e.setAposentadoPensionista(rs.getString("aposentadopensionista"));
            e.setAreaRisco(rs.getString("arearisco"));
            e.setTipoResidencia(rs.getString("tiporesidencia"));
            e.setComplementoImovel(rs.getString("complementoimovel"));
            e.setLogradouro(rs.getString("logradouro"));
            e.setNumero(rs.getString("numero"));
            e.setComplementoEndereco(rs.getString("complementoendereco"));
            e.setBairro(rs.getString("bairro"));
            e.setCep(rs.getString("cep"));
            e.setPontoReferencia(rs.getString("pontoreferencia"));
            e.setLocalizacao(rs.getString("localizacao"));
            e.setAbrigo(rs.getString("abrigo"));
            e.setTipoLogradouro(rs.getString("tipologradouro"));
            e.setDataDesligamento(rs.getDate("datadesligamento"));
            e.setMotivoDesligamento(rs.getString("motivodesligamento"));
            e.setComplementoPessoa(rs.getString("complementopessoa"));
            e.setDataAtualizacaoCadastro(rs.getDate("dataatualizacaocadastro"));
            e.setDataAtualizacaoEndereco(rs.getDate("dataatualizacaoendereco"));
            e.setDataAtualizacaoHabitacional(rs.getDate("dataatualizacaohabitacional"));
            e.setComplementoHabitacional(rs.getString("complementohabitacional"));

            FormaIngresso formaIngresso = new FormaIngresso();
            formaIngresso.setId(rs.getLong("formaIngresso_id"));
            formaIngresso.setDescricao(rs.getString("formaIngresso_descricao"));
            e.setFormaIngresso(formaIngresso);

            TipoParentesco tipoParentesco = new TipoParentesco();
            tipoParentesco.setId(rs.getLong("tipoParentesco_id"));
            tipoParentesco.setDescricao(rs.getString("tipoParentesco_descricao"));
            e.setTipoParentesco(tipoParentesco);

            TipoEscolaridade tipoEscolaridade = new TipoEscolaridade();
            tipoEscolaridade.setId(rs.getLong("tipoEscolaridade_id"));
            tipoEscolaridade.setDescricao(rs.getString("tipoEscolaridade_descricao"));
            e.setTipoEscolaridade(tipoEscolaridade);

            TipoOcupacao tipoOcupacao = new TipoOcupacao();
            tipoOcupacao.setId(rs.getLong("tipoOcupacao_id"));
            tipoOcupacao.setDescricao(rs.getString("tipoOcupacao_descricao"));
            e.setTipoOcupacao(tipoOcupacao);

            TipoEspecificidadeSocial tipoEspecificidadeSocial = new TipoEspecificidadeSocial();
            tipoEspecificidadeSocial.setId(rs.getLong("tipoEspecificidadeSocial_id"));
            tipoEspecificidadeSocial.setDescricao(rs.getString("tipoEspecificidadeSocial_descricao"));
            e.setTipoEspecificidadeSocial(tipoEspecificidadeSocial);

            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("municipio_id"));
            municipio.setNome(rs.getString("municipio_nome"));
            e.setMunicipio(municipio);

            Uf uf = new Uf();
            uf.setId(rs.getLong("uf_id"));
            uf.setNome(rs.getString("uf_nome"));
            uf.setSigla(rs.getString("uf_sigla"));
            e.setUf(uf);

            TipoBeneficioDespesa tipoBeneficioDespesa = new TipoBeneficioDespesa();
            tipoBeneficioDespesa.setId(rs.getLong("tipoBeneficioDespesa_id"));
            tipoBeneficioDespesa.setDescricao(rs.getString("tipoBeneficioDespesa_descricao"));
            e.setTipoBeneficioDespesa(tipoBeneficioDespesa);

            TipoDeficiencia tipoDeficiencia = new TipoDeficiencia();
            tipoDeficiencia.setId(rs.getLong("tipoDeficiencia_id"));
            tipoDeficiencia.setDescricao(rs.getString("tipoDeficiencia_descricao"));
            e.setTipoDeficiencia(tipoDeficiencia);

            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getLong("pessoa_id"));
            e.setPessoa(pessoa);

        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Pessoa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Pessoa> lista = new ArrayList<Pessoa>();
        String sql = "SELECT pessoa.*, formaingresso.id as formaingresso_id, formaingresso.descricao as formaingresso_descricao, tipoescolaridade.id as tipoescolaridade_id, tipoescolaridade.descricao as tipoescolaridade_descricao, tipoocupacao.id as tipoocupacao_id, tipoocupacao.descricao as tipoocupacao_descricao, uf1.id as uf_id, uf1.nome as uf_nome, uf1.sigla as uf_sigla, uf2.id as ufrg_id, uf2.sigla as ufrg_sigla, uf3.id as ufcn_id, uf3.sigla as ufcn_sigla, uf4.id as ufctps_id, uf4.sigla as ufctps_sigla, uf5.id as ufnacionalidade_id, uf5.sigla as ufnacionalidade_sigla, municipio1.id as municipio_id, municipio1.nome as municipio_nome, municipio2.id as municipionacionalidade_id, municipio2.nome as municipionacionalidade_nome, tipoparentesco.id as tipoparentesco_id, tipoparentesco.descricao as tipoparentesco_descricao, tipoespecificidadesocial.id as tipoespecificidadesocial_id, tipoespecificidadesocial.descricao as tipoespecificidadesocial_descricao, tipodeficiencia.id as tipodeficiencia_id, tipodeficiencia.descricao as tipodeficiencia_descricao, tipobeneficiodespesa.id as tipobeneficiodespesa_id, tipobeneficiodespesa.descricao as tipobeneficiodespesa_descricao FROM pessoa LEFT JOIN formaingresso ON pessoa.formaingresso_fk = formaingresso.id LEFT JOIN tipoescolaridade ON pessoa.tipoescolaridade_fk = tipoescolaridade.id LEFT JOIN tipoocupacao ON pessoa.tipoocupacao_fk = tipoocupacao.id LEFT JOIN uf as uf1 ON pessoa.uf_fk = uf1.id LEFT JOIN uf as uf2 ON pessoa.ufrg_fk = uf2.id LEFT JOIN uf as uf3 ON pessoa.ufcn_fk = uf3.id LEFT JOIN uf as uf4 ON pessoa.ufctps_fk = uf4.id LEFT JOIN uf as uf5 ON pessoa.ufnacionalidade_fk = uf5.id LEFT JOIN municipio as municipio1 ON pessoa.municipio_fk = municipio1.id LEFT JOIN municipio as municipio2 ON pessoa.municipionacionalidade_fk = municipio2.id LEFT JOIN tipoparentesco ON pessoa.tipoparentesco_fk = tipoparentesco.id LEFT JOIN tipoespecificidadesocial ON pessoa.tipoespecificidadesocial_fk = tipoespecificidadesocial.id LEFT JOIN tipodeficiencia ON pessoa.tipodeficiencia_fk = tipodeficiencia.id LEFT JOIN tipobeneficiodespesa ON pessoa.tipobeneficiodespesa_fk = tipobeneficiodespesa.id WHERE 1=1";

        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND pessoa.nome ILIKE '%" + criterionNomeILike + "%'";
        }

        Long criterionMunicipioIdEq = (Long) criteria.get(CRITERION_MUNICIPIO_ID_EQ);
        if (criterionMunicipioIdEq != null && criterionMunicipioIdEq > 0) {
            sql += " AND municipio_fk ='" + criterionMunicipioIdEq + "'";
        }

        Long criterionUfIdEq = (Long) criteria.get(CRITERION_UF_ID_EQ);
        if (criterionUfIdEq != null && criterionUfIdEq > 0) {
            sql += " AND uf_fk ='" + criterionUfIdEq + "'";
        }

        Long criterionFormaIngressoIdEq = (Long) criteria.get(CRITERION_FORMAINGRESSO_ID_EQ);
        if (criterionFormaIngressoIdEq != null && criterionFormaIngressoIdEq > 0) {
            sql += " AND formaingresso_fk ='" + criterionFormaIngressoIdEq + "'";
        }

        Long criterionTipoBeneficioDespesaIdEq = (Long) criteria.get(CRITERION_TIPOBENEFICIODESPESA_ID_EQ);
        if (criterionTipoBeneficioDespesaIdEq != null && criterionTipoBeneficioDespesaIdEq > 0) {
            sql += " AND tipobeneficiodespesa_fk ='" + criterionTipoBeneficioDespesaIdEq + "'";
        }

        Long criterionTipoDeficienciaIdEq = (Long) criteria.get(CRITERION_TIPODEFICIENCIA_ID_EQ);
        if (criterionTipoDeficienciaIdEq != null && criterionTipoDeficienciaIdEq > 0) {
            sql += " AND tipodeficiencia_fk ='" + criterionTipoDeficienciaIdEq + "'";
        }

        Long criterionTipoEscolaridadeIdEq = (Long) criteria.get(CRITERION_TIPOESCOLARIDADE_ID_EQ);
        if (criterionTipoEscolaridadeIdEq != null && criterionTipoEscolaridadeIdEq > 0) {
            sql += " AND tipoescolaridade_fk ='" + criterionTipoEscolaridadeIdEq + "'";
        }

        Long criterionTipoEspecificidadeSocialIdEq = (Long) criteria.get(CRITERION_TIPOESPECIFICIDADESOCIAL_ID_EQ);
        if (criterionTipoEspecificidadeSocialIdEq != null && criterionTipoEspecificidadeSocialIdEq > 0) {
            sql += " AND tipoespecificidadesocial_fk ='" + criterionTipoEspecificidadeSocialIdEq + "'";
        }

        Long criterionTipoOcupacaoIdEq = (Long) criteria.get(CRITERION_TIPOOCUPACAO_ID_EQ);
        if (criterionTipoOcupacaoIdEq != null && criterionTipoOcupacaoIdEq > 0) {
            sql += " AND tipoocupacao_fk ='" + criterionTipoOcupacaoIdEq + "'";
        }

        Long criterionTipoParentescoIdEq = (Long) criteria.get(CRITERION_TIPOPARENTESCO_ID_EQ);
        if (criterionTipoParentescoIdEq != null && criterionTipoParentescoIdEq > 0) {
            sql += " AND tipoparentesco_fk ='" + criterionTipoParentescoIdEq + "'";
        }

        String criterionCpfILike = (String) criteria.get(CRITERION_CPF_I_LIKE);
        if (criterionCpfILike != null && !criterionCpfILike.trim().isEmpty()) {
            sql += " AND pessoa.cpf ILIKE '%" + criterionCpfILike + "%'";
        }

        String criterionNisILike = (String) criteria.get(CRITERION_NIS_I_LIKE);
        if (criterionNisILike != null && !criterionNisILike.trim().isEmpty()) {
            sql += " AND pessoa.nis ILIKE '%" + criterionNisILike + "%'";
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getLong("id"));
            pessoa.setDataInclusao(rs.getDate("datainclusao"));
            pessoa.setNumeroOrdem(rs.getInt("numeroordem"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setNomeMae(rs.getString("nomemae"));
            pessoa.setNomePai(rs.getString("nomepai"));
            pessoa.setNis(rs.getString("nis"));
            pessoa.setCpf(rs.getString("cpf"));
            pessoa.setNumeroRg(rs.getString("numerorg"));
            pessoa.setOrgaoExpedidor(rs.getString("orgaoexpedidor"));
            pessoa.setDataEmissaoRg(rs.getDate("dataemissaorg"));

            Uf ufRg = new Uf();
            ufRg.setId(rs.getLong("ufrg_id"));
            ufRg.setSigla(rs.getString("ufrg_sigla"));
            pessoa.setUfRg(ufRg);
            //pessoa.setUfRg(rs.getString("ufrg"));

            pessoa.setNumeroCtps(rs.getString("numeroctps"));
            pessoa.setSerie(rs.getString("serie"));
            pessoa.setDataEmissaoCtps(rs.getDate("dataemissaoctps"));

            Uf ufCtps = new Uf();
            ufCtps.setId(rs.getLong("ufctps_id"));
            ufCtps.setSigla(rs.getString("ufctps_sigla"));
            pessoa.setUfCtps(ufCtps);
            //pessoa.setUfCtps(rs.getString("ufctps"));

            pessoa.setNumeroTituloEleitoral(rs.getString("numerotituloeleitoral"));
            pessoa.setZona(rs.getString("zona"));
            pessoa.setSecao(rs.getString("secao"));
            pessoa.setCartorioCertidao(rs.getString("cartoriocertidao"));
            pessoa.setNumeroTermo(rs.getString("numerotermo"));
            pessoa.setLivro(rs.getString("livro"));
            pessoa.setFolha(rs.getString("folha"));
            pessoa.setDataEmissaoCn(rs.getDate("dataemissaocn"));

            Uf ufCn = new Uf();
            ufCn.setId(rs.getLong("ufcn_id"));
            ufCn.setSigla(rs.getString("ufcn_sigla"));
            pessoa.setUfCn(ufCn);
            //pessoa.setUfCn(rs.getString("ufcn"));

            pessoa.setTipoCertidao(rs.getString("tipocertidao"));
            pessoa.setDataNascimento(rs.getDate("datanascimento"));
            pessoa.setNacionalidade(rs.getString("nacionalidade"));

            Municipio municipioNacionalidade = new Municipio();
            municipioNacionalidade.setId(rs.getLong("municipionacionalidade_id"));
            municipioNacionalidade.setNome(rs.getString("municipionacionalidade_nome"));
            pessoa.setMunicipioNacionalidade(municipioNacionalidade);
            //pessoa.setMunicipioNacionalidade(rs.getString("municipionacionalidade"));

            Uf ufNacionalidade = new Uf();
            ufNacionalidade.setId(rs.getLong("ufnacionalidade_id"));
            ufNacionalidade.setSigla(rs.getString("ufnacionalidade_sigla"));
            pessoa.setUfNacionalidade(ufNacionalidade);
            //pessoa.setUfNacionalidade(rs.getString("ufnacionalidade"));

            pessoa.setSexo(rs.getString("sexo"));
            pessoa.setRaca(rs.getString("raca"));
            pessoa.setEstadoCivil(rs.getString("estadocivil"));
            pessoa.setTelefone(rs.getString("telefone"));
            pessoa.setFrequenciaEscolar(rs.getString("frequenciaescolar"));
            pessoa.setLerEscrever(rs.getString("lerescrever"));
            pessoa.setQualificacaoProfissional(rs.getString("qualificacaoprofissional"));
            pessoa.setRenda(rs.getFloat("renda"));
            pessoa.setDataRenda(rs.getDate("datarenda"));
            pessoa.setAposentadoPensionista(rs.getString("aposentadopensionista"));
            pessoa.setAreaRisco(rs.getString("arearisco"));
            pessoa.setTipoResidencia(rs.getString("tiporesidencia"));
            pessoa.setComplementoImovel(rs.getString("complementoimovel"));
            pessoa.setLogradouro(rs.getString("logradouro"));
            pessoa.setNumero(rs.getString("numero"));
            pessoa.setComplementoEndereco(rs.getString("complementoendereco"));
            pessoa.setBairro(rs.getString("bairro"));
            pessoa.setCep(rs.getString("cep"));
            pessoa.setPontoReferencia(rs.getString("pontoreferencia"));
            pessoa.setLocalizacao(rs.getString("localizacao"));
            pessoa.setAbrigo(rs.getString("abrigo"));
            pessoa.setTipoLogradouro(rs.getString("tipologradouro"));
            pessoa.setDataDesligamento(rs.getDate("datadesligamento"));
            pessoa.setMotivoDesligamento(rs.getString("motivodesligamento"));
            pessoa.setComplementoPessoa(rs.getString("complementopessoa"));
            pessoa.setDataAtualizacaoCadastro(rs.getDate("dataatualizacaocadastro"));
            pessoa.setDataAtualizacaoEndereco(rs.getDate("dataatualizacaoendereco"));
            pessoa.setDataAtualizacaoHabitacional(rs.getDate("dataatualizacaohabitacional"));
            pessoa.setComplementoHabitacional(rs.getString("complementohabitacional"));

            FormaIngresso formaIngresso = new FormaIngresso();
            formaIngresso.setId(rs.getLong("formaIngresso_id"));
            formaIngresso.setDescricao(rs.getString("formaIngresso_descricao"));
            pessoa.setFormaIngresso(formaIngresso);

            TipoParentesco tipoParentesco = new TipoParentesco();
            tipoParentesco.setId(rs.getLong("tipoParentesco_id"));
            tipoParentesco.setDescricao(rs.getString("tipoParentesco_descricao"));
            pessoa.setTipoParentesco(tipoParentesco);

            TipoEscolaridade tipoEscolaridade = new TipoEscolaridade();
            tipoEscolaridade.setId(rs.getLong("tipoEscolaridade_id"));
            tipoEscolaridade.setDescricao(rs.getString("tipoEscolaridade_descricao"));
            pessoa.setTipoEscolaridade(tipoEscolaridade);

            TipoOcupacao tipoOcupacao = new TipoOcupacao();
            tipoOcupacao.setId(rs.getLong("tipoOcupacao_id"));
            tipoOcupacao.setDescricao(rs.getString("tipoOcupacao_descricao"));
            pessoa.setTipoOcupacao(tipoOcupacao);

            TipoEspecificidadeSocial tipoEspecificidadeSocial = new TipoEspecificidadeSocial();
            tipoEspecificidadeSocial.setId(rs.getLong("tipoEspecificidadeSocial_id"));
            tipoEspecificidadeSocial.setDescricao(rs.getString("tipoEspecificidadeSocial_descricao"));
            pessoa.setTipoEspecificidadeSocial(tipoEspecificidadeSocial);

            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("municipio_id"));
            municipio.setNome(rs.getString("municipio_nome"));
            pessoa.setMunicipio(municipio);

            Uf uf = new Uf();
            uf.setId(rs.getLong("uf_id"));
            uf.setNome(rs.getString("uf_nome"));
            uf.setSigla(rs.getString("uf_sigla"));
            pessoa.setUf(uf);

            TipoBeneficioDespesa tipoBeneficioDespesa = new TipoBeneficioDespesa();
            tipoBeneficioDespesa.setId(rs.getLong("tipoBeneficioDespesa_id"));
            tipoBeneficioDespesa.setDescricao(rs.getString("tipoBeneficioDespesa_descricao"));
            pessoa.setTipoBeneficioDespesa(tipoBeneficioDespesa);

            TipoDeficiencia tipoDeficiencia = new TipoDeficiencia();
            tipoDeficiencia.setId(rs.getLong("tipoDeficiencia_id"));
            tipoDeficiencia.setDescricao(rs.getString("tipoDeficiencia_descricao"));
            pessoa.setTipoDeficiencia(tipoDeficiencia);

            lista.add(pessoa);
        }
        rs.close();
        s.close();
        return lista;

    }

    @Override
    public void update(Pessoa e, Connection conn) throws Exception {
        String sql = "UPDATE pessoa SET datainclusao=?, numeroordem=?, nome=?, nomemae=?, nomepai=?, nis=?, cpf=?, numerorg=?, orgaoexpedidor=?, dataemissaorg=?, ufrg_fk=?, numeroctps=?, serie=?, dataemissaoctps=?, ufctps_fk=?, numerotituloeleitoral=?, zona=?, secao=?, cartoriocertidao=?, numerotermo=?, livro=?, folha=?, dataemissaocn=?, ufcn_fk=?, tipocertidao=?, datanascimento=?, nacionalidade=?, ufnacionalidade_fk=?, municipionacionalidade_fk=?, sexo=?, raca=?, estadocivil=?, telefone=?, frequenciaescolar=?, lerescrever=?, qualificacaoprofissional=?, renda=?, datarenda=?, aposentadopensionista=?, arearisco=?, tiporesidencia=?, complementoimovel=?, logradouro=?, numero=?, complementoendereco=?, bairro=?, cep=?, pontoreferencia=?, localizacao=?, abrigo=?, tipologradouro=?, datadesligamento=?, motivodesligamento=?, complementopessoa=?, complementohabitacional=?, dataatualizacaocadastro=?, dataatualizacaoendereco=?, dataatualizacaohabitacional=?, formaingresso_fk=?, tipoescolaridade_fk=?, tipoocupacao_fk=?, uf_fk=?, municipio_fk=?, tipoparentesco_fk=?, tipoespecificidadesocial_fk=?, tipodeficiencia_fk=?, tipobeneficiodespesa_fk=?, pessoa_fk=? WHERE pessoa.id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setDate(++i, new Date(e.getDataInclusao().getTime()));
        ps.setInt(++i, e.getNumeroOrdem());
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getNomeMae());
        ps.setString(++i, e.getNomePai());
        ps.setString(++i, e.getNis());
        ps.setString(++i, e.getCpf());
        ps.setString(++i, e.getNumeroRg());
        ps.setString(++i, e.getOrgaoExpedidor());

        if (e.getDataEmissaoRg() != null) {
            ps.setDate(++i, e.getDataEmissaoRg());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        if (e.getUfRg() != null) {
            ps.setLong(++i, e.getUfRg().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getNumeroCtps());
        ps.setString(++i, e.getSerie());

        if (e.getDataEmissaoCtps() != null) {
            ps.setDate(++i, e.getDataEmissaoCtps());
        } else {
            ps.setNull(++i, Types.DATE);
        }

        if (e.getUfCtps() != null) {
            ps.setLong(++i, e.getUfCtps().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getNumeroTituloEleitoral());
        ps.setString(++i, e.getZona());
        ps.setString(++i, e.getSecao());
        ps.setString(++i, e.getCartorioCertidao());
        ps.setString(++i, e.getNumeroTermo());
        ps.setString(++i, e.getLivro());
        ps.setString(++i, e.getFolha());

        if (e.getDataEmissaoCn() != null) {
            ps.setDate(++i, e.getDataEmissaoCn());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        if (e.getUfCn() != null) {
            ps.setLong(++i, e.getUfCn().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getTipoCertidao());
        
        if (e.getDataNascimento() != null) {
        ps.setDate(++i, e.getDataNascimento());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        ps.setString(++i, e.getNacionalidade());

        if (e.getMunicipioNacionalidade() != null) {
            ps.setLong(++i, e.getMunicipioNacionalidade().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        if (e.getUfNacionalidade() != null) {
            ps.setLong(++i, e.getUfNacionalidade().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getSexo());
        ps.setString(++i, e.getRaca());
        ps.setString(++i, e.getEstadoCivil());
        ps.setString(++i, e.getTelefone());
        ps.setString(++i, e.getFrequenciaEscolar());
        ps.setString(++i, e.getLerEscrever());
        ps.setString(++i, e.getQualificacaoProfissional());
        ps.setFloat(++i, e.getRenda());
        
        if (e.getDataRenda() != null){
            ps.setDate(++i, e.getDataRenda());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        
        ps.setString(++i, e.getAposentadoPensionista());
        ps.setString(++i, e.getAreaRisco());
        ps.setString(++i, e.getTipoResidencia());
        ps.setString(++i, e.getComplementoImovel());
        ps.setString(++i, e.getLogradouro());
        ps.setString(++i, e.getNumero());
        ps.setString(++i, e.getComplementoEndereco());
        ps.setString(++i, e.getBairro());
        ps.setString(++i, e.getCep());
        ps.setString(++i, e.getPontoReferencia());
        ps.setString(++i, e.getLocalizacao());
        ps.setString(++i, e.getAbrigo());
        ps.setString(++i, e.getTipoLogradouro());
        
        if (e.getDataDesligamento()!= null){
            ps.setDate(++i, e.getDataDesligamento());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        
        ps.setString(++i, e.getMotivoDesligamento());
        ps.setString(++i, e.getComplementoPessoa());
        ps.setString(++i, e.getComplementoHabitacional());

        if (e.getDataAtualizacaoCadastro()!= null){
            ps.setDate(++i, e.getDataAtualizacaoCadastro());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        
        if (e.getDataAtualizacaoEndereco()!= null){
            ps.setDate(++i, e.getDataAtualizacaoEndereco());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        
        if (e.getDataAtualizacaoHabitacional()!= null){
            ps.setDate(++i, e.getDataAtualizacaoHabitacional());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        
        if (e.getMunicipio() != null) {
            ps.setLong(++i, e.getMunicipio().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getUf() != null) {
            ps.setLong(++i, e.getUf().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getFormaIngresso() != null) {
            ps.setLong(++i, e.getFormaIngresso().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoEscolaridade() != null) {
            ps.setLong(++i, e.getTipoEscolaridade().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoOcupacao() != null) {
            ps.setLong(++i, e.getTipoOcupacao().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoParentesco() != null) {
            ps.setLong(++i, e.getTipoParentesco().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoEspecificidadeSocial() != null) {
            ps.setLong(++i, e.getTipoEspecificidadeSocial().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoBeneficioDespesa() != null) {
            ps.setLong(++i, e.getTipoBeneficioDespesa().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoDeficiencia() != null) {
            ps.setLong(++i, e.getTipoDeficiencia().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM pessoa WHERE id =" + id);
        st.close();
    }

}
