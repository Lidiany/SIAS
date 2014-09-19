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
        Map<String, String> error = new HashMap<String, String>();
        if (properties != null) {
            String nome = (String) properties.get("nome");
            if (nome == null || nome.isEmpty()) {
                error.put("nome", "*");
            }
           /* String cpf = (String) properties.get("cpf");
            if (cpf == null || cpf.isEmpty()) {
                error.put("cpf", "*");
            }
            String numeroRg = (String) properties.get("numeroRg");
            if (numeroRg == null || numeroRg.isEmpty()) {
                error.put("numerorg", "*");
            }
            String orgaoExpedidor = (String) properties.get("orgaoExpedidor");
            if (orgaoExpedidor == null || orgaoExpedidor.isEmpty()) {
                error.put("orgaoexpedidor", "*");
            }

            String dataNascimento = (String) properties.get("dataNascimento");
            if (dataNascimento != null || dataNascimento.isEmpty()) {
                error.put("datanascimento", "*");
            }
*/
            /*   Date dataEmissao = (Date) properties.get("dataemissao");
             if (dataEmissao == null || dataEmissao.equals(dataEmissao)) {
             error.put("dataemissao", "*");
             }*/
/*            String ufEmissao = (String) properties.get("ufemissao");
            if (ufEmissao == null || ufEmissao.isEmpty()) {
                error.put("ufemissao", "*");
            }

            String cargo = (String) properties.get("cargo");
            if (cargo == null || cargo.isEmpty()) {
                error.put("cargo", "*");
            }
            String funcao = (String) properties.get("funcao");
            if (funcao == null || funcao.isEmpty()) {
                error.put("funcao", "*");
            }
            String telefone = (String) properties.get("telefone");
            if (telefone == null || telefone.isEmpty()) {
                error.put("telefone", "*");
            }
            String logradouro = (String) properties.get("logradouro");
            if (logradouro == null || logradouro.isEmpty()) {
                error.put("logradouro", "*");
            }
            String numero = (String) properties.get("numero");
            if (numero == null || numero.isEmpty()) {
                error.put("numero", "*");
            }
            String complementoEndereco = (String) properties.get("complementoEndereco");
            if (complementoEndereco == null || complementoEndereco.isEmpty()) {
                error.put("complementoendereco", "*");
            }
            String bairro = (String) properties.get("bairro");
            if (bairro == null || bairro.isEmpty()) {
                error.put("bairro", "*");
            }
            String cep = (String) properties.get("cep");
            if (cep == null || cep.isEmpty()) {
                error.put("cep", "*");
            }

            String municipio = (String) properties.get("municipio");
            if (municipio == null || municipio.isEmpty()) {
                error.put("municipio", "*");
            }
            
            String uf = (String) properties.get("uf");
            if (uf == null || uf.isEmpty()) {
                error.put("uf", "*");
            }
            
            String unidadeAtendimento = (String) properties.get("unidadeatendimento");
            if (unidadeAtendimento == null || unidadeAtendimento.isEmpty()) {
                error.put("unidadeatendimento", "*");
            }*/

        }
        return error;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

}
