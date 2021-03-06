<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="FormaIngressoCreate.mtw" method="post">
    <legend>Nova Forma Ingresso</legend>
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
            <mtw:input type="text" id="inputDescricao" name="descricao" />
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
            <a type="submit" class="btn btn-danger" href="FormaIngressoRead.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>

 <!--   <div class="control-group">
        <label class="control-label" for="inputAtivo">Ativo:</label>
        <div class="controls">
            <input type="radio" name="ativo" value="Sim"/>Sim  
            <input type="radio" name="ativo" value="Nao"/>Não<br>
            <span class="label label-important">${error.ativo}</span>
        </div>
    </div>        
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success"><i class="icon-ok icon-white"></i> Confirmar</button>
            <button type="submit" class="btn btn-danger"><i class="icon-remove icon-white"></i> Cancelar</button>
        </div>
    </div>-->
 
 