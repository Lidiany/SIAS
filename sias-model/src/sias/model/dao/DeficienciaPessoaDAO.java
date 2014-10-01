package sias.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.DeficienciaPessoa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoDeficiencia;

public class DeficienciaPessoaDAO implements BaseDAO<DeficienciaPessoa>{

    @Override
    public void create(DeficienciaPessoa e, Connection conn) throws Exception {
        String sql = "";
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
    public DeficienciaPessoa readById(Long id, Connection conn) throws Exception {
        DeficienciaPessoa e = null;
        String sql = "";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            e = new DeficienciaPessoa();
            e.setId(rs.getLong("id"));
            e.setDescricao(rs.getString("descricao"));
            
            TipoDeficiencia tipoDeficiencia = new TipoDeficiencia();
            tipoDeficiencia.setId(rs.getLong("tipoDeficiencia_id"));
            tipoDeficiencia.setDescricao(rs.getString("tipoDeficiencia_descricao"));
            e.setTipoDeficiencias((List<TipoDeficiencia>) tipoDeficiencia);
            
            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getLong("pessoa_id"));
            pessoa.setNome(rs.getString("pessoa_nome"));
            e.setPessoas((List<Pessoa>) pessoa);
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<DeficienciaPessoa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(DeficienciaPessoa e, Connection conn) throws Exception {
        String sql = "";
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
        st.execute("DELETE FROM deficienciapessoa WHERE id =" + id);
        st.close();
    }
    
}
