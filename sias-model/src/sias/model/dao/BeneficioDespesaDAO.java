package sias.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;
import java.util.Map;
import sias.model.base.BaseDAO;
import sias.model.pojo.BeneficioDespesa;

public class BeneficioDespesaDAO implements BaseDAO<BeneficioDespesa> {

    public static final String CRITERION_TIPOBENEFICIODESPESA_LIST_IN = "1";
    public static final String CRITERION_PESSOA_LIST_IN = "2";
    
    @Override
    public void create(BeneficioDespesa e, Connection conn) throws Exception {
        String sql = "INSERT INTO beneficiodespesa(tipobeneficiodespesa_fk, pessoa_fk, datainicio, datatermino, valor, dataatualizacao) VALUES (?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BeneficioDespesa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BeneficioDespesa e, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
