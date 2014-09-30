<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="TipoDeficienciaCreate.mtw" method="post">
    <legend>Novo Tipo Deficiência</legend>
    <div class="control-group">
        <label class="control-label" for="inputCodigo">Código:</label>
        <div class="controls">
            <mtw:input type="text" id="inputCodigo" name="codigo"/>
            <span class="label label-important">${error.codigo}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Descrição:</label>
        <div class="controls">
            <mtw:input type="text" id="inputDescricao" name="descricao"/>
            <span class="label label-important">${error.descricao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputAtivo">Ativo:</label>
        <div class="controls radio">
            <label>
                <input checked="yes" type="radio" name="ativo" value="1"> Sim
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input type="radio" name="ativo" value="0"> Não
                <span class="label label-important">${error.ativo}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <a type="submit" class="btn btn-danger" href="TipoDeficienciaRead.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>