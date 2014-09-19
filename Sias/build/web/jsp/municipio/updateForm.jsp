<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="MunicipioUpdate.mtw" method="post">
    <mtw:input type="hidden" name="municipio.id"/>
    <legend>Alterar Município</legend>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome</label>
        <div class="controls">
            <mtw:input type="text" id="inputNome" name="municipio.nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputUf">UF</label>
        <div class="controls">
            <mtw:select name="municipio.uf.id" list="ufOptions" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important"></span>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success"><i class="icon-ok icon-white"></i> Confirmar</button>
            <button type="submit" class="btn btn-danger"><i class="icon-remove icon-white"></i> Cancelar</button>
        </div>
    </div>
</mtw:form>