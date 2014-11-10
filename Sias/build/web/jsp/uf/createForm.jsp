<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="UfCreate.mtw" method="post">
    <legend>Novo UF</legend>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputNome" name="nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputSigla">Sigla:</label>
        <div class="controls">
            <mtw:input klass="span1" type="text" id="inputSigla" name="sigla" style="text-transform:uppercase"/>
            <span class="label label-important">${error.sigla}</span>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <a type="submit" class="btn btn-danger" href="UfRead.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>