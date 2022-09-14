package controller;

import beans.EstadoBeans;
import beans.UsuarioBeans;
import exception.BuscarEstadoException;
import exception.CadastrarNovoClienteException;
import facade.ClienteFacade;
import facade.EstadoCidadeFacade;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CriarContaController", urlPatterns = {"/CriarContaController"})
public class CriarContaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        
        switch(action) {
            case "formCriarConta":
                try {
                    List<EstadoBeans> listaEstados = EstadoCidadeFacade.buscarEstado();
                    request.setAttribute("estados", listaEstados);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/criarConta.jsp");
                    rd.forward(request, response);
                } catch (BuscarEstadoException e) {
                    request.setAttribute("mensagem", "Erro ao acessar criação de conta");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            case "criarConta":
                try {
                    UsuarioBeans novoCliente = new UsuarioBeans();
                    novoCliente.setNomeUsuario(request.getParameter("nomeCompleto"));
                    String cpf = request.getParameter("cpf");
                    cpf = cpf.replace(".", "");
                    cpf = cpf.replace("-", "");
                    novoCliente.setCpfUsuario(cpf);
                    novoCliente.setEmailUsuario(request.getParameter("email"));
                    //TODO, fazer hash senha
                    novoCliente.setSenhaUsuario(request.getParameter("senha"));
                    String telefone = request.getParameter("telefone");
                    telefone = telefone.replace("(", "");
                    telefone = telefone.replace(")", "");
                    telefone = telefone.replace("-", "");
                    novoCliente.setTelefoneUsuario(telefone);
                    novoCliente.setRuaUsuario(request.getParameter("rua"));
                    novoCliente.setNumeroUsuario(request.getParameter("numero"));
                    novoCliente.setComplementoUsuario(request.getParameter("complemento"));
                    novoCliente.setBairroUsuario(request.getParameter("bairro"));
                    String cep = request.getParameter("cep");
                    cep = cep.replace(".", "");
                    cep = cep.replace("-", "");
                    novoCliente.setCepUsuario(cep);
                    //TODO, precisa fazer uma tabela cidades, por hora ta string string
                    novoCliente.setCidadeUsuario(Integer.parseInt(request.getParameter("cidade")));
                    novoCliente.setEstadoUsuario(Integer.parseInt(request.getParameter("estado")));
                    novoCliente.setCargoUsuario(1);
                    ClienteFacade.cadastrarNovoCliente(novoCliente);
                    request.setAttribute("mensagem", "Conta criada com sucesso lol");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                } catch (CadastrarNovoClienteException e) {
                    request.setAttribute("mensagem", "Erro ao cadastrar novo cliente!!!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
            default:
                try {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("mensagem", "Erro na escolha da opção cliente!!!");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                    rd.forward(request, response);
                }
                break;
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
