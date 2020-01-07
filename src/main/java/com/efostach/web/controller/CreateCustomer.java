package com.efostach.web.controller;

import com.efostach.web.model.Customer;
import com.efostach.web.model.Project;
import com.efostach.web.repository.hibernate.CustomerRepoImpl;
import com.efostach.web.repository.hibernate.ProjectRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.efostach.web.controller.ControllerUtil.REF_OBJ_NOT_EXISTS_WARN_MSG;

@WebServlet("/customer/create")
public class CreateCustomer extends HttpServlet {

    private CustomerRepoImpl ioCustomer = new CustomerRepoImpl();
    private ProjectRepoImpl ioProject = new ProjectRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createCustomer.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String project = req.getParameter("project");

        Customer customer = new Customer();
        customer.setName(name);

        if (!project.equals("")) {
            List<Project> projects = new ArrayList<>();
            if (ioProject.getById(Integer.valueOf(project)) != null) {
                projects.add(ioProject.getById(Integer.valueOf(project)));
            } else
                req.setAttribute("warning_msg", REF_OBJ_NOT_EXISTS_WARN_MSG);
            customer.setProjects(projects);
        } else
            req.setAttribute("warning_msg", REF_OBJ_NOT_EXISTS_WARN_MSG);

        ioCustomer.create(customer);

        doGet(req, resp);
    }
}