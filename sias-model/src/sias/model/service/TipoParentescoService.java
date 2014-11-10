package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseTipoParentescoService;
import sias.model.dao.TipoParentescoDAO;
import sias.model.pojo.TipoParentesco;

public class TipoParentescoService implements BaseTipoParentescoService {

    @Override
    public void create(TipoParentesco pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoParentescoDAO dao = new TipoParentescoDAO();
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
    public TipoParentesco readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        TipoParentesco tipoParentesco = null;
        try {
            TipoParentescoDAO dao = new TipoParentescoDAO();
            tipoParentesco = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return tipoParentesco;
    }

    @Override
    public List<TipoParentesco> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<TipoParentesco> lista = null;
        try {
            TipoParentescoDAO dao = new TipoParentescoDAO();
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
    public void update(TipoParentesco pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoParentescoDAO dao = new TipoParentescoDAO();
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
            TipoParentescoDAO dao = new TipoParentescoDAO();
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
            String codigo = (String) properties.get("codigo");
            if (codigo == null || codigo.isEmpty()) {
                errors.put("codigo", "*");
            }
            String descricao = (String) properties.get("descricao");
            if (descricao == null || descricao.isEmpty()) {
                errors.put("descricao", "*");
            }
            String ativo = (String) properties.get("ativo");
            if (ativo == null || ativo.isEmpty()) {
                errors.put("ativo", "*");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

}
