<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="TipoEspecificidadeSocialUpdate.mtw" method="post">
    <mtw:input type="hidden" name="tipoEspecificidadeSocial.id"/>
    <legend>Alterar Tipo Especificidade Social</legend>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Descrição:</label>
        <div class="controls">
            <mtw:input type="text" id="inputDescricao" name="tipoEspecificidadeSocial.descricao"/>
            <span class="label label-important">${error.descricao}</span>

        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success"><i class="icon-ok icon-white"></i> Confirmar</button>
            <button type="submit" class="btn btn-danger"><i class="icon-remove icon-white"></i> Cancelar</button>
        </div>
    </div>
</mtw:form>