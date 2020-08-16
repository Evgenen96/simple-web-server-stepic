package main;

import accounts.AccountService;
import dbService.DBService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            DBService dbService = new DBService();
            dbService.printConnectInfo();
            dbService.create();
            dbService.check();

            AccountService accountService = new AccountService(dbService);

            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
            context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");

            Server server = new Server(8080);
            server.setHandler(context);

            server.start();
            System.out.println("Server started!");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
