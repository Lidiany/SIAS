<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<div class="input-append">
    <mtw:form action="DeficienciaPessoaRead.mtw" method="post">
        <a href="DeficienciaPessoaShowForm.mtw" class="btn">Nova deficiencia</a>
    </mtw:form>
</div>

<legend><strong>> 1. Deficiencia(s) encontrada(s)</strong></legend>
<div class="tabela">
    <display:table name="lista" id="item" pagesize="15" requestURI="" defaultsort="1" sort="list">
        <display:column property="tipoDeficiencia.descricao" sortable="true" title="Tipo de Deficiência" style="width:45%;"/>
        <display:column property="descricao" sortable="true" title="Descrição" style="width:29%;"/>
        <display:column value="Ver" href="" title="Opções" paramId="id" paramProperty="id" style="width:1%;"/>
        <display:column value="Alterar" href="" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Excluir" href="" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
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