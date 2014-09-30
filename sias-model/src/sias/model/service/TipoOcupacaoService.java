package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BaseTipoOcupacaoService;
import sias.model.dao.TipoOcupacaoDAO;
import sias.model.pojo.TipoOcupacao;

public class TipoOcupacaoService implements BaseTipoOcupacaoService {

    @Override
    public void create(TipoOcupacao pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoOcupacaoDAO dao = new TipoOcupacaoDAO();
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
    public TipoOcupacao readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        TipoOcupacao tipoOcupacao = null;
        try {
            TipoOcupacaoDAO dao = new TipoOcupacaoDAO();
            tipoOcupacao = dao.readById(id, conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
        return tipoOcupacao;
    }

    @Override
    public List<TipoOcupacao> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<TipoOcupacao> lista = null;
        try {
            TipoOcupacaoDAO dao = new TipoOcupacaoDAO();
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
    public void update(TipoOcupacao pojo) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TipoOcupacaoDAO dao = new TipoOcupacaoDAO();
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
            TipoOcupacaoDAO dao = new TipoOcupacaoDAO();
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
