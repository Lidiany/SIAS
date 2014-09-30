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
import sias.model.pojo.Colaborador;
import sias.model.pojo.Municipio;
import sias.model.pojo.Uf;
import sias.model.pojo.UnidadeAtendimento;

public class ColaboradorDAO implements BaseDAO<Colaborador> {

    public static final String CRITERION_NOME_I_LIKE = "1";
    public static final String CRITERION_MUNICIPIO_ID_EQ = "2";
    public static final String CRITERION_UF_ID_EQ = "3";
    public static final String CRITERION_UNIDADEATENDIMENTO_ID_EQ = "4";

    @Override
    public void create(Colaborador e, Connection conn) throws Exception {
        String sql = "INSERT INTO colaborador(nome, cpf, numerorg, orgaoexpedidor, dataemissao, ufemissao_fk, cargo, funcao, telefone, logradouro, numero, complementoendereco, bairro, cep, municipio_fk, uf_fk, unidadeatendimento_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getCpf());
        ps.setString(++i, e.getNumeroRg());
        ps.setString(++i, e.getOrgaoExpedidor());
        ps.setDate(++i, new Date(e.getDataEmissao().getTime()));

        if (e.getUfEmissao() != null) {
            ps.setLong(++i, e.getUfEmissao().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getCargo());
        ps.setString(++i, e.getFuncao());
        ps.setString(++i, e.getTelefone());
        ps.setString(++i, e.getLogradouro());
        ps.setString(++i, e.getNumero());
        ps.setString(++i, e.getComplementoEndereco());
        ps.setString(++i, e.getBairro());
        ps.setString(++i, e.getCep());

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
        if (e.getUnidadeAtendimento() != null) {
            ps.setLong(++i, e.getUnidadeAtendimento().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ResultSet rs = ps.executeQuery();

        /*  PrintWriter out = new PrintWriter("C:\\Temp\\teste.txt");
         out.println(ps.toString());
         out.close(); */
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Colaborador readById(Long id, Connection conn) throws Exception {
        Colaborador e = null;
        String sql = "SELECT colaborador.*, municipio.id as municipio_id, municipio.nome as municipio_nome, uf1.id as uf_id, uf1.nome as uf_nome, uf1.sigla as uf_sigla, uf2.id as ufemissao_id, uf2.sigla as ufemissao_sigla, unidadeatendimento.id as unidadeatendimento_id, unidadeatendimento.nome as unidadeatendimento_nome FROM colaborador LEFT JOIN municipio ON colaborador.municipio_fk = municipio.id LEFT JOIN uf as uf1 ON colaborador.uf_fk = uf1.id LEFT JOIN uf as uf2 ON colaborador.ufemissao_fk = uf2.id LEFT JOIN unidadeatendimento ON colaborador.unidadeatendimento_fk = unidadeatendimento.id WHERE colaborador.id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new Colaborador();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
            e.setCpf(rs.getString("cpf"));
            e.setNumeroRg(rs.getString("numerorg"));
            e.setOrgaoExpedidor(rs.getString("orgaoexpedidor"));
            e.setDataEmissao(rs.getDate("dataemissao"));

            //  e.setUfEmissao(rs.getString("ufemissao"));
            e.setCargo(rs.getString("cargo"));
            e.setFuncao(rs.getString("funcao"));
            e.setTelefone(rs.getString("telefone"));
            e.setLogradouro(rs.getString("logradouro"));
            e.setNumero(rs.getString("numero"));
            e.setComplementoEndereco(rs.getString("complementoendereco"));
            e.setBairro(rs.getString("bairro"));
            e.setCep(rs.getString("cep"));

            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId(rs.getLong("unidadeatendimento_id"));
            unidadeAtendimento.setNome(rs.getString("unidadeatendimento_nome"));
            /*  unidadeAtendimento.setNumeroUnidade(rs.getString("unidadeatendimento_numerounidade"));
             unidadeAtendimento.setResponsavel(rs.getString("unidadeatendimento_responsavel"));
             unidadeAtendimento.setTelefone(rs.getString("unidadeatendimento_telefone"));
             unidadeAtendimento.setLogradouro(rs.getString("unidadeatendimento_logradouro"));
             unidadeAtendimento.setNumero(rs.getString("unidadeatendimento_numero"));
             unidadeAtendimento.setComplementoEndereco(rs.getString("unidadeatendimento_complementoendereco"));
             unidadeAtendimento.setBairro(rs.getString("unidadeatendimento_bairro"));
             unidadeAtendimento.setCep(rs.getString("unidadeatendimento_cep"));*/
            e.setUnidadeAtendimento(unidadeAtendimento);

            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("municipio_id"));
            municipio.setNome(rs.getString("municipio_nome"));
            e.setMunicipio(municipio);

            Uf ufEmissao = new Uf();
            ufEmissao.setId(rs.getLong("ufemissao_id"));
            ufEmissao.setSigla(rs.getString("ufemissao_sigla"));
            e.setUfEmissao(ufEmissao);

            Uf uf = new Uf();
            uf.setId(rs.getLong("uf_id"));
            uf.setNome(rs.getString("uf_nome"));
            uf.setSigla(rs.getString("uf_sigla"));
            e.setUf(uf);

            /*PrintWriter out = new PrintWriter("C:\\Temp\\teste.txt");
             out.println(ps.toString());
             out.close();
             */
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Colaborador> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Colaborador> lista = new ArrayList<Colaborador>();
        String sql = "SELECT colaborador.*, municipio.id as municipio_id, municipio.nome as municipio_nome, uf.id as uf_id, uf.nome as uf_nome, uf.sigla as uf_sigla, unidadeatendimento.id as unidadeatendimento_id, unidadeatendimento.nome as unidadeatendimento_nome, uf.id as ufemissao_id, uf.sigla as ufemissao_sigla FROM colaborador LEFT JOIN municipio ON colaborador.municipio_fk = municipio.id LEFT JOIN uf ON colaborador.uf_fk = uf.id LEFT JOIN unidadeatendimento ON colaborador.unidadeatendimento_fk = unidadeatendimento.id WHERE 1=1";

        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND colaborador.nome ILIKE '%" + criterionNomeILike + "%'";
        }

        Long criterionMunicipioIdEq = (Long) criteria.get(CRITERION_MUNICIPIO_ID_EQ);
        if (criterionMunicipioIdEq != null && criterionMunicipioIdEq > 0) {
            sql += " AND municipio_fk ='" + criterionMunicipioIdEq + "'";
        }

        Long criterionUfIdEq = (Long) criteria.get(CRITERION_UF_ID_EQ);
        if (criterionUfIdEq != null && criterionUfIdEq > 0) {
            sql += " AND uf_fk ='" + criterionUfIdEq + "'";
        }

        Long criterionUnidadeAtendimentoIdEq = (Long) criteria.get(CRITERION_UNIDADEATENDIMENTO_ID_EQ);
        if (criterionUnidadeAtendimentoIdEq != null && criterionUnidadeAtendimentoIdEq > 0) {
            sql += " AND unidadeatendimento_fk ='" + criterionUnidadeAtendimentoIdEq + "'";
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Colaborador colaborador = new Colaborador();
            colaborador.setId(rs.getLong("id"));
            colaborador.setNome(rs.getString("nome"));
            colaborador.setCpf(rs.getString("cpf"));
            colaborador.setNumeroRg(rs.getString("numerorg"));
            colaborador.setOrgaoExpedidor(rs.getString("orgaoexpedidor"));
            colaborador.setDataEmissao(rs.getDate("dataemissao"));
            colaborador.setCargo(rs.getString("cargo"));
            colaborador.setFuncao(rs.getString("funcao"));
            colaborador.setTelefone(rs.getString("telefone"));
            colaborador.setLogradouro(rs.getString("logradouro"));
            colaborador.setNumero(rs.getString("numero"));
            colaborador.setComplementoEndereco(rs.getString("complementoendereco"));
            colaborador.setBairro(rs.getString("bairro"));
            colaborador.setCep(rs.getString("cep"));

            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId(rs.getLong("unidadeatendimento_id"));
            unidadeAtendimento.setNome(rs.getString("unidadeatendimento_nome"));
            /*    unidadeAtendimento.setNumeroUnidade(rs.getString("unidadeatendimento_numerounidade"));
             unidadeAtendimento.setResponsavel(rs.getString("unidadeatendimento_responsavel"));
             unidadeAtendimento.setTelefone(rs.getString("unidadeatendimento_telefone"));
             unidadeAtendimento.setLogradouro(rs.getString("unidadeatendimento_logradouro"));
             unidadeAtendimento.setNumero(rs.getString("unidadeatendimento_numero"));
             unidadeAtendimento.setComplementoEndereco(rs.getString("unidadeatendimento_complementoendereco"));
             unidadeAtendimento.setBairro(rs.getString("unidadeatendimento_bairro"));
             unidadeAtendimento.setCep(rs.getString("unidadeatendimento_cep"));*/
            colaborador.setUnidadeAtendimento(unidadeAtendimento);

            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("municipio_id"));
            municipio.setNome(rs.getString("municipio_nome"));
            colaborador.setMunicipio(municipio);

            Uf ufEmissao = new Uf();
            ufEmissao.setId(rs.getLong("ufemissao_id"));
            ufEmissao.setSigla(rs.getString("ufemissao_sigla"));
            colaborador.setUfEmissao(ufEmissao);

            Uf uf = new Uf();
            uf.setId(rs.getLong("uf_id"));
            uf.setNome(rs.getString("uf_nome"));
            uf.setSigla(rs.getString("uf_sigla"));
            colaborador.setUf(uf);

            lista.add(colaborador);
        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(Colaborador e, Connection conn) throws Exception {
        String sql = "UPDATE colaborador SET nome=?, cpf=?, numerorg=?, orgaoexpedidor=?, dataemissao=?, ufemissao_fk=?, cargo=?, funcao=?, telefone=?, logradouro=?, numero=?, complementoendereco=?, bairro=?, cep=?, unidadeatendimento_fk=?, municipio_fk=?, uf_fk=? WHERE colaborador.id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getCpf());
        ps.setString(++i, e.getNumeroRg());
        ps.setString(++i, e.getOrgaoExpedidor());
        ps.setDate(++i, new Date(e.getDataEmissao().getTime()));
        /*        if (e.getDataEmissao() != null) {
         ps.setDate(++i, (Date) e.getDataEmissao());
         } else {
         ps.setNull(++i, Types.DATE);
         }*/

        if (e.getUfEmissao() != null) {
            ps.setLong(++i, e.getUfEmissao().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        ps.setString(++i, e.getCargo());
        ps.setString(++i, e.getFuncao());
        ps.setString(++i, e.getTelefone());
        ps.setString(++i, e.getLogradouro());
        ps.setString(++i, e.getNumero());
        ps.setString(++i, e.getComplementoEndereco());
        ps.setString(++i, e.getBairro());
        ps.setString(++i, e.getCep());

        if (e.getUnidadeAtendimento() != null) {
            ps.setLong(++i, e.getUnidadeAtendimento().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
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

        ps.setLong(++i, e.getId());

        /*        PrintWriter out = new PrintWriter("C:\\Temp\\teste.txt");
         out.println(ps.toString());
         out.close();
         */
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM colaborador WHERE id =" + id);
        st.close();
    }

}
