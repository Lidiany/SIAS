package sias.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.Uf;

public class UfDAO implements BaseDAO<Uf> {

    public static final String CRITERION_NOME_I_LIKE = "1";

    @Override
    public void create(Uf e, Connection conn) throws Exception {
        String sql = "INSERT INTO uf (nome, sigla) VALUES (?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getSigla());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Uf readById(Long id, Connection conn) throws Exception {
        Uf e = null;
        String sql = "SELECT * FROM uf WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new Uf();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
            e.setSigla(rs.getString("sigla"));
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Uf> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Uf> lista = new ArrayList<Uf>();
        String sql = "SELECT * FROM uf WHERE 1=1";
        
        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND nome ILIKE '%" + criterionNomeILike + "%'";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Uf e = new Uf();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
            e.setSigla(rs.getString("sigla"));
            lista.add(e);
        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(Uf e, Connection conn) throws Exception {
        String sql = "UPDATE uf SET nome=?, sigla=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        ps.setString(++i, e.getSigla());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM uf WHERE id =" + id);
        st.close();
    }
}
