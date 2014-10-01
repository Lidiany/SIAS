<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="PessoaDescricaoFamilia.mtw" method="post">
    <legend>Descrição de Pessoa de Referência</legend>
    <legend>Identificação</legend>
    <div class="control-group">
        <label class="control-label" for="inputTipoparentescoDescricao">Parentesco com a pessoa de referência:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputTipoparentesco" name="tipoparentesco.descricao" value="${tipoparentesco.descricao}"/>
            <span class="label label-important">${error.tipoparentesco.descricao}</span>
            <td>Número de ordem:</td>
            <mtw:input klass="span1" type="text" id="inputNumeroordem" name="numeroordem" value="${numeroordem}"/>
            <span class="label label-important">${error.numeroordem}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDatainclusao">Data Inclusão:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputDatainclusao" name="datainclusao" value="${datainclusao}"/>
            <span class="label label-important">${error.datainclusao}</span>
            <td>Forma de Ingresso:</td>
            <mtw:input klass="span6" type="text" id="inputFormaingresso.descricao" name="formaingresso.descricao" value="${formaingresso.descricao}"/>
            <span class="label label-important">${error.formaingresso.descricao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome da pessoa:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNome" name="nome" value="${nome}"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNomepai">Nome do pai:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNomepai" name="nomepai" value="${nomepai}"/>
            <span class="label label-important">${error.nomepai}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNomemae">Nome da mãe:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNomemae" name="nomemae" value="${nomemae}"/>
            <span class="label label-important">${error.nomemae}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputSexo">Sexo:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputSexo" name="sexo" value="${sexo}"/>
            <span class="label label-important">${error.sexo}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDatanascimento">Data de nascimento:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputDatanascimento" name="datanascimento" value="${datanascimento}"/>
            <span class="label label-important">${error.datanascimento}</span>
            <td>Idade:</td>
            <mtw:input klass="span1" type="text" id="inputIdade" name="pessoa.idade" value="${pessoa.idade}"/>
            <span class="label label-important">${error.idade}</span>
            <td>Classificação:</td>
            <mtw:input klass="span3" type="text" id="inputClassificacaoetaria" name="pessoa.classificacaoetaria" value="${pessoa.classificacaoetaria}"/>
            <span class="label label-important">${error.classificacaoetaria}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNacionalidade">Nacionalidade:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNacionalidade" name="nacionalidade" value="${nacionalidade}"/>
            <span class="label label-important">${error.nacionalidade}</span>
            <td>UF:</td>
            <mtw:input klass="span2" type="text" id="inputUfnacionalidade" name="ufnacionalidade.sigla" value="${ufnacionalidade.sigla}"/>
            <span class="label label-important">${error.ufnacionalidade.sigla}</span>
            <td>Municipio de nascimento:</td>
            <mtw:input klass="span4" type="text" id="inputMunicipionacionalidade" name="municipionacionalidade.nome" value="${municipionacionalidade.nome}"/>
            <span class="label label-important">${error.municipionacionalidade.nome}</span>

        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputRaca">Raça/Cor:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputRaca" name="raca" value="${raca}"/>
            <span class="label label-important">${error.raca}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputestadocivil">Estado Civil:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputEstadocivil" name="estadocivil" value="${estadocivil}"/>
            <span class="label label-important">${error.estadocivil}</span>
            <td>Telefone:</td>
            <mtw:input klass="span2" type="text" id="inputTelefone" name="telefone" value="${telefone}"/>
            <span class="label label-important">${error.telefone}</span>
        </div>
    </div>  
    <div class="control-group">
        <label class="control-label" for="inputDataatualizacaocadastro">Data de atualização:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputDataatualizacaocadastro" name="dataatualizacaocadastro" value="${dataatualizacaocadastro}"/>
            <span class="label label-important">${error.dataatualizacaocadastro}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementopessoa">Complemento do cadastro:</label>
        <div class="controls">
            <mtw:input klass="span10" type="text" id="inputComplementopessoa" name="complementopessoa" value="${complementopessoa}"/>
            <span class="label label-important">${error.complementopessoa}</span>
        </div>
    </div>
    <legend>Documentos civis</legend>
    <div class="control-group">
        <label class="control-label" for="inputCpf">CPF:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputCpf" name="cpf" value="${cpf}"/>
            <span class="label label-important">${error.cpf}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNis">NIS:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNis" name="nis" value="${nis}"/>
            <span class="label label-important">${error.nis}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerorg">RG:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerorg" name="numerorg" value="${numerorg}"/>
            <span class="label label-important">${error.numerorg}</span>
            <td>Orgão expedidor:</td>
            <mtw:input klass="span1" type="text" id="inputOrgaoexpedidor" name="orgaoexpedidor" value="${orgaoexpedidor}"/>
            <span class="label label-important">${error.orgaoexpedidor}</span>
            <td>Data emissão:</td>
            <mtw:input klass="span2" type="text" id="inputDataemissaorg" name="dataemissaorg" value="${dataemissaorg}"/>
            <span class="label label-important">${error.dataemissaorg}</span>
            <td>UF</td>
            <mtw:input klass="span2" type="text" id="inputUfrg" name="ufrg.sigla" value="${ufrg.sigla}"/>
            <span class="label label-important">${error.ufrg.sigla}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumeroctps">CTPS:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumeroctps" name="numeroctps" value="${numeroctps}"/>
            <span class="label label-important">${error.numeroctps}</span>
            <td>Série:</td>
            <mtw:input klass="span1" type="text" id="inputSerie" name="serie" value="${serie}"/>
            <span class="label label-important">${error.serie}</span>
            <td>Data emissão:</td>
            <mtw:input klass="span2" id="inputDataemissaoctps" name="dataemissaoctps" value="${dataemissaoctps}"/>
            <span class="label label-important">${error.dataemissaoctps}</span>
            <td>UF</td>
            <mtw:input klass="span2" type="text" id="inputUfctps" name="ufctps.sigla" value="${ufctps.sigla}"/>
            <span class="label label-important">${error.ufctps.sigla}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerotituloeleitoral">Título de eleitor:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerotituloeleitoral" name="numerotituloeleitoral" value="${numerotituloeleitoral}"/>
            <span class="label label-important">${error.numerotituloeleitoral}</span>
            <td>Zona:</td>
            <mtw:input klass="span1" type="text" id="inputZona" name="zona" value="${zona}"/>
            <span class="label label-important">${error.zona}</span>
            <td>Seção:</td>
            <mtw:input klass="span1" type="text" id="inputSecao" name="secao" value="${secao}"/>
            <span class="label label-important">${error.secao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTipocertidao">Tipo de Certidão:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputTipocertidao" name="tipocertidao" value="${tipocertidao}"/>
            <span class="label label-important">${error.tipocertidao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputCartoriocertidao">Cartório:</label>
        <div class="controls">
            <mtw:input klass="span1" type="text" id="inputCartoriocertidao" name="cartoriocertidao" value="${cartoriocertidao}"/>
            <span class="label label-important">${error.cartoriocertidao}</span>
            <td>Número termo:</td>
            <mtw:input klass="span1" type="text" id="inputNumerotermo" name="numerotermo" value="${numerotermo}"/>
            <span class="label label-important">${error.numerotermo}</span>
            <td>Livro:</td>
            <mtw:input klass="span1" type="text" id="inputLivro" name="livro" value="${livro}"/>
            <span class="label label-important">${error.livro}</span>
            <td>Folha:</td>
            <mtw:input klass="span1" type="text" id="inputFolha" name="folha" value="${folha}"/>
            <span class="label label-important">${error.folha}</span>
            <td>Data emissão:</td>
            <mtw:input klass="span2" id="inputDataemissaocn" name="dataemissaocn" value="${dataemissaocn}"/>
            <span class="label label-important">${error.dataemissaocn}</span>
            <td>UF:</td>
            <mtw:input klass="span2" type="text" id="inputUfcn" name="ufcn.sigla" value="${ufcn.sigla}"/>
            <span class="label label-important">${error.ufcn.sigla}</span>
        </div>
    </div>
    <legend>Endereço</legend>
    <div class="control-group">
        <label class="control-label" for="inputTipologradouro">Tipo:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputTipologradouro" name="tipologradouro" value="${tipologradouro}"/>
            <span class="label label-important">${error.tipologradouro}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro:</label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputLogradouro" name="logradouro" value="${logradouro}"/>
            <span class="label label-important">${error.logradouro}</span>
            <td>Número:</td>
            <mtw:input klass="span1" type="text" id="inputNumero" name="numero" value="${numero}"/>
            <span class="label label-important">${error.numero}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputComplementoendereco" name="complementoendereco" value="${complementoendereco}"/>
            <span class="label label-important">${error.complementoendereco}</span>
            <td>Bairro</td>
            <mtw:input klass="span3" type="text" id="inputBairro" name="bairro" value="${bairro}"/>
            <span class="label label-important">${error.bairro}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputMunicipio">Município:</label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputMunicipio" name="municipio.nome" value="${municipio.nome}"/>
            <span class="label label-important">${error.municipio.nome}</span>
            <td>UF:</td>
            <mtw:input klass="span2" type="text" id="inputUf" name="uf.sigla" value="${uf.sigla}"/>
            <span class="label label-important">${error.uf.sigla}</span>
            <td>CEP:</td>
            <mtw:input klass="span2" type="text" id="inputCep" name="cep" value="${cep}"/>
            <span class="label label-important">${error.cep}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLocalizacao">Localização:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputLocalizacao" name="localizacao" value="${localizacao}"/>
            <span class="label label-important">${error.localizacao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputPontoreferencia">Ponto de Referência:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputPontoreferencia" name="pontoreferencia" value="${pontoreferencia}"/>
            <span class="label label-important">${error.pontoreferencia}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputAbrigo">Em abrigo:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputAbrigo" name="abrigo" value="${abrigo}"/>
            <span class="label label-important">${error.abrigo}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDataatualizacaoendereco">Data de atualização:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputDataatualizacaoendereco" name="dataatualizacaoendereco" value="${dataatualizacaoendereco}"/>
            <span class="label label-important">${error.dataatualizacaoendereco}</span>
        </div>
    </div>


    <legend>Condições habitacionais</legend>
    <div class="control-group">
        <label class="control-label" for="inputTiporesidencia">Tipo de Residência:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputTiporesidencia" name="tiporesidencia" value="${tiporesidencia}"/>
            <span class="label label-important">${error.tiporesidencia}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoimovel">Condições do imóvel:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputComplementoimovel" name="complementoimovel" value="${complementoimovel}"/>
            <span class="label label-important">${error.complementoimovel}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputArearisco">Área de risco:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputArearisco" name="arearisco" value="${arearisco}"/>
            <span class="label label-important">${error.arearisco}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementocondicaohabitacional">Complemento das condições habitacionais:</label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputComplementocondicaohabitacional" name="complementocondicaohabitacional" value="${complementocondicaohabitacional}"/>
            <span class="label label-important">${error.complementocondicaohabitacional}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDataatualizacaohabitacional">Data de atualização:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputDataatualizacaohabitacional" name="dataatualizacaohabitacional" value="${dataatualizacaohabitacional}"/>
            <span class="label label-important">${error.dataatualizacaohabitacional}</span>
        </div>
    </div>

    <legend>Especificidades sociais, étnicas ou culturais da família</legend>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Tipo de Especificidade:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputTipoespecificidadesocial" name="tipoespecificidadesocial.descricao" value="${tipoespecificidadesocial.descricao}"/>
            <span class="label label-important">${error.tipoEspecificidadeSocial.descricao}</span>
        </div>
    </div> 

    <div class="control-group">
        <div class="controls">
            <a type="submit" class="btn btn-primary" href="PessoaRead.mtw">Voltar</a>
        </div>
    </div>

</mtw:form>