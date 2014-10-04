package sias.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.BeneficioDespesa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoBeneficioDespesa;

public class BeneficioDespesaDAO implements BaseDAO<BeneficioDespesa> {

    @Override
    public void create(BeneficioDespesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO beneficiodespesa(datainicio, datatermino, valor, dataatualizacao) VALUES (?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setDate(++i, new Date(e.getDataInicio().getTime()));
        ps.setDate(++i, new Date(e.getDataTermino().getTime()));
        ps.setFloat(++i, e.getValor());
        ps.setDate(++i, new Date(e.getDataAtualizacao().getTime()));
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }

        rs.close();
        ps.close();

        List<Pessoa> pessoas = e.getPessoas();
        if (pessoas != null && pessoas.size() > 0) {
            String sqlBeneficioDespesaPessoa = "INSERT INTO beneficiodespesa_pessoa (beneficiodespesa_fk, pessoa_fk) VALUES (?, ?);";
            PreparedStatement psBeneficioDespesaPessoa = conn.prepareStatement(sqlBeneficioDespesaPessoa);
            for (Pessoa pessoa : pessoas) {
                psBeneficioDespesaPessoa.setLong(1, e.getId());
                psBeneficioDespesaPessoa.setLong(2, pessoa.getId());
                psBeneficioDespesaPessoa.execute();
            }
            psBeneficioDespesaPessoa.close();
        }

        List<TipoBeneficioDespesa> tipoBeneficioDespesas = e.getTipoBeneficioDespesas();
        if (tipoBeneficioDespesas != null && tipoBeneficioDespesas.size() > 0) {
            String sqlBeneficioDespesaTipoBeneficioDespesa = "INSERT INTO beneficiodespesa_tipobeneficiodespesa (beneficiodespesa_fk, tipobeneficiodespesa_fk) VALUES (?, ?);";
            PreparedStatement psBeneficioDespesaTipoBeneficioDespesa = conn.prepareStatement(sqlBeneficioDespesaTipoBeneficioDespesa);
            for (TipoBeneficioDespesa tipoBeneficioDespesa : tipoBeneficioDespesas) {
                psBeneficioDespesaTipoBeneficioDespesa.setLong(1, e.getId());
                psBeneficioDespesaTipoBeneficioDespesa.setLong(2, tipoBeneficioDespesa.getId());
                psBeneficioDespesaTipoBeneficioDespesa.close();
            }
        }
    }

    @Override
    public BeneficioDespesa readById(Long id, Connection conn) throws Exception {
        BeneficioDespesa e = null;
        String sql = "SELECT beneficiodespesa.*, pessoa.id as pessoa_id, pessoa.nome as pessoa_nome, tipobeneficiodespesa.id as tipobeneficiodespesa_id, tipobeneficiodespesa.descricao as tipobeneficiodespesa_descricao, tipobeneficiodespesa.tipo as tipobeneficiodespesa_tipo FROM beneficiodespesa LEFT JOIN pessoa ON beneficiodespesa.pessoa_fk = pessoa.id LEFT JOIN tipobeneficiodespesa ON beneficiodespesa.tipobeneficiodespesa_fk = tipobeneficiodespesa.id WHERE beneficiodespesa.id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (e == null) {
                e = new BeneficioDespesa();
                e.setId(rs.getLong("id"));
                e.setDataInicio(rs.getDate("datainicio"));
                e.setDataTermino(rs.getDate("datatermino"));
                e.setValor(rs.getFloat("valor"));
                e.setDataAtualizacao(rs.getDate("dataatualizacao"));
            }

            Long pessoa_id = rs.getLong("pessoa_id");
            if (pessoa_id > 0) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(pessoa_id);
                pessoa.setNome(rs.getString("pessoa_nome"));
                e.getPessoas().add(pessoa);
            }

            Long tipoBeneficioDespesa_id = rs.getLong("tipobeneficiodespesa_id");
            if (tipoBeneficioDespesa_id > 0) {
                TipoBeneficioDespesa tipoBeneficioDespesa = new TipoBeneficioDespesa();
                tipoBeneficioDespesa.setId(tipoBeneficioDespesa_id);
                tipoBeneficioDespesa.setDescricao(rs.getString("tipoBeneficioDespesa_descricao"));
                tipoBeneficioDespesa.setTipo(rs.getString("tipoBeneficioDespesa_tipo"));
                e.getTipoBeneficioDespesas().add(tipoBeneficioDespesa);
            }

        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<BeneficioDespesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<BeneficioDespesa> lista = new ArrayList<BeneficioDespesa>();
        String sql = "SELECT * FROM beneficiodespesa WHERE 1=1";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            BeneficioDespesa beneficioDespesa = new BeneficioDespesa();
            beneficioDespesa.setId(rs.getLong("id"));
            beneficioDespesa.setDataInicio(rs.getDate("datainicio"));
            beneficioDespesa.setDataTermino(rs.getDate("datatermino"));
            beneficioDespesa.setValor(rs.getFloat("valor"));
            beneficioDespesa.setDataAtualizacao(rs.getDate("dataatualizacao"));
            lista.add(beneficioDespesa);
        }
        rs.close();
        st.close();
        return lista;
    }

    @Override
    public void update(BeneficioDespesa e, Connection conn) throws Exception {
        String sql = "UPDATE beneficiodespesa SET datainicio=?, datatermino=?, valor=?, dataatualizacao=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setDate(++i, new Date(e.getDataInicio().getTime()));
        ps.setDate(++i, new Date(e.getDataTermino().getTime()));
        ps.setFloat(++i, e.getValor());
        ps.setDate(++i, new Date(e.getDataAtualizacao().getTime()));
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();

        String sqlBeneficioDespesaPessoa = "DELETE FROM beneficiodespesa_pessoa WHERE beneficiodespesa_fk='" + e.getId() + "';";
        Statement st = conn.createStatement();
        st.execute(sqlBeneficioDespesaPessoa);
        st.close();

        List<Pessoa> pessoas = e.getPessoas();
        if (pessoas != null && pessoas.size() > 0) {
            sqlBeneficioDespesaPessoa = "INSERT INTO beneficiodespesa_pessoa (beneficiodespesa_fk, pessoa_fk) VALUES (?, ?);";
            PreparedStatement psBeneficioDespesaPessoa = conn.prepareStatement(sqlBeneficioDespesaPessoa);
            for (Pessoa pessoa : pessoas) {
                psBeneficioDespesaPessoa.setLong(1, e.getId());
                psBeneficioDespesaPessoa.setLong(2, pessoa.getId());
                psBeneficioDespesaPessoa.execute();
            }
            psBeneficioDespesaPessoa.close();
        }

        String sqlBeneficioDespesaTipoBeneficioDespesa = "DELETE FROM beneficiodespesa_tipobeneficiodespesa WHERE beneficiodespesa_fk='" + e.getId() + "';";
        st = conn.createStatement();
        st.execute(sqlBeneficioDespesaTipoBeneficioDespesa);
        st.close();

        List<TipoBeneficioDespesa> tipoBeneficioDespesas = e.getTipoBeneficioDespesas();
        if (tipoBeneficioDespesas != null && tipoBeneficioDespesas.size() > 0) {
            sqlBeneficioDespesaTipoBeneficioDespesa = "INSERT INTO beneficiodespesa_tipobeneficiodespesa (beneficiodespesa_fk, tipobeneficiodespesa_fk) VALUES (?, ?);";
            PreparedStatement psBeneficioDespesaTipoBeneficioDespesa = conn.prepareStatement(sqlBeneficioDespesaTipoBeneficioDespesa);
            for (TipoBeneficioDespesa tipoBeneficioDespesa : tipoBeneficioDespesas) {
                psBeneficioDespesaTipoBeneficioDespesa.setLong(1, e.getId());
                psBeneficioDespesaTipoBeneficioDespesa.setLong(2, tipoBeneficioDespesa.getId());
                psBeneficioDespesaTipoBeneficioDespesa.close();
            }

        }
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM beneficiodespesa WHERE id =" + id);
        st.close();
    }

}
