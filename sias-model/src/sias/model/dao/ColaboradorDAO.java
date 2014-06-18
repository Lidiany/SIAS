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
import sias.model.pojo.UnidadeAtendimento;

public class ColaboradorDAO implements BaseDAO<Colaborador>{

    public static final String CRITERION_NOME_I_LIKE = "1";
    public static final String CRITERION_MUNICIPIO_ID_EQ = "2";
    public static final String CRITERION_UNIDADEATENDIMENTO_ID_EQ = "3";
    
    @Override
    public void create(Colaborador e, Connection conn) throws Exception {
        String sql = "INSERT INTO colaborador(nome, cpf, numerorg, orgaoexpedidor, dataemissao, uf, cargo, funcao, telefone, logradouro, numero, complementoendereco, bairro, cep, unidadeatendimento_fk, municipio_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getCpf());
        ps.setString(++i, e.getNumeroRg());
        ps.setString(++i, e.getOrgaoExpedidor());
        if (e.getDataEmissao() != null) {
            ps.setDate(++i, (Date) e.getDataEmissao());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        ps.setString(++i, e.getUf());
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
            ps.setNull(++i, Types.SMALLINT);
        }
        if (e.getMunicipio() != null) {
            ps.setLong(++i, e.getMunicipio().getId());
        } else {
            ps.setNull(++i, Types.SMALLINT);
        }
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Colaborador readById(Long id, Connection conn) throws Exception {
        Colaborador e = null;
        String sql = "SELECT * FROM colaborador WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new Colaborador();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
            e.setCpf(rs.getString("cpf"));
            e.setNumeroRg(rs.getString("numeroRg"));
            e.setOrgaoExpedidor(rs.getString("orgaoExpedidor"));
            e.setDataEmissao(rs.getDate("dataEmissao"));
            e.setUf(rs.getString("uf"));
            e.setCargo(rs.getString("cargo"));
            e.setFuncao(rs.getString("funcao"));
            e.setTelefone(rs.getString("telefone"));
            e.setLogradouro(rs.getString("logradouro"));
            e.setNumero(rs.getString("numero"));
            e.setComplementoEndereco(rs.getString("complementoEndereco"));
            e.setBairro(rs.getString("bairro"));
            e.setCep(rs.getString("cep"));
            
            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId(rs.getLong("unidadeAtendimento_id"));
            unidadeAtendimento.setNome(rs.getString("unidadeAtendimento_nome"));
            unidadeAtendimento.setNumeroUnidade(rs.getString("unidadeAtendimento_numeroUnidade"));
            unidadeAtendimento.setResponsavel(rs.getString("unidadeAtendimento_responsavel"));
            unidadeAtendimento.setTelefone(rs.getString("unidadeAtendimento_telefone"));
            unidadeAtendimento.setLogradouro(rs.getString("unidadeAtendimento_logradouro"));
            unidadeAtendimento.setNumero(rs.getString("unidadeAtendimento_numero"));
            unidadeAtendimento.setComplementoEndereco(rs.getString("unidadeAtendimento_complementoEndereco"));
            unidadeAtendimento.setBairro(rs.getString("unidadeAtendimento_bairro"));
            unidadeAtendimento.setCep(rs.getString("unidadeAtendimento_cep"));
            e.setUnidadeAtendimento(unidadeAtendimento);
            
            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("municipio_id"));
            municipio.setNome(rs.getString("municipio_nome"));
            e.setMunicipio(municipio);            
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Colaborador> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Colaborador> lista = new ArrayList<Colaborador>();
        String sql = "SELECT * FROM colaborador WHERE 1=1";
        
        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND nome ILIKE '%" + criterionNomeILike + "%'";
        }
        
        Long criterionUnidadeAtendimentoIdEq = (Long) criteria.get(CRITERION_UNIDADEATENDIMENTO_ID_EQ);
        if (criterionUnidadeAtendimentoIdEq != null && criterionUnidadeAtendimentoIdEq > 0) {
            sql += " AND unidadeAtendimento_fk ='" + criterionUnidadeAtendimentoIdEq + "'";
        }
        
        Long criterionMunicipioIdEq = (Long) criteria.get(CRITERION_UNIDADEATENDIMENTO_ID_EQ);
        if (criterionMunicipioIdEq != null && criterionMunicipioIdEq > 0) {
            sql += " AND municipio_fk ='" + criterionMunicipioIdEq + "'";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Colaborador colaborador = new Colaborador();
            colaborador.setId(rs.getLong("id"));
            colaborador.setNome(rs.getString("nome"));
            colaborador.setCpf(rs.getString("cpf"));
            colaborador.setNumeroRg(rs.getString("numeroRg"));
            colaborador.setOrgaoExpedidor(rs.getString("orgaoExpedidor"));
            colaborador.setDataEmissao(rs.getDate("dataEmissao"));
            colaborador.setUf(rs.getString("uf"));
            colaborador.setCargo(rs.getString("cargo"));
            colaborador.setFuncao(rs.getString("funcao"));
            colaborador.setTelefone(rs.getString("telefone"));
            colaborador.setLogradouro(rs.getString("logradouro"));
            colaborador.setNumero(rs.getString("numero"));
            colaborador.setComplementoEndereco(rs.getString("complementoEndereco"));
            colaborador.setBairro(rs.getString("bairro"));
            colaborador.setCep(rs.getString("cep"));
            
            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId(rs.getLong("unidadeAtendimento_id"));
            unidadeAtendimento.setNome(rs.getString("unidadeAtendimento_nome"));
            unidadeAtendimento.setNumeroUnidade(rs.getString("unidadeAtendimento_numeroUnidade"));
            unidadeAtendimento.setResponsavel(rs.getString("unidadeAtendimento_responsavel"));
            unidadeAtendimento.setTelefone(rs.getString("unidadeAtendimento_telefone"));
            unidadeAtendimento.setLogradouro(rs.getString("unidadeAtendimento_logradouro"));
            unidadeAtendimento.setNumero(rs.getString("unidadeAtendimento_numero"));
            unidadeAtendimento.setComplementoEndereco(rs.getString("unidadeAtendimento_complementoEndereco"));
            unidadeAtendimento.setBairro(rs.getString("unidadeAtendimento_bairro"));
            unidadeAtendimento.setCep(rs.getString("unidadeAtendimento_cep"));
            colaborador.setUnidadeAtendimento(unidadeAtendimento);
            
            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("municipio_id"));
            municipio.setNome(rs.getString("municipio_nome"));
            colaborador.setMunicipio(municipio);
            
            lista.add(colaborador);
        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(Colaborador e, Connection conn) throws Exception {
        String sql = "UPDATE colaborador nome=?, cpf=?, numeroRg=?, orgaoExpedidor=?, dataEmissao=?, uf=?, cargo=?, funcao=?, telefone=?, logradouro=?, numero=?, complementoEndereco=?, bairro=?, cep=?, unidadeAtendimentofk=?, municipiofk=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getCpf());
        ps.setString(++i, e.getNumeroRg());
        ps.setString(++i, e.getOrgaoExpedidor());
        if (e.getDataEmissao() != null) {
            ps.setDate(++i, (Date) e.getDataEmissao());
        } else {
            ps.setNull(++i, Types.DATE);
        }
        ps.setString(++i, e.getUf());
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
            ps.setNull(++i, Types.SMALLINT);
        }
        if (e.getMunicipio() != null) {
            ps.setLong(++i, e.getMunicipio().getId());
        } else {
            ps.setNull(++i, Types.SMALLINT);
        }
        ps.setLong(++i, e.getId());
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
