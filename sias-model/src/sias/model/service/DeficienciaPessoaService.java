package sias.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseDeficienciaPessoaService;
import sias.model.dao.DeficienciaPessoaDAO;
import sias.model.pojo.DeficienciaPessoa;

public class DeficienciaPessoaService implements BaseDeficienciaPessoaService{

    @Override
    public void create(DeficienciaPessoa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DeficienciaPessoaDAO dao = new DeficienciaPessoaDAO();
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
    public DeficienciaPessoa readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        DeficienciaPessoa deficienciaPessoa = null;
        try {
            DeficienciaPessoaDAO dao = new DeficienciaPessoaDAO();
            deficienciaPessoa = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return deficienciaPessoa;
    }

    @Override
    public List<DeficienciaPessoa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<DeficienciaPessoa> lista = null;
        try {
            DeficienciaPessoaDAO dao = new DeficienciaPessoaDAO();
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
    public void update(DeficienciaPessoa pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DeficienciaPessoaDAO dao = new DeficienciaPessoaDAO();
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
            DeficienciaPessoaDAO dao = new DeficienciaPessoaDAO();
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
