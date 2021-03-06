package Controller;

import Services.Implementation.AccountService;
import command.Command;
import command.Factory;
import command.Page;
import exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {
private AccountService accountService=new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doWork(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doWork(req,resp);

    }
    private void doWork(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String commandType=req.getParameter("command");
        Factory factory=new Factory();
       Command command =factory.getCommand(commandType);
        try {
            Page page = command.execute(req);
            if (page.isRedirect()){
                doRedirect(req,resp,page.getUrl());
            }else {doForward(req,resp,page.getUrl());}
        }catch (ServiceException e){
            throw new ServletException(e);
        }

    }

    private void doRedirect(HttpServletRequest req, HttpServletResponse resp,String url) throws IOException {
        resp.sendRedirect(url);
    }

    private void doForward(HttpServletRequest req, HttpServletResponse resp, String url) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }

}

