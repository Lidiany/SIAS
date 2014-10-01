package sias.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseBeneficioDespesaService;
import sias.model.dao.BeneficioDespesaDAO;
import sias.model.pojo.BeneficioDespesa;

public class BeneficioDespesaService implements BaseBeneficioDespesaService {

    @Override
    public void create(BeneficioDespesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            BeneficioDespesaDAO dao = new BeneficioDespesaDAO();
            dao.create(pojo, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public BeneficioDespesa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        BeneficioDespesa beneficioDespesa = null;
        try {
            BeneficioDespesaDAO dao = new BeneficioDespesaDAO();
            beneficioDespesa = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return beneficioDespesa;
    }

    @Override
    public List<BeneficioDespesa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<BeneficioDespesa> lista = null;
        try {
            BeneficioDespesaDAO dao = new BeneficioDespesaDAO();
            lista = dao.readByCriteria(criteria, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return lista;
    }

    @Override
    public void update(BeneficioDespesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            BeneficioDespesaDAO dao = new BeneficioDespesaDAO();
            dao.update(pojo, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            BeneficioDespesaDAO dao = new BeneficioDespesaDAO();
            dao.delete(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public Map<String, String> validateForCreate(Map<String, Object> properties) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

}
