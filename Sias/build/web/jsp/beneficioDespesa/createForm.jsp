<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="BeneficioDespesaCreate.mtw" method="post">
    <legend>Novo Benefício / Despesa</legend>
    <div class="control-group">
        <label class="control-label" for="inputNome">Pessoa:</label>
        <div class="controls">
            <mtw:select klass="span4" name="pessoa.id" list="pessoaOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.pessoa.id}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Tipo Benefício/Despesa:</label>
        <div class="controls">
            <mtw:select klass="span4" name="tipobeneficiodespesa.id" list="tipoBeneficioDespesaOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tipobeneficiodespesa.id}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDatainicio">Data de início:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy"  id="inputDatainicio" name="datainicio"/>
            <span class="label label-important">${error.datainicio}</span>
            <td>Data de término:</td>
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy"  id="inputDatatermino" name="datatermino"/>
            <span class="label label-important">${error.datatermino}</span>
        </div>
    </div> 
    <div class="control-group">
        <label class="control-label" for="inputValor">Valor:</label>
        <div class="controls">
            <mtw:input klass="span1" type="text" id="inputValor" name="valor"/>
            <span class="label label-important">${error.valor}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDataatualizacao">Data de atualização:</label>
        <div class="controls">
            <mtw:inputDate klass="span2" dateFormat="dd/mm/yyyy"  id="inputDataatualizacao" name="dataatualizacao"/>
            <span class="label label-important">${error.dataatualizacao}</span>
        </div>
    </div> 

    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <a type="submit" class="btn btn-danger" href="BeneficioDespesaRead.mtw">Cancelar</a>
        </div>
    </div>
</mtw:form>