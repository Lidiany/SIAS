<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="FormaIngressoUpdate.mtw" method="post">
    <mtw:input type="hidden" name="formaIngresso.id"/>
    <legend>Alterar Forma Ingresso</legend>
    <div class="control-group">
        <label class="control-label" for="inputCodigo">Código:</label>
        <div class="controls">
            <mtw:input type="text" id="inputCodigo" name="formaIngresso.codigo"/>
            <span class="label label-important">${error.codigo}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Descrição:</label>
        <div class="controls">
            <mtw:input type="text" id="inputDescricao" name="formaIngresso.descricao"/>
            <span class="label label-important">${error.descricao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputAtivo">Ativo:</label>
        <div class="controls radio">
            <label>
                <input type="radio" name="formaIngresso.ativo" value="1" <c:if test="${formaIngresso.ativo eq '1'}">checked</c:if> /> Sim
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input type="radio" name="formaIngresso.ativo" value="0" <c:if test="${formaIngresso.ativo eq '0'}">checked</c:if> /> Não
                <span class="label label-important">${error.ativo}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <button type="submit" class="btn btn-danger">Cancelar</button>
        </div>
    </div>
</mtw:form>