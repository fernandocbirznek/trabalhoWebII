package controller;
import beans.Categoria;
import beans.Produto;
import facade.FuncionarioFacade;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/hello")
public class ServletFuncionario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "cadastrar":
                    //validaLogin(request,response);
                    insereCadastro(request, response);
                break;
                case "listarCategoria":
                    //validaLogin(request,response);
                    response.sendRedirect("funcionario/listar_categoria.jsp");
                break;
                case "listarProdutos":
                    //validaLogin(request,response);
                    response.sendRedirect("funcionario/listar_produtos.jsp");
                break;
                case "voltar":
                    //validaLogin(request,response);
                    response.sendRedirect("index.jsp");
                break;
                case "voltarFuncionario":
                    //validaLogin(request,response);
                    response.sendRedirect("funcionario/funcionario.jsp");
                break;
                case "adicionarProduto":
                    //validaLogin(request,response);
                    adicionaProduto(request,response);
                break;
                }
            }
    }

    protected void insereCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList categoriasCadastradas = (ArrayList) request.getSession().getAttribute("newCategoria");

        String nome = request.getParameter("nomeCategoria");
        String idCategoria = request.getParameter("idCategoria");
        nome = nome.toUpperCase();
        int id = Integer.parseInt(idCategoria);

        Categoria cat = new Categoria(id,nome);

        if (categoriasCadastradas != null) {
            categoriasCadastradas = FuncionarioFacade.getCategoria(categoriasCadastradas,cat);
            request.getSession().setAttribute("newCategoria", categoriasCadastradas);
            response.sendRedirect("funcionario/listar_categoria.jsp");
        }
        else {
            ArrayList<Categoria> categorias = new ArrayList<>();
            categorias = FuncionarioFacade.getCategoria(categorias, cat);
            request.getSession().setAttribute("newCategoria", categorias);
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

    public void validaLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        //LoginBean login = (LoginBean) session.getAttribute("login");

        //if (session == null) {
        //    RequestDispatcher rd = getServletContext().getRequestDispatcher("/geral/erro.jsp");
        //    request.setAttribute("mensagem", "Erro: " + "Usuário deve estar logado para acessar.");
        //    request.setAttribute("voltar", request.getContextPath() + "/geral/login.jsp");
         //   rd.forward(request, response);
        //    return;
        //} else if (!"Funcionário".equalsIgnoreCase(login.getTipoUsuario())) {
        //    RequestDispatcher rd = getServletContext().getRequestDispatcher("/geral/erro.jsp");
         //   request.setAttribute("mensagem", "Erro: " + "Usuário não possui permissão para acessar a página.");
          //  request.setAttribute("voltar", request.getContextPath() + "/geral/login.jsp");
          //  rd.forward(request, response);
          //  return;
       // }
    }
}

