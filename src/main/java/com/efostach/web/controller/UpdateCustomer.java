package com.efostach.web.controller;

import com.efostach.web.model.Customer;
import com.efostach.web.repository.hibernate.CustomerRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customer/update")
public class UpdateCustomer extends HttpServlet {

    private CustomerRepoImpl ioCustomer = new CustomerRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/updateCustomer.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");

        Customer customer = ioCustomer.getById(id);

        if(!name.equals(""))
            customer.setName(name);

        ioCustomer.update(customer);

       doGet(req, resp);
    }
}