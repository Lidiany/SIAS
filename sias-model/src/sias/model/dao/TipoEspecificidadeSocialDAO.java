package sias.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.TipoEspecificidadeSocial;

public class TipoEspecificidadeSocialDAO implements BaseDAO<TipoEspecificidadeSocial>{

    public static final String CRITERION_DESCRICAO_I_LIKE = "1";
    
    @Override
    public void create(TipoEspecificidadeSocial e, Connection conn) throws Exception {
        String sql = "INSERT INTO tipoespecificidadesocial(descricao) VALUES (?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getDescricao());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public TipoEspecificidadeSocial readById(Long id, Connection conn) throws Exception {
        TipoEspecificidadeSocial e = null;
        String sql = "SELECT * FROM tipoespecificidadesocial WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new TipoEspecificidadeSocial();
            e.setId(rs.getLong("id"));
            e.setDescricao(rs.getString("descricao"));
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<TipoEspecificidadeSocial> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<TipoEspecificidadeSocial> lista = new ArrayList<TipoEspecificidadeSocial>();
        String sql = "SELECT * FROM tipoespecificidadesocial WHERE 1=1 ";
        
        String criterionDescricaoILike = (String) criteria.get(CRITERION_DESCRICAO_I_LIKE);
        if (criterionDescricaoILike != null && !criterionDescricaoILike.trim().isEmpty()){
            sql += " AND descricao ILIKE '%" + criterionDescricaoILike + "%'";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            TipoEspecificidadeSocial e = new TipoEspecificidadeSocial();
            e.setId(rs.getLong("id"));
            e.setDescricao(rs.getString("descricao"));
            lista.add(e);
        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(TipoEspecificidadeSocial e, Connection conn) throws Exception {
        String sql = "UPDATE tipoespecificidadesocial SET descricao=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getDescricao());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM tipoespecificidadesocial WHERE id =" + id);
        st.close();
    }
    
}
