<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<legend><strong>1. Procura de Município</strong></legend>
<legend>> 1. Procurar por município</legend>
<div class="input-append">
    <mtw:form action="MunicipioRead.mtw" method="post">
        <label class="control-label"> Município:
            <mtw:input name="nome" type="text"/>
        </label>
        <a href="MunicipioShowForm.mtw" class="btn">Novo município</a>
        <button class="btn" type="submit">Procurar município</button>
    </mtw:form>
</div>

<legend><strong>> 1. Município(s) encontrado(s)</strong></legend>
<div class="tabela">
    <display:table name="lista" id="item" pagesize="15" requestURI="" defaultsort="1" sort="list">
        <display:column property="nome" sortable="true" title="Município" style="width:70%;"/>
        <display:column property="uf.sigla" sortable="true" title="UF" style="width:20%;"/>
        <display:column value="Alterar" href="MunicipioShowForm.mtw" title="Opções" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Excluir" href="MunicipioDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
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