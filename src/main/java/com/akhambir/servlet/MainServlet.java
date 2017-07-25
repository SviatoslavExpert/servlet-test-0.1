package com.akhambir.servlet;

import com.akhambir.controller.UserController;
import com.akhambir.factory.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private UserController userController;

    public void init() {
        userController = Factory.getUserController();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/home")) {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        }

        if (request.getMethod().equals("GET") && request.getRequestURI().equals("/login")) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

        if (request.getMethod().equals("POST") && request.getRequestURI().equals("/login")) {
            userController.getUser(request, response);
        }
    }
}
