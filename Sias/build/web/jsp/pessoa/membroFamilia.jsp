<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="PessoaCreate.mtw" method="post">
<legend><strong>> 2. Cadastro de família/indíviduo > 2.2 Composição Familiar > 2.2.1 Membro familiar</strong></legend>
    <legend>Identificação</legend>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Parentesco com a pessoa de referência:</label>
        <div class="controls">
            <mtw:select klass="span3" name="tipoParentesco.id" list="tipoParentescoOptions" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tipoparentesco.id}</span>
            <td>Número de ordem:</td>
            <mtw:input klass="span1" type="text" id="inputNumeroordem" name="numeroOrdem"/>
            <span class="label label-important">${error.numeroordem}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDatainclusao">Data Inclusão:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy" id="inputDatainclusao" name="datainclusao"/>
            <span class="label label-important">${error.datainclusao}</span>
            <td>Forma de Ingresso:</td>
            <mtw:select klass="span6" name="formaIngresso.id" list="formaIngressoOptions" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.formaingresso.id}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome da pessoa:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNome" name="nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNomepai">Nome do pai:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNomepai" name="nomePai"/>
            <span class="label label-important">${error.nomepai}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNomemae">Nome da mãe:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNomemae" name="nomeMae"/>
            <span class="label label-important">${error.nomemae}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputSexo">Sexo:</label>
        <div class="controls radio">
            <label>
                <input type="radio" name="sexo" value="0"> Masculino
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input checked="yes" type="radio" name="sexo" value="1"> Feminino
                <span class="label label-important">${error.sexo}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDatanascimento">Data de nascimento:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy"  id="inputDatanascimento" name="datanascimento"/>
            <span class="label label-important">${error.datanascimento}</span>
            <td>Idade:</td>
            <mtw:input klass="span1" type="text" id="inputIdade" name="idade"/>
            <span class="label label-important">${error.idade}</span>
            <td>Classificação:</td>
            <mtw:select klass="span3" name="classificacaoetaria" list="classificacaoEtariaOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.classificacaoetaria}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNacionalidade">Nacionalidade:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNacionalidade" name="nacionalidade"/>
            <span class="label label-important">${error.nacionalidade}</span>
            <td>UF:</td>
            <mtw:select klass="span2" name="ufnacionalidade" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.uf.id}</span>
            <td>Municipio de nascimento:</td>
            <mtw:select klass="span4" name="municipionacionalidade" list="municipioOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.municipio.id}</span>

        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputRaca">Raça/Cor:</label>
        <div class="controls">
            <mtw:select klass="span2" name="raca" list="racaOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.raca}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputestadocivil">Estado Civil:</label>
        <div class="controls">
            <mtw:select klass="span2" name="estadocivil" list="estadoCivilOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.estadocivil}</span>
            <td>Telefone:</td>
            <mtw:input klass="span2" type="text" id="inputTelefone" name="telefone"/>
            <span class="label label-important">${error.telefone}</span>
        </div>
    </div>  
    <div class="control-group">
        <label class="control-label" for="inputDataatualizacaocadastro">Data de atualização:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy"  id="inputDataatualizacaocadastro" name="dataatualizacaocadastro"/>
            <span class="label label-important">${error.dataatualizacaocadastro}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementopessoa">Complemento do cadastro:</label>
        <div class="controls">
            <mtw:input klass="span10" type="text" id="inputComplementopessoa" name="complementoPessoa"/>
            <span class="label label-important">${error.complementopessoa}</span>
        </div>
    </div>
    <legend>Documentos civis</legend>
    <div class="control-group">
        <label class="control-label" for="inputCpf">CPF:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputCpf" name="cpf"/>
            <span class="label label-important">${error.cpf}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNis">NIS:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNis" name="nis"/>
            <span class="label label-important">${error.nis}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerorg">RG:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerorg" name="numeroRg"/>
            <span class="label label-important">${error.numerorg}</span>
            <td>Orgão expeditor:</td>
            <mtw:input klass="span1" type="text" id="inputOrgaoexpedidor" name="orgaoExpedidor"/>
            <span class="label label-important">${error.orgaoexpedidor}</span>
            <td>Data emissão:</td>
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy" id="inputDataemissaorg" name="dataemissaorg"/>
            <span class="label label-important">${error.dataemissaorg}</span>
            <td>UF</td>
            <mtw:select klass="span2" name="ufrg" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufrg}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumeroctps">CTPS:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumeroctps" name="numeroCtps"/>
            <span class="label label-important">${error.numeroctps}</span>
            <td>Série:</td>
            <mtw:input klass="span1" type="text" id="inputSerie" name="serie"/>
            <span class="label label-important">${error.serie}</span>
            <td>Data emissão:</td>
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy" id="inputDataemissaoctps" name="dataemissaoctps"/>
            <span class="label label-important">${error.dataemissaoctps}</span>
            <td>UF</td>
            <mtw:select klass="span2" name="ufctps" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufrg}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerotituloeleitoral">Título de eleitor:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerotituloeleitoral" name="numerotituloeleitoral"/>
            <span class="label label-important">${error.numerotituloeleitoral}</span>
            <td>Zona:</td>
            <mtw:input klass="span1" type="text" id="inputZona" name="zona"/>
            <span class="label label-important">${error.zona}</span>
            <td>Seção:</td>
            <mtw:input klass="span1" type="text" id="inputSecao" name="secao"/>
            <span class="label label-important">${error.secao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTipocertidao">Tipo de Certidão:</label>
        <div class="controls">
            <mtw:select klass="span2" name="tipocertidao" list="tipoCertidaoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tipocertidao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputCartoriocertidao">Cartório:</label>
        <div class="controls">
            <mtw:input klass="span1" type="text" id="inputCartoriocertidao" name="cartoriocertidao"/>
            <span class="label label-important">${error.cartoriocertidao}</span>
            <td>Número termo:</td>
            <mtw:input klass="span1" type="text" id="inputNumerotermo" name="numerotermo"/>
            <span class="label label-important">${error.numerotermo}</span>
            <td>Livro:</td>
            <mtw:input klass="span1" type="text" id="inputLivro" name="livro"/>
            <span class="label label-important">${error.livro}</span>
            <td>Folha:</td>
            <mtw:input klass="span1" type="text" id="inputFolha" name="folha"/>
            <span class="label label-important">${error.folha}</span>
            <td>Data emissão:</td>
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy" id="inputDataemissaocn" name="dataemissaocn"/>
            <span class="label label-important">${error.dataemissaocn}</span>
            <td>UF:</td>
            <mtw:select klass="span2" name="ufcn" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufcn}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDatadesligamento">Data de desligamento:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy"  id="inputDatadesligamento" name="datadesligamento"/>
            <span class="label label-important">${error.datadesligamento}</span>
            <td>Motivo:</td>
            <mtw:input klass="span4" type="text" id="inputMotivodesligamento" name="motivodesligamento"/>
            <span class="label label-important">${error.motivodesligamento}</span>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <button type="submit" class="btn btn-danger">Cancelar</button>
        </div>
    </div>

</mtw:form>