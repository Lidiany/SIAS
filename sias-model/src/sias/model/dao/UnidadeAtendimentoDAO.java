package sias.model.dao;

import java.io.PrintWriter;
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
import sias.model.pojo.Uf;
import sias.model.pojo.UnidadeAtendimento;

public class UnidadeAtendimentoDAO implements BaseDAO<UnidadeAtendimento> {
    
    public static final String CRITERION_NOME_I_LIKE = "1";
    public static final String CRITERION_MUNICIPIO_ID_EQ = "2";
    public static final String CRITERION_UF_ID_EQ = "3";
    
    @Override
    public void create(UnidadeAtendimento e, Connection conn) throws Exception {
        String sql = "INSERT INTO unidadeatendimento(nome, numerounidade, responsavel, telefone, logradouro, numero, complementoendereco, bairro, cep, municipio_fk, uf_fk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";
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
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getUf() != null){
            ps.setLong(++i, e.getUf().getId());
        } else{
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
    public UnidadeAtendimento readById(Long id, Connection conn) throws Exception {
        UnidadeAtendimento e = null;
        String sql = "SELECT unidadeatendimento.*, municipio.id as municipio_id, municipio.nome as municipio_nome, uf.id as uf_id, uf.nome as uf_nome, uf.sigla as uf_sigla FROM unidadeatendimento LEFT JOIN municipio ON unidadeatendimento.municipio_fk = municipio.id LEFT JOIN uf ON unidadeatendimento.uf_fk = uf.id WHERE unidadeatendimento.id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new UnidadeAtendimento();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
            e.setNumeroUnidade(rs.getString("numerounidade"));
            e.setResponsavel(rs.getString("responsavel"));
            e.setTelefone(rs.getString("telefone"));
            e.setLogradouro(rs.getString("logradouro"));
            e.setNumero(rs.getString("numero"));
            e.setComplementoEndereco(rs.getString("complementoendereco"));
            e.setBairro(rs.getString("bairro"));
            e.setCep(rs.getString("cep"));
            
            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("municipio_id"));
            municipio.setNome(rs.getString("municipio_nome"));
            e.setMunicipio(municipio);
            
            Uf uf = new Uf();
            uf.setId(rs.getLong("uf_id"));
            uf.setNome(rs.getString("uf_nome"));
            uf.setSigla(rs.getString("uf_sigla"));
            e.setUf(uf);
            
            
/*        PrintWriter out = new PrintWriter("C:\\Temp\\teste.txt");
        out.println(ps.toString());
        out.close();*/
        
        }
        rs.close();
        ps.close();
        return e;
    }
    
    @Override
    public List<UnidadeAtendimento> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<UnidadeAtendimento> lista = new ArrayList<UnidadeAtendimento>();
        String sql = "SELECT unidadeatendimento.*, municipio.id as municipio_id, municipio.nome as municipio_nome, uf.id as uf_id, uf.nome as uf_nome, uf.sigla as uf_sigla FROM unidadeatendimento LEFT JOIN uf ON unidadeatendimento.uf_fk = uf.id LEFT JOIN municipio ON unidadeatendimento.municipio_fk = municipio.id WHERE 1=1";
        
        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND unidadeatendimento.nome ILIKE '%" + criterionNomeILike + "%'";
        }
        
        Long criterionMunicipioIdEq = (Long) criteria.get(CRITERION_MUNICIPIO_ID_EQ);
        if (criterionMunicipioIdEq != null && criterionMunicipioIdEq > 0) {
            sql += " AND municipio_fk ='" + criterionMunicipioIdEq + "'";
        }
        
        Long criterionUfIdEq = (Long) criteria.get(CRITERION_UF_ID_EQ);
        if (criterionUfIdEq != null && criterionUfIdEq > 0) {
            sql += " AND uf_fk ='" + criterionUfIdEq + "'";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            UnidadeAtendimento unidadeAtendimento = new UnidadeAtendimento();
            unidadeAtendimento.setId(rs.getLong("id"));
            unidadeAtendimento.setNome(rs.getString("nome"));
            unidadeAtendimento.setNumeroUnidade(rs.getString("numerounidade"));
            unidadeAtendimento.setResponsavel(rs.getString("responsavel"));
            unidadeAtendimento.setTelefone(rs.getString("telefone"));
            unidadeAtendimento.setLogradouro(rs.getString("logradouro"));
            unidadeAtendimento.setNumero(rs.getString("numero"));
            unidadeAtendimento.setComplementoEndereco(rs.getString("complementoendereco"));
            unidadeAtendimento.setBairro(rs.getString("bairro"));
            unidadeAtendimento.setCep(rs.getString("cep"));
            
            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("municipio_id"));
            municipio.setNome(rs.getString("municipio_nome"));
            unidadeAtendimento.setMunicipio(municipio);
            
            Uf uf = new Uf();
            uf.setId(rs.getLong("uf_id"));
            uf.setNome(rs.getString("uf_nome"));
            uf.setSigla(rs.getString("uf_sigla"));
            unidadeAtendimento.setUf(uf);
            
            lista.add(unidadeAtendimento);
        }
        rs.close();
        s.close();
        return lista;
    }
    
    @Override
    public void update(UnidadeAtendimento e, Connection conn) throws Exception {
        String sql = "UPDATE unidadeatendimento SET nome=?, numeroUnidade=?, responsavel=?, telefone=?, logradouro=?, numero=?, complementoEndereco=?, bairro=?, cep=?, municipio_fk=?, uf_fk=? WHERE unidadeatendimento.id=?;";
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
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getUf() != null){
            ps.setLong(++i, e.getUf().getId());
        } else{
            ps.setNull(++i, Types.BIGINT);
        }
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }
    
    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM unidadeatendimento WHERE id =" + id);
        st.close();
    }
    
}
