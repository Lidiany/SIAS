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
import sias.model.pojo.DeficienciaPessoa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoDeficiencia;

public class DeficienciaPessoaDAO implements BaseDAO<DeficienciaPessoa> {

    public static final String CRITERION_ID_EQ = "1";
    
    @Override
    public void create(DeficienciaPessoa e, Connection conn) throws Exception {
        String sql = "INSERT INTO deficienciapessoa (tipodeficiencia_fk, pessoa_fk, descricao) VALUES (?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        if (e.getPessoa() != null) {
            ps.setLong(++i, e.getPessoa().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        if (e.getTipoDeficiencia() != null) {
            ps.setLong(++i, e.getTipoDeficiencia().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
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
        String sql = "SELECT deficienciapessoa.*, pessoa.id as pessoa_id, pessoa.nome as pessoa_nome, tipodeficiencia.id as tipodeficiencia_id, tipodeficiencia.descricao as tipodeficiencia_descricao FROM deficienciapessoa LEFT JOIN pessoa ON deficienciapessoa.pessoa_fk = pessoa.id LEFT JOIN tipodeficiencia ON deficienciapessoa.tipodeficiencia_fk = tipodeficiencia.id WHERE deficienciapessoa.id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new DeficienciaPessoa();
            e.setId(rs.getLong("id"));
            e.setDescricao(rs.getString("descricao"));

            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getLong("pessoa_id"));
            pessoa.setNome(rs.getString("pessoa_nome"));
            e.setPessoa(pessoa);

            TipoDeficiencia tipoDeficiencia = new TipoDeficiencia();
            tipoDeficiencia.setId(rs.getLong("tipodeficiencia_id"));
            tipoDeficiencia.setDescricao(rs.getString("tipodeficiencia_descricao"));
            e.setTipoDeficiencia(tipoDeficiencia);

        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<DeficienciaPessoa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<DeficienciaPessoa> lista = new ArrayList<DeficienciaPessoa>();
        String sql = "SELECT deficienciapessoa.*, pessoa.id as pessoa_id, pessoa.nome as pessoa_nome, tipodeficiencia.id as tipodeficiencia_id, tipodeficiencia.descricao as tipodeficiencia_descricao FROM deficienciapessoa LEFT JOIN pessoa ON deficienciapessoa.pessoa_fk = pessoa.id LEFT JOIN tipodeficiencia ON deficienciapessoa.tipodeficiencia_fk = tipodeficiencia.id WHERE 1=1";

        String criterionIdEq = (String) criteria.get(CRITERION_ID_EQ);
        if (criterionIdEq != null && !criterionIdEq.trim().isEmpty()){
            sql += " AND id = '%" + criterionIdEq + "'";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            DeficienciaPessoa deficienciaPessoa = new DeficienciaPessoa();
            deficienciaPessoa.setId(rs.getLong("id"));
            deficienciaPessoa.setDescricao(rs.getString("descricao"));

            TipoDeficiencia tipoDeficiencia = new TipoDeficiencia();
            tipoDeficiencia.setId(rs.getLong("tipodeficiencia_id"));
            tipoDeficiencia.setDescricao(rs.getString("tipodeficiencia_descricao"));
            deficienciaPessoa.setTipoDeficiencia(tipoDeficiencia);

            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getLong("pessoa_id"));
            pessoa.setNome(rs.getString("pessoa_nome"));
            deficienciaPessoa.setPessoa(pessoa);

            lista.add(deficienciaPessoa);

        }
        rs.close();
        s.close();
        return lista;
    }

    @Override
    public void update(DeficienciaPessoa e, Connection conn) throws Exception {
        String sql = "UPDATE deficienciapessoa SET descricao=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getDescricao());
        if (e.getPessoa() != null) {
            ps.setLong(++i, e.getPessoa().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        if (e.getTipoDeficiencia() != null) {
            ps.setLong(++i, e.getTipoDeficiencia().getId());
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
        st.execute("DELETE FROM deficienciapessoa WHERE id =" + id);
        st.close();
    }

}
