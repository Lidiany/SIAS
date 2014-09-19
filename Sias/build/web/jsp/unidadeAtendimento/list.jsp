<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<div class="input-append">
    <mtw:form action="UnidadeAtendimentoRead.mtw" method="post">
        <mtw:input name="nome" type="text"/>
        <button class="btn" type="submit"><i class="icon-search"></i> Pesquisar</button>
        <a href="UnidadeAtendimentoShowForm.mtw" class="btn"><i class="icon-plus"></i> Novo</a>
    </mtw:form>
</div>

<div class="tabela">
    <display:table name="lista" id="item" pagesize="3" requestURI="" defaultsort="1" sort="list">
        <display:column property="id" sortable="true" title="Código" style="width:10%;"/>
        <display:column property="nome" sortable="true" title="Nome" style="width:60%;"/>
        <display:column property="numeroUnidade" sortable="true" title="Número Unidade" style="width:40%;"/>
        <display:column property="responsavel" sortable="true" title="Responsavel" style="width:10%;"/>
        <display:column value="<i class=\"icon-edit\"></i>" href="UnidadeAtendimentoShowForm.mtw" title="Opções" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="<i class=\"icon-trash\"></i>" href="UnidadeAtendimentoDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="<i class=\"icon-list-alt\"></i>" href="" class="listLink" paramId="id" paramProperty="id" style="width:5%;"/>
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