package br.com.crescer.aula05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametro = req.getParameter("pessoa.nome");
        try (final PrintWriter out = resp.getWriter();) {
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            out.append("<h1>Pessoa ").append(parametro).append("</h1>");
            out.append("</body>");
            out.append("</html>");
        }
    }    
}
