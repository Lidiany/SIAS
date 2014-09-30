<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<legend><strong>> 2. Cadastro de família/indíviduo > 2.2 Composição Familiar</strong></legend>
<a href="PessoaShowForm.mtw" class="btn">Novo membro familiar</a>

<div class="tabela">
    <display:table name="lista" id="item" pagesize="15" requestURI="" defaultsort="1" sort="list">
        <display:column class="pull-right" property="numeroOrdem" sortable="true" title="Número de Ordem"  style="width:25%;"/>
        <display:column property="nome" sortable="true" title="Nome" style="width:15%;"/>
        <display:column property="sexo" sortable="true" title="Sexo" style="width:10%;"/>
        <display:column class="pull-right" property="idade" sortable="true" title="Idade" style="width:10%;"/>
        <display:column property="tipoParentesco.descricao" sortable="true" title="Parentesco" style="width:20%;"/>
        <display:column value="Ver" href="PessoaDescricao.mtw" title="Opções" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Alterar" href="PessoaShowForm.mtw" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Excluir" href="PessoaDelete.mtw" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Escolaridade" href="PessoaMembroEscolaridade.mtw" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Saúde" href="PessoaSaude.mtw" paramId="id" paramProperty="id" style="width:5%;"/>
        <display:column value="Trabalho/Renda" href="PessoaTrabalhoRenda.mtw" paramId="id" paramProperty="id" style="width:5%;"/>

    </display:table>
</div>

<div class="control-group">
    <div class="controls">
        <a type="submit" class="btn btn-primary" href="PessoaRead.mtw">Voltar</a>
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