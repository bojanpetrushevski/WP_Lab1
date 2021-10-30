package finki.ukim.mk.lab.web;

import finki.ukim.mk.lab.model.Order;
import finki.ukim.mk.lab.service.OrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Confirmation Info Servlet", urlPatterns = "/ConfirmationInfo")
public class ConfirmationInfoServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final OrderService orderService;

    public ConfirmationInfoServlet(SpringTemplateEngine springTemplateEngine, OrderService orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req,resp,req.getServletContext());
        String clientName = req.getParameter("clientName");
        String clientAddress = req.getParameter("clientAddress");
        String balloonColor = (String) req.getSession().getAttribute("balloonColor");
        String balloonSize = (String) req.getSession().getAttribute("balloonSize");

        if (clientName == null ||  clientAddress == null || balloonColor == null || balloonSize == null) {
            throw new IllegalArgumentException();
        }

        Order order = orderService.placeOrder(balloonColor, balloonSize, clientName, clientAddress);
        context.setVariable("order", order);
        context.setVariable("clientIpAddress", req.getRemoteAddr());
        context.setVariable("clientBrowser", req.getHeader("User-Agent"));
        this.springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
    }
}
