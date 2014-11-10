<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="PessoaTrabalhoRenda.mtw" method="post">
    <mtw:input type="hidden" name="pessoa.id"/>
    
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Situação Ocupacional:</label>
        <div class="controls">
            <mtw:select klass="span3" name="tipoOcupacao.id" list="tipoOcupacaoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tipoocupacao.id}</span>
            <td>Qualificação Profissional:</td>
            <mtw:input klass="span3" type="text" id="inputQualificacaoprofissional" name="qualificacaoProfissional"/>
            <span class="label label-important">${error.qualificacaoprofissional}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDatarenda">Data da Renda:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy" id="inputDatarenda" name="dataRenda"/>
            <span class="label label-important">${error.datarenda}</span>
            <td>Renda mensal (sem beneficíos) R$:</td>
            <mtw:input klass="span3" type="text" id="inputRenda" name="renda"/>
            <span class="label label-important">${error.renda}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputAposentadopensionista">Aposentado ou pensionista:</label>
        <div class="controls radio">
            <label>
                <input type="radio" name="aposentadopensionista" value="1"> Sim
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input type="radio" name="aposentadopensionista" value="0"> Não
                <span class="label label-important">${error.aposentadopensionista}</span>
            </label>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <a type="submit" class="btn btn-danger" href="PessoaComposicaoFamilia.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>