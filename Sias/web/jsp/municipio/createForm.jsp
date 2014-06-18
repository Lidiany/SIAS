<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="MunicipioCreate.mtw" method="post">
    <legend>Novo Município</legend>

    <div class="control-group">
        <label class="control-label" for="inputNome">Nome:</label>
        <div class="controls">
            <mtw:input type="text" id="inputNome" name="nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNome">UF:</label>
        <div class="controls">
            <mtw:select name="uf.id" list="ufOptions" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.uf.id}</span>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success"><i class="icon-ok icon-white"></i> Confirmar</button>
        </div>
    </div>
</mtw:form>