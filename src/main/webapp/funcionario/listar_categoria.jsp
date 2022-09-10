<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

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
    <body class="imagem">
        <div class="container-fluid conteudo">
            <div class="header">
                <div class="titulo">
                    LISTAR CATEGORIA <br>
                    <br>
                </div>
                <div class="botoes">
                    <button type="button" data-toggle="modal" data-target="#criarConta" class="botao botao-acessar">
                        Nova Categoria
                    </button>

                    <form action="${pageContext.request.contextPath}/hello?action=voltarFuncionario" method="post">
                        <button name = "submit" type="submit" value="voltarFuncionario" class="botao botao-criar">
                            Voltar
                        </button>
                    </form>
                    
                    <div class="modal fade bd-example-modal-lg" id="acessarSistema" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog modal-lg" role="document">
                           <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">Tem certeza que deseja exluir?</h5>
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
                                    <h5 class="modal-title" id="exampleModalLongTitle">Acessar Sistema</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                 
                                    <form action="${pageContext.request.contextPath}/hello?action=cadastrar" method="post" >
                                        <div class="row">
                                            <div class="col-12">
                                                <div class="form-group">
                                                    <label>ID categoria</label>
                                                    <input name="idCategoria" class="form-control" type="text" placeholder="idCategoria" value="232131">
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <div class="form-group">
                                                    <label>Nome Categoria</label>
                                                    <input name="nomeCategoria" type="text" class="form-control" placeholder="000.000.000-00">
                                                </div>
                                            </div>
                                        </div>
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                        <button name = "submit" value = "cadastrar" type="submit" class="btn btn-primary">Cadastrar</button>
                                    </form>
                                </div>
                           </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            <div class="informacao">
                <div class="row">
                    <div class="col-12">
                        
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col">ID Categoria</th>
                                    <th scope="col">Nome Categoria</th>
                                    <th scope="col" id="acao">Ação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="categorias" varStatus="cont" items="${sessionScope.newCategoria}">
                                    <tr>
                                    <th scope="row"><c:out value="${categorias.id}"/></th>
                                    <td><c:out value="${categorias.nome}"/></td>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#criarConta">Editar</button></td>
                                    <td><button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#acessarSistema">Excluir</button></td>
                                    </tr>
                                </c:forEach>
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
</html>
