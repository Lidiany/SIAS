<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="UnidadeAtendimentoUpdate.mtw" method="post">
    <mtw:input type="hidden" name="unidadeatendimento.id"/>
    <legend>Alterar Unidade de Atendimento</legend>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNome" name="unidadeatendimento.nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerounidade">Número Unidade:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerounidade" name="unidadeatendimento.numeroUnidade"/>
            <span class="label label-important">${error.numerounidade}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputResponsavel">Responsável:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputResponsavel" name="unidadeatendimento.responsavel"/>
            <span class="label label-important">${error.responsavel}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTelefone">Telefone:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputTelefone" name="unidadeatendimento.telefone"/>
            <span class="label label-important">${error.telefone}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro:</label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputLogradouro" name="unidadeatendimento.logradouro"/>
            <span class="label label-important">${error.logradouro}</span>
            <td>Número:</td>
            <mtw:input klass="span1" type="text" id="inputNumero" name="unidadeatendimento.numero"/>
            <span class="label label-important">${error.numero}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputComplementoendereco" name="unidadeatendimento.complementoEndereco"/>
            <span class="label label-important">${error.complementoendereco}</span>
            <td>Bairro:</td>
            <mtw:input klass="span3" type="text" id="inputBairro" name="unidadeatendimento.bairro"/>
            <span class="label label-important">${error.bairro}</span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputNome">Município:</label>
        <div class="controls">
            <mtw:select klass="span4" name="unidadeatendimento.municipio.id" list="municipioOptions" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.municipio.id}</span>
            <td>UF:</td>
            <mtw:select klass="span2" name="unidadeatendimento.uf.id" list="ufOptions" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.uf.id}</span>
            <td>CEP:</td>
            <mtw:input klass="span2" type="text" id="inputCep" name="unidadeatendimento.cep"/>
            <span class="label label-important">${error.cep}</span>
        </div>
    </div>



    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <a type="submit" class="btn btn-danger" href="UnidadeAtendimentoRead.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>