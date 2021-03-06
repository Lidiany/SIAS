<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<legend><strong>1. Procura de unidade de atendimento</strong></legend>
<legend>> 1. Procurar por unidade de atendimento</legend>
<div class="input-append">
    <mtw:form action="UnidadeAtendimentoRead.mtw" method="post">
        <label class="control-label"> Unidade Atendimento:
        <mtw:input name="nome" type="text"/>
        </label>
        <a href="UnidadeAtendimentoShowForm.mtw" class="btn">Nova Unidade de Atendimento</a>
        <button class="btn" type="submit">Procurar Unidade de Atendimento</button>
    </mtw:form>
</div>

<legend><strong>> 1. Unidade(s) de Atendimento(s) encontrada(s)</strong></legend>
<div class="tabela">
    <display:table name="lista" id="item" pagesize="15" requestURI="" defaultsort="1" sort="list">
        <display:column class="pull-right" property="numeroUnidade" sortable="true" title="Número da Unidade" style="width:28%;"/>
        <display:column property="nome" sortable="true" title="Nome da Unidade" style="width:42%;"/>
        <display:column property="responsavel" sortable="true" title="Responsável" style="width:15%;"/>
        <display:column value="Ver" href="UnidadeAtendimentoDescricao.mtw" title="Opções" paramId="id" paramProperty="id" style="width:1%;"/>        
        <display:column value="Alterar" href="UnidadeAtendimentoShowForm.mtw" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Excluir" href="UnidadeAtendimentoDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
    </display:table>
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


<div class="control-group">
    <div class="controls">
        <a type="submit" class="btn btn-primary" href="Teste.mtw">Voltar</a>
    </div>
</div>