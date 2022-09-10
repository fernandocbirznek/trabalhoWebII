<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Listar Categoria</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel='stylesheet' type='text/css' href="indexCss.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="imagem" id="pagina">
        <div class="container-fluid conteudo">
            <div class="header">
                <div class="titulo">
                    LISTAR ATENDIMENTOS <br>
                    <br>
                </div>                
                <div class="botoes">

                    <button type="button" data-toggle="modal" data-target="#criarConta" class="botao botao-acessar">
                        Novo Atendimento
                    </button>
                    <br>

                    <form action="${pageContext.request.contextPath}/hello?action=listarCategoria" method="post">
                        <button name = "submit" type="submit" value="listarCategoria" class="botao botao-acessar">
                            Listar categoria
                        </button>
                    </form>

                    <form action="${pageContext.request.contextPath}/hello?action=listarProdutos" method="post">
                        <button name = "submit" type="submit" value="listarProdutos" class="botao botao-acessar">
                            Listar Produtos
                        </button>
                    </form>

                    <form action="${pageContext.request.contextPath}/hello?action=voltar" method="post">
                        <button name = "submit" type="submit" value="voltar" class="botao botao-criar">
                            Voltar
                        </button>
                    </form>

                </div>
            </div>

            <div class="informacao">
                <div class="row">
                    <div class="col-12">
                        
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">Cliente</th>
                                    <th scope="col">Situação do atendimento</th>
                                    <th scope="col">Data/Hora</th>
                                    <th scope="col">Data de abertura</th>
                                    <th scope="col">Detalhes</th>
                                    <th scope="col" id="acao">Comando</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">Fulano Fulano</th>
                                    <td>Aberto</td>
                                    <th scope="row">09/10/1999 10:00</th>
                                    <td>09/10/1999 10:00</td>
                                    <th scope="row"><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Mais Detalhes</button></th>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Editar</button></td>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#acessarSistema">Excluir</button></td>
                                </tr>
                                <tr>
                                    <th scope="row">Fulano Fulano</th>
                                    <td>Aberto</td>
                                    <th scope="row">09/10/1999 10:00</th>
                                    <td>09/10/1999 10:00</td>
                                    <th scope="row"><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Mais Detalhes</button></th>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Editar</button></td>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#acessarSistema">Excluir</button></td>
                                </tr>
                                <tr>
                                    <th scope="row">Fulano Fulano</th>
                                    <td>Aberto</td>
                                    <th scope="row">09/10/1999 10:00</th>
                                    <td>09/10/1999 10:00</td>
                                    <th scope="row"><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Mais Detalhes</button></th>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Editar</button></td>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#acessarSistema">Excluir</button></td>
                                </tr>
                                <tr>
                                    <th scope="row">Fulano Fulano</th>
                                    <td>Fechado</td>
                                    <th scope="row">09/10/1999 10:00</th>
                                    <td>09/10/1999 10:00</td>
                                    <th scope="row"><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Mais Detalhes</button></th>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Editar</button></td>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#acessarSistema">Excluir</button></td>
                                </tr>
                                <tr>
                                    <th scope="row">Fulano Fulano</th>
                                    <td>Fechado</td>
                                    <th scope="row">09/10/1999 10:00</th>
                                    <td>09/10/1999 10:00</td>
                                    <th scope="row"><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Mais Detalhes</button></th>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Editar</button></td>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#acessarSistema">Excluir</button></td>
                                </tr>
                            </tbody>
                        </table>
                        
                    </div>
                    
                </div>
            </div>
            <div class="footer">
                <p class="titulo">BEIBE</p>
                <div class="endereco-footer">
                    <span class="endereco">Rua do Embuste, 1313 </span>
                    <span class="endereco">Curitiba, PR, 13131-313 </span>
                    <span class="endereco">(41) 9 1313-1313 </span>
                </div>
            </div>
        </div>
    </body>
    <script src="js/js.js"></script>
</html>


<div class="modal fade bd-example-modal-lg" id="acessarSistema" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Tem certeza que deseja exluir?</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <button type="submit" class="btn btn-primary" id="sim">Sim</button>
                </form>
                <form>
                    <button type="submit" class="btn btn-primary" id="nao">Não</button>
                </form>
                
            </div>
        </div>
    </div>
</div>

<div class="modal fade bd-example-modal-lg" id="criarConta" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Acessar Sistema</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                
                <form>
                    <div class="row">
                        <div class="col-12">
                            <div class="form-group">
                                <label>ID categoria</label>
                                <input class="form-control" type="text" placeholder="Nome completo" value="232131">
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="form-group">
                                <label>Nome Categoria</label>
                                <input type="text" class="form-control" placeholder="000.000.000-00">
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </form>
                
            </div>
        </div>
    </div>
</div>