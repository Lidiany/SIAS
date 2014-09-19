<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<legend><strong>1. Procura de UF</strong></legend>
<legend>> 1. Procura por UF</legend>
<div class="input-append">
    <mtw:form action="UfRead.mtw" method="post">
        <label class="control-label"> UF:
            <mtw:input name="nome" type="text"/>
        </label>
        <a href="UfShowForm.mtw" class="btn">Novo UF</a>
        <button class="btn" type="submit">Procurar UF</button>
    </mtw:form>
</div>

<legend><strong>> 1. Procura por UF - UF(s) encontrado(os)</strong></legend>
<div class="tabela">
    <display:table name="lista" id="item" pagesize="15" requestURI="" defaultsort="1" sort="list">
        <display:column property="id" sortName="id" sortable="true" title="Código" style="width:10%;"/>
        <display:column property="nome" sortable="true" title="Nome do Estado" style="width:40%;"/>
        <display:column property="sigla" sortable="true" title="Sigla" style="width:40%;"/>
        <display:column value="Alterar" href="UfShowForm.mtw" title="Opções" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Excluir" href="UfDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
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