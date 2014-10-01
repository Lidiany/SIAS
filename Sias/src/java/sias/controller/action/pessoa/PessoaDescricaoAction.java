package sias.controller.action.pessoa;

import org.mentawai.core.BaseAction;
import sias.model.ServiceLocator;
import sias.model.pojo.Pessoa;

public class PessoaDescricaoAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        String consequence = SUCCESS;
        Long id = input.getLong("id");
        Pessoa pessoa = ServiceLocator.getPessoaService().readById(id);;
        output.setValue("id", pessoa.getId());
        output.setValue("tipoparentesco.descricao", pessoa.getTipoParentesco().getDescricao());
        output.setValue("numeroordem", pessoa.getNumeroOrdem());
        output.setValue("datainclusao", pessoa.getDataInclusao());
        output.setValue("formaingresso.descricao", pessoa.getFormaIngresso().getDescricao());
        output.setValue("nome", pessoa.getNome());
        output.setValue("nomepai", pessoa.getNomePai());
        output.setValue("nomemae", pessoa.getNomeMae());
        output.setValue("sexo", pessoa.getSexo());
        output.setValue("datanascimento", pessoa.getDataNascimento());
        output.setValue("nacionalidade", pessoa.getNacionalidade());
        output.setValue("ufnacionalidade.sigla", pessoa.getUfNacionalidade().getSigla());
        output.setValue("municipionacionalidade.nome", pessoa.getMunicipioNacionalidade().getNome());
        output.setValue("raca", pessoa.getRaca());
        output.setValue("estadocivil", pessoa.getEstadoCivil());
        output.setValue("telefone", pessoa.getTelefone());
        output.setValue("dataatualizacaocadastro", pessoa.getDataAtualizacaoCadastro());
        output.setValue("complementopessoa", pessoa.getComplementoPessoa());
        output.setValue("formaingresso.descricao", pessoa.getFormaIngresso().getDescricao());
        output.setValue("dataatualizacaocadastro", pessoa.getDataAtualizacaoCadastro());
        output.setValue("cpf", pessoa.getCpf());
        output.setValue("nis", pessoa.getNis());
        output.setValue("numerorg", pessoa.getNumeroRg());
        output.setValue("orgaoexpedidor", pessoa.getOrgaoExpedidor());
        output.setValue("dataemissaorg", pessoa.getDataEmissaoRg());
        output.setValue("ufrg.sigla", pessoa.getUfRg().getSigla());
        output.setValue("numeroctps", pessoa.getNumeroCtps());
        output.setValue("serie", pessoa.getSerie());
        output.setValue("dataemissaoctps", pessoa.getDataEmissaoCtps());
        output.setValue("ufctps.sigla", pessoa.getUfCtps().getSigla());
        output.setValue("numerotituloeleitoral", pessoa.getNumeroTituloEleitoral());
        output.setValue("zona", pessoa.getZona());
        output.setValue("secao", pessoa.getSecao());
        output.setValue("tipocertidao", pessoa.getTipoCertidao());
        output.setValue("cartoriocertidao", pessoa.getCartorioCertidao());
        output.setValue("numerotermo", pessoa.getNumeroTermo());
        output.setValue("livro", pessoa.getLivro());
        output.setValue("folha", pessoa.getFolha());
        output.setValue("dataemissaocn", pessoa.getDataEmissaoCn());
        output.setValue("ufcn.sigla", pessoa.getUfCn().getSigla());
        output.setValue("tipologradouro", pessoa.getTipoLogradouro());
        output.setValue("logradouro", pessoa.getLogradouro());
        output.setValue("numero", pessoa.getNumero());
        output.setValue("complementoendereco", pessoa.getComplementoEndereco());
        output.setValue("bairro", pessoa.getBairro());
        output.setValue("municipio.nome", pessoa.getMunicipio().getNome());
        output.setValue("uf.sigla", pessoa.getUf().getSigla());
        output.setValue("cep", pessoa.getCep());
        output.setValue("localizacao", pessoa.getLocalizacao());
        output.setValue("pontoreferencia", pessoa.getPontoReferencia());
        output.setValue("abrigo", pessoa.getAbrigo());
        output.setValue("dataatualizacaoendereco", pessoa.getDataAtualizacaoEndereco());
        output.setValue("tiporesidencia", pessoa.getTipoResidencia());
        output.setValue("complementoimovel", pessoa.getComplementoImovel());
        output.setValue("arearisco", pessoa.getAreaRisco());
        output.setValue("complementocondicaohabitacional", pessoa.getComplementoHabitacional());
        output.setValue("dataatualizacaohabitacional", pessoa.getDataAtualizacaoHabitacional());
        output.setValue("tipoespecificidadesocial.descricao", pessoa.getTipoEspecificidadeSocial().getDescricao());
        
        return consequence;
    }

}
