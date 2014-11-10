package sias.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sias.model.ConnectionManager;
import sias.model.base.service.BasePessoaService;
import sias.model.dao.PessoaDAO;
import sias.model.pojo.Pessoa;

public class PessoaService implements BasePessoaService {

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
            conn.close();
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
            conn.close();
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
            PessoaDAO dao = new PessoaDAO();
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
            /*String dataInclusao = (String) properties.get("datainclusao");
             if (dataInclusao == null || dataInclusao.isEmpty()) {
             errors.put("datainclusao", "*");
             }*/

            /*  String numeroOrdem = (String) properties.get("numeroordem");
             if (numeroOrdem == null || numeroOrdem.isEmpty()) {
             errors.put("numeroordem", "*");
             }

             String nome = (String) properties.get("nome");
             if (nome == null || nome.isEmpty()) {
             errors.put("nome", "*");
             }

             String nomeMae = (String) properties.get("nomemae");
             if (nomeMae == null || nomeMae.isEmpty()) {
             errors.put("nomemae", "*");
             }

             String nomePai = (String) properties.get("nomepai");
             if (nomePai == null || nomePai.isEmpty()) {
             errors.put("nomepai", "*");
             }

             String nis = (String) properties.get("nis");
             if (nis == null || nis.isEmpty()) {
             errors.put("nis", "*");
             }*/

            /*            String cpf = (String) properties.get("cpf");
             if (cpf == null || cpf.isEmpty()) {
             errors.put("cpf", "*");
             }else{
             if (!ValidaCPF.isCPF(cpf)) {
             errors.put("cpf", "CPF Inválido!");
             }
             }*/
            /*
             String numeroRg = (String) properties.get("numerorg");
             if (numeroRg == null || numeroRg.isEmpty()) {
             errors.put("numerorg", "*");
             }

             String orgaoExpedidor = (String) properties.get("orgaoexpedidor");
             if (orgaoExpedidor == null || orgaoExpedidor.isEmpty()) {
             errors.put("orgaoexpedidor", "*");
             }

             String dataEmissaoRg = (String) properties.get("dataemissaorg");
             if (dataEmissaoRg == null || dataEmissaoRg.isEmpty()) {
             errors.put("dataemissaorg", "*");
             }

             String ufRg = (String) properties.get("ufrg");
             if (ufRg == null || ufRg.isEmpty()) {
             errors.put("ufrg", "*");
             }

             String numeroCtps = (String) properties.get("numeroctps");
             if (numeroCtps == null || numeroCtps.isEmpty()) {
             errors.put("numeroctps", "*");
             }

             String serie = (String) properties.get("serie");
             if (serie == null || serie.isEmpty()) {
             errors.put("serie", "*");
             }

             String dataEmissaoCtps = (String) properties.get("dataemissaoctps");
             if (dataEmissaoCtps == null || dataEmissaoCtps.isEmpty()) {
             errors.put("dataemissaoctps", "*");
             }

             String ufCtps = (String) properties.get("ufctps");
             if (ufCtps == null || ufCtps.isEmpty()) {
             errors.put("ufctps", "*");
             }

             String numeroTituloEleitoral = (String) properties.get("numerotituloeleitoral");
             if (numeroTituloEleitoral == null || numeroTituloEleitoral.isEmpty()) {
             errors.put("numerotituloeleitoral", "*");
             }

             String zona = (String) properties.get("zona");
             if (zona == null || zona.isEmpty()) {
             errors.put("zona", "*");
             }

             String secao = (String) properties.get("secao");
             if (secao == null || secao.isEmpty()) {
             errors.put("secao", "*");
             }

             String cartorioCertidao = (String) properties.get("cartoriocertidao");
             if (cartorioCertidao == null || cartorioCertidao.isEmpty()) {
             errors.put("cartoriocertidao", "*");
             }

             String numeroTermo = (String) properties.get("numerotermo");
             if (numeroTermo == null || numeroTermo.isEmpty()) {
             errors.put("numerotermo", "*");
             }

             String livro = (String) properties.get("livro");
             if (livro == null || livro.isEmpty()) {
             errors.put("livro", "*");
             }

             String folha = (String) properties.get("folha");
             if (folha == null || folha.isEmpty()) {
             errors.put("folha", "*");
             }

             String dataEmissaoCn = (String) properties.get("dataemissaocn");
             if (dataEmissaoCn == null || dataEmissaoCn.isEmpty()) {
             errors.put("dataemissaocn", "*");
             }

             String ufCn = (String) properties.get("ufcn");
             if (ufCn == null || ufCn.isEmpty()) {
             errors.put("ufcn", "*");
             }

             String tipoCertidao = (String) properties.get("tipocertidao");
             if (tipoCertidao == null || tipoCertidao.isEmpty()) {
             errors.put("tipocertidao", "*");
             }

             String dataNascimento = (String) properties.get("datanascimento");
             if (dataNascimento == null || dataNascimento.isEmpty()) {
             errors.put("datanascimento", "*");
             }

             String nacionalidade = (String) properties.get("nacionalidade");
             if (nacionalidade == null || nacionalidade.isEmpty()) {
             errors.put("nacionalidade", "*");
             }

             String ufNacionalidade = (String) properties.get("ufnacionalidade");
             if (ufNacionalidade == null || ufNacionalidade.isEmpty()) {
             errors.put("ufnacionalidade", "*");
             }

             String municipioNacionalidade = (String) properties.get("municipionacionalidade");
             if (municipioNacionalidade == null || municipioNacionalidade.isEmpty()) {
             errors.put("municipionacionalidade", "*");
             }

             String sexo = (String) properties.get("sexo");
             if (sexo == null || sexo.isEmpty()) {
             errors.put("sexo", "*");
             }

             String raca = (String) properties.get("raca");
             if (raca == null || raca.isEmpty()) {
             errors.put("raca", "*");
             }

             String estadoCivil = (String) properties.get("estadocivil");
             if (estadoCivil == null || estadoCivil.isEmpty()) {
             errors.put("estadocivil", "*");
             }

             String telefone = (String) properties.get("telefone");
             if (telefone == null || telefone.isEmpty()) {
             errors.put("telefone", "*");
             }

             String frequenciaEscolar = (String) properties.get("frequenciaescolar");
             if (frequenciaEscolar == null || frequenciaEscolar.isEmpty()) {
             errors.put("frequenciaescolar", "*");
             }

             String lerEscrever = (String) properties.get("lerescrever");
             if (lerEscrever == null || lerEscrever.isEmpty()) {
             errors.put("lerescrever", "*");
             }

             String qualificacaoProfissional = (String) properties.get("qualificacaoprofissional");
             if (qualificacaoProfissional == null || qualificacaoProfissional.isEmpty()) {
             errors.put("qualificacaoprofissional", "*");
             }

             String renda = (String) properties.get("renda");
             if (renda == null || renda.isEmpty()) {
             errors.put("renda", "*");
             }

             String dataRenda = (String) properties.get("datarenda");
             if (dataRenda == null || dataRenda.isEmpty()) {
             errors.put("datarenda", "*");
             }

             String aposentadoPensionista = (String) properties.get("aposentadopensionista");
             if (aposentadoPensionista == null || aposentadoPensionista.isEmpty()) {
             errors.put("aposentadopensionista", "*");
             }

             String areaRisco = (String) properties.get("arearisco");
             if (areaRisco == null || areaRisco.isEmpty()) {
             errors.put("arearisco", "*");
             }

             String tipoResidencia = (String) properties.get("tiporesidencia");
             if (tipoResidencia == null || tipoResidencia.isEmpty()) {
             errors.put("tiporesidencia", "*");
             }

             String complementoImovel = (String) properties.get("complementoimovel");
             if (complementoImovel == null || complementoImovel.isEmpty()) {
             errors.put("complementoimovel", "*");
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

             String pontoReferencia = (String) properties.get("pontoreferencia");
             if (pontoReferencia == null || pontoReferencia.isEmpty()) {
             errors.put("pontoreferencia", "*");
             }

             String localizacao = (String) properties.get("localizacao");
             if (localizacao == null || localizacao.isEmpty()) {
             errors.put("localizacao", "*");
             }

             String tipoLogradouro = (String) properties.get("tipologradouro");
             if (tipoLogradouro == null || tipoLogradouro.isEmpty()) {
             errors.put("tipologradouro", "*");
             }

             String dataDesligamento = (String) properties.get("datadesligamento");
             if (dataDesligamento == null || dataDesligamento.isEmpty()) {
             errors.put("datadesligamento", "*");
             }

             String motivoDesligamento = (String) properties.get("motivodesligamento");
             if (motivoDesligamento == null || motivoDesligamento.isEmpty()) {
             errors.put("motivodesligamento", "*");
             }

             String complementoPessoa = (String) properties.get("complementopessoa");
             if (complementoPessoa == null || complementoPessoa.isEmpty()) {
             errors.put("complementopessoa", "*");
             }

             String complementoHabitacional = (String) properties.get("complementohabitacional");
             if (complementoHabitacional == null || complementoHabitacional.isEmpty()) {
             errors.put("complementohabitacional", "*");
             }

             String dataAtualizacaoCadastro = (String) properties.get("dataatualizacaocadastro");
             if (dataAtualizacaoCadastro == null || dataAtualizacaoCadastro.isEmpty()) {
             errors.put("dataatualizacaocadastro", "*");
             }

             String dataAtualizacaoEndereco = (String) properties.get("dataatualizacaoendereco");
             if (dataAtualizacaoEndereco == null || dataAtualizacaoEndereco.isEmpty()) {
             errors.put("dataatualizacaoendereco", "*");
             }

             String dataAtualizacaoHabitacional = (String) properties.get("dataatualizacaohabitacional");
             if (dataAtualizacaoHabitacional == null || dataAtualizacaoHabitacional.isEmpty()) {
             errors.put("dataatualizacaohabitacional", "*");
             }

             String formaIngresso = (String) properties.get("formaingresso");
             if (formaIngresso == null || formaIngresso.isEmpty()) {
             errors.put("formaingresso", "*");
             }

             String tipoEscolaridade = (String) properties.get("tipoescolaridade");
             if (tipoEscolaridade == null || tipoEscolaridade.isEmpty()) {
             errors.put("tipoescolaridade", "*");
             }

             String tipoOcupacao = (String) properties.get("tipoocupacao");
             if (tipoOcupacao == null || tipoOcupacao.isEmpty()) {
             errors.put("tipoocupacao", "*");
             }

             String uf = (String) properties.get("uf");
             if (uf == null || uf.isEmpty()) {
             errors.put("uf", "*");
             }

             String municipio = (String) properties.get("municipio");
             if (municipio == null || municipio.isEmpty()) {
             errors.put("municipio", "*");
             }

             String tipoParentesco = (String) properties.get("tipoparentesco");
             if (tipoParentesco == null || tipoParentesco.isEmpty()) {
             errors.put("tipoparentesco", "*");
             }

             String tipoEspecificidadeSocial = (String) properties.get("tipoespecificidadesocial");
             if (tipoEspecificidadeSocial == null || tipoEspecificidadeSocial.isEmpty()) {
             errors.put("tipoespecificidadesocial", "*");
             }

             String tipoDeficiencia = (String) properties.get("tipodeficiencia");
             if (tipoDeficiencia == null || tipoDeficiencia.isEmpty()) {
             errors.put("tipodeficiencia", "*");
             }
            
             String tipoBeneficioDespesa = (String) properties.get("tipobeneficiodespesa");
             if (tipoBeneficioDespesa == null || tipoBeneficioDespesa.isEmpty()) {
             errors.put("tipobeneficiodespesa", "*");
             }
            
             String pessoa = (String) properties.get("pessoa");
             if (pessoa == null || pessoa.isEmpty()) {
             errors.put("pessoa", "*");
             }*/
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForUpdate(Map<String, Object> properties) throws Exception {
        return this.validateForCreate(properties);
    }

}
