<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<legend><strong>1. Procura de especificidade social</strong></legend>
<legend>> 1. Procura por especificidade social</legend>
<div class="input-append">
    <mtw:form action="TipoEspecificidadeSocialRead.mtw" method="post">
        <label class="control-label"> Especificidade Social:
            <mtw:input name="descricao" type="text"/>
        </label>>
        <a href="TipoEspecificidadeSocialShowForm.mtw" class="btn">Novo especificidade social</a>
        <button class="btn" type="submit">Procurar especificidade social</button
    </mtw:form>
</div>

<legend><strong>> 1. Procura por especificidade social - Especificidade(es) Social(ais) encontrada(as)</strong></legend>
<div class="tabela">
    <display:table name="lista" id="item" pagesize="15" requestURI="" defaultsort="1" sort="list">
        <display:column property="id" sortName="id" sortable="true" title="Código" style="width:10%;"/>
        <display:column property="descricao" sortable="true" title="Descrição" style="width:80%;"/>
        <display:column value="Alterar" href="TipoEspecificidadeSocialShowForm.mtw" title="Opções" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Excluir" href="TipoEspecificidadeSocialDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
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