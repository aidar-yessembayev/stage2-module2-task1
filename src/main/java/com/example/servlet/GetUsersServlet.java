package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Warehouse warehouse = Warehouse.getInstance();
        Set<User> users = warehouse.getUsers();

        request.setAttribute("users", users);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/users.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
