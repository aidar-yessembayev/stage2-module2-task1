package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/add.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");

        User user = new User(fName, lName);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.addUser(user);

        request.setAttribute("user", user);

        try {
            response.sendRedirect("/add");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
