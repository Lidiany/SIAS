package sias.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.TipoBeneficioDespesa;

public class TipoBeneficioDespesaDAO implements BaseDAO<TipoBeneficioDespesa>{

    public static final String CRITERION_DESCRICAO_I_LIKE = "1";
    
    @Override
    public void create(TipoBeneficioDespesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO tipobeneficiodespesa(descricao, tipo) VALUES (?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getDescricao());
        ps.setString(++i, e.getTipo());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public TipoBeneficioDespesa readById(Long id, Connection conn) throws Exception {
        TipoBeneficioDespesa e = null;
        String sql = "SELECT * FROM tipobeneficiodespesa WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new TipoBeneficioDespesa();
            e.setId(rs.getLong("id"));
            e.setDescricao(rs.getString("descricao"));
            e.setTipo(rs.getString("tipo"));
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<TipoBeneficioDespesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<TipoBeneficioDespesa> lista = new ArrayList<TipoBeneficioDespesa>();
        String sql = "SELECT * FROM tipobeneficiodespesa WHERE 1=1 ";
        
        String criterionDescricaoILike = (String) criteria.get(CRITERION_DESCRICAO_I_LIKE);
        if (criterionDescricaoILike != null && !criterionDescricaoILike.trim().isEmpty()) {
            sql += " AND descricao ILIKE '%" + criterionDescricaoILike + "%'";
            sql += " ORDER BY tipo, descricao";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            TipoBeneficioDespesa e = new TipoBeneficioDespesa();
            e.setId(rs.getLong("id"));
            e.setDescricao(rs.getString("descricao"));
            e.setTipo(rs.getString("tipo"));
            lista.add(e);
        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(TipoBeneficioDespesa e, Connection conn) throws Exception {
        String sql = "UPDATE tipobeneficiodespesa SET descricao=?, tipo=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getDescricao());
        ps.setString(++i, e.getTipo());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM tipobeneficiodespesa WHERE id =" + id);
        st.close();
    }
    
}
