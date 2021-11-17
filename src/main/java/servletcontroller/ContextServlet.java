package servletcontroller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class ContextServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws SecurityException, IOException, ServletException {
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("name", "name");
        servletContext.setAttribute("age", 35);
        getServletContext().getRequestDispatcher("/pages/setupdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie name = new Cookie("name", req.getParameter("name"));
        name.setMaxAge(3600); //время хранения кукии. Работает для непосредственно присвоенного объекта перед ним
        resp.addCookie(name);
        Cookie country = new Cookie("country", req.getParameter("country"));
        resp.addCookie(country); // здесь выше работа с куки, ниже сервлеты и вывод в бейсик

        ServletContext context = getServletContext();
        context.setAttribute("country", req.getParameter("country"));
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("age", req.getParameter("age"));
        req.setAttribute("gender", req.getParameter("gender"));

        getServletContext().getRequestDispatcher("/pages/basic.jsp").forward(req, resp);
    }
}
