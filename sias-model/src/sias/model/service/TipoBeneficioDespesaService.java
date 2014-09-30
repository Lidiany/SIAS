package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseTipoBeneficioDespesaService;
import sias.model.dao.TipoBeneficioDespesaDAO;
import sias.model.pojo.TipoBeneficioDespesa;

public class TipoBeneficioDespesaService implements BaseTipoBeneficioDespesaService {

    @Override
    public void create(TipoBeneficioDespesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoBeneficioDespesaDAO dao = new TipoBeneficioDespesaDAO();
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
    public TipoBeneficioDespesa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        TipoBeneficioDespesa tipoBeneficioDespesa = null;
        try {
            TipoBeneficioDespesaDAO dao = new TipoBeneficioDespesaDAO();
            tipoBeneficioDespesa = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return tipoBeneficioDespesa;
    }

    @Override
    public List<TipoBeneficioDespesa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<TipoBeneficioDespesa> lista = null;
        try {
            TipoBeneficioDespesaDAO dao = new TipoBeneficioDespesaDAO();
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
    public void update(TipoBeneficioDespesa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoBeneficioDespesaDAO dao = new TipoBeneficioDespesaDAO();
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
            TipoBeneficioDespesaDAO dao = new TipoBeneficioDespesaDAO();
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
        Map<String, String> errors = new HashMap<String, String>();
        if (properties != null) {
            String descricao = (String) properties.get("descricao");
            if (descricao == null || descricao.isEmpty()) {
                errors.put("descricao", "*");
            }
            String tipo = (String) properties.get("tipo");
            if (tipo == null || tipo.isEmpty()) {
                errors.put("tipo", "*");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

}
