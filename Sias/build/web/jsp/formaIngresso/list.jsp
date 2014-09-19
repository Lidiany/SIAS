<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<div class="input-append">
    <mtw:form action="FormaIngressoRead.mtw" method="post">
        <mtw:input name="descricao" type="text"/>
        <button class="btn" type="submit"><i class="icon-search"></i> Pesquisar</button>
        <a href="FormaIngressoShowForm.mtw" class="btn"><i class="icon-plus"></i> Novo</a>
    </mtw:form>
</div>

<div class="tabela">
    <display:table name="lista" id="item" pagesize="3" requestURI="" defaultsort="1" sort="list">
        <display:column property="codigo" sortable="true" title="Código" style="width:10%;"/>
        <display:column property="descricao" sortable="true" title="Descrição" style="width:60%;"/>
        <display:column property="ativo" sortable="true" title="Ativo" style="width:20%;"/>
        <display:column value="<i class=\"icon-edit\"></i>" href="FormaIngressoShowForm.mtw" title="Opções" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="<i class=\"icon-trash\"></i>" href="FormaIngressoDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
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
    $(function(){
        $("td.deleteLink a").click(function(){
            $('#confirmDelete').modal('show');
            $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
            return false; 
        });
    });
</script>