<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="PessoaCreate.mtw" method="post">
    <legend>Identificação</legend>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Parentesco com a pessoa de referência:</label>
        <div class="controls">
            <mtw:select klass="span3" name="pessoa.tipoParentesco.id" list="tipoParentescoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tipoparentesco.id}</span>
            <td>Número de ordem:</td>
            <mtw:input klass="span1" type="text" id="inputNumeroordem" name="pessoa.numeroOrdem"/>
            <span class="label label-important">${error.numeroordem}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDatainclusao">Data Inclusão:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy" id="inputDatainclusao" name="pessoa.dataInclusao"/>
            <span class="label label-important">${error.datainclusao}</span>
            <td>Forma de Ingresso:</td>
            <mtw:select klass="span6" name="pessoa.formaIngresso.id" list="formaIngressoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.formaingresso.id}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome da pessoa:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNome" name="pessoa.nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNomepai">Nome do pai:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNomepai" name="pessoa.nomePai"/>
            <span class="label label-important">${error.nomepai}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNomemae">Nome da mãe:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNomemae" name="pessoa.nomeMae"/>
            <span class="label label-important">${error.nomemae}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputSexo">Sexo:</label>
        <div class="controls radio">
            <label>
                <input type="radio" name="pessoa.sexo" value="0"> Masculino
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input checked="yes" type="radio" name="pessoa.sexo" value="1"> Feminino
                <span class="label label-important">${error.sexo}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDatanascimento">Data de nascimento:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy"  id="inputDatanascimento" name="pessoa.dataNascimento"/>
            <span class="label label-important">${error.datanascimento}</span>
            <td>Idade:</td>
            <mtw:input klass="span1" type="text" id="inputIdade" name="pessoa.idade"/>
            <span class="label label-important">${error.idade}</span>
            <td>Classificação:</td>
            <mtw:select klass="span3" name="pessoa.classificacaoEtaria" list="classificacaoEtariaOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.classificacaoetaria}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNacionalidade">Nacionalidade:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNacionalidade" name="pessoa.nacionalidade"/>
            <span class="label label-important">${error.nacionalidade}</span>
            <td>UF:</td>
            <mtw:select klass="span2" name="pessoa.ufNacionalidade.id" list="ufNacionalidadeOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufnacionalidade.id}</span>
            <td>Municipio de nascimento:</td>
            <mtw:select klass="span4" name="pessoa.municipioNacionalidade.id" list="municipioNacionalidadeOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.municipionacionalidade.id}</span>

        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputRaca">Raça/Cor:</label>
        <div class="controls">
            <mtw:select klass="span2" name="pessoa.raca" list="racaOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.raca}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputestadocivil">Estado Civil:</label>
        <div class="controls">
            <mtw:select klass="span2" name="pessoa.estadoCivil" list="estadoCivilOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.estadocivil}</span>
            <td>Telefone:</td>
            <mtw:input klass="span2" type="text" id="inputTelefone" name="pessoa.telefone"/>
            <span class="label label-important">${error.telefone}</span>
        </div>
    </div>  
    <div class="control-group">
        <label class="control-label" for="inputDataatualizacaocadastro">Data de atualização:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy"  id="inputDataatualizacaocadastro" name="pessoa.dataAtualizacaoCadastro"/>
            <span class="label label-important">${error.dataatualizacaocadastro}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementopessoa">Complemento do cadastro:</label>
        <div class="controls">
            <mtw:input klass="span10" type="text" id="inputComplementopessoa" name="pessoa.complementoPessoa"/>
            <span class="label label-important">${error.complementopessoa}</span>
        </div>
    </div>
    <legend>Documentos civis</legend>
    <div class="control-group">
        <label class="control-label" for="inputCpf">CPF:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputCpf" name="pessoa.cpf"/>
            <span class="label label-important">${error.cpf}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNis">NIS:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNis" name="pessoa.nis"/>
            <span class="label label-important">${error.nis}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerorg">RG:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerorg" name="pessoa.numeroRg"/>
            <span class="label label-important">${error.numerorg}</span>
            <td>Orgão expeditor:</td>
            <mtw:input klass="span1" type="text" id="inputOrgaoexpedidor" name="pessoa.orgaoExpedidor"/>
            <span class="label label-important">${error.orgaoexpedidor}</span>
            <td>Data emissão:</td>
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy" id="inputDataemissaorg" name="pessoa.dataEmissaoRg"/>
            <span class="label label-important">${error.dataemissaorg}</span>
            <td>UF</td>
            <mtw:select klass="span2" name="ufrg" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufrg}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumeroctps">CTPS:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumeroctps" name="pessoa.numeroCtps"/>
            <span class="label label-important">${error.numeroctps}</span>
            <td>Série:</td>
            <mtw:input klass="span1" type="text" id="inputSerie" name="pessoa.serie"/>
            <span class="label label-important">${error.serie}</span>
            <td>Data emissão:</td>
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy" id="inputDataemissaoctps" name="pessoa.dataEmissaoCtps"/>
            <span class="label label-important">${error.dataemissaoctps}</span>
            <td>UF</td>
            <mtw:select klass="span2" name="ufctps" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufrg}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerotituloeleitoral">Título de eleitor:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerotituloeleitoral" name="pessoa.numeroTituloEleitoral"/>
            <span class="label label-important">${error.numerotituloeleitoral}</span>
            <td>Zona:</td>
            <mtw:input klass="span1" type="text" id="inputZona" name="pessoa.zona"/>
            <span class="label label-important">${error.zona}</span>
            <td>Seção:</td>
            <mtw:input klass="span1" type="text" id="inputSecao" name="pessoa.secao"/>
            <span class="label label-important">${error.secao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTipocertidao">Tipo de Certidão:</label>
        <div class="controls">
            <mtw:select klass="span2" name="pessoa.tipoCertidao" list="tipoCertidaoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tipocertidao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputCartoriocertidao">Cartório:</label>
        <div class="controls">
            <mtw:input klass="span1" type="text" id="inputCartoriocertidao" name="pessoa.cartorioCertidao"/>
            <span class="label label-important">${error.cartoriocertidao}</span>
            <td>Número termo:</td>
            <mtw:input klass="span1" type="text" id="inputNumerotermo" name="pessoa.numeroTermo"/>
            <span class="label label-important">${error.numerotermo}</span>
            <td>Livro:</td>
            <mtw:input klass="span1" type="text" id="inputLivro" name="pessoa.livro"/>
            <span class="label label-important">${error.livro}</span>
            <td>Folha:</td>
            <mtw:input klass="span1" type="text" id="inputFolha" name="pessoa.folha"/>
            <span class="label label-important">${error.folha}</span>
            <td>Data emissão:</td>
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy" id="inputDataemissaocn" name="pessoa.dataEmissaoCn"/>
            <span class="label label-important">${error.dataemissaocn}</span>
            <td>UF:</td>
            <mtw:select klass="span2" name="pessoa.ufcn" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufcn}</span>
        </div>
    </div>
    <legend>Endereço</legend>
    <div class="control-group">
        <label class="control-label" for="inputTipo">Tipo:</label>
        <div class="controls">
            <mtw:select klass="span2" name="pessoa.tipologradouro" list="tipoLogradouroOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tipologradouro}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro:</label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputLogradouro" name="pessoa.logradouro"/>
            <span class="label label-important">${error.logradouro}</span>
            <td>Número:</td>
            <mtw:input klass="span1" type="text" id="inputNumero" name="pessoa.numero"/>
            <span class="label label-important">${error.numero}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputComplementoendereco" name="pessoa.complementoEndereco"/>
            <span class="label label-important">${error.complementoendereco}</span>
            <td>Bairro</td>
            <mtw:input klass="span3" type="text" id="inputBairro" name="pessoa.bairro"/>
            <span class="label label-important">${error.bairro}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputMunicipio">Município:</label>
        <div class="controls">
            <mtw:select klass="span4" name="pessoa.municipio.id" list="municipioOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.municipio.id}</span>
            <td>UF:</td>
            <mtw:select klass="span2" name="pessoa.uf.id" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.uf.id}</span>
            <td>CEP:</td>
            <mtw:input klass="span2" type="text" id="inputCep" name="pessoa.cep"/>
            <span class="label label-important">${error.cep}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLocalizacao">Localização:</label>
        <div class="controls radio">
            <label>
                <input type="radio" name="pessoa.localizacao" value="0"> Rural
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input checked="yes" type="radio" name="pessoa.localizacao" value="1"> Urbana
                <span class="label label-important">${error.localizacao}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputPontoreferencia">Ponto de Referência:</label>
        <div class="controls">
            <mtw:input type="text" id="inputPontoreferencia" name="pessoa.pontoReferencia"/>
            <span class="label label-important">${error.pontoreferencia}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputAbrigo">Em abrigo:</label>
        <div class="controls radio">
            <label>
                <input type="radio" name="pessoa.abrigo" value="0"> Sim
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input checked="yes" type="radio" name="pessoa.abrigo" value="1"> Não
                <span class="label label-important">${error.abrigo}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDataatualizacaoendereco">Data de atualização:</label>
        <div class="controls">
            <mtw:inputDate dateFormat="dd/mm/yyyy"  id="inputDataatualizacaoendereco" name="pessoa.dataAtualizacaoEndereco"/>
            <span class="label label-important">${error.dataatualizacaoendereco}</span>
        </div>
    </div>

    <legend>Condições habitacionais</legend>
    <div class="control-group">
        <label class="control-label" for="inputTiporesidencia">Tipo de Residência:</label>
        <div class="controls">
            <mtw:select klass="span2" name="pessoa.tipoResidencia" list="tipoResidenciaOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tiporesidencia}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoimovel">Condições do imóvel:</label>
        <div class="controls">
            <mtw:select klass="span2" name="pessoa.complementoImovel" list="complementoImovelOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.complementoimovel}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputArearisco">Área de risco:</label>
        <div class="controls radio">
            <label>
                <input type="radio" name="pessoa.areaRisco" value="0"> Sim
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input checked="yes" type="radio" name="pessoa.areaRisco" value="1"> Não
                <span class="label label-important">${error.arearisco}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementocondicaohabitacional">Complemento das condições habitacionais:</label>
        <div class="controls">
            <mtw:input type="text" id="inputComplementocondicaohabitacional" name="pessoa.complementoCondicaoHabitacional"/>
            <span class="label label-important">${error.complementocondicaohabitacional}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDataatualizacaohabitacional">Data de atualização:</label>
        <div class="controls">
            <mtw:inputDate dateFormat="dd/mm/yyyy"  id="inputDataatualizacaohabitacional" name="pessoa.dataAtualizacaoHabitacional"/>
            <span class="label label-important">${error.dataatualizacaohabitacional}</span>
        </div>
    </div>

    <legend>Especificidades sociais, étnicas ou culturais da família</legend>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Tipo de Especificidade:</label>
        <div class="controls">
            <mtw:select klass="span5" name="pessoa.tipoEspecificidadeSocial.id" list="tipoEspecificidadeSocialOptions" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tipoEspecificidadeSocial.id}</span>
        </div>
    </div> 

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <button type="submit" class="btn btn-danger">Cancelar</button>
        </div>
    </div>
</mtw:form>