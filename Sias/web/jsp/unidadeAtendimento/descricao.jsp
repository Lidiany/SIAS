<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="UnidadeAtendimentoDescricao.mtw" method="post">
    <legend>Descrição da Unidade de Atendimento</legend>
    <div class="control-group">
        <label class="control-label" title="Nome" for="inputNome">Nome:</label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNome" name="nome" value="${nome}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerounidade">Número da Unidade:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerounidade" name="numerounidade" value="${numerounidade}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputResponsavel">Responsável:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputResponsavel" name="responsavel" value="${responsavel}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTelefone">Telefone:</label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputTelefone" name="telefone" value="${telefone}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro:</label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputLogradouro" name="logradouro" value="${logradouro}"/>
            <td>Número:</td>
            <mtw:input klass="span1" type="text" id="inputNumero" name="numero" value="${numero}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço:</label>
        <div class="controls">
            <mtw:input klass="span3" type="text" id="inputComplementoendereco" name="complementoendereco" value="${complementoendereco}"/>
            <td>Bairro:</td>
            <mtw:input klass="span3" type="text" id="inputBairro" name="bairro" value="${bairro}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputMunicipioNome">Município:</label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputMunicipio" name="municipio.nome" value="${municipio.nome}"/>
            <td>UF:</td>
            <mtw:input klass="span2" type="text" id="inputUf" name="uf.sigla" value="${uf.sigla}"/>
            <td>CEP:</td>
            <mtw:input klass="span2" type="text" id="inputCep" name="cep" value="${cep}"/>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <a type="submit" class="btn btn-primary" href="UnidadeAtendimentoRead.mtw">Voltar</a>
        </div>
    </div>

</mtw:form>
