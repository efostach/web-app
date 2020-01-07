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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/customer/list")
public class ShowCustomer extends HttpServlet {

    private CustomerRepoImpl ioCustomer = new CustomerRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> customers = new ArrayList<>();
        for (Customer customer : ioCustomer.getAll()) {
            customers.add(customer.toString());
        }
        req.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/showCustomers.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
