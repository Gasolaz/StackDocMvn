package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ErrorHandler")
public class ErrorHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath());
    }

//    private void processError(HttpServletRequest request,
//                              HttpServletResponse response) throws ServletException, IOException {
//        Throwable throwable = (Throwable) request
//                .getAttribute("javax.servlet.error.exception");
//        Integer statusCode = (Integer) request
//                .getAttribute("javax.servlet.error.status_code");
//        String servletName = (String) request
//                .getAttribute("javax.servlet.error.servlet_name");
//        if (servletName == null) {
//            servletName = "Unknown";
//        }
//        String requestUri = (String) request
//                .getAttribute("javax.servlet.error.request_uri");
//        if (requestUri == null) {
//            requestUri = "Unknown";
//        }
//        request.setAttribute("error", "Servlet " + servletName +
//                " has thrown an exception " + throwable.getClass().getName() +
//                " : " + throwable.getMessage());
//        request.getRequestDispatcher("ErrorHandler.jsp").forward(request, response);
//    }
}