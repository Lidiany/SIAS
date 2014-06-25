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
import sias.model.pojo.Uf;

public class MunicipioDAO implements BaseDAO<Municipio> {

    public static final String CRITERION_NOME_I_LIKE = "1";
    public static final String CRITERION_UF_ID_EQ = "2";

    @Override
    public void create(Municipio e, Connection conn) throws Exception {
        String sql = "INSERT INTO municipio (nome, uf_fk) VALUES (?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareCall(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        if (e.getUf() != null) {
            ps.setLong(++i, e.getUf().getId());
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
    public Municipio readById(Long id, Connection conn) throws Exception {
        Municipio e = null;
        String sql = "SELECT municipio.*, uf.id as uf_id, uf.nome as uf_nome FROM municipio LEFT JOIN uf ON municipio.uf_fk = uf.id WHERE municipio.id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new Municipio();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));

            Uf uf = new Uf();
            uf.setId(rs.getLong("uf_id"));
            uf.setNome(rs.getString("uf_nome"));
            e.setUf(uf);
        }
/*        PrintWriter out = new PrintWriter("C:\\Temp\\teste.txt");
        out.println(ps.toString());
        out.close();*/
        
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<Municipio> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Municipio> lista = new ArrayList<Municipio>();
        String sql = "SELECT municipio.*, uf.id as uf_id, uf.nome as uf_nome FROM municipio LEFT JOIN uf ON municipio.uf_fk = uf.id WHERE 1=1";

        String criterionNomeILike = (String) criteria.get(CRITERION_NOME_I_LIKE);
        if (criterionNomeILike != null && !criterionNomeILike.trim().isEmpty()) {
            sql += " AND municipio.nome ILIKE '%" + criterionNomeILike + "%'";
        }

        Long criterionUfIdEq = (Long) criteria.get(CRITERION_UF_ID_EQ);
        if (criterionUfIdEq != null && criterionUfIdEq > 0) {
            sql += " AND uf_fk ='" + criterionUfIdEq + "'";
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            Municipio municipio = new Municipio();
            municipio.setId(rs.getLong("id"));
            municipio.setNome(rs.getString("nome"));

            Uf uf = new Uf();
            uf.setId(rs.getLong("uf_id"));
            uf.setNome(rs.getString("uf_nome"));
            municipio.setUf(uf);

            lista.add(municipio);
        }
        
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(Municipio e, Connection conn) throws Exception {
        String sql = "UPDATE municipio SET nome=?, uf_fk=? WHERE municipio.id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getNome());
        if (e.getUf() != null) {
            ps.setLong(++i, e.getUf().getId());
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
        st.execute("DELETE FROM municipio WHERE id =" + id);
        st.close();
    }

}
