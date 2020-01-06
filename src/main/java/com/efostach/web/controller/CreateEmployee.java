package com.efostach.web.controller;

import com.efostach.web.model.Employee;
import com.efostach.web.repository.hibernate.EmployeeRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employee/create")
public class CreateEmployee extends HttpServlet {

    private EmployeeRepoImpl ioEmployee = new EmployeeRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createEmployee.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        Integer specialty = Integer.valueOf(req.getParameter("specialty"));

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSpecialty(specialty);
        ioEmployee.create(employee);

        doGet(req, resp);
    }
}