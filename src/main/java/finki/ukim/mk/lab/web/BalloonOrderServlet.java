package finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Balloon Order Servlet", urlPatterns = "/BalloonOrder.do")
public class BalloonOrderServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;

    public BalloonOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String size = req.getParameter("size");
        if (size == null){
            throw new IllegalArgumentException();
        }

        req.getSession().setAttribute("balloonSize", size);

        String balloonColor = (String)req.getSession().getAttribute("balloonColor");

        WebContext context = new WebContext(req,resp,req.getServletContext());
        context.setVariable("balloonColor", balloonColor);
        context.setVariable("balloonSize", size);

        this.springTemplateEngine.process("deliveryInfo.html", context, resp.getWriter());
    }
}
