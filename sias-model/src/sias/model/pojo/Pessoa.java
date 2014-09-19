package sias.model.pojo;

import java.sql.Date;
import sias.model.base.BasePOJO;

public class Pessoa extends BasePOJO {

    private Date dataInclusao;
    private Integer numeroOrdem;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String nis;
    private String cpf;
    private String numeroRg;
    private String orgaoExpedidor;
    private Date dataEmissaoRg;
    private Uf ufRg;
    private String numeroCtps;
    private String serie;
    private Date dataEmissaoCtps;
    private Uf ufCtps;
    private String numeroTituloEleitoral;
    private String zona;
    private String secao;
    private String cartorioCertidao;
    private String numeroTermo;
    private String livro;
    private String folha;
    private Date dataEmissaoCn;
    private Uf ufCn;
    private String tipoCertidao;
    private Date dataNascimento;
    private String nacionalidade;
    private Uf ufNacionalidade;
    private Municipio municipioNacionalidade;
    private Integer idade;
    private String classificacaoetaria;
    private String sexo;
    private String raca;
    private String estadoCivil;
    private String telefone;
    private String frequenciaEscolar;
    private String lerEscrever;
    private String qualificacaoProfissional;
    private Float renda;
    private Date dataRenda;
    private String aposentadoPensionista;
    private String areaRisco;
    private String tipoResidencia;
    private String complementoImovel;
    private String logradouro;
    private String numero;
    private String complementoEndereco;
    private String bairro;
    private String cep;
    private String pontoReferencia;
    private String localizacao;
    private String abrigo;
    private String tipoLogradouro;
    private Date dataDesligamento;
    private String motivoDesligamento;
    private String complementoPessoa;
    private FormaIngresso formaIngresso;
    private TipoEscolaridade tipoEscolaridade;
    private TipoOcupacao tipoOcupacao;
    private TipoParentesco tipoParentesco;
    private TipoEspecificidadeSocial tipoEspecificidadeSocial;
    private Municipio municipio;
    private Uf uf;
    private TipoBeneficioDespesa tipoBeneficioDespesa;
    private TipoDeficiencia tipoDeficiencia;
    private Pessoa pessoa;
    private Date dataAtualizacaoCadastro;
    private Date dataAtualizacaoEndereco;
    private Date dataAtualizacaoHabitacional;
    private String complementoHabitacional;

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Integer getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(Integer numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public Date getDataEmissaoRg() {
        return dataEmissaoRg;
    }

    public void setDataEmissaoRg(Date dataEmissaoRg) {
        this.dataEmissaoRg = dataEmissaoRg;
    }

    public String getNumeroCtps() {
        return numeroCtps;
    }

    public void setNumeroCtps(String numeroCtps) {
        this.numeroCtps = numeroCtps;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getDataEmissaoCtps() {
        return dataEmissaoCtps;
    }

    public void setDataEmissaoCtps(Date dataEmissaoCtps) {
        this.dataEmissaoCtps = dataEmissaoCtps;
    }

    public String getNumeroTituloEleitoral() {
        return numeroTituloEleitoral;
    }

    public void setNumeroTituloEleitoral(String numeroTituloEleitoral) {
        this.numeroTituloEleitoral = numeroTituloEleitoral;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getCartorioCertidao() {
        return cartorioCertidao;
    }

    public void setCartorioCertidao(String cartorioCertidao) {
        this.cartorioCertidao = cartorioCertidao;
    }

    public String getNumeroTermo() {
        return numeroTermo;
    }

    public void setNumeroTermo(String numeroTermo) {
        this.numeroTermo = numeroTermo;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getFolha() {
        return folha;
    }

    public void setFolha(String folha) {
        this.folha = folha;
    }

    public Date getDataEmissaoCn() {
        return dataEmissaoCn;
    }

    public void setDataEmissaoCn(Date dataEmissaoCn) {
        this.dataEmissaoCn = dataEmissaoCn;
    }

    public String getTipoCertidao() {
        return tipoCertidao;
    }

    public void setTipoCertidao(String tipoCertidao) {
        this.tipoCertidao = tipoCertidao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFrequenciaEscolar() {
        return frequenciaEscolar;
    }

    public void setFrequenciaEscolar(String frequenciaEscolar) {
        this.frequenciaEscolar = frequenciaEscolar;
    }

    public String getLerEscrever() {
        return lerEscrever;
    }

    public void setLerEscrever(String lerEscrever) {
        this.lerEscrever = lerEscrever;
    }

    public String getQualificacaoProfissional() {
        return qualificacaoProfissional;
    }

    public void setQualificacaoProfissional(String qualificacaoProfissional) {
        this.qualificacaoProfissional = qualificacaoProfissional;
    }

    public Float getRenda() {
        return renda;
    }

    public void setRenda(Float renda) {
        this.renda = renda;
    }

    public Date getDataRenda() {
        return dataRenda;
    }

    public void setDataRenda(Date dataRenda) {
        this.dataRenda = dataRenda;
    }

    public String getAposentadoPensionista() {
        return aposentadoPensionista;
    }

    public void setAposentadoPensionista(String aposentadoPensionista) {
        this.aposentadoPensionista = aposentadoPensionista;
    }

    public String getAreaRisco() {
        return areaRisco;
    }

    public void setAreaRisco(String areaRisco) {
        this.areaRisco = areaRisco;
    }

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public String getComplementoImovel() {
        return complementoImovel;
    }

    public void setComplementoImovel(String complementoImovel) {
        this.complementoImovel = complementoImovel;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(String abrigo) {
        this.abrigo = abrigo;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public String getMotivoDesligamento() {
        return motivoDesligamento;
    }

    public void setMotivoDesligamento(String motivoDesligamento) {
        this.motivoDesligamento = motivoDesligamento;
    }

    public String getComplementoPessoa() {
        return complementoPessoa;
    }

    public void setComplementoPessoa(String complementoPessoa) {
        this.complementoPessoa = complementoPessoa;
    }

    public FormaIngresso getFormaIngresso() {
        return formaIngresso;
    }

    public void setFormaIngresso(FormaIngresso formaIngresso) {
        this.formaIngresso = formaIngresso;
    }

    public TipoEscolaridade getTipoEscolaridade() {
        return tipoEscolaridade;
    }

    public void setTipoEscolaridade(TipoEscolaridade tipoEscolaridade) {
        this.tipoEscolaridade = tipoEscolaridade;
    }

    public TipoOcupacao getTipoOcupacao() {
        return tipoOcupacao;
    }

    public void setTipoOcupacao(TipoOcupacao tipoOcupacao) {
        this.tipoOcupacao = tipoOcupacao;
    }

    public TipoParentesco getTipoParentesco() {
        return tipoParentesco;
    }

    public void setTipoParentesco(TipoParentesco tipoParentesco) {
        this.tipoParentesco = tipoParentesco;
    }

    public TipoEspecificidadeSocial getTipoEspecificidadeSocial() {
        return tipoEspecificidadeSocial;
    }

    public void setTipoEspecificidadeSocial(TipoEspecificidadeSocial tipoEspecificidadeSocial) {
        this.tipoEspecificidadeSocial = tipoEspecificidadeSocial;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public TipoBeneficioDespesa getTipoBeneficioDespesa() {
        return tipoBeneficioDespesa;
    }

    public void setTipoBeneficioDespesa(TipoBeneficioDespesa tipoBeneficioDespesa) {
        this.tipoBeneficioDespesa = tipoBeneficioDespesa;
    }

    public TipoDeficiencia getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(TipoDeficiencia tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDataAtualizacaoCadastro() {
        return dataAtualizacaoCadastro;
    }

    public void setDataAtualizacaoCadastro(Date dataAtualizacaoCadastro) {
        this.dataAtualizacaoCadastro = dataAtualizacaoCadastro;
    }

    public Date getDataAtualizacaoEndereco() {
        return dataAtualizacaoEndereco;
    }

    public void setDataAtualizacaoEndereco(Date dataAtualizacaoEndereco) {
        this.dataAtualizacaoEndereco = dataAtualizacaoEndereco;
    }

    public Date getDataAtualizacaoHabitacional() {
        return dataAtualizacaoHabitacional;
    }

    public void setDataAtualizacaoHabitacional(Date dataAtualizacaoHabitacional) {
        this.dataAtualizacaoHabitacional = dataAtualizacaoHabitacional;
    }

    public String getComplementoHabitacional() {
        return complementoHabitacional;
    }

    public void setComplementoHabitacional(String complementoHabitacional) {
        this.complementoHabitacional = complementoHabitacional;
    }

    public Uf getUfRg() {
        return ufRg;
    }

    public void setUfRg(Uf ufRg) {
        this.ufRg = ufRg;
    }

    public Uf getUfCtps() {
        return ufCtps;
    }

    public void setUfCtps(Uf ufCtps) {
        this.ufCtps = ufCtps;
    }

    public Uf getUfCn() {
        return ufCn;
    }

    public void setUfCn(Uf ufCn) {
        this.ufCn = ufCn;
    }

    public Uf getUfNacionalidade() {
        return ufNacionalidade;
    }

    public void setUfNacionalidade(Uf ufNacionalidade) {
        this.ufNacionalidade = ufNacionalidade;
    }

    public Municipio getMunicipioNacionalidade() {
        return municipioNacionalidade;
    }

    public void setMunicipioNacionalidade(Municipio municipioNacionalidade) {
        this.municipioNacionalidade = municipioNacionalidade;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getClassificacaoetaria() {
        return classificacaoetaria;
    }

    public void setClassificacaoetaria(String classificacaoetaria) {
        this.classificacaoetaria = classificacaoetaria;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getSexoAsTexto() {
        String texto = "Feminino";
        if (sexo.equals("0")) {
            texto = "Masculino";
        }
        return texto;
    }
}
