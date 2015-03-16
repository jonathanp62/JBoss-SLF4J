package net.jonathan.jboss.slf4j;

/*
 * @(#)TestServlet.java 0.1.3   03/16/2015
 * @(#)TestServlet.java 0.1.2   03/15/2015
 * @(#)TestServlet.java 0.1.1   03/14/2015
 * @(#)TestServlet.java 0.1.0   03/13/2015
 */

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.MDC;

/**
 * A trivial servlet class that
 * functions as a simple test of
 * using the built-in logging
 * over the logging facade.
 * Creation date: 3/13/15 10:10 AM
 *
 * @author	Jonathan Parker
 * @version     0.1.3
 * @since	0.1.0
 */
@WebServlet(name = "Test Servlet", urlPatterns = {"/test.do"})
public class TestServlet extends HttpServlet {
    /** The name of the logger. */
    @Resource(mappedName = "java:comp/env/logger/name")
    private String loggerName;

    /** A SLF4J extended logger that allows for markers. */
    private MXLogger logger;

    /** A marker. */
    private Marker marker;
    
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
        this.logger = new MXLogger(LoggerFactory.getLogger(this.loggerName));
        this.marker = MarkerFactory.getMarker("RESOURCE");
    }

    /**
     * The pre-destruction method.
     */
    @PreDestroy
    public void preDestroy() {
        this.marker = null;
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

        /* Load the resource bundle for server messages using the locale from the default locale */
        
        ResourceBundle serverMessages = ResourceBundle.getBundle("messages", Locale.getDefault(), Thread.currentThread().getContextClassLoader());

        this.logger.info(this.marker, "{}", serverMessages.getString("class.testservlet.loaded.server"));

        /* Load the resource bundle for user/presentation messages using the locale from the user request */
        
        ResourceBundle userMessages = ResourceBundle.getBundle("messages", request.getLocale(), Thread.currentThread().getContextClassLoader());

        this.logger.info(this.marker, "{}", serverMessages.getString("class.testservlet.loaded.user"));

        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(200);
        
        this.logger.info("{}", serverMessages.getString("class.testservlet.response.set"));
        
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
        
        this.logger.info("{}", serverMessages.getString("class.testservlet.response.sent"));
        
        serverMessages = null;
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
        MDC.put("requestId", UUID.randomUUID().toString().replaceAll("-", ""));
        processRequest(request, response);
        MDC.clear();
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
        MDC.put("requestId", UUID.randomUUID().toString().replaceAll("-", ""));
        processRequest(request, response);
        MDC.clear();
        this.logger.exit();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return  java.lang.String
     */
    @Override
    public String getServletInfo() {
        return ResourceBundle.getBundle("messages", Locale.getDefault(), Thread.currentThread().getContextClassLoader()).getString("class.testservlet.info");
    }    
}
