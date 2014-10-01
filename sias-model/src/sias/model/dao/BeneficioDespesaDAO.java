package sias.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.BeneficioDespesa;
import sias.model.pojo.Pessoa;
import sias.model.pojo.TipoBeneficioDespesa;

public class BeneficioDespesaDAO implements BaseDAO<BeneficioDespesa> {

    @Override
    public void create(BeneficioDespesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO beneficiodespesa(tipobeneficiodespesa_fk, pessoa_fk, datainicio, datatermino, valor, dataatualizacao) VALUES (?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setDate(++i, new Date(e.getDataInicio().getTime()));
        ps.setDate(++i, new Date(e.getDataTermino().getTime()));
        ps.setFloat(++i, e.getValor());
        ps.setDate(++i, new Date(e.getDataAtualizacao().getTime()));

        ResultSet rs = ps.executeQuery();

        /*  PrintWriter out = new PrintWriter("C:\\Temp\\teste.txt");
         out.println(ps.toString());
         out.close(); */
        if (rs.next()) {
            e.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public BeneficioDespesa readById(Long id, Connection conn) throws Exception {
        BeneficioDespesa e = null;
        String sql = "";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            e = new BeneficioDespesa();
            e.setId(rs.getLong("id"));
            e.setDataInicio(rs.getDate("datainicio"));
            e.setDataTermino(rs.getDate("datatermino"));
            e.setValor(rs.getFloat("valor"));
            e.setDataAtualizacao(rs.getDate("dataatualizacao"));
            
            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getLong("pessoa_id"));
            pessoa.setNome(rs.getString("pessoa_nome"));
            e.setPessoas((List<Pessoa>) pessoa);
            
            TipoBeneficioDespesa tipoBeneficioDespesa = new TipoBeneficioDespesa();
            tipoBeneficioDespesa.setId(rs.getLong("tipoBeneficioDespesa_id"));
            tipoBeneficioDespesa.setDescricao(rs.getString("tipoBeneficioDespesa_descricao"));
            tipoBeneficioDespesa.setTipo(rs.getString("tipoBeneficioDespesa_tipo"));
            e.setTipoBeneficioDespesas((List<TipoBeneficioDespesa>) tipoBeneficioDespesa);
            
        }
        rs.close();
        ps.close();
        return e;
    }

    @Override
    public List<BeneficioDespesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BeneficioDespesa e, Connection conn) throws Exception {
        String sql = "";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setDate(++i, new Date(e.getDataInicio().getTime()));
        ps.setDate(++i, new Date(e.getDataTermino().getTime()));
        ps.setFloat(++i, e.getValor());
        ps.setDate(++i, new Date(e.getDataAtualizacao().getTime()));
        ps.setLong(++i, e.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        Statement st = conn.createStatement();
        st.execute("DELETE FROM beneficiodespesa WHERE id =" +id);;
        st.close();
    }

}
