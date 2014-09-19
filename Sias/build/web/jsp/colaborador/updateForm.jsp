<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>
<mtw:form klass="form-horizontal" action="ColaboradorUpdate.mtw" method="post">
    <mtw:input type="hidden" name="colaborador.id"/>
    <legend>Alterar Colaborador</legend>
    <div class="control-group">
        <label class="control-label" for="inputNome">Nome:</label>
        <div class="controls">
            <mtw:input type="text" id="inputNome" name="colaborador.nome"/>
            <span class="label label-important">${error.nome}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputCpf">CPF:</label>
        <div class="controls">
            <mtw:input type="text" id="inputCpf" name="colaborador.cpf"/>
            <span class="label label-important">${error.cpf}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumeroRg">Número RG:</label>
        <div class="controls">
            <mtw:input type="text" id="inputNumerorg" name="colaborador.numeroRg"/>
            <span class="label label-important">${error.numerorg}</span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputOrgaoExpedidor">Órgão Expedidor:</label>
        <div class="controls">
            <mtw:input type="text" id="inputOrgaoexpedidor" name="colaborador.orgaoExpedidor"/>
            <span class="label label-important">${error.orgaoexpedidor}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputDataemissao">Data Emissão:</label>
        <div class="controls">
            <mtw:inputDate dateFormat="dd/mm/yyyy"  id="inputDataemissao" name="colaborador.dataEmissao"/>
            <span class="label label-important">${error.dataemissao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputUfEmissao">UF Emissão:</label>
        <div class="controls">
            <mtw:select name="colaborador.ufEmissao.id" list="ufEmissaoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.ufemissao.id}</span>
        </div>
    </div> 

    <div class="control-group">
        <label class="control-label" for="inputCargo">Cargo:</label>
        <div class="controls">
            <mtw:input type="text" id="inputCargo" name="colaborador.cargo"/>
            <span class="label label-important">${error.cargo}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputFuncao">Função:</label>
        <div class="controls">
            <mtw:input type="text" id="inputFuncao" name="colaborador.funcao"/>
            <span class="label label-important">${error.funcao}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputTelefone">Telefone:</label>
        <div class="controls">
            <mtw:input type="text" id="inputTelefone" name="colaborador.telefone"/>
            <span class="label label-important">${error.telefone}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputLogradouro">Logradouro:</label>
        <div class="controls">
            <mtw:input type="text" id="inputLogradouro" name="colaborador.logradouro"/>
            <span class="label label-important">${error.logradouro}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputNumero">Número:</label>
        <div class="controls">
            <mtw:input type="text" id="inputNumero" name="colaborador.numero"/>
            <span class="label label-important">${error.numero}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputComplementoendereco">Complemento do Endereço:</label>
        <div class="controls">
            <mtw:input type="text" id="inputComplementoendereco" name="colaborador.complementoEndereco"/>
            <span class="label label-important">${error.complementoendereco}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputBairro">Bairro:</label>
        <div class="controls">
            <mtw:input type="text" id="inputBairro" name="colaborador.bairro"/>
            <span class="label label-important">${error.bairro}</span>
        </div>
    </div>

    <div class="control-group">
        <label class="control-label" for="inputMunicipio">Município:</label>
        <div class="controls">
            <mtw:select name="colaborador.municipio.id" list="municipioOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.municipio.id}</span>
        </div>
    </div> 
    <div class="control-group">
        <label class="control-label" for="inputUf">UF:</label>
        <div class="controls">
            <mtw:select name="colaborador.uf.id" list="ufOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
            <span class="label label-important">${error.uf.id}</span>
        </div>
    </div> 
    <div class="control-group">
        <label class="control-label" for="inputCep">CEP:</label>
        <div class="controls">
            <mtw:input type="text" id="inputCep" name="colaborador.cep"/>
            <span class="label label-important">${error.cep}</span>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputUnidadeatendimento">Unidade Atendimento:</label>
        <div class="controls">
            <mtw:select name="colaborador.unidadeAtendimento.id" list="unidadeAtendimentoOptions" emptyField="true" defEmptyFieldValue="0" emptyFieldValue="Selecione..."/>
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