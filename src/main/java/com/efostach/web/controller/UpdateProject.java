package com.efostach.web.controller;

import com.efostach.web.model.Project;
import com.efostach.web.model.ProjectStatus;
import com.efostach.web.repository.hibernate.ProjectRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project/update")
public class UpdateProject extends HttpServlet {

    private ProjectRepoImpl ioProject = new ProjectRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/updateProject.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Project project = ioProject.getById(id);

        project.setStatus(ProjectStatus.COMPLETED);
        ioProject.update(project);

       doGet(req, resp);
    }
}