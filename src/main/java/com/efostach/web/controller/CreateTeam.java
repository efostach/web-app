package com.efostach.web.controller;

import com.efostach.web.model.Team;
import com.efostach.web.repository.hibernate.TeamRepoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/team/create")
public class CreateTeam extends HttpServlet {

    private TeamRepoImpl ioTeam = new TeamRepoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/createTeam.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        Team team = new Team();
        team.setName(name);
        ioTeam.create(team);

        doGet(req, resp);
    }
}
