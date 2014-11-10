package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseUfService;
import sias.model.dao.UfDAO;
import sias.model.pojo.Uf;

public class UfService implements BaseUfService {

    @Override
    public void create(Uf pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UfDAO dao = new UfDAO();
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
    public Uf readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Uf uf = null;
        try {
            UfDAO dao = new UfDAO();
            uf = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return uf;
    }

    @Override
    public List<Uf> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Uf> lista = null;
        try {
            UfDAO dao = new UfDAO();
            lista = dao.readByCriteria(criteria, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return lista;
    }

    @Override
    public void update(Uf pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UfDAO dao = new UfDAO();
            dao.update(pojo, conn);
            conn.commit();
            conn.close();
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
            UfDAO dao = new UfDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
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
            String nome = (String) properties.get("nome");
            if (nome == null || nome.isEmpty()) {
                errors.put("nome", "*");
            }
            String sigla = (String) properties.get("sigla");
            if (sigla == null || sigla.isEmpty()) {
                errors.put("sigla", "*");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

}
