package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        
        //TODO, Buscar no banco de dados usuário
        //Retirar variavel abaixo ao buscar na base o usuario
        String usuario = "cliente";
        
        switch(usuario) {
            case "cliente":
                request.setAttribute("action", "listarAtendimentosCliente");
                rd = getServletContext().getRequestDispatcher("/ClienteController");
                rd.forward(request, response);
                break;
            case "funcionario":
                request.setAttribute("action", "listarAtendimentosCliente");
                rd = getServletContext().getRequestDispatcher("/FuncionarioController");
                rd.forward(request, response);
                break;
            case "gerente":
                request.setAttribute("action", "listarAtendimentosCliente");
                rd = getServletContext().getRequestDispatcher("/GerenteController");
                rd.forward(request, response);
                break;
            default:
                //TODO, criar página de erro
                request.setAttribute("action", "listarAtendimentosCliente");
                rd = getServletContext().getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
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
