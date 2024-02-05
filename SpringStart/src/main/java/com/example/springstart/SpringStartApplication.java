package com.example.springstart;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.util.Objects;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


public class SpringStartApplication {

    public static void main(String[] args) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        WebServer webServer = factory.getWebServer(servletContext -> {
            FrontController frontController = new FrontController();

            servletContext.addServlet("root", new HttpServlet() {
                @Override
                protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                    super.doGet(req, resp);
                        //String name = req.getParameter("name");

                        //String result = frontController.hello(name);
                }

                @Override
                public void service(ServletRequest req, ServletResponse res)
                        throws ServletException, IOException {
                    super.service(req, res);
                    res.setContentType(MediaType.TEXT_PLAIN_VALUE);
                    res.getWriter().println("spring");
                }

                @Override
                protected void service(HttpServletRequest req, HttpServletResponse res)
                        throws ServletException, IOException {
                    super.service(req, res);

                }
            }).addMapping("/*");
        });
        webServer.start();

    }

}
