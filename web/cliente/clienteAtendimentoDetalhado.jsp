<%-- 
    Document   : clienteAtendimentoDetalhado
    Created on : 12/09/2022, 18:32:02
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel='stylesheet' type='text/css' href="http://localhost:8080/trabalho/indexCss.scss">
        <link rel='stylesheet' type='text/css' href="http://localhost:8080/trabalho/cliente/clienteCss.scss">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script type="text/javascript" src="http://localhost:8080/trabalho/cliente/clienteJS.js" defer></script>
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/jquery-migrate-3.4.0.js"></script>
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        <style>
            .container-detalhe {
                margin-top: 100px;
            }
        </style>
    </head>
    <body class="imagem">
        <c:if test="${empty sessionScope.logado}" >
            <c:set var="mensagem" value="Precisa fazer o login" scope="request" />
            <jsp:forward page="erro.jsp" />
        </c:if>
        <div class="container conteudo">
            <div class="row align-items-center container-detalhe">
                <div class="col">
                    <div class="column justify-content-center">
                        <div>Dados do Atendimento:</div>
                        <div>Id: ${atendimento.getIdAtendimento()}</div>
                        <div>Data: ${atendimento.getDataAtendimento()}</div>
                        <div>Descricao: ${atendimento.getDescricaoAtendimento()}</div>
                        <div>Solucao: ${atendimento.getSolucaoAtendimento()}</div>
                        <div>Tipo atendimento: ${atendimento.getTipoAtendimentoString()}</div>
                        <div>Situação: 
                            <c:choose>
                                <c:when test="${atendimento.getSituacaoAtendimento() == false}">
                                    Em aberto
                                </c:when>
                                <c:otherwise>
                                    Procedimento realizado
                                </c:otherwise>
                            </c:choose></div>
                        <div class="button">
                            <a href="ClienteController?action=listarAtendimentosCliente">Voltar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
