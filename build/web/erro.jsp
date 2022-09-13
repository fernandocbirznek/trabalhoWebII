<%-- 
    Document   : erro
    Created on : 04/09/2022, 11:25:01
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel='stylesheet' type='text/css' href="indexCss.scss">
        <style>
            .mensagem {
                color: red;
                font-size: 28px;
            }
            .container-mensagem {
                margin-top: 70px;
                height: 400px;
            }
            .container {
                background-color: #D1D1D1;
            }
        </style>
    </head>
    <body>
        <div class="container conteudo">
            <div class="row align-items-center container-detalhe">
                <div class="col">
                    <div class="column justify-content-center container-mensagem">
                        <div class="mensagem">${mensagem}</div>
                        <a href="index.jsp">Voltar para Home</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
