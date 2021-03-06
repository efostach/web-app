package com.efostach.web.controller;

import com.efostach.web.model.Project;
import com.efostach.web.model.Team;
import com.efostach.web.repository.hibernate.ProjectRepoImpl;
import com.efostach.web.repository.hibernate.TeamRepoImpl;

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

@WebServlet("/project/create")
public class CreateProject extends HttpServlet {

    private ProjectRepoImpl ioProject = new ProjectRepoImpl();
    private TeamRepoImpl ioTeam = new TeamRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createProject.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer budget = Integer.valueOf(req.getParameter("budget"));
        String team = req.getParameter("team");

        Project project = new Project();
        project.setName(name);
        project.setBudget(budget);

        if (!team.equals("")) {
            List<Team> teams = new ArrayList<>();
            if (ioTeam.getById(Integer.valueOf(team)) != null) {
                teams.add(ioTeam.getById(Integer.valueOf(team)));
            } else
                req.setAttribute("warning_msg", REF_OBJ_NOT_EXISTS_WARN_MSG);
            project.setTeams(teams);
        } else
            req.setAttribute("warning_msg", REF_OBJ_NOT_EXISTS_WARN_MSG);

        ioProject.create(project);

        doGet(req, resp);
    }
}
