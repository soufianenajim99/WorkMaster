package org.workmaster.workmaster.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "/test",value = "/test")
public class TestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var name = request.getParameter("name");

        if (name == null || name.isBlank()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        var greeting = "Hello Monsieur!, " + name + "!";

        response.setContentType("text/plain");
        response.getWriter().write(greeting);
    }
}
