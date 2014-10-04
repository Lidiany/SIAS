<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="TipoEspecificidadeSocialUpdate.mtw" method="post">
    <mtw:input type="hidden" name="tipoEspecificidadeSocial.id"/>
    <legend>Alterar Especificidade Familiar</legend>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Descrição:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputDescricao" name="tipoEspecificidadeSocial.descricao"/>
            <span class="label label-important">${error.descricao}</span>

        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <a type="submit" class="btn btn-danger" href="TipoEspecificidadeSocialRead.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>