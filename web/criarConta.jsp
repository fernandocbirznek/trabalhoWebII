<%-- 
    Document   : criarConta
    Created on : 09/09/2022, 18:48:26
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar conta</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel='stylesheet' type='text/css' href="indexCss.scss">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        
        <style>
            .imagem {
                height: 100%;
            }
            .conteudo {
                background-color: #9e9e9e;
            }
        </style>
        <script>
            $(document).ready(function() {
                $( "#estado" ).change(function() {
                    getCidades();
                });
            });
            
            function getCidades() {
                var estadoId = $("#estado").val();
                var url = "AJAXController";
                $.ajax({
                    url : url, // URL 
                    data : {
                        estadoId : estadoId
                    }, // Parâmetro passado para a Servlet
                    dataType : 'json',
                    success : function(data) {
                        // Se sucesso, limpa e preenche a combo de cidade
                        // alert(JSON.stringify(data));
                        $("#cidade").empty();
                        $.each(data, function(i, obj) {
                            $("#cidade").append('<option value=' + obj.id + '>' + obj.nome + '</option>');
                        });
                    },
                    error : function(request, textStatus, errorThrown) {
                        alert(request.status + ', Error: ' + request.statusText);
                        // Erro
                    }
                });
            }
        </script>
    </head>
    <body class="imagem">
        <div class="container conteudo">
            <form action="CriarContaController?action=criarConta" method="POST">
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                            <label for="nomeCompleto">Nome Completo</label>
                            <input class="form-control" type="text" placeholder="Nome completo" name="nomeCompleto">
                        </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="cpf">CPF</label>
                            <input type="text" class="form-control" onkeypress="$(this).mask('000.000.000-00');" placeholder="000.000.000-00" name="cpf">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" aria-describedby="emailHelp" placeholder="Enter email" name="email">
                    </div>
                    </div>
                    <div class="col-6">
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control" placeholder="Password" name="senha">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="telefone">Telefone/Celular</label>
                        <input type="text" class="form-control" onkeypress="$(this).mask('(00) 0000-00009');" placeholder="(00) 0000-00000" name="telefone">
                    </div>
                </div>
                <div class="row">
                    <div class="col-8">
                        <div class="form-group">
                            <label for="rua">Rua</label>
                            <input class="form-control" type="text" placeholder="Nome completo" name="rua">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <label for="numero">Número</label>
                            <input type="number" class="form-control" name="numero">
                        </div>
                    </div>
                    <div class="col-2">
                        <div class="form-group">
                            <label for="complemento">Complemento</label>
                            <input type="text" class="form-control" name="complemento">
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <div class="form-group">
                            <label for="bairro">Bairro</label>
                            <input class="form-control" type="text" name="bairro">
                        </div>
                    </div>
                    <div class="col-3">
                        <div class="form-group">
                            <label for="cep">CEP</label>
                            <input type="text" class="form-control" onkeypress="$(this).mask('00.000-000')" placeholder="00.000-000" name="cep">
                        </div>
                    </div>                                          
                    <div class="input-group form-group col-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="estado">Estado</label>
                        </div>
                        <select class="custom-select" id="estado" name="estado">
                            <option selected>Escolha...</option>
                            <c:forEach var="estado" items="${estados}">
                                <option value="${estado.getId()}">${estado.getNome()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group form-group col-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="cidade">Cidade</label>
                        </div>
                        <select class="custom-select" id="cidade" name="cidade">
                            <option selected>Escolha...</option>
                        </select>
                    </div>

                </div>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
    </body>
</html>
