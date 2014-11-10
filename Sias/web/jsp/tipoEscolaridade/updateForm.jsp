<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="TipoEscolaridadeUpdate.mtw" method="post">
    <mtw:input type="hidden" name="tipoEscolaridade.id"/>
    <legend>Alterar Tipo Escolaridade</legend>
    <div class="control-group">
        <label class="control-label" for="inputCodigo">Código:</label>
        <div class="controls">
            <mtw:input type="text" id="inputCodigo" name="tipoEscolaridade.codigo"/>
            <span class="label label-important">${error.codigo}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Descrição:</label>
        <div class="controls">
            <mtw:input type="text" id="inputDescricao" name="tipoEscolaridade.descricao"/>
            <span class="label label-important">${error.descricao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputAtivo">Ativo:</label>
        <div class="controls radio">
            <label>
                <input type="radio" name="tipoEscolaridade.ativo" value="1" <c:if test="${tipoEscolaridade.ativo eq '1'}">checked</c:if> /> Sim
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input type="radio" name="tipoEscolaridade.ativo" value="0" <c:if test="${tipoEscolaridade.ativo eq '0'}">checked</c:if> /> Não
                <span class="label label-important">${error.ativo}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <a type="submit" class="btn btn-danger" href="TipoEscolaridadeRead.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>