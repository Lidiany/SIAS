<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="PessoaMembroEscolaridade.mtw" method="post">
<legend><strong>> 2. Cadastro de família/indíviduo > 2.2 Composição Familiar > 2.2.2 Escolaridade</strong></legend>
    <legend>Escolaridade</legend>
    <div class="control-group">
        <label class="control-label" for="inputLerescrever">Sabe ler e escrever:</label>
        <div class="controls radio">
            <label>
                <input type="radio" name="lerescrever" value="0"> Sim
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input checked="yes" type="radio" name="lerescrever" value="1"> Não
                <span class="label label-important">${error.lerescrever}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputFrequenciaescolar">Frequenta a escola:</label>
        <div class="controls radio">
            <label>
                <input checked="yes" type="radio" name="frequenciaescolar" value="0"> Sim
            </label>
        </div>
        <div class="controls radio">
            <label>
                <input type="radio" name="frequenciaescolar" value="1"> Não
                <span class="label label-important">${error.frequenciaescolar}</span>
            </label>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDescricao">Grau de escolaridade:</label>
        <div class="controls">
            <mtw:select klass="span5" name="tipoEscolaridade.id" list="tipoEscolaridadeOptions" emptyField="true" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.tipoEscolaridade.id}</span>
        </div>
    </div> 

    <div class="control-group">
        <label class="control-label" for="inputDataatualizacaoescolaridade">Data de atualização:</label>
        <div class="controls">
            <mtw:inputDate dateFormat="dd/mm/yyyy"  id="inputDataatualizacaoescolaridade" name="dataatualizacaoescolaridade"/>
            <span class="label label-important">${error.dataatualizacaoescolaridade}</span>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <button type="submit" class="btn btn-danger">Cancelar</button>
        </div>
    </div>

</mtw:form>        