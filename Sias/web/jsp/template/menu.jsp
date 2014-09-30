<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../WEB-INF/imports.jspf"%>

<body>
    <div class="navbar navbar-inverse">

        <div class="navbar-inner">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">SIAS</a>
            <!-- Responsive Navbar Part 2: Place all navbar contents you want collapsed withing .navbar-collapse.collapse. -->
            <div class="nav-collapse collapse">
                <ul class="nav nav-pills nav-justified">
                    <li class="active"><a href="Teste.mtw">Início</a></li>
                    <li><a href="PessoaRead.mtw">Pessoa</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cadastros<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="ColaboradorRead.mtw">Colaborador</a></li>
                            <li><a href="TipoEspecificidadeSocialRead.mtw">Especificidade Social</a></li>
                            <li><a href="FormaIngressoRead.mtw">Forma Ingresso</a></li>
                            <li><a href="MunicipioRead.mtw">Município</a></li>
                            <li><a href="TipoBeneficioDespesaRead.mtw">Tipo Benefício/Despesa</a></li>
                            <li><a href="TipoDeficienciaRead.mtw">Tipo Deficiência</a></li>
                            <li><a href="TipoEscolaridadeRead.mtw">Tipo Escolaridade</a></li>
                            <li><a href="TipoOcupacaoRead.mtw">Tipo Ocupação</a></li>
                            <li><a href="TipoParentescoRead.mtw">Tipo Parentesco</a></li>
                            <li><a href="UfRead.mtw">UF</a></li>
                            <li><a href="UnidadeAtendimentoRead.mtw">Unidade de Atendimento</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Relatorios</a></li>
                    <li><a href="#">Central de Atendimento</a></li>
                    <li><a href="#">Sair</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!-- /.navbar-inner -->
    </div><!-- /.navbar -->
    <!--
            <div class="container">
    
                <div class="starter-template">
                    <h1>Bootstrap starter template</h1>
                    <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
                </div>
    
            </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
</body>
