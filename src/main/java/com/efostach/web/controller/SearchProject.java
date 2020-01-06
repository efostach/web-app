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

import static com.efostach.web.controller.Util.EMPTY_INPUT_VALUE_WARN_MSG;
import static com.efostach.web.controller.Util.OBJ_NOT_FOUND_WARN_MSG;

@WebServlet("/project/search")
public class SearchProject extends HttpServlet {

    private ProjectRepoImpl ioProject = new ProjectRepoImpl();
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/searchProject.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!req.getParameter("id").isEmpty()) {
            Integer id = Integer.valueOf(req.getParameter("id"));

            Project project = ioProject.getById(id);
            if (project == null) {
                req.setAttribute("warning_msg", OBJ_NOT_FOUND_WARN_MSG);
            }
            req.setAttribute("project", project);
        } else
            req.setAttribute("warning_msg", EMPTY_INPUT_VALUE_WARN_MSG);
        doGet(req, resp);
    }
}
