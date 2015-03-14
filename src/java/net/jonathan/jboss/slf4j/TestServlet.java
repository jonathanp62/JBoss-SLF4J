package net.jonathan.jboss.slf4j;

/*
 * @(#)TestServlet.java 0.1.1   03/14/2015
 * @(#)TestServlet.java 0.1.0   03/13/2015
 */

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;

import org.slf4j.ext.XLogger;

/**
 * A trivial servlet class that
 * functions as a simple test of
 * using the built-in logging
 * over the logging facade.
 * Creation date: 3/13/15 10:10 AM
 *
 * @author	Jonathan Parker
 * @version     0.1.1
 * @since	0.1.0
 */
@WebServlet(name = "Test Servlet", urlPatterns = {"/test.do"})
public class TestServlet extends HttpServlet {
    /** The name of the logger. */
    @Resource(mappedName = "java:comp/env/logger/name")
    private String loggerName;

    /** The logger. */
    private XLogger logger;

    /**
     * The default constructor.
     */
    public TestServlet() {
        super();
    }

    /**
     * The post-construction method.
     */
    @PostConstruct
    public void postConstruct() {
        this.logger = new XLogger(LoggerFactory.getLogger(this.loggerName));
    }

    /**
     * The pre-destruction method.
     */
    @PreDestroy
    public void preDestroy() {
        this.logger = null;
        this.loggerName = null;
    }

    /**
     * The servlet initialization method.
     * 
     * @throws  javax.servlet.ServletException 
     */
    @Override
    public void init() throws ServletException {
        super.init();
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param   request     javax.servlet.http.HttpServletRequest
     * @param   response    javax.servlet.http.HttpServletResponse
     * @throws              javax.servlet.ServletException
     * @throws              java.io.IOException
     */
    protected void processRequest(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.logger.entry(request, response);
        
        /* Load the resource bundle for user/presentation messages using the locale from the user request */
        
        ResourceBundle userMessages = ResourceBundle.getBundle("messages", request.getLocale(), Thread.currentThread().getContextClassLoader());

        this.logger.info("Loaded the resource bundle");
        
        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(200);
        
        this.logger.info("Set the content type and status in the response");
        
        PrintWriter out = response.getWriter();
        
        try {
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
            out.printf("<html lang=\"%s\">\n", request.getLocale().getLanguage());
            out.println("<head>");
            out.printf("<title>%s</title>\n", userMessages.getString("class.testservlet.title"));
            out.println("</head>");
            out.println("<body>");
            out.printf("<h2>%s</h2>\n", userMessages.getString("class.testservlet.title"));
            out.printf("<p>%s %s</p>\n", userMessages.getString("class.testservlet.path"), request.getContextPath());
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
        
        this.logger.info("Sent output to the response");
        
        userMessages = null;
        
        this.logger.exit();
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param   request     javax.servlet.http.HttpServletRequest
     * @param   response    javax.servlet.http.HttpServletResponse
     * @throws              javax.servlet.ServletException
     * @throws              java.io.IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.logger.entry(request, response);
        processRequest(request, response);
        this.logger.exit();
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param   request     javax.servlet.http.HttpServletRequest
     * @param   response    javax.servlet.http.HttpServletResponse
     * @throws              javax.servlet.ServletException
     * @throws              java.io.IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.logger.entry(request, response);
        processRequest(request, response);
        this.logger.exit();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return  java.lang.String    The servlet description
     */
    @Override
    public String getServletInfo() {
        /* Use the resource bundle for server/logging messages based on the server locale */

        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", Locale.getDefault(), Thread.currentThread().getContextClassLoader());

        return resourceBundle.getString("class.testservlet.info");
    }    
}
