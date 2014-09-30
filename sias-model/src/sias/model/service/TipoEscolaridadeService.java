package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseTipoEscolaridadeService;
import sias.model.dao.TipoEscolaridadeDAO;
import sias.model.pojo.TipoEscolaridade;

public class TipoEscolaridadeService implements BaseTipoEscolaridadeService {

    @Override
    public void create(TipoEscolaridade pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoEscolaridadeDAO dao = new TipoEscolaridadeDAO();
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
    public TipoEscolaridade readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        TipoEscolaridade tipoEscolaridade = null;
        try {
            TipoEscolaridadeDAO dao = new TipoEscolaridadeDAO();
            tipoEscolaridade = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return tipoEscolaridade;
    }

    @Override
    public List<TipoEscolaridade> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<TipoEscolaridade> lista = null;
        try {
            TipoEscolaridadeDAO dao = new TipoEscolaridadeDAO();
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
    public void update(TipoEscolaridade pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoEscolaridadeDAO dao = new TipoEscolaridadeDAO();
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
            TipoEscolaridadeDAO dao = new TipoEscolaridadeDAO();
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
