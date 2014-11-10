<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<legend><strong>1. Procura de benefício/despesa</strong></legend>
<legend>> 1. Procurar por benefício/despesa</legend>
<div class="input-append">
    <mtw:form action="TipoBeneficioDespesaRead.mtw" method="post">
        <label class="control-label"> Benefício/Despesa:
            <mtw:input name="descricao" type="text"/>
        </label>
        <a href="TipoBeneficioDespesaShowForm.mtw" class="btn">Novo benefício/despesa</a>
        <button class="btn" type="submit">Procura benefício/despesa</button>
    </mtw:form>
</div>

<legend><strong>> 1. Benefício(s) / Despesa(s) encontrado(s)</strong></legend>
<div class="tabela">
    <display:table name="lista" id="item" pagesize="15" requestURI="" defaultsort="1" sort="list">
        <display:column property="tipo" sortable="true" title="Tipo" style="width:40%;"/>
        <display:column property="descricao" sortable="true" title="Descrição" style="width:50%;"/>
        <display:column value="Alterar" href="TipoBeneficioDespesaShowForm.mtw" title="Opções" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Excluir" href="TipoBeneficioDespesaDelete.mtw" class="deleteLink" paramId="id" paramProperty="id" style="width:5%;"/>
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