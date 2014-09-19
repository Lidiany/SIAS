<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="ColaboradorCreate.mtw" method="post">
    <legend>Novo Colaborador</legend>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome:</label>
        <div class="controls">
            <mtw:input type="text" id="inputNome" name="nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputCpf">CPF:</label>
        <div class="controls">
            <mtw:input type="text" id="inputCpf" name="cpf"/>
            <span class="label label-important">${error.cpf}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumerorg">Número RG:</label>
        <div class="controls">
            <mtw:input type="text" id="inputNumerorg" name="numerorg"/>
            <span class="label label-important">${error.numerorg}</span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputOrgaoexpedidor">Órgão Expedidor:</label>
        <div class="controls">
            <mtw:input type="text" id="inputOrgaoexpedidor" name="orgaoexpedidor"/>
            <span class="label label-important">${error.orgaoexpedidor}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDataemissao">Data Emissão:</label>
        <div class="controls">
            <mtw:inputDate dateFormat="dd/mm/yyyy"  id="inputDataemissao" name="dataemissao"/>
            <span class="label label-important">${error.dataemissao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputSigla">UF Emissão:</label>
        <div class="controls">
            <mtw:select name="ufemissao.id" list="ufEmissaoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufemissao.id}</span>
        </div>
    </div> 
    <div class="control-group">
        <label class="control-label" for="inputCargo">Cargo:</label>
        <div class="controls">
            <mtw:input type="text" id="inputCargo" name="cargo"/>
            <span class="label label-important">${error.cargo}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputFuncao">Função:</label>
        <div class="controls">
            <mtw:input type="text" id="inputFuncao" name="funcao"/>
            <span class="label label-important">${error.funcao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTelefone">Telefone:</label>
        <div class="controls">
            <mtw:input type="text" id="inputTelefone" name="telefone"/>
            <span class="label label-important">${error.telefone}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro:</label>
        <div class="controls">
            <mtw:input type="text" id="inputLogradouro" name="logradouro"/>
            <span class="label label-important">${error.logradouro}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumero">Número:</label>
        <div class="controls">
            <mtw:input type="text" id="inputNumero" name="numero"/>
            <span class="label label-important">${error.numero}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço:</label>
        <div class="controls">
            <mtw:input type="text" id="inputComplementoendereco" name="complementoendereco"/>
            <span class="label label-important">${error.complementoendereco}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputBairro">Bairro:</label>
        <div class="controls">
            <mtw:input type="text" id="inputBairro" name="bairro"/>
            <span class="label label-important">${error.bairro}</span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputNome">Município:</label>
        <div class="controls">
            <mtw:select name="municipio.id" list="municipioOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.municipio.id}</span>
        </div>
    </div> 
    <div class="control-group">
        <label class="control-label" for="inputNome">UF:</label>
        <div class="controls">
            <mtw:select name="uf.id" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.uf.id}</span>
        </div>
    </div> 

    <div class="control-group">
        <label class="control-label" for="inputCep">CEP:</label>
        <div class="controls">
            <mtw:input type="text" id="inputCep" name="cep"/>
            <span class="label label-important">${error.cep}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNome">Unidade Atendimento:</label>
        <div class="controls">
            <mtw:select name="unidadeatendimento.id" list="unidadeAtendimentoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.unidadeatendimento.id}</span>
        </div>
    </div> 



    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn btn-success">Confirmar</button>
            <button type="submit" class="btn btn-danger">Cancelar</button>
        </div>
    </div>
</mtw:form>