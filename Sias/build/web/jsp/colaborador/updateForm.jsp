<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="ColaboradorUpdate.mtw" method="post">
    <mtw:input type="hidden" name="colaborador.id"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <legend>Alterar Colaborador</legend>
    <div class="control-group">
        <label class="control-label" for="inputUnidadeatendimento">Unidade Atendimento:</label>
        <div class="controls">
            <mtw:select klass="span5" name="colaborador.unidadeAtendimento.id" list="unidadeAtendimentoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.unidadeatendimento.id}</span>
        </div>
    </div> 
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNome" name="colaborador.nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputCpf">CPF:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputCpf" name="colaborador.cpf"/>
            <span class="label label-important">${error.cpf}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumeroRg">Número RG:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerorg" name="colaborador.numeroRg"/>
            <span class="label label-important">${error.numerorg}</span>
            <td>Órgão Expedidor:</td>
            <mtw:input klass="span1" type="text" id="inputOrgaoexpedidor" name="colaborador.orgaoExpedidor" style="text-transform:uppercase"/>
            <span class="label label-important">${error.orgaoexpedidor}</span>
            <td>Data Emissão:</td>
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy"  id="inputDataemissao" name="colaborador.dataEmissao"/>
            <span class="label label-important">${error.dataemissao}</span>
            <td>UF Emissão:</td>
            <mtw:select klass="span2" name="colaborador.ufEmissao.id" list="ufEmissaoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufemissao.id}</span>
        </div>
    </div> 

    <div class="control-group">
        <label class="control-label" for="inputCargo">Cargo:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputCargo" name="colaborador.cargo"/>
            <span class="label label-important">${error.cargo}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputFuncao">Função:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputFuncao" name="colaborador.funcao"/>
            <span class="label label-important">${error.funcao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTelefone">Telefone:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputTelefone" name="colaborador.telefone"/>
            <span class="label label-important">${error.telefone}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro:</label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputLogradouro" name="colaborador.logradouro"/>
            <span class="label label-important">${error.logradouro}</span>
            <td>Número:</td>
            <mtw:input klass="span1" type="text" id="inputNumero" name="colaborador.numero"/>
            <span class="label label-important">${error.numero}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputComplementoendereco" name="colaborador.complementoEndereco"/>
            <span class="label label-important">${error.complementoendereco}</span>
            <td>Bairro:</td>
            <mtw:input klass="span3" type="text" id="inputBairro" name="colaborador.bairro"/>
            <span class="label label-important">${error.bairro}</span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputMunicipio">Município:</label>
        <div class="controls">
            <mtw:select klass="span4" name="colaborador.municipio.id" list="municipioOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.municipio.id}</span>
            <td>UF:</td>
            <mtw:select klass="span2" name="colaborador.uf.id" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.uf.id}</span>
            <td>CEP:</td>
            <mtw:input klass="span2" type="text" id="inputCep" name="colaborador.cep"/>
            <span class="label label-important">${error.cep}</span>
        </div>
    </div>



    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <a type="submit" class="btn btn-danger" href="ColaboradorRead.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>