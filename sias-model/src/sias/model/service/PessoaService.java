package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BasePessoaService;
import sias.model.dao.PessoaDAO;
import sias.model.pojo.Pessoa;

public class PessoaService implements BasePessoaService{

    @Override
    public void create(Pessoa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            PessoaDAO dao = new PessoaDAO();
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
    public Pessoa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Pessoa pessoa = null;
        try {
            PessoaDAO dao = new PessoaDAO();
            pessoa = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return pessoa;
    }

    @Override
    public List<Pessoa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Pessoa> lista = null;
        try {
            PessoaDAO dao = new PessoaDAO();
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
    public void update(Pessoa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            PessoaDAO dao = new PessoaDAO();
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
            PessoaDAO dao = new PessoaDAO();
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
