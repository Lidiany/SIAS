package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseTipoDeficienciaService;
import sias.model.dao.TipoDeficienciaDAO;
import sias.model.pojo.TipoDeficiencia;

public class TipoDeficienciaService implements BaseTipoDeficienciaService {

    @Override
    public void create(TipoDeficiencia pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoDeficienciaDAO dao = new TipoDeficienciaDAO();
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
    public TipoDeficiencia readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        TipoDeficiencia tipoDeficiencia = null;
        try {
            TipoDeficienciaDAO dao = new TipoDeficienciaDAO();
            tipoDeficiencia = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return tipoDeficiencia;
    }

    @Override
    public List<TipoDeficiencia> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<TipoDeficiencia> lista = null;
        try {
            TipoDeficienciaDAO dao = new TipoDeficienciaDAO();
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
    public void update(TipoDeficiencia pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoDeficienciaDAO dao = new TipoDeficienciaDAO();
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
            TipoDeficienciaDAO dao = new TipoDeficienciaDAO();
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
