<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="ColaboradorDescricao.mtw" method="post">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <legend>Descrição Colaborador</legend>
    <div class="control-group">
        <label class="control-label" for="inputUnidadeatendimentoNome">Unidade de Atendimento: </label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputUnidadeatendimento" name="unidadeatendimento.nome" value="${unidadeatendimento.nome}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome: </label>
        <div class="controls">
            <mtw:input klass="span5" type="text" id="inputNome" name="nome" value="${nome}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputCpf">CPF: </label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputCpf" name="cpf" value="${cpf}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerorg">Número RG: </label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputNumerorg" name="numerorg" value="${numerorg}"/>
            <td>Órgão Expedidor: </td>
            <mtw:input klass="span1" type="text" id="inputOrgaoexpedidor" name="orgaoexpedidor" style="text-transform:uppercase" value="${orgaoexpedidor}"/>
            <td>Data Emissão: </td>
            <mtw:input klass="span2" type="text" id="inputDataemissao" name="dataemissao" value="${dataemissao}"/>
            <td>UF Emissão: </td>
            <mtw:input klass="span2" type="text" id="inputUfemissao.sigla" name="ufemissao.sigla" value="${ufemissao.sigla}"/>
        </div>
    </div>       
    <div class="control-group">
        <label class="control-label" for="inputCargo">Cargo: </label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputCargo" name="cargo" value="${cargo}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputFuncao">Função: </label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputFuncao" name="funcao" value="${funcao}"/>
        </div>
    </div>    
    <div class="control-group">
        <label class="control-label" for="inputTelefone">Telefone: </label>
        <div class="controls">
            <mtw:input klass="span2" type="text" id="inputTelefone" name="telefone" value="${telefone}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro: </label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputLogradouro" name="logradouro" value="${logradouro}"/>
            <td>Número: </td>
            <mtw:input klass="span1" type="text" id="inputNumero" name="numero" value="${numero}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço: </label>
        <div class="controls">
            <input klass="span3" type="text" id="inputComplementoendereco" name="complementoendereco" value="${complementoendereco}"/>
            <td>Bairro: </td>
            <input klass="span3" type="text" id="inputBairro" name="bairro" value="${bairro}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputMunicipioNome">Município: </label>
        <div class="controls">
            <mtw:input klass="span4" type="text" id="inputMunicipio" name="municipio.nome" value="${municipio.nome}"/>
            <td>UF: </td>
            <mtw:input klass="span2" type="text" id="inputUf" name="uf.sigla" value="${uf.sigla}"/>
            <td>CEP: </td>
            <input klass="span2" type="text" id="inputCep" name="cep" value="${cep}"/>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <a type="submit" class="btn btn-primary" href="ColaboradorRead.mtw">Voltar</a>
        </div>
    </div>
</mtw:form>