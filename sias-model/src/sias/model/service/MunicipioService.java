package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseMunicipioService;
import sias.model.dao.MunicipioDAO;
import sias.model.pojo.Municipio;

public class MunicipioService implements BaseMunicipioService{

    @Override
    public void create(Municipio pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            MunicipioDAO dao = new MunicipioDAO();
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
    public Municipio readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Municipio municipio = null;
        try {
            MunicipioDAO dao = new MunicipioDAO();
            municipio = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return municipio;
    }

    @Override
    public List<Municipio> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Municipio> lista = null;
        try {
            MunicipioDAO dao = new MunicipioDAO();
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
    public void update(Municipio pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            MunicipioDAO dao = new MunicipioDAO();
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
            MunicipioDAO dao = new MunicipioDAO();
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
            String nome = (String) properties.get("nome");
            if (nome == null || nome.isEmpty()) {
                errors.put("nome", "Campo obrigatório!");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
    
}
