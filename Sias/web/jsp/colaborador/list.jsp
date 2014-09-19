<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<legend><strong>1. Procura de colaborador</strong></legend>
<legend>> 1. Procura por colaborador</legend>
<div class="input-append">
    <mtw:form action="ColaboradorRead.mtw" method="post">
        <label class="control-label">Colaborador:
            <mtw:input klass="span5" name="nome" type="text"/>
        </label>
        <a href="ColaboradorShowForm.mtw" class="btn">Novo colaborador</a>
        <button class="btn" type="submit">Procurar colaborador</button>
    </mtw:form>
</div>

<legend><strong>> 1. Procura por colaborador - Colaborador(es) encontrado(os)</strong></legend>
<div class="tabela">
    <display:table name="lista" id="item" pagesize="15" requestURI="" defaultsort="1" sort="list">
        <display:column property="id" sortable="true" title="Código" style="width:10%;"/>
        <display:column property="nome" sortable="true" title="Nome" style="width:60%;"/>
        <display:column property="cpf" sortable="true" title="CPF" style="width:20%;"/>
        <display:column value="Ver" href="ColaboradorDescricao.mtw" title="Opções" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Alterar" href="ColaboradorShowForm.mtw" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Excluir" href="ColaboradorDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
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
    $(function(){
        $("td.deleteLink a").click(function(){
            $('#confirmDelete').modal('show');
            $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
            return false; 
        });
    });
</script>