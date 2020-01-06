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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/team/list")
public class ShowTeams extends HttpServlet {

    private TeamRepoImpl ioTeam = new TeamRepoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> teams = new ArrayList<>();
        for (Team team : ioTeam.getAll()) {
            teams.add(team.toString());
        }
        req.setAttribute("teams", teams);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/showTeams.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
