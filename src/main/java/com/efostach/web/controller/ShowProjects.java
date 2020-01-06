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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/project/list")
public class ShowProjects extends HttpServlet {

    private ProjectRepoImpl ioProject = new ProjectRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> projects = new ArrayList<>();
        for (Project project : ioProject.getAll()) {
            projects.add(project.toString());
        }
        req.setAttribute("projects", projects);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/showProjects.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
