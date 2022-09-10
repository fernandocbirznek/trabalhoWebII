package funcionario.controller;
import funcionario.model.Categoria;
import funcionario.model.Produto;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@WebServlet("/hello")
public class ServletFuncionario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String action = request.getParameter("action");
    if (action != null) {
        switch (action) {
            case "cadastrar":
                insereCadastro(request, response);
            break;
            case "listarCategoria":
                response.sendRedirect("funcionario/listar_categoria.jsp");
            break;
            case "listarProdutos":
                response.sendRedirect("funcionario/listar_produtos.jsp");
            break;
            case "voltar":
                response.sendRedirect("index.jsp");
            break;
            case "voltarFuncionario":
                response.sendRedirect("funcionario/funcionario.jsp");
            break;
            case "adicionarProduto":
                adicionaProduto(request,response);
            break;
            }
        }
    }


    protected void insereCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nomeCategoria");
        ArrayList teste = new ArrayList<Categoria>();
        ArrayList pego = (ArrayList) request.getSession().getAttribute("newCategoria");

        nome = nome.toUpperCase();
        String idCategoria = request.getParameter("idCategoria");
        int id = Integer.parseInt(idCategoria);
        Categoria cat = new Categoria(id,nome);
        if (pego != null) {
            pego.add(cat);
            request.getSession().setAttribute("newCategoria", pego);
            response.sendRedirect("funcionario/listar_categoria.jsp");
        }
        else {
            teste.add(cat);
            request.getSession().setAttribute("newCategoria", teste);
            response.sendRedirect("funcionario/listar_categoria.jsp");
        }
    }

    protected void adicionaProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nome = request.getParameter("nomeProduto");
        String idProduto = request.getParameter("idProduto");
        String peso = request.getParameter("pesoProduto");
        String descricao = request.getParameter("descriProduto");


        ArrayList listaProdp = new ArrayList<Produto>();
        ArrayList listaProd = (ArrayList) request.getSession().getAttribute("newProduto");

        nome = nome.toUpperCase();
        int id = Integer.parseInt(idProduto);
        Produto prod = new Produto(id,nome,descricao,peso);

        if (listaProd != null) {
            listaProd.add(prod);
            request.getSession().setAttribute("newProduto", listaProd);
            response.sendRedirect("funcionario/listar_produtos.jsp");
        }
        else {
            listaProdp.add(prod);
            request.getSession().setAttribute("newProduto", listaProdp);
            response.sendRedirect("funcionario/listar_produtos.jsp");
        }
    }

}

