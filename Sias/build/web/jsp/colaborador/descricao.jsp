<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="ColaboradorDescricao.mtw" method="post">
    <legend>Colaborador</legend>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome: </label>
        <div class="controls">
            <input type="text" id="inputNome" name="nome" value="${nome}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputCpf">CPF: </label>
        <div class="controls">
            <input type="text" id="inputCpf" name="cpf" value="${cpf}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerorg">Número RG: </label>
        <div class="controls">
            <input type="text" id="inputNumerorg" name="numerorg" value="${numerorg}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputOrgaoexpedidor">Órgão Expedidor: </label>
        <div class="controls">
            <input type="text" id="inputOrgaoexpedidor" name="orgaoexpedidor" value="${orgaoexpedidor}"/>
        </div>
    </div>        
    <div class="control-group">
        <label class="control-label" for="inputDataemissao">Data Emissão: </label>
        <div class="controls">
            <input type="text" id="inputDataemissao" name="dataemissao" value="${dataemissao}"/>
        </div>
    </div>   
    <div class="control-group">
        <label class="control-label" for="inputUfemissao.sigla">UF Emissão: </label>
        <div class="controls">
            <input type="text" id="inputUfemissao.sigla" name="ufemissao.sigla" value="${ufemissao.sigla}"/>
        </div>
    </div>       
    <div class="control-group">
        <label class="control-label" for="inputCargo">Cargo: </label>
        <div class="controls">
            <input type="text" id="inputCargo" name="cargo" value="${cargo}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputFuncao">Função: </label>
        <div class="controls">
            <input type="text" id="inputFuncao" name="funcao" value="${funcao}"/>
        </div>
    </div>    
    <div class="control-group">
        <label class="control-label" for="inputTelefone">Telefone: </label>
        <div class="controls">
            <input type="text" id="inputTelefone" name="telefone" value="${telefone}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro: </label>
        <div class="controls">
            <input type="text" id="inputLogradouro" name="logradouro" value="${logradouro}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumero">Número: </label>
        <div class="controls">
            <input type="text" id="inputNumero" name="numero" value="${numero}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço: </label>
        <div class="controls">
            <input type="text" id="inputComplementoendereco" name="complementoendereco" value="${complementoendereco}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputBairro">Bairro: </label>
        <div class="controls">
            <input type="text" id="inputBairro" name="bairro" value="${bairro}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputMunicipioNome">Município: </label>
        <div class="controls">
            <input type="text" id="inputMunicipio" name="municipio.nome" value="${municipio.nome}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputUf">UF: </label>
        <div class="controls">
            <input type="text" id="inputUf" name="uf.id" value="${uf}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputCep">CEP: </label>
        <div class="controls">
            <input type="text" id="inputCep" name="cep" value="${cep}"/>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputUnidadeatendimento">Unidade de Atendimento: </label>
        <div class="controls">
            <input type="text" id="inputUnidadeatendimento" name="unidadeatendimento.id" value="${unidadeatendimento}"/>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <a type="submit" class="btn btn-primary" href="ColaboradorRead.mtw">Voltar</a>
        </div>
    </div>
</mtw:form>