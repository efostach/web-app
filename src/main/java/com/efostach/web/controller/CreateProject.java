package com.efostach.web.controller;

import com.efostach.web.model.Project;
import com.efostach.web.repository.hibernate.ProjectRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project/create")
public class CreateProject extends HttpServlet {

    private ProjectRepoImpl ioProject = new ProjectRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createProject.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer budget = Integer.valueOf(req.getParameter("budget"));

        Project project = new Project();
        project.setName(name);
        project.setBudget(budget);

        ioProject.create(project);

        doGet(req, resp);
    }
}
