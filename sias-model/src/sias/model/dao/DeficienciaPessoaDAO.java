package sias.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.DeficienciaPessoa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoDeficiencia;

public class DeficienciaPessoaDAO implements BaseDAO<DeficienciaPessoa> {

    @Override
    public void create(DeficienciaPessoa e, Connection conn) throws Exception {
        String sql = "INSERT INTO deficienciapessoa (descricao) VALUES (?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getDescricao());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();

        List<Pessoa> pessoas = e.getPessoas();
        if (pessoas != null && pessoas.size() > 0) {
            String sqlDeficienciaPessoaPessoa = "INSERT INTO deficienciapessoa_pessoa (deficicenciapessoa_fk, pessoa_fk) VALUES (?, ?);";
            PreparedStatement psDeficienciaPessoaPessoa = conn.prepareStatement(sqlDeficienciaPessoaPessoa);
            for (Pessoa pessoa : pessoas) {
                psDeficienciaPessoaPessoa.setLong(1, e.getId());
                psDeficienciaPessoaPessoa.setLong(2, pessoa.getId());
                psDeficienciaPessoaPessoa.execute();
            }
            psDeficienciaPessoaPessoa.close();
        }

        List<TipoDeficiencia> tipoDeficiencias = e.getTipoDeficiencias();
        if (tipoDeficiencias != null && tipoDeficiencias.size() > 0) {
            String sqlDeficienciaPessoaTipoDeficiencia = "INSERT INTO deficienciapessoa_tipodeficiencia (deficienciapessoa_fk, tipodeficiencia_fk) VALUES (?, ?);";
            PreparedStatement psDeficienciaPessoaTipoDeficiencia = conn.prepareStatement(sqlDeficienciaPessoaTipoDeficiencia);
            for (TipoDeficiencia tipoDeficiencia : tipoDeficiencias) {
                psDeficienciaPessoaTipoDeficiencia.setLong(1, e.getId());
                psDeficienciaPessoaTipoDeficiencia.setLong(2, tipoDeficiencia.getId());
                psDeficienciaPessoaTipoDeficiencia.close();
            }
        }
    }

    @Override
    public DeficienciaPessoa readById(Long id, Connection conn) throws Exception {
        DeficienciaPessoa e = null;
        String sql = "SELECT deficienciapessoa.*, pessoa.id as pessoa_id, pessoa.nome as pessoa_nome, tipodeficiencia.id as tipodeficiencia_id, tipodeficiencia.descricao as tipodeficiencia_descricao FROM deficienciapessoa LEFT JOIN pessoa ON deficienciapessoa.pessoa_fk = pessoa.id LEFT JOIN tipodeficiencia ON deficienciapessoa.tipodeficiencia_fk = tipodeficiencia.id WHERE deficienciapessoa.id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (e == null) {
                e = new DeficienciaPessoa();
                e.setId(rs.getLong("id"));
                e.setDescricao(rs.getString("descricao"));
            }

            Long pessoa_id = rs.getLong("pessoa_id");
            if (pessoa_id > 0) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(pessoa_id);
                pessoa.setNome(rs.getString("pessoa_nome"));
                e.getPessoas().add(pessoa);
            }

            Long tipoDeficiencia_id = rs.getLong("tipodeficiencia_id");
            if (tipoDeficiencia_id > 0) {
                TipoDeficiencia tipoDeficiencia = new TipoDeficiencia();
                tipoDeficiencia.setId(tipoDeficiencia_id);
                tipoDeficiencia.setDescricao(rs.getString("tipoDeficiencia_descricao"));
                e.getTipoDeficiencias().add(tipoDeficiencia);
            }
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<DeficienciaPessoa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<DeficienciaPessoa> lista = new ArrayList<DeficienciaPessoa>();
        String sql = "SELECT * FROM deficienciapessoa WHERE 1=1";
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            DeficienciaPessoa deficienciaPessoa = new DeficienciaPessoa();
            deficienciaPessoa.setId(rs.getLong("id"));
            deficienciaPessoa.setDescricao(rs.getString("descricao"));
            lista.add(deficienciaPessoa);
            
        }
        rs.close();
        st.close();
        return lista;
    }

    @Override
    public void update(DeficienciaPessoa e, Connection conn) throws Exception {
        String sql = "UPDATE deficienciapessoa SET descricao=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, e.getDescricao());
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
        
        String sqlDeficienciaPessoaPessoa = "DELETE FROM deficienciapessoa_pessoa WHERE deficienciapessoa_fk='" + e.getId() + "';";
        Statement st = conn.createStatement();
        st.execute(sqlDeficienciaPessoaPessoa);
        st.close();

        List<Pessoa> pessoas = e.getPessoas();
        if (pessoas != null && pessoas.size() > 0) {
            sqlDeficienciaPessoaPessoa = "INSERT INTO deficienciapessoa_pessoa (deficienciapessoa_fk, pessoa_fk) VALUES (?, ?);";
            PreparedStatement psDeficienciaPessoaPessoa = conn.prepareStatement(sqlDeficienciaPessoaPessoa);
            for (Pessoa pessoa : pessoas) {
                psDeficienciaPessoaPessoa.setLong(1, e.getId());
                psDeficienciaPessoaPessoa.setLong(2, pessoa.getId());
                psDeficienciaPessoaPessoa.execute();
            }
            psDeficienciaPessoaPessoa.close();
        }
        
        String sqlDeficienciaPessoaTipoDeficiencia = "DELETE FROM deficienciapessoa_tipodeficiencia WHERE deficienciapessoa_fk'" + e.getId() + "';";
        st = conn.createStatement();
        st.execute(sqlDeficienciaPessoaTipoDeficiencia);
        st.close();
        
        List<TipoDeficiencia> tipoDeficiencias = e.getTipoDeficiencias();
        if (tipoDeficiencias != null && tipoDeficiencias.size() > 0) {
            sqlDeficienciaPessoaTipoDeficiencia = "INSERT INTO deficienciapessoa_tipodeficiencia (deficienciapessoa_fk, tipodeficiencia_fk) VALUES (?, ?);";
            PreparedStatement psDeficienciaPessoaTipoDeficiencia = conn.prepareStatement(sqlDeficienciaPessoaTipoDeficiencia);
            for (TipoDeficiencia tipoDeficiencia : tipoDeficiencias) {
                psDeficienciaPessoaTipoDeficiencia.setLong(1, e.getId());
                psDeficienciaPessoaTipoDeficiencia.setLong(2, tipoDeficiencia.getId());
                psDeficienciaPessoaTipoDeficiencia.close();
            }
        }
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM deficienciapessoa WHERE id =" + id);
        st.close();
    }

}
