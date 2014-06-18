package sias.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.Municipio;
import sias.model.pojo.UnidadeAtendimento;

public class UnidadeAtendimentoDAO implements BaseDAO<UnidadeAtendimento> {
    
    public static final String CRITERION_NOME_I_LIKE = "1";
    public static final String CRITERION_MUNICIPIO_ID_EQ = "2";
    
    @Override
    public void create(UnidadeAtendimento e, Connection conn) throws Exception {
        String sql = "INSERT INTO unidadeatendimento(nome, numerounidade, responsavel, telefone, logradouro, numero, complementoendereco, bairro, cep, municipio_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getNumeroUnidade());
        ps.setString(++i, e.getResponsavel());
        ps.setString(++i, e.getTelefone());
        ps.setString(++i, e.getLogradouro());
        ps.setString(++i, e.getNumero());
        ps.setString(++i, e.getComplementoEndereco());
        ps.setString(++i, e.getBairro());
        ps.setString(++i, e.getCep());
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
    public UnidadeAtendimento readById(Long id, Connection conn) throws Exception {
        UnidadeAtendimento e = null;
        String sql = "SELECT * FROM unidadeAtendimento WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new UnidadeAtendimento();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
            e.setNumeroUnidade(rs.getString("numeroUnidade"));
            e.setResponsavel(rs.getString("responsavel"));
            e.setTelefone(rs.getString("telefone"));
            e.setLogradouro(rs.getString("logradouro"));
            e.setNumero(rs.getString("numero"));
            e.setComplementoEndereco(rs.getString("complementoEndereco"));
            e.setBairro(rs.getString("bairro"));
            e.setCep(rs.getString("cep"));
            
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
    public List<UnidadeAtendimento> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<UnidadeAtendimento> lista = new ArrayList<UnidadeAtendimento>();
        String sql = "SELECT * FROM unidadeAtendimento WHERE 1=1";
        
        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND nome ILIKE '%" + criterionNomeILike + "%'";
        }
        
        Long criterionMunicipioIdEq = (Long) criteria.get(CRITERION_MUNICIPIO_ID_EQ);
        if (criterionMunicipioIdEq != null && criterionMunicipioIdEq > 0) {
            sql += " AND municipio_fk ='" + criterionMunicipioIdEq + "'";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId(rs.getLong("id"));
            unidadeAtendimento.setNome(rs.getString("nome"));
            unidadeAtendimento.setNumeroUnidade(rs.getString("numeroUnidade"));
            unidadeAtendimento.setResponsavel(rs.getString("responsavel"));
            unidadeAtendimento.setTelefone(rs.getString("telefone"));
            unidadeAtendimento.setLogradouro(rs.getString("logradouro"));
            unidadeAtendimento.setNumero(rs.getString("numero"));
            unidadeAtendimento.setComplementoEndereco(rs.getString("complementoEndereco"));
            unidadeAtendimento.setBairro(rs.getString("bairro"));
            unidadeAtendimento.setCep(rs.getString("cep"));
            
            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("municipio_id"));
            municipio.setNome(rs.getString("municipio_nome"));
            unidadeAtendimento.setMunicipio(municipio);
            
            lista.add(unidadeAtendimento);
        }
        rs.close();
        s.close();
        return lista;
    }
    
    @Override
    public void update(UnidadeAtendimento e, Connection conn) throws Exception {
        String sql = "UPDATE unidadeAtendimento nome=?, numeroUnidade=?, responsavel=?, telefone=?, logradouro=?, numero=?, complementoEndereco=?, bairro=?, cep=?, municipiofk=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getNumeroUnidade());
        ps.setString(++i, e.getResponsavel());
        ps.setString(++i, e.getTelefone());
        ps.setString(++i, e.getLogradouro());
        ps.setString(++i, e.getNumero());
        ps.setString(++i, e.getComplementoEndereco());
        ps.setString(++i, e.getBairro());
        ps.setString(++i, e.getCep());
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
        st.execute("DELETE FROM unidadeAtendimento WHERE id =" + id);
        st.close();
    }
    
}
