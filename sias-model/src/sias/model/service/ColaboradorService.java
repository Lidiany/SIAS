package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseColaboradorService;
import sias.model.dao.ColaboradorDAO;
import sias.model.pojo.Colaborador;

public class ColaboradorService implements BaseColaboradorService {

    @Override
    public void create(Colaborador pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ColaboradorDAO dao = new ColaboradorDAO();
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
    public Colaborador readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Colaborador colaborador = null;
        try {
            ColaboradorDAO dao = new ColaboradorDAO();
            colaborador = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return colaborador;
    }

    @Override
    public List<Colaborador> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Colaborador> lista = null;
        try {
            ColaboradorDAO dao = new ColaboradorDAO();
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
    public void update(Colaborador pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ColaboradorDAO dao = new ColaboradorDAO();
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
            ColaboradorDAO dao = new ColaboradorDAO();
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
