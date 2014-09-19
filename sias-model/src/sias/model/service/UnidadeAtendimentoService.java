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
                errors.put("nome", "*");
            }
/*            String numeroUnidade = (String) properties.get("numerounidade");
            if (numeroUnidade == null || numeroUnidade.isEmpty()) {
                errors.put("numerounidade", "*");
            }
            String resposavel = (String) properties.get("responsavel");
            if (resposavel == null || resposavel.isEmpty()) {
                errors.put("responsavel", "*");
            }
            String telefone = (String) properties.get("telefone");
            if (telefone == null || telefone.isEmpty()) {
                errors.put("telefone", "*");
            }
            String logradouro = (String) properties.get("logradouro");
            if (logradouro == null || logradouro.isEmpty()) {
                errors.put("logradouro", "*");
            }
            String numero = (String) properties.get("numero");
            if (numero == null || numero.isEmpty()) {
                errors.put("numero", "*");
            }
            String complementoEndereco = (String) properties.get("complementoendereco");
            if (complementoEndereco == null || complementoEndereco.isEmpty()) {
                errors.put("complementoendereco", "*");
            }
            String bairro = (String) properties.get("bairro");
            if (bairro == null || bairro.isEmpty()) {
                errors.put("bairro", "*");
            }
            String cep = (String) properties.get("cep");
            if (cep == null || cep.isEmpty()) {
                errors.put("cep", "*");
            }            
            String municipio = (String) properties.get("municipio");
            if (municipio == null || municipio.isEmpty()) {
                errors.put("municipio", "*");
            }
            String uf = (String) properties.get("uf");
            if (uf == null || uf.isEmpty()) {
                errors.put("uf", "*");
            }*/
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }
    
}
