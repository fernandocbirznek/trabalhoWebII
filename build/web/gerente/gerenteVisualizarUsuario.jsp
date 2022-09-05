<%-- 
    Document   : gerenteVisualizarUsuario
    Created on : 25/08/2022, 15:40:00
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar usuário</title>
        <link rel='stylesheet' type='text/css' href="../indexCss.scss">
        <link rel='stylesheet' type='text/css' href="gerenteCss.scss">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script type="text/javascript" src="gerenteJS.js" defer></script>
    </head>
    <body class="imagem">
        <c:if test="${empty sessionScope.logado}" >
            <c:set var="msg" value="Precisa fazer o login" scope="request" />
            <jsp:forward page="index.jsp" />
        </c:if>
        
        <form>
            <div class="row">
                <div class="col-6">
                    <div class="form-group">
                        <label for="nomeCompleto">Nome Completo</label>
                        <input class="form-control" type="text" placeholder="Nome completo" name="nomeCompleto" value="${usuario.getNomeUsuario()}" readonly>
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="cpf">CPF</label>
                        <input type="text" class="form-control" onkeypress="$(this).mask('000.000.000-00');" placeholder="000.000.000-00" name="cpf" value="${usuario.getCpfUsuario()}" readonly>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-6">
                    <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" aria-describedby="emailHelp" placeholder="Enter email" name="email" value="${usuario.getEmailUsuario()}" readonly>
                </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-6">
                    <label for="telefone">Telefone/Celular</label>
                    <input type="text" class="form-control" onkeypress="$(this).mask('(00) 0000-00009');" placeholder="(00) 0000-00000" name="telefone" value="${usuario.getTelefoneUsuario()}" readonly>
                </div>
            </div>
            <div class="row">
                <div class="col-8">
                    <div class="form-group">
                        <label for="rua">Rua</label>
                        <input class="form-control" type="text" placeholder="Nome completo" name="rua" value="${usuario.getRuaUsuario()}" readonly>
                    </div>
                </div>
                <div class="col-2">
                    <div class="form-group">
                        <label for="numero">Número</label>
                        <input type="number" class="form-control" name="numero" value="${usuario.getNumeroUsuario()}" readonly>
                    </div>
                </div>
                <div class="col-2">
                    <div class="form-group">
                        <label for="complemento">Complemento</label>
                        <input type="text" class="form-control" name="complemento" value="${usuario.getComplementoUsuario()}" readonly>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-3">
                    <div class="form-group">
                        <label for="bairro">Bairro</label>
                        <input class="form-control" type="text" name="bairro" value="${usuario.getBairroUsuario()}" readonly>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-group">
                        <label for="cep">CEP</label>
                        <input type="text" class="form-control" onkeypress="$(this).mask('00.000-000')" placeholder="00.000-000" name="cep" value="${usuario.getCepUsuario()}" readonly>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-group">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="estado">Estado</label>
                            <input type="text" class="form-control" name="estado" value="${usuario.getEstadoUsuario()}" readonly>
                        </div>
                    </div>
                </div>
                <div class="col-3">
                    <div class="form-group">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="cidade">Cidade</label>
                            <input type="text" class="form-control" name="cidade" value="${usuario.getCidadeUsuario()}" readonly>
                        </div>
                    </div>
                </div>
            </div>
            <a href="GerenteController" class="btn btn-secondary">Voltar</a>
        </form>
    </body>
</html>
