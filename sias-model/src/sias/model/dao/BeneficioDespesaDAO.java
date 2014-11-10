package sias.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.BeneficioDespesa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoBeneficioDespesa;

public class BeneficioDespesaDAO implements BaseDAO<BeneficioDespesa> {

    public static final String CRITERION_ID_EQ = "1";
    
    @Override
    public void create(BeneficioDespesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO beneficiodespesa(tipobeneficiodespesa_fk, pessoa_fk, datainicio, datatermino, valor, dataatualizacao) VALUES (?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        if (e.getTipoBeneficioDespesa() != null) {
            ps.setLong(++i, e.getTipoBeneficioDespesa().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

        if (e.getPessoa() != null) {
            ps.setLong(++i, e.getPessoa().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }

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

    }

    @Override
    public BeneficioDespesa readById(Long id, Connection conn) throws Exception {
        BeneficioDespesa e = null;
        String sql = "SELECT beneficiodespesa.*, pessoa.id as pessoa_id, pessoa.nome as pessoa_nome, tipobeneficiodespesa.id as tipobeneficiodespesa_id, tipobeneficiodespesa.descricao as tipobeneficiodespesa_descricao, tipobeneficiodespesa.tipo as tipobeneficiodespesa_tipo FROM beneficiodespesa LEFT JOIN pessoa ON beneficiodespesa.pessoa_fk = pessoa.id LEFT JOIN tipobeneficiodespesa ON beneficiodespesa.tipobeneficiodespesa_fk = tipobeneficiodespesa.id WHERE beneficiodespesa.id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            e = new BeneficioDespesa();
            e.setId(rs.getLong("id"));
            e.setDataInicio(rs.getDate("datainicio"));
            e.setDataTermino(rs.getDate("datatermino"));
            e.setValor(rs.getFloat("valor"));
            e.setDataAtualizacao(rs.getDate("dataatualizacao"));

            TipoBeneficioDespesa tipoBeneficioDespesa = new TipoBeneficioDespesa();
            tipoBeneficioDespesa.setId(rs.getLong("tipobeneficiodespesa_id"));
            tipoBeneficioDespesa.setDescricao(rs.getString("tipobeneficiodespesa_descricao"));
            e.setTipoBeneficioDespesa(tipoBeneficioDespesa);

            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getLong("pessoa_id"));
            pessoa.setNome(rs.getString("pessoa_nome"));
            e.setPessoa(pessoa);

        }

        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<BeneficioDespesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<BeneficioDespesa> lista = new ArrayList<BeneficioDespesa>();
        String sql = "SELECT beneficiodespesa.*, pessoa.id as pessoa_id, pessoa.nome as pessoa_nome, tipobeneficiodespesa.id as tipobeneficiodespesa_id, tipobeneficiodespesa.descricao as tipobeneficiodespesa_descricao, tipobeneficiodespesa.tipo as tipobeneficiodespesa_tipo FROM beneficiodespesa LEFT JOIN pessoa ON beneficiodespesa.pessoa_fk = pessoa.id LEFT JOIN tipobeneficiodespesa ON beneficiodespesa.tipobeneficiodespesa_fk = tipobeneficiodespesa.id WHERE 1=1";

        Long criterionIdEq = (Long) criteria.get(CRITERION_ID_EQ);
        if (criterionIdEq != null && criterionIdEq > 0) {
            sql += " AND id = '" + criterionIdEq + "'";
        }
        
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            BeneficioDespesa beneficioDespesa = new BeneficioDespesa();
            beneficioDespesa.setId(rs.getLong("id"));
            beneficioDespesa.setDataInicio(rs.getDate("datainicio"));
            beneficioDespesa.setDataTermino(rs.getDate("datatermino"));
            beneficioDespesa.setValor(rs.getFloat("valor"));
            beneficioDespesa.setDataAtualizacao(rs.getDate("dataatualizacao"));

            TipoBeneficioDespesa tipoBeneficioDespesa = new TipoBeneficioDespesa();
            tipoBeneficioDespesa.setId(rs.getLong("tipobeneficiodespesa_id"));
            tipoBeneficioDespesa.setDescricao(rs.getString("tipobeneficiodespesa_descricao"));
            beneficioDespesa.setTipoBeneficioDespesa(tipoBeneficioDespesa);

            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getLong("pessoa_id"));
            pessoa.setNome(rs.getString("pessoa_nome"));
            beneficioDespesa.setPessoa(pessoa);

            lista.add(beneficioDespesa);
        }
        rs.close();
        s.close();
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
        
        if (e.getTipoBeneficioDespesa() != null) {
            ps.setLong(++i, e.getTipoBeneficioDespesa().getId());
        } else {
            ps.setNull(++i, Types.BIGINT);
        }
        
        if (e.getPessoa() != null) {
            ps.setLong(++i, e.getPessoa().getId());
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
        st.execute("DELETE FROM beneficiodespesa WHERE id =" + id);
        st.close();
    }

}
