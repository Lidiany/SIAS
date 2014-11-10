package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseTipoEspecificidadeSocialService;
import sias.model.dao.TipoEspecificidadeSocialDAO;
import sias.model.pojo.TipoEspecificidadeSocial;

public class TipoEspecificidadeSocialService implements BaseTipoEspecificidadeSocialService {

    @Override
    public void create(TipoEspecificidadeSocial pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoEspecificidadeSocialDAO dao = new TipoEspecificidadeSocialDAO();
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
    public TipoEspecificidadeSocial readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        TipoEspecificidadeSocial tipoEspecificidadeSocial = null;
        try {
            TipoEspecificidadeSocialDAO dao = new TipoEspecificidadeSocialDAO();
            tipoEspecificidadeSocial = dao.readById(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return tipoEspecificidadeSocial;
    }

    @Override
    public List<TipoEspecificidadeSocial> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<TipoEspecificidadeSocial> lista = null;
        try {
            TipoEspecificidadeSocialDAO dao = new TipoEspecificidadeSocialDAO();
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
    public void update(TipoEspecificidadeSocial pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoEspecificidadeSocialDAO dao = new TipoEspecificidadeSocialDAO();
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
            TipoEspecificidadeSocialDAO dao = new TipoEspecificidadeSocialDAO();
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
            String descricao = (String) properties.get("descricao");
            if (descricao == null || descricao.isEmpty()) {
                errors.put("descricao", "*");
            }
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

}
