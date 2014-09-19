<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="TipoBeneficioDespesaCreate.mtw" method="post">
    <legend>Novo Tipo Benefício/Despesa</legend>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Descrição:</label>
        <div class="controls">
            <mtw:input type="text" id="inputDescricao" name="descricao"/>
            <span class="label label-important">${error.descricao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTipo">Tipo:</label>
        <div class="controls">
            <mtw:input type="text" id="inputTipo" name="tipo"/>
            <span class="label label-important">${error.tipo}</span>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <button type="submit" class="btn btn-danger">Cancelar</button>
        </div>
    </div>
</mtw:form>