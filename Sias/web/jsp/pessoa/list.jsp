<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<legend><strong>1. Procura de família/indíviduo</strong></legend>
<legend>> 1. Procura por pessoa</legend>
<div class="input-append">
    <mtw:form action="PessoaRead.mtw" method="post">
        <label class="control-label"> NIS:
            <mtw:input klass="span2" name="nis" type="text"/>
        </label>
        <label class="control-label"> CPF:
            <mtw:input klass="span2" name="cpf" type="text"/>
        </label>
        <label class="control-label">Nome:
            <mtw:input klass="span5" name="nome" type="text"/>
        </label>
        <a href="PessoaShowForm.mtw" class="btn">Nova pessoa de referência</a>
        <button class="btn" type="submit">Procurar pessoa</button>
    </mtw:form>
</div>

<legend><strong>> 1. Pessoa(s) encontrada(s)</strong></legend>
<div class="tabela">
    <display:table name="lista" id="item" pagesize="15" requestURI="" defaultsort="1" sort="list">
        <display:column class="pull-right" property="numeroOrdem" sortable="true" title="Número de Ordem" style="width:20%;"/>
        <display:column property="nome" sortable="true" title="Nome" style="width:30%;"/>
        <display:column property="sexoAsTexto" sortable="true" title="Sexo" style="width:10%;"/>
        <display:column class="pull-right" property="pessoa.idade" sortable="true" title="Idade" style="width:10%;"/>
        <display:column property="tipoParentesco.descricao" sortable="true" title="Parentesco" style="width:20%;"/>
        <display:column value="Ver" href="PessoaDescricaoFamilia.mtw" title="Opções" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Consultar" href="PessoaComposicaoFamilia.mtw" paramId="id" paramProperty="id" style="width:5%;"/>

    </display:table>
</div>

<div class="control-group">
    <div class="controls">
        <a type="submit" class="btn btn-primary" href="Teste.mtw">Voltar</a>
    </div>
</div>

<div class="modal hide" id="confirmDelete">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Atenção</h3>
    </div>
    <div class="modal-body">
        <p>Você deseja realmente excluir?</p>
        <div class="alert alert-error">
            Atenção: esta operação não pode ser desfeita.
        </div>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn btn-danger">Sim, desejo excluir.</a>
        <a href="#" class="btn" data-dismiss="modal">Cancelar</a>
    </div>
</div>

<script>
    $(function() {
        $("td.deleteLink a").click(function() {
            $('#confirmDelete').modal('show');
            $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
            return false;
        });
    });
</script>