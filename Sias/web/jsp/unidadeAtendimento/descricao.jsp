<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="UnidadeAtendimentoDescricao.mtw" method="post">
    <legend>Descrição Unidade Atendimento</legend>
    <div class="control-group">
        <label class="control-label" title="Nome" for="inputNome">Nome:</label>
        <div class="controls">
            <input type="text" id="inputNome" name="nome" value="${nome}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerounidade">Número Unidade:</label>
        <div class="controls">
            <input type="text" id="inputNumerounidade" name="numerounidade" value="${numerounidade}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputResponsavel">Responsável:</label>
        <div class="controls">
            <input type="text" id="inputResponsavel" name="responsavel" value="${responsavel}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTelefone">Telefone:</label>
        <div class="controls">
            <input type="text" id="inputTelefone" name="telefone" value="${telefone}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro:</label>
        <div class="controls">
            <input type="text" id="inputLogradouro" name="logradouro" value="${logradouro}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumero">Número:</label>
        <div class="controls">
            <input type="text" id="inputNumero" name="numero" value="${numero}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço:</label>
        <div class="controls">
            <input type="text" id="inputComplementoendereco" name="complementoendereco" value="${complementoendereco}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputBairro">Bairro:</label>
        <div class="controls">
            <input type="text" id="inputBairro" name="bairro" value="${bairro}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNome">Município:</label>
        <div class="controls">
            <input type="text" id="inputMunicipio" name="municipio.id" value="${municipio}"/>
        </div>
    </div> 
    <div class="control-group">
        <label class="control-label" for="inputUf">UF:</label>
        <div class="controls">
            <input type="text" id="inputUf" name="uf.sigla" value="${uf.sigla}"/>
        </div>
    </div> 
    <div class="control-group">
        <label class="control-label" for="inputCep">CEP:</label>
        <div class="controls">
            <input type="text" id="inputCep" name="cep" value="${cep}"/>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <a type="submit" class="btn btn-primary" href="UnidadeAtendimentoRead.mtw">Voltar</a>
        </div>
    </div>

</mtw:form>
