package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseFormaIngressoService;
import sias.model.dao.FormaIngressoDAO;
import sias.model.pojo.FormaIngresso;

public class FormaIngressoService implements BaseFormaIngressoService{

    @Override
    public void create(FormaIngresso pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            FormaIngressoDAO dao = new FormaIngressoDAO();
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
    public FormaIngresso readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        FormaIngresso formaIngresso = null;
        try {
            FormaIngressoDAO dao = new FormaIngressoDAO();
            formaIngresso = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return formaIngresso;
    }

    @Override
    public List<FormaIngresso> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<FormaIngresso> lista = null;
        try {
            FormaIngressoDAO dao = new FormaIngressoDAO();
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
    public void update(FormaIngresso pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            FormaIngressoDAO dao = new FormaIngressoDAO();
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
            FormaIngressoDAO dao = new FormaIngressoDAO();
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
                errors.put("descricao", "Campo obrigatório!");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
    
}
