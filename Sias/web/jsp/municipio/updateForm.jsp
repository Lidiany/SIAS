<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="MunicipioUpdate.mtw" method="post">
    <mtw:input type="hidden" name="municipio.id"/>
    <legend>Alterar Município</legend>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome:</label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputNome" name="municipio.nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputSigla">UF:</label>
        <div class="controls">
            <mtw:select klass="span1" name="municipio.uf.id" list="ufOptions" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.uf.id}</span>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <a type="submit" class="btn btn-danger" href="MunicipioRead.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>