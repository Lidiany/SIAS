package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseUnidadeAtendimentoService;
import sias.model.dao.UnidadeAtendimentoDAO;
import sias.model.pojo.UnidadeAtendimento;

public class UnidadeAtendimentoService implements BaseUnidadeAtendimentoService{

    @Override
    public void create(UnidadeAtendimento pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UnidadeAtendimentoDAO dao = new UnidadeAtendimentoDAO();
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
    public UnidadeAtendimento readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        UnidadeAtendimento unidadeAtendimento = null;
        try {
            UnidadeAtendimentoDAO dao = new UnidadeAtendimentoDAO();
            unidadeAtendimento = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return unidadeAtendimento;
    }

    @Override
    public List<UnidadeAtendimento> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<UnidadeAtendimento> lista = null;
        try {
            UnidadeAtendimentoDAO dao = new UnidadeAtendimentoDAO();
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
    public void update(UnidadeAtendimento pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UnidadeAtendimentoDAO dao = new UnidadeAtendimentoDAO();
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
            UnidadeAtendimentoDAO dao = new UnidadeAtendimentoDAO();
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
