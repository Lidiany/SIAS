package sias.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.TipoDeficiencia;

public class TipoDeficienciaDAO implements BaseDAO<TipoDeficiencia>{

    public static final String CRITERION_DESCRICAO_I_LIKE = "1";
    
    @Override
    public void create(TipoDeficiencia e, Connection conn) throws Exception {
        String sql = "INSERT INTO tipoDeficiencia(codigo, descricao, ativo) VALUES (?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getCodigo());
        ps.setString(++i, e.getDescricao());
        ps.setBoolean(++i, e.getAtivo());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public TipoDeficiencia readById(Long id, Connection conn) throws Exception {
        TipoDeficiencia e = null;
        String sql = "SELECT * FROM tipoDeficiencia WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new TipoDeficiencia();
            e.setId(rs.getLong("id"));
            e.setCodigo(rs.getString("codigo"));
            e.setDescricao(rs.getString("descricao"));
            e.setAtivo(rs.getBoolean("ativo"));
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<TipoDeficiencia> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<TipoDeficiencia> lista = new ArrayList<TipoDeficiencia>();
        String sql = "SELECT * FROM tipoDeficiencia WHERE 1=1 ";
        
        String criterionDescricaoILike = (String) criteria.get(CRITERION_DESCRICAO_I_LIKE);
        if (criterionDescricaoILike != null && !criterionDescricaoILike.trim().isEmpty()) {
            sql += " AND descricao ILIKE '%" + criterionDescricaoILike + "%'";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            TipoDeficiencia e = new TipoDeficiencia();
            e.setId(rs.getLong("id"));
            e.setCodigo(rs.getString("codigo"));
            e.setDescricao(rs.getString("descricao"));
            e.setAtivo(rs.getBoolean("ativo"));
            lista.add(e);
        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(TipoDeficiencia e, Connection conn) throws Exception {
        String sql = "UPDATE tipoDeficiencia SET codigo=?, descricao=?, ativo=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getCodigo());
        ps.setString(++i, e.getDescricao());
        ps.setBoolean(++i, e.getAtivo());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM tipoDeficiencia WHERE id =" + id);
        st.close();
    }
    
}
